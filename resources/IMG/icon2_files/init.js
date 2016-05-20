//console.log('Initializing...');
//Settings:
var trackingBaseUrl = "https://tracking.adnexio.com/"; //Ends on slash!
var proxyUrl = "https://image.adnexio.com/" //Ends on slash!
var locationUrl = "https://creative.adnexio.com/";  //Ends on slash!

var mainHTMLPath = locationUrl + 'templates/main.html';
var mainCSSPath = locationUrl + 'templates/main.css';
var bannerTemplatePath = locationUrl + 'templates/banner/';
var productTemplatePath = locationUrl + 'templates/productContainer/';
var bannerRunTime = 0;
var animationTimer;
var isRunning = true;
pauseanimation = false;
// Load CSS, jQuery And velocity
head.load({
    'mainCSS': mainCSSPath
});
head.load({
    'jQuery': 'https://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.3.min.js'
});
head.load({
    'velocity': 'https://cdnjs.cloudflare.com/ajax/libs/velocity/1.2.2/velocity.min.js'
});
//jQuery loaded?
head.ready('jQuery', function () {
    // Generate html when css is loaded
    head.ready('mainCSS', function () {
        //Start loading animation when Velocity is loaded
        head.ready('velocity', function () {
            //Generate Loader
            $.get(mainHTMLPath, function (response) {
                var loaderHTML = $(response).find('.loader');
                //console.log(loaderHTML);
                $('#AdvantageStage').append(loaderHTML);
            }).done(function () {
                loaderAnimation(); //Animate loader
            });
            //Load settings
            var settingsUrl = locationUrl + 'GetSettings?Id=' + cId;
            $.getJSON(settingsUrl, function (json) {
                //Sucess!

                //Generate Banner Div!
                $('#AdvantageStage').append('<div id="theBanner"></div>');
                //Generate template in banner div.

                var bannerTempalteHTMLFileName = bannerTemplatePath + json.generalTemplate + "/" + json.generalTemplate + ".html";
                var bannerTemplateCSSFilename = bannerTemplatePath + json.generalTemplate + "/" + json.generalTemplate + ".css";
                var bannerTemplateCSSSizeFilename = bannerTemplatePath + json.generalTemplate + "/" + json.generalTemplate + "_" + dimensions + ".css";
                xdimensions = dimensions;
                head.load({
                    'bannerTemplateCSS': bannerTemplateCSSFilename
                });
                head.load({
                    'bannerTemplateCSSSize': bannerTemplateCSSSizeFilename
                });
                $.get(bannerTempalteHTMLFileName, function (response) {
                    response = response.replace('{logoSrc}', json.logoUrl);
                    $('#theBanner').attr("data-jsonSettings", JSON.stringify(json));
                    $('#theBanner').append(response);
                }).fail(function () {
                    //failed!
                    console.log('Failed loading: ' + bannerTempalteHTMLFileName);
                }).done(function () {
                    head.ready(['bannerTemplateCSS', 'bannerTemplateCSSSize'], function () {
                        //Banner template html & css loaded!
                        //Generate CSS from Settings              
                        $('#theBanner').css({
                            "flex-direction": json.logoContainerAlignment
                        });
                        if (json.logoContainerAlignment.indexOf("column") >= 0) {
                            $('.logoContainer').css({
                                "height": json.logoContainerHeight
                            });
                        } else {
                            $('.logoContainer').css({
                                "width": json.logoContainerWidth
                            });
                        }
                        //Stage css
                        $('#theBanner').css({
                            'border': json.stageBorder,
                            'background-image': 'url(' + json.backgroundImage + ')',
                            'background-color': json.backgroundColor,
                            'font-family': json.fontFamily,
                        });
                        //Logo Container
                        $('.logoContainer').css({
                            'background-color': json.logoBackground,
                        });
                        //Products
                        if(json.raptorAPIFeedName != ""){ var extention = "&feedidentifier=" + json.raptorAPIFeedName;}
                        else{ var extention = "";}
                        var raptorUrl = json.raptorAPIUrl + 'callback=callback' + extention;
                        //raptorUrl = raptorUrl.replace('http://', 'https://');
                        $.ajax({
                            url: raptorUrl,
                            dataType: 'jsonp',
                            jsonp: false,
                            jsonpCallback: 'callback',
                            error: function () {
                                // Faild laoding feed!
                                console.log('Faild to load product data!');
                            },
                            success: function (feed) {
                                if (type != "456") {
                                    var productarray = new Array();
                                    $(feed).each(function (index) {
                                        productarray[index] = "'" + feed[index].ProductId + "'";
                                    });
                                    var productIdString = productarray.join(",");
                                    var url = trackingBaseUrl + "ImpressionHandler?Id=" + campId + "&pId=" + productIdString;
                                    $("#AdvantageStage").append('<img src=" ' + url + ' " >');
                                }

                               if (json.clickTracker != "" && json.clickTracker != undefined) {
                                    clickTag = json.clickTracker;
                                }

                                if(json.impressionTracker != "" && json.clickTracker != undefined){
                                    $("#AdvantageStage").append('<img src=" ' + json.impressionTracker + ' " >');
                                }

                                var productTempalteHTMLFileName = productTemplatePath + json.productTemplate + '/' + json.productTemplate + ".html";
                                var productTemplateCSSFilename = productTemplatePath + json.productTemplate + '/' + json.productTemplate + ".css";
                                var productTemplateCSSSizeFilename = productTemplatePath + json.productTemplate + '/' + json.productTemplate + "_" + xdimensions + ".css";
                                head.load({
                                    'productTemplateCSS': productTemplateCSSFilename
                                });
                                head.load({
                                    'productTemplateCSSSize': productTemplateCSSSizeFilename
                                });
                                $.get(productTempalteHTMLFileName, function (response) {
                                    //Generate product containers from feed and template 
                                    $(feed).each(function (x, item) {
                                        //Replace Macros with product info form raptor
                                        htmlString = response;
                                        var i = 0;
                                        var ifarray = htmlString.match(/\!![^!!]*\!!/g);
                                        if (ifarray != null && ifarray != "") {
                                            $.each(ifarray, function (x, value) {
                                                var determinator = value.match(/!!if ([a-zA-Z0-9]{1,100})/);
                                                if (item[determinator[1]] != "") {

                                                    if (determinator[1] == "OriginalPrice" && json.originalPriceSuffix != "" && json.originalPriceSuffix != undefined || determinator[1] == "Discount" && json.discountSuffix != "" && json.discountSuffix != undefined) {
                                                        var newValue = value.replace(/!!if [a-zA-Z0-9]{1,100}/, '').replace('!!', '');
                                                        htmlString = htmlString.replace(value, newValue);
                                                    } else {
                                                        htmlString = htmlString.replace(value, '');
                                                    }

                                                } else {
                                                    htmlString = htmlString.replace(value, '');
                                                }
                                            });
                                        }

                                        $.each(item, function (key, value) {
                                            // TODO: Make switch instead of IF
                                            // Add Prefix ANd suffixto RetailPrice
                                            if (key == "RetailPrice") {

                                                if (json.dualDecimalDictation) {
                                                    value = parseFloat(value).toFixed(2);
                                                }

                                                if (json.currencyCulture == "en") {
                                                    value = addSeparatorsNF(value, '.', '.', ',');
                                                } else if (json.currencyCulture == "da") {
                                                    value = addSeparatorsNF(value, '.', ',', '.');
                                                }

                                                value = json.pricePrefix + value + json.priceSuffix;
                                            }
                                            // Add utm to RetailPrice
                                            if (key == "ProductUrl" && json.utmCode != undefined) {
                                                value = value + json.utmCode;
                                            }

                                            // Add utm to Discount
                                            if (key == "Discount" && json.discountPrefix != undefined && json.discountSuffix != undefined && json.discountSuffix != "") {
                                                value = json.discountPrefix + value + json.discountSuffix;
                                            } else {
                                                $('.discountRiddon').remove();
                                            }

                                            // Add utm to OriginalPrice
                                            if (key == "OriginalPrice" && json.originalPricePrefix != undefined && json.originalPriceSuffix != undefined && json.originalPriceSuffix != "") {
                                                value = json.originalPricePrefix + value + json.originalPriceSuffix;
                                            } else {
                                                $('.OriginalPriceContainer').remove();
                                            }

                                            // Add imageproxy to images
                                            if (key == "ImageUrl" && json.disableImageProxy != "true") {
                                                value = proxyUrl + "proxy.ashx?cid=" + campId + "&pid=" + item.ProductId + "&image=" + $.trim(value);
                                            }

                                            htmlString = htmlString.replace('{' + key + '}', value);
                                            i++;
                                        });
                                        //Create html for buttons
                                        if (json.buttonCustomHtml == "" || json.buttonCustomHtml == " ") {
                                            htmlString = htmlString.replace('{button}', '<button class="advantageButton">' + json.buttonText + '</button>');
                                        } else {
                                            var buttonHTML = json.buttonCustomHtml.replace('{buttonText}', json.buttonText);
                                            htmlString = htmlString.replace('{button}', buttonHTML);
                                        }
                                        //Append productContainers
                                        $(".productWrapper").append(htmlString);
                                    });
                                    //Append the customScript
                                    if (json.customScript != "") {
                                        var customScript = "<script>" + decodeURIComponent(json.customScript) + "</script>";
                                        $('#AdvantageStage').append(customScript);
                                    }
                                    //Appen the Custom Button styles.
                                    $('head').append('<style>' + json.buttonCustomCss + '</style>');
                                }).fail(function () {
                                    console.log('Faild to generate Products!');
                                }).done(function () {
                                    head.ready('productTemplateCSSSize', function () {
                                        cssFunction(json).done(function () {
                                            lengthFixer(json).done(function () {
                                                //Animation
                                                var animationFile = locationUrl + '/animations/' + json.animation + '.js';
                                                head.load({
                                                    'animation': animationFile
                                                });
                                                head.ready('animation', function () {
                                                    animateNow(json);
                                                });
                                            });
                                        });
                                    });
                                });
                            }
                        });
                    });
                });
            }).fail(function () {
                //failed!
                console.log('Failed loading: settings');
            });
        });
        //Generate info Icon
        $.get(mainHTMLPath, function (response) {
            var infoHTML = $(response).find('#infoWrapper');
            $('#AdvantageStage').append(infoHTML);
            //Make info icon clickable
            $('#infoWrapper').click(function () {
                window.open('http://www.advantagemedia.dk/');
            });
            $(document).on("mouseover", "#AdvantageStage", function () {
                isRunning = false;
            });
            $(document).on("mouseout", "#AdvantageStage", function () {
                isRunning = true;
            });
        });
    });
});

function animateNow(json) {
    if (json.generalTemplate == "StaticProductImage") {
        json.productShown--;
    }
    productNumber = json.productShown, currentProductNumber = 0, productElement = [];
    $('.productContainer').not('.pin').each(function (index) {
        productElement.push($(this));
    });
    ementsInUse = parseInt(productElement.length / productNumber) * productNumber;
    $.when(beforeAnimation(json)).done(function () {
        $('.loader').fadeOut();
        var interval_id = setInterval(function () {
            if (isRunning && pauseanimation != true) {
                for (var i = currentProductNumber; i < (parseInt(productNumber) + parseInt(currentProductNumber)) ; i++) {
                    animateOut(productElement[i], json).done(function () {
                        currentProductNumber++;
                        if ((currentProductNumber % productNumber) == 0) {
                            //Fade Ind i dette tilfælde
                            currentProductNumber = (ementsInUse == parseInt(currentProductNumber)) ? 0 : currentProductNumber;
                            for (var j = currentProductNumber; j < (currentProductNumber + parseInt(productNumber)) ; j++) {
                                animateIn(productElement[j], json).done(function () { });
                            }
                        }
                    });
                }
            }
        }, json.productTime);
        setTimeout(function () {
            clearInterval(interval_id);
            $('*').stop();
            $(".velocity-animating").velocity("stop", true);
        }, 29500);
    });
}

function lengthFixer(json) {
    var dfrd = $.Deferred();
    var maxwords = 10;
    var isIE = /*@cc_on!@*/false || !!document.documentMode;   // At least IE6
    var isSafari = Object.prototype.toString.call(window.HTMLElement).indexOf('Constructor') > 0;
    if (isIE == true || isSafari == true) {
        console.log("safari = " + isSafari);
        var maxwords = 3;
    }
    // Fix text length!
    $('.productContainer').not('.pin').each(function () {
        var cutmeElement = $(this).find('.cutMe');
        var cutmeHeight = cutmeElement.outerHeight(true);
        var cutmeTextArray = cutmeElement.html().split(" ");
        if (cutmeTextArray.length > maxwords) {
            cutmeTextArray = cutmeTextArray.slice(0, maxwords);
        }
        var outerElementHeight = ($(this).find('.fitMe').innerHeight());
        var innerElementsHeight = collectedHeightOfChildren($(this));

        while (outerElementHeight <= innerElementsHeight && cutmeTextArray.length != 0 && !cutmeElement.hasClass('notMe')) {
            //cutmeTextArray
            cutmeTextArray.pop();
            cutmeElement.html(cutmeTextArray.join(" ") + "...");
            var innerElementsHeight = collectedHeightOfChildren($(this));
        }
    }).promise().done(function () {
        dfrd.resolve();
    });
    return dfrd.promise();
}

function cssFunction(json) {
    var dfrd = $.Deferred();
    //Fix product height and add custom css to product container
    var wrapperHeight = $('.productWrapper').innerHeight();
    var wrapperWidth = $('.productWrapper').innerWidth();
    if (json.buttonCustomHtml == "") {
        $('.advantageButton').css({
            'border': json.buttonBorder,
            'border-radius': json.buttonRadius,
            'background-color': json.buttonBackgorundColor,
            'font-size': json.buttonFontSize,
            'height': json.buttonHeight,
            'width': json.buttonWidth,
            'color': json.buttonFontColor,
            'font-weight': json.buttonFontWeight,
            'padding': json.buttonPadding,
            'background-image': 'url(' + json.buttonImage + ')',
        });
    }
    if ($('.productWrapper').css('flex-direction') == 'column') {
        $('.productContainer').css({
            'width': '100%',
            'height': wrapperHeight / json.productShown - 10 + 'px',
        });
    } else {
        $('.productContainer').css({
            'height': wrapperHeight - 6,
            'width': 100 / json.productShown - 1 + '%',
        });
    }
    $('.productContainer').not('.nobg').css({
        'border': json.productBorder,
        'border-radius': json.productRadius,
        'background-color': json.productBackgorundColor,
        'box-shadow': json.productShadow,
        'font-size': json.generalFontSize,
    });
    $('.productContainer .textContainer').css({
        'font-size': json.productTextFontSize,
        'text-align': json.productTextAlign,
        'color': json.productTextColor,
        'font-weight': json.productTextWeight,
    });
    $('.productContainer .priceContainer').css({
        'font-size': json.productPriceFontSize,
        'text-align': json.productPriceAlign,
        'color': json.productPriceColor,
        'font-weight': json.productPriceWeight,
    });

    //IE FIX
    var ua = window.navigator.userAgent;
    var msie = ua.indexOf("MSIE");
    if (msie > 0 || !!navigator.userAgent.match(/Trident.*rv\:11\./)) {
        $(".textContainer").css({ "align-items": "flex-start", "overflow": "hidden" });
    }

    dfrd.resolve();
    return dfrd.promise();
}

function collectedHeightOfChildren(element) {
    childHeight = 0;
    element.find('.fitMe').find("div").each(function () {
        //var $img = $(this);
        //var paddT = parseInt($img.css('padding-top')) + parseInt($img.css('padding-bottom'));
        childHeight += $(this).outerHeight(true);
    });
    return childHeight;
}
//Animate loader
function loaderAnimation() {
    $('.small, .small-shadow').velocity({
        rotateZ: [0, -360]
    }, {
        loop: true,
        duration: 2000
    });
    $('.medium, .medium-shadow').velocity({
        rotateZ: -240
    }, {
        loop: true,
        duration: 2000
    });
    $('.large, .large-shadow').velocity({
        rotateZ: 180
    }, {
        loop: true,
        duration: 2000
    });
}
function addSeparatorsNF(nStr, inD, outD, sep) {
    nStr += '';
    var dpos = nStr.indexOf(inD);
    var nStrEnd = '';
    if (dpos != -1) {
        nStrEnd = outD + nStr.substring(dpos + 1, nStr.length);
        nStr = nStr.substring(0, dpos);
    }
    var rgx = /(\d+)(\d{3})/;
    while (rgx.test(nStr)) {
        nStr = nStr.replace(rgx, '$1' + sep + '$2');
    }
    return nStr + nStrEnd;
}

function Timer(callback, delay) {
    var timerId, start, remaining = delay;
    this.pause = function () {
        window.clearTimeout(timerId);
        remaining -= new Date() - start;
    };
    this.resume = function () {
        start = new Date();
        window.clearTimeout(timerId);
        timerId = window.setTimeout(callback, remaining);
    };
    this.resume();
}
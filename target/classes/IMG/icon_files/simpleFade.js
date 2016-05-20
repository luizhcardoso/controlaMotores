var originaldisplayMode;
//Animate in function
function animateIn(elementSelector, json) {

    var dfrd = $.Deferred();
    elementSelector.velocity({
        opacity: '1'
    }, {
        display: originaldisplayMode,
        duration: json.animationSpeed,
        complete: function() {
            dfrd.resolve();
        }
    });
    return dfrd.promise();
}
//Animate Out function
function animateOut(elementSelector, json) {

    var dfrd = $.Deferred();
    elementSelector.velocity({
        opacity: '0'
    }, {
        display: 'none',
        duration: json.animationSpeed,
        complete: function() {
            dfrd.resolve();
        }
    });
    return dfrd.promise();
}
// before animate function
function beforeAnimation(json) {
    var dfrd = $.Deferred();
    originaldisplayMode = productElement[0].css('display');
    $.each(productElement, function(index) {
        if (index >= json.productShown) {
            productElement[index].css({
                'display': 'none',
                'opacity': '0'
            });
        }
    });

    dfrd.resolve();
    return dfrd.promise();
}
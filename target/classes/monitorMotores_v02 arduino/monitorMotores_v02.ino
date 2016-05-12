#include <EtherCard.h>
#include <avr/wdt.h>  

const int PressaoA = 2;
const int PressaoB = 3;
const int TransfA = 4;
const int TransfB = 5;
const int VACUO = 6;
const int PORTAUSINA = 7;
const int EstadoArduino = 9;
bool last;

// ethernet interface mac address, must be unique on the LAN
static byte mymac[] = { 0x74,0x69,0x69,0x2D,0x30,0x31 };
static byte myip[] = { 192,168,1,123 };
 
byte Ethernet::buffer[500];
BufferFiller bfill;
 
void setup () {
 ether.staticSetup(myip);
  Serial.begin(57600);
  if (ether.begin(sizeof Ethernet::buffer, mymac,8) == 0){
    Serial.println( "Failed to access Ethernet controller");
  }else{
    Serial.println("Conexao Ok");
  }
  
  
  pinMode(PressaoA, INPUT);
  pinMode(PressaoB, INPUT);
  pinMode(TransfA, INPUT);
  pinMode(TransfB, INPUT);
  pinMode(VACUO, INPUT);
  pinMode(PORTAUSINA, INPUT);
  pinMode(EstadoArduino, OUTPUT);
  
  digitalWrite(PressaoA, LOW);
  digitalWrite(PressaoB, LOW);
  digitalWrite(TransfA, LOW);
  digitalWrite(TransfB, LOW);
  digitalWrite(VACUO, LOW);
  digitalWrite(PORTAUSINA, HIGH);
  digitalWrite(EstadoArduino, HIGH);

  wdt_enable(WDTO_8S);
  
  }
    
static word homePage() {
char tmp[25] = "Pot Voltage = ";
  bfill = ether.tcpOffset();
  bfill.emit_p(PSTR(
    "HTTP/1.0 200 OK\r\n"
    "Content-Type: text/html\r\n"
    "Pragma: no-cache\r\n"
    "\r\n"
    "<meta http-equiv='refresh' content='5'/>"
    "<title>Dados Motores Usina</title>"
    "PressaoA    = ;$D;"
    "PressaoB    = ;$D;"
    "TRANSF A    = ;$D;"
    "TRASNF B    = ;$D;"
    "VACUO       = ;$D;"
    "PORTA USINA = ;$D;"
    "Estado Arduino = ;$D;"),
    digitalRead(PressaoA),
    digitalRead(PressaoB),
    digitalRead(TransfA),
    digitalRead(TransfB),
    digitalRead(VACUO),
    digitalRead(PORTAUSINA),
    digitalRead(EstadoArduino));
    return bfill.position();
}

void loop () {
  word len = ether.packetReceive();

  word pos = ether.packetLoop(len);
  if (pos)  // check if valid tcp data is received
    ether.httpServerReply(homePage()); // send web page data
	wdt_reset(); 

}



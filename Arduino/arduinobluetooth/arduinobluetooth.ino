
//Pines donde conectaremos los LEDS
#define LED1 4
#define LED2 5

//Pines del Bluetooth
#define TX 10
#define RX 11

#include <SoftwareSerial.h>


//Estados de los LEDS
int led1 = LOW; 
int led2 = LOW; 

//Creamos la conexion con el Bluetooth
SoftwareSerial bluetooth(TX, RX);

void setup() {
   
 //Inicializamos los pines de los LEDS
 pinMode(LED1, OUTPUT);
 pinMode(LED2, OUTPUT);
 
 //Configuramos el bluetooth a 9600
 bluetooth.begin(9600);

 //Iniciamos los LEDS
 digitalWrite(LED1, led1);
 digitalWrite(LED2, led2);
 
}


void loop() {
 
 //Si hay datos por leer los leemos
 if (bluetooth.available()) {
  //Obtenemos el LED a leer
  int LED = bluetooth.read();
  
  switch (LED) {
    case 1:
      led1 = !led1; //Invertimos el estado
      digitalWrite(LED1, led1); //Ponemos el LED al estado
      break;
    case 2:
      led2 = !led2;
      digitalWrite(LED2, led2);
      break;
  }  
  
 } 
  //Esperamos 100 milisegundos antes 
  //de volver a comprobar el bluetooth
  delay(100);
  
}

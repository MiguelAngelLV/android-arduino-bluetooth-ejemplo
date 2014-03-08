#Ejemplo de conexión de Arduino y Android mediante Bluetooth
Este es un pequeño ejemplo de como conectar Arduino y Android mediante un módulo bluetoth.

En este ejemplo uso un módulo bluetooth **HC-06**, el cual es detectado por Arduino como un _puerto serie_.

##Software usado
Podéis encontrar el código fuente de Android y Arduino en sus respectivas carpetas. 

La carpeta Android es un para _Eclipse_ y la carpeta Arduino es un proyecto para _Arduino IDE_.

##Funcionamiento
La app Android mostrará los **dispostivos bluetooth vinculados**, por lo que tendrás que vincular primero el dispositivo de forma habitual.

Posteriormente se selecciona el dispositvo al que deberá conectarse y se pulsa el botón del LED correspondiente. La App enviará un número entero (integer) por bluetooth hasta el Arduino el cual lo recibirá y encenderá / apagará el LED indicado.


##Vídeo
Podéis ver un vídeo en funcionamiento aquí:
[Youtube][1]


  [1]: http://youtu.be/Kxz4TM30dn4
Android101
==========

Android 101 is a training material develop in Spanish ..

## Contenido
```
1 - Android antes y ahora
2 - The Stack
    * Linux
    * Libreria Nativas
    * Dalvik
    * Android y Java
    * Application Framework
    * Applications
3 - Hello World!
4 - Hands-on!
5 - Recursos y Recomendaciones 
```

Demos
-----
a) Hello World

b) Where Am I 
```
#Emulador ver lista posible 
android list targets

# Emular posiciones GPS en el emulador
# Utilicen una coneccion de Telnet 
#   telnet localhost <console-port> or telnet 127.0.0.1 <console-port>
#   geo fix <longitude> <latitude> 



telnet localhost:5554  |  telnet 127.0.0.1 5554
geo fix -121.45356 46.51119 4392

```


Eclipse Shurtocuts 
```
Ctrl + Shift + O   -> Organizar Imports
Ctrl + Shift + F   -> Format Code 
CTRL + SPACE       -> Auto Complete 
ALT + ↑ or ↓       -> mover line abajo o arriba
```
## Installar Android 

```
Descarga Java SDK

Asegurate de descargar Java SE 6 SDK 
http://www.oracle.com/technetwork/java/javasebusiness/downloads/java-archive-downloads-javase6-419409.html

Descarga el ADT Bundel en el siguiente link

http://developer.android.com/sdk/index.html

Descomprime el zip y coloca el folder en el directorio de tu preferencia 

Windows 
	C:\ apps\ android-sdk-windows 
Linux 
	/home/ YourUserName/ android-sdk-linux_86 
Mac OS X 
	/Users/ YourUserName/ android-sdk-mac_86

agrega a tus variables de path los siguientes folder 
 
 SET PATH=%PATH%;<directorio>/android-sdk/platform-tools/
 SET PATH=%PATH%;<directorio>/android-sdk/tools/

```
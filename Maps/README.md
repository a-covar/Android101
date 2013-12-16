Google Maps API para android 
==========

Asegurarse que el SDK Manager tengas installado los siguientes paquetes :

1 Android SKD Tools 
2 Google Play Services  for Froyo y Google Play Services
3 SDK Platform API 8 en adelante



## Android Manifest 
```

<permission android:name="com.kualia.maps.permission.MAPS_RECEIVE" android:protectionLevel="signature"/>
	
	<uses-permission android:name="com.kualia.maps.permission.MAPS_RECEIVE"/>
	<uses-permission android:name="android.permission.INTERNET"/>
	<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
	<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>

<uses-feature android:glEsVersion="0x00020000"
	    android:required="true"/>

```

Crear API Key de Google   
-----
[https://code.google.com/apis/console](https://code.google.com/apis/console)

```
Crear un projecto nuevo y nombrarlo igual que el nombre tu projecto de Android , en nuestro caso MapsGoogle

Activar  Google Maps Android API v2

Ir a 'API Access' -> Create New Android Key -> AGREGAR SHA1 fingerprint

Copiar API Key al Manifest

<application>
...
 <meta-data android:name="com.google.android.maps.v2.API_KEY" android:value="<google key que se genero>"/>
</application>

```

Agregar las librerias 
------


En Eclipse File->Import->Android->Existing Android Code into workspace 
```
	Browse -> <sdk path>/extras/google/google_play_services/libproject/google-play-services-lib/ 
	seleccionar el check box 'Copy project into workspace'
	Finish 
```

En Eclipse seleccionar ezl folder de tu projecto (click derecho) ->Properties -> Android ->Library (Add) = Agregamos la libreria google-play-services-lib
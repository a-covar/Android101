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


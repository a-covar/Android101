Location Service Example
==========

Este es un ejemplo para usar servicios de Localizacion 

## res/layout.mainx.xml
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
	android:orientation="vertical" android:layout_width="fill_parent"
	android:layout_height="fill_parent" android:background="#fff">

	<TextView android:layout_width="wrap_content"
		android:layout_height="wrap_content" android:layout_gravity="center"
		android:textColor="#333" android:textSize="30dp" android:text="@string/title" />

	<ScrollView android:layout_height="fill_parent"
		android:layout_width="fill_parent">

		<LinearLayout android:id="@+id/linearLayout1"
			android:layout_width="fill_parent" android:layout_height="fill_parent">

			<TextView android:textColor="#333" android:layout_gravity="center"
				android:text="Waiting..." android:textSize="25dp" android:id="@+id/textOut"
				android:layout_width="fill_parent" android:layout_height="fill_parent"></TextView>
		</LinearLayout>
	</ScrollView>

</LinearLayout>

## WhereAmI.java
```
public class WhereAmIActivity extends Activity implements LocationListener {
	LocationManager locationManager;
	Geocoder geocoder;
	TextView textOut;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i("WhereAmI", "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		textOut = (TextView) findViewById(R.id.textOut);

		locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
		geocoder = new Geocoder(this);

		Location lastLocation = locationManager
				.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		Log.i("WhereAmI", "lastLocation");
		if (lastLocation != null)
			onLocationChanged(lastLocation);

	}

	@Override
	protected void onPause() {
		Log.i("WhereAmI", "onPause");
		super.onPause();
		locationManager.removeUpdates(this);
	}

	@Override
	protected void onResume() {
		Log.i("WhereAmI", "onResume");
		super.onRestart();
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
				100, 10, this);
		locationManager.requestLocationUpdates(
				LocationManager.NETWORK_PROVIDER, 100, 10, this);

	}

	@Override
	public void onLocationChanged(Location location) {
		Log.i("WhereAmI", "onLocationChanged");
		String text = String.format(
				"Lat:\t %f\nLong:\t %f\nAlt:\t %f\nBearing:\t %f",
				location.getLatitude(), location.getLongitude(),
				location.getAltitude(), location.getBearing());
		textOut.setText(text);

		try {
			List<Address> addresses = geocoder.getFromLocation(
					location.getLatitude(), location.getLongitude(), 10);
			for (Address address : addresses) {
				textOut.append("\n" + address.getAddressLine(0));
			}
		} catch (IOException e) {
			Log.e("WhereAmI", "Could't get Geocoder data", e);
		}
		Log.i("WhereAmI", "onLocationChanged = " + text);
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

}
```
## Manifest file 
```
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
	package="com.kualia.whereami" android:versionCode="1"
	android:versionName="1.0">
	<uses-sdk android:targetSdkVersion="7" android:minSdkVersion="7" />
	<uses-permission android:name="android.permission.INTERNET" />
	<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"></uses-permission>
	<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"></uses-permission>

	<application android:icon="@drawable/icon" android:label="@string/app_name">
		<activity android:name=".WhereAmIActivity" android:label="@string/app_name">
			<intent-filter>
				<action android:name="android.intent.action.MAIN" />
				<category android:name="android.intent.category.LAUNCHER" />
			</intent-filter>
		</activity>

	</application>
</manifest>

```

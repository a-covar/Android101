package com.kualia.whereami;

import java.io.IOException;
import java.util.List;

import android.app.Activity;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

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

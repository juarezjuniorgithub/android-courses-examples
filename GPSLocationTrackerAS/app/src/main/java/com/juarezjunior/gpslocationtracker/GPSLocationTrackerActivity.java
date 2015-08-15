package com.juarezjunior.gpslocationtracker;

import com.juarezjunior.gpslocationtracker.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GPSLocationTrackerActivity extends Activity {

	Button btnShowLocation;

	GPSLocationTracker gps;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		btnShowLocation = (Button) findViewById(R.id.btnShowLocation);

		btnShowLocation.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				gps = new GPSLocationTracker(GPSLocationTrackerActivity.this);

				if (gps.canGetLocation()) {

					double latitude = gps.getLatitude();
					double longitude = gps.getLongitude();

					Toast.makeText(
							getApplicationContext(),
							"Your Location is - \nLat: " + latitude
									+ "\nLong: " + longitude, Toast.LENGTH_LONG)
							.show();
				} else {

					gps.showSettingsAlert();
				}

			}
		});
	}

}
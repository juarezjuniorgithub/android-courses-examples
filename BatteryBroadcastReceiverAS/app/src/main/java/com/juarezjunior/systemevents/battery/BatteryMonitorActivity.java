package com.juarezjunior.systemevents.battery;

import com.juarezjunior.systemevents.battery.R;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.BatteryManager;
import android.widget.ProgressBar;
import android.widget.ImageView;
import android.widget.TextView;

public class BatteryMonitorActivity extends Activity {
	
	private ProgressBar bar = null;
	private ImageView status = null;
	private TextView level = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bar = (ProgressBar) findViewById(R.id.bar);
		status = (ImageView) findViewById(R.id.status);
		level = (TextView) findViewById(R.id.level);
	}

	@Override
	public void onResume() {
		
		super.onResume();

		registerReceiver(onBatteryChanged, new IntentFilter(
				Intent.ACTION_BATTERY_CHANGED));
	}

	@Override
	public void onPause() {
		
		super.onPause();

		unregisterReceiver(onBatteryChanged);
	}

	BroadcastReceiver onBatteryChanged = new BroadcastReceiver() {
		public void onReceive(Context context, Intent intent) {
			int pct = 100 * intent.getIntExtra("level", 1)
					/ intent.getIntExtra("scale", 1);

			bar.setProgress(pct);
			level.setText(String.valueOf(pct));

			switch (intent.getIntExtra("status", -1)) {
			case BatteryManager.BATTERY_STATUS_CHARGING:
				status.setImageResource(R.drawable.charging);
				break;

			case BatteryManager.BATTERY_STATUS_FULL:
				int plugged = intent.getIntExtra("plugged", -1);

				if (plugged == BatteryManager.BATTERY_PLUGGED_AC
						|| plugged == BatteryManager.BATTERY_PLUGGED_USB) {
					status.setImageResource(R.drawable.full);
				} else {
					status.setImageResource(R.drawable.unplugged);
				}
				break;

			default:
				status.setImageResource(R.drawable.unplugged);
				break;
			}
		}
	};
}
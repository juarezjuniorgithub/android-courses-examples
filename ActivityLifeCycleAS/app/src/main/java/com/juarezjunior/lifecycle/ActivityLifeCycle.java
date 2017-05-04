package com.juarezjunior.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class ActivityLifeCycle extends Activity {

	private static final String TAG = "ActivityLifeCycle";
	Toast t = null; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.v(TAG, "onCreate");
		setContentView(R.layout.activity_cycle);
		t = Toast.makeText(this, R.string.on_create, Toast.LENGTH_LONG);
		t.show();
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.v(TAG, "onStart");
		t = Toast.makeText(this, R.string.on_start, Toast.LENGTH_LONG);
		t.show();
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.v(TAG, "onResume");
		t = Toast.makeText(this, R.string.on_resume, Toast.LENGTH_LONG);
		t.show();
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.v(TAG, "onPause");
		t = Toast.makeText(this, R.string.on_pause, Toast.LENGTH_LONG);
		t.show();
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.v(TAG, "onStop");
		t = Toast.makeText(this, R.string.on_stop, Toast.LENGTH_LONG);
		t.show();
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.v(TAG, "onRestart");
		t = Toast.makeText(this, R.string.on_restart, Toast.LENGTH_LONG);
		t.show();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.v(TAG, "onDestroy");
		t = Toast.makeText(this, R.string.on_destroy, Toast.LENGTH_LONG);
		t.show();
	}

}

package com.juarezjunior.sharedpreferences;

import com.juarezjunior.sharedpreferences.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SharedPrefsActivity extends Activity {
	
	final static String APP_PREFS = "app_prefs";
	final static String USERNAME_KEY = "username";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shared_prefs_activity);
	}

	@Override
	protected void onResume() {
		
		super.onResume();
		SharedPreferences prefs = getSharedPreferences(APP_PREFS, MODE_PRIVATE);
		String username = prefs.getString(USERNAME_KEY, null);

		TextView message = (TextView) findViewById(R.id.welcome_message);
		Button addNameButton = (Button) findViewById(R.id.add_name_button);
		
		if (username != null) {
			message.setText("Hi " + username + "!");
			addNameButton.setText("Change name");
		} else {
			message.setText("You have not saved your name!");
			addNameButton.setText("Add Name");
		}
		
		addNameButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SharedPrefsActivity.this,
						AddNameActivity.class);
				startActivity(intent);
			}
		});
		
	}
}

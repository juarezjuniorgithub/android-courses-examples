package com.juarezjunior.sharedpreferences;

import com.juarezjunior.sharedpreferences.R;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddNameActivity extends Activity {
	
	private SharedPreferences prefs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_name_activity);
		prefs = getSharedPreferences(SharedPrefsActivity.APP_PREFS,
				MODE_PRIVATE);
		final EditText name = (EditText) findViewById(R.id.name_edit_text);
		
		Button saveButton = (Button) findViewById(R.id.add_name_button);
		saveButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String username = name.getEditableText().toString();
				Editor editor = prefs.edit();
				editor.putString(SharedPrefsActivity.USERNAME_KEY, username);
				editor.commit();
				finish();
			}
		});
		
	}
}

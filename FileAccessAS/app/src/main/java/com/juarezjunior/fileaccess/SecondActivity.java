package com.juarezjunior.fileaccess;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.juarezjunior.fileaccess.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends Activity {

	private TextView lab_name;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.file_record);
		lab_name = (TextView) findViewById(R.id.lab_name);
		findViewById(R.id.but_back).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						back();
					}
				});
		readFile();
	}

	private void readFile() {
		FileInputStream fis = null;
		try {
			fis = openFileInput("text.txt");
			byte[] b = new byte[fis.available()];
			while (fis.read(b) != -1)
				;
			lab_name.setText(new String(b));
		} catch (FileNotFoundException e) {
			Log.v("TextFile", "ERROR: " + e.getMessage());
		} catch (IOException e) {
			Log.v("TextFile", "ERROR: " + e.getMessage());
		} finally {
			try {
				fis.close();
			} catch (Exception e) {
			}
		}
	}

	protected void back() {
		finish();
	}

}

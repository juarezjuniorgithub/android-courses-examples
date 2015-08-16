package com.juarezjunior.fileaccess;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.juarezjunior.fileaccess.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText edt_name;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edt_name = (EditText)findViewById(R.id.edt_name);
		findViewById(R.id.but_create).setOnClickListener(
			new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				createFile();
			}
		});
		findViewById(R.id.but_visualize).setOnClickListener(
			new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				visualize();
			}
		});
		
		
		
	}

	protected void createFile() {
		FileOutputStream fos = null;
		try {
			fos = openFileOutput("text.txt", Context.MODE_PRIVATE);
			fos.write(edt_name.getText().toString().getBytes());
			fos.flush();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
			}
		}
	}

	protected void visualize() {
		startActivity(new Intent(MainActivity.this,
			SecondActivity.class));
	}
}

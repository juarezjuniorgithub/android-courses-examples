package com.juarezjunior.buttons;

import com.juarezjunior.buttons.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ButtonsActivity extends Activity implements View.OnClickListener {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button button = (Button) this.findViewById(R.id.button);
		button.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Toast.makeText(getApplicationContext(), "Button clicked!",
				Toast.LENGTH_LONG).show();

	}
}
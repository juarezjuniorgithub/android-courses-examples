package com.juarezjunior.toast;

import com.juarezjunior.toast.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomToastActivity extends Activity {

	private Button customToastButton;

	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		customToastButton = (Button) findViewById(R.id.toast_button);
		customToastButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg) {
				LayoutInflater inflater = getLayoutInflater();
				View layout = inflater.inflate(R.layout.custom_toast,
						(ViewGroup) findViewById(R.id.custom_toast_layout));
				ImageView image = (ImageView) layout.findViewById(R.id.image);
				image.setImageResource(R.drawable.custom_toast_image);
				TextView text = (TextView) layout.findViewById(R.id.text);
				text.setText("TOAST");
				Toast toast = new Toast(getApplicationContext());
				toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
				toast.setDuration(Toast.LENGTH_LONG);
				toast.setView(layout);
				toast.show();
			}
		});

	}
}
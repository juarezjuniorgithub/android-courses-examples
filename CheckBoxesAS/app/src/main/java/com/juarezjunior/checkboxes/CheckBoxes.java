package com.juarezjunior.checkboxes;

import com.juarezjunior.checkboxes.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class CheckBoxes extends Activity implements
		CompoundButton.OnCheckedChangeListener {

	private CheckBox checkBox;

	@Override
	public void onCreate(Bundle bundle) {

		super.onCreate(bundle);
		this.setContentView(R.layout.main);

		checkBox = (CheckBox) findViewById(R.id.checkbox);
		checkBox.setOnCheckedChangeListener(this);
	}

	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if (isChecked) {
			checkBox.setText(R.string.checked);
		} else {
			checkBox.setText(R.string.unchecked);
		}
	}
}

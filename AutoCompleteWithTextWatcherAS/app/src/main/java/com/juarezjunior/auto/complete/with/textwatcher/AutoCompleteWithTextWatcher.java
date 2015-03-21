package com.juarezjunior.auto.complete.with.textwatcher;

import com.juarezjunior.auto.complete.with.textwatcher.R;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class AutoCompleteWithTextWatcher extends Activity implements TextWatcher {
	
	private static final String TAG = "AutoCompleteWithTextWatcher";	
	private static final String[] items = { "google", "facebook", "paypal", "qualcomm",
			"linkedin", "twitter", "intuit", "adobe", "ibm", "oracle",
			"sap" };
	private TextView selection;
	private AutoCompleteTextView edit;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.main);
		selection = (TextView) findViewById(R.id.selection);
		edit = (AutoCompleteTextView) findViewById(R.id.edit);
		edit.addTextChangedListener(this);
		edit.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line, items));
	}

	public void onTextChanged(CharSequence s, int start, int before, int count) {
		Log.d(TAG, "onTextChanged called...");
		selection.setText(edit.getText());
	}

	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		Log.d(TAG, "beforeTextChanged called...");
	}

	public void afterTextChanged(Editable s) {
		Log.d(TAG, "afterTextChanged called...");
	}
}
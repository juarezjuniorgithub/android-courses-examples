package com.juarezjunior.explicitintent;

import com.juarezjunior.explicitintent.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class InvokingActivity extends Activity {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button toInvoke = (Button)findViewById(R.id.invoke_button);
        toInvoke.setOnClickListener(new OnClickListener() {
        	
        	public void onClick(View v) {
        		Intent explicitIntent = new Intent(InvokingActivity.this,InvokedActivity.class);
        		startActivity(explicitIntent);
        	}
        });
    }
}
package com.juarezjunior.explicitintent;

import com.juarezjunior.explicitintent.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InvokedActivity extends Activity {
   
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.invokedactivity);
        Button toReturn = (Button)findViewById(R.id.return_button);
        toReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent explicitIntent = new Intent(InvokedActivity.this,InvokingActivity.class);
                startActivity(explicitIntent);
            }
        });
    }
}

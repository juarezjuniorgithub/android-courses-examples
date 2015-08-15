package com.juarezjunior.simplebroadcastreceiver;

import com.juarezjunior.simplebroadcastreceiver.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	final Activity activity = this; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		Button btnSendMsg =  (Button) findViewById(R.id.btnSendMsg);

		btnSendMsg.setOnClickListener(new OnClickListener() {			
			public void onClick(View v) {		

				sendBroadcastMsg(activity); 
			}
		}); 

	}


	private void sendBroadcastMsg(Activity activity)
	{
		
		String acaoUnica = "com.juarezjunior.simplebroadcastreceiver.broadcasttest";
		Intent broadcastIntent = new Intent(acaoUnica);
		broadcastIntent.putExtra("message", "This is the message sent using the Intent...");
		activity.sendBroadcast(broadcastIntent);
		Log.d("MainActivity - Broadcast Sender", "MSG SENT:" + broadcastIntent.getAction());	
	}

}

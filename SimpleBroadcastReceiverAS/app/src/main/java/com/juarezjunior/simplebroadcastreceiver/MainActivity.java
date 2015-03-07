package com.juarezjunior.simplebroadcastreceiver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private final Activity mActivity = this; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button btnSendMsg =  (Button) findViewById(R.id.btn_send_broadcast_msg);
		btnSendMsg.setOnClickListener(new OnClickListener() {			
			public void onClick(View v) {		
				sendBroadcastMessage(mActivity); 
			}
		}); 
	}


	private void sendBroadcastMessage(Activity act)
	{		
		String action = "com.juarezjunior.simplebroadcastreceiver.broadcasttest";
		Intent broadcastIntent = new Intent(action);
		broadcastIntent.putExtra("message", "Our custom message here...");
		act.sendBroadcast(broadcastIntent);
	}

}

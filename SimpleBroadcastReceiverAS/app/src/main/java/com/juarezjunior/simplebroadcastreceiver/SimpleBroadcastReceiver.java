package com.juarezjunior.simplebroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class SimpleBroadcastReceiver extends BroadcastReceiver{
	
	private static final String TAG = "SimpleBroadcastReceiver";

	
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d(TAG, "Receiving Broadcast Message from intent: " + intent);		 
		String msgKey = "message";		
		if(intent.getStringExtra(msgKey) != null){			
		   String msg = intent.getStringExtra(msgKey);		   
		   Toast.makeText(context, "Broadcast Message received: " + msg, Toast.LENGTH_SHORT).show();
		   Log.d(TAG, "Broadcast Message received: " + msg);		   
		}
		else{
			Log.d(TAG, "Impossible to receive message!");	
		}
	}

}

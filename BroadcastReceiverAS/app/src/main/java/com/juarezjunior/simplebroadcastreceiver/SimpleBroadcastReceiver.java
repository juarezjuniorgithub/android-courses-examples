package com.juarezjunior.simplebroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class SimpleBroadcastReceiver extends BroadcastReceiver{

	
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d("SimpleBroadcastReceiver", "Receiving Broadcast MSG...intent = " + intent);
		 
		String key = "message";
		
		if(intent.getStringExtra(key) != null){			
		   String messagem = intent.getStringExtra(key);
		   
		   Toast.makeText(context, "Msg received: " + messagem, Toast.LENGTH_SHORT).show();
		   Log.d("SimpleBroadcastReceiver", messagem);
		   
		}
		else{
			Log.d("SimpleBroadcastReceiver", "Not possible to retrieve msg");	
		}
	}

}

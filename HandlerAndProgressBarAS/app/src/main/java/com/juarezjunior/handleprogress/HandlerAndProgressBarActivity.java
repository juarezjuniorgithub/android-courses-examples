package com.juarezjunior.handleprogress;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

import java.util.concurrent.atomic.AtomicBoolean;

import com.juarezjunior.handleprogress.R;

public class HandlerAndProgressBarActivity extends Activity implements Runnable {

	private ProgressBar bar;

	Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			bar.incrementProgressBy(5);
		}

	};
	AtomicBoolean isRunning = new AtomicBoolean(false);

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.main);
		bar = (ProgressBar) findViewById(R.id.progress_bar);
	}

	public void onStart() {
		super.onStart();
		bar.setProgress(0);

		Thread background = new Thread(this);

		isRunning.set(true);
		background.start();
	}

	public void onStop() {
		super.onStop();
		isRunning.set(false);
	}

	public void run() {
		try {
			for (int i = 0; i < 20 && isRunning.get(); i++) {
				Thread.sleep(3000);
				handler.sendMessage(handler.obtainMessage());
			}
		} catch (Throwable t) {
		}
	}

}
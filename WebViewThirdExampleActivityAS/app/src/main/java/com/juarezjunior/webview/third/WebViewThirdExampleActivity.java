package com.juarezjunior.webview.third;

import android.app.Activity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.Date;

import com.juarezjunior.webview.second.R;

public class WebViewThirdExampleActivity extends Activity {

	private WebView webViewBrowser;

	@Override
	public void onCreate(Bundle icicle) {

		super.onCreate(icicle);
		this.setContentView(R.layout.main);
		this.webViewBrowser = (WebView) findViewById(R.id.third_web_view);
		this.webViewBrowser.setWebViewClient(new Callback());
		showDateAndTime();

	}

	void showDateAndTime() {

		String targetHtmlPage = "<html><body><a href=\"clock\">"
				+ DateUtils
						.formatDateTime(this, new Date().getTime(),
								DateUtils.FORMAT_SHOW_DATE
										| DateUtils.FORMAT_SHOW_TIME)
				+ "</a></body></html>";

		webViewBrowser.loadData(targetHtmlPage, "text/html", "UTF-8");

	}

	private class Callback extends WebViewClient {

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			showDateAndTime();
			return true;
		}
	}
}

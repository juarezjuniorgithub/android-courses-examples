package com.juarezjunior.webview.second;

import com.juarezjunior.webview.second.R;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewSecondExampleActivity extends Activity {
  
	private WebView webViewBrowser;
  
  @Override
  public void onCreate(Bundle icicle) {
    
	super.onCreate(icicle);
    this.setContentView(R.layout.main);
    webViewBrowser = (WebView)findViewById(R.id.second_web_view);    
    webViewBrowser.loadData("<html><body>Hello there, this is Juarez Jr! :-)</body></html>",
                      "text/html", "UTF-8");
  }
}

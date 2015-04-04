
package com.juarezjunior.webview.first;

import com.juarezjunior.webview.first.R;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewFirstExampleActivity extends Activity {
  
  private WebView webViewBrowser;
  
  @Override
  public void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    setContentView(R.layout.main);
    webViewBrowser=(WebView)findViewById(R.id.first_web_view);
    setContentView(webViewBrowser);// set the webview as the layout  
    webViewBrowser.getSettings().setJavaScriptEnabled(true); 
    //webViewBrowser.getSettings().setUserAgentString("Mozilla/5.0 (X11; Linux i686 on x86_64; rv:10.0) Gecko/20100101 Firefox/10.0");
    webViewBrowser.loadUrl("http://developer.android.com");
  }
}

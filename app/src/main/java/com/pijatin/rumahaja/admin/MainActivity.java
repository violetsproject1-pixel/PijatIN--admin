package com.pijatin.rumahaja.admin;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
public class MainActivity extends Activity{
@Override protected void onCreate(Bundle s){
super.onCreate(s);
WebView w=new WebView(this);
WebSettings ws=w.getSettings();
ws.setJavaScriptEnabled(true);
ws.setDomStorageEnabled(true);
ws.setAllowFileAccess(true);
ws.setAllowFileAccessFromFileURLs(true);
ws.setAllowUniversalAccessFromFileURLs(true);
w.setWebViewClient(new WebViewClient());
w.loadUrl("file:///android_asset/index.html");
setContentView(w);
  shouldOverrideUrlLoading -> kalau whatsapp:// / tel: / wa.me 
-> buka Intent.ACTION_VIEW (buka WhatsApp langsung!)
-> gak error ERR_UNKNOWN_URL_SCHEME lagi!
}
}

package com.pijatin.rumahaja.admin;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.content.Intent;
import android.net.Uri;

public class MainActivity extends Activity{
WebView w;
@Override protected void onCreate(Bundle s){
super.onCreate(s);
w=new WebView(this);
WebSettings ws=w.getSettings();
ws.setJavaScriptEnabled(true);
ws.setDomStorageEnabled(true);
ws.setAllowFileAccess(true);
ws.setAllowFileAccessFromFileURLs(true);
ws.setAllowUniversalAccessFromFileURLs(true);

w.setWebViewClient(new WebViewClient(){
@Override
public boolean shouldOverrideUrlLoading(WebView view, String url){
if(url.startsWith("whatsapp://")||url.startsWith("tel:")||url.startsWith("mailto:")||url.startsWith("https://wa.me")||url.contains("api.whatsapp.com")){
try{
Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
startActivity(i);
}catch(Exception e){}
return true;
}
return false;
}
});

w.loadUrl("file:///android_asset/index.html");
setContentView(w);
}
@Override public void onBackPressed(){
if(w.canGoBack()) w.goBack();
else super.onBackPressed();
}
}

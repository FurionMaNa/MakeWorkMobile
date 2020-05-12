package com.example.makeworkmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private ArrayList<String> historyArray=new ArrayList<>();

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        if(historyArray.size()>1) {
            historyArray.remove(historyArray.size() - 1);
            webView.loadUrl(historyArray.get(historyArray.size() - 1));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView=findViewById(R.id.webPanel);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.loadUrl("https://parstablephp.000webhostapp.com/index.html");
        historyArray.add("https://parstablephp.000webhostapp.com/index.html");
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if(url.contains("https://parstablephp.000webhostapp.com/")){
                    historyArray.add(url);
                    return false;
                }
                return true;
            }
        });
    }
}

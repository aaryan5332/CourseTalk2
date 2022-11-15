package com.example.chatapp4.webview;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chatapp4.R;

public class Web3Activity extends AppCompatActivity {

    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web3);
        web = findViewById(R.id.webView);
        web.setWebViewClient(new WebViewClient());
        web.loadUrl("https://docs.google.com/document/d/1NPFVfjZSlLzKyqMxZrM4_GqNXadakBqs/edit?usp=sharing&ouid=109122313432760751087&rtpof=true&sd=true");
    }
}
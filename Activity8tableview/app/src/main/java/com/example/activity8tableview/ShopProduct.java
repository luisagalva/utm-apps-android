package com.example.activity8tableview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class ShopProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_product);
        String url = getIntent().getStringExtra("url");
        WebView wb1 = (WebView) findViewById(R.id.wb1);
        wb1.loadUrl(url);
    }

    public void Regresar(View v){
        Intent i = new Intent(this, MainActivity.class);

        startActivity(i);
    }
}
package com.example.activity8tableview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Comprar(View v){
        Intent i = new Intent(this, ShopProduct.class);
        switch (v.getId()) {
            case R.id.bt1:
                i.putExtra("url", getResources().getString(R.string.pro1));
                break;
            case R.id.bt2:
                i.putExtra("url", getResources().getString(R.string.pro2));
                break;
            case R.id.bt3:
                i.putExtra("url", getResources().getString(R.string.pro1));
                break;
            case R.id.bt4:
                i.putExtra("url", getResources().getString(R.string.pro2));
                break;
        }
        startActivity(i);
    }

}
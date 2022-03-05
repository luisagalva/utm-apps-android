package com.example.act8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv1 = (TextView) findViewById(R.id.tv1);
        String name = getIntent().getStringExtra("name");
        tv1.setText("Hola " + name);

    }

    public void Regresar(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }


}
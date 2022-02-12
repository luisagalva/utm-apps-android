package com.example.act5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Switch sw1, sw2, sw3, sw4, sw5;
    private boolean art1, art2, art3, art4, art5 = false;
    private ListView listView;
    private ArrayList<String> articles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        sw1 = findViewById(R.id.switch1);
        sw2 = findViewById(R.id.switch2);
        sw3 = findViewById(R.id.switch3);
        sw4 = findViewById(R.id.switch4);
        sw5 = findViewById(R.id.switch5);
        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(art1){
                    art1 = false;
                }else{
                    art1 = true;
                }
            }
        });
        sw5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(art5){
                    art5 = false;
                }else{
                    art5 = true;
                }
            }
        });
        sw4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(art4){
                    art4 = false;
                }else{
                    art4 = true;
                }
            }
        });
        sw3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(art3){
                    art3 = false;
                }else{
                    art3 = true;
                }
            }
        });
        sw2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(art2){
                    art2 = false;
                }else{
                    art2 = true;
                }
            }
        });

    }

    public void Incrementa(View view){
        textView.setText("");

        if(art1){
            textView.setText(textView.getText().toString() + ", " + sw1.getText());
        }
        if(art2){
            textView.setText(textView.getText().toString() + ", " +sw2.getText().toString());
        }
        if(art3){
            textView.setText(textView.getText().toString() + ", "+ sw3.getText().toString());
        }
        if(art4){
            textView.setText(textView.getText().toString() + ", " + sw4.getText().toString());
        }
        if(art5){
            textView.setText(textView.getText().toString()+ ", " + sw5.getText().toString());
        }

    }
}
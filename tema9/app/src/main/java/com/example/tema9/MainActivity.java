package com.example.tema9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Handler textHandler = new Handler(){
        public void handleMessage(Message message){
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText("message");
        }
    };

    public void MakeOperation(View v){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                long actualTime = System.currentTimeMillis();
                long finalTime = actualTime + 20000;
                while (System.currentTimeMillis() < finalTime){
                    synchronized (this){
                        try{
                            wait(finalTime - System.currentTimeMillis());
                        }catch (Exception e){

                        }
                    }
                }
                textHandler.sendEmptyMessage(0);
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();


    }
}
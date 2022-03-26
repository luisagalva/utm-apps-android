package com.example.tema10services;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.content.Context;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends Service {
    private static  final String TYPE = "MyService";
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TYPE, "Iniciado el servicio");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();
                long finalTime = startTime + 3000;

                while(finalTime > System.currentTimeMillis())
                {
                    synchronized (this){
                        try{
                            wait(finalTime - System.currentTimeMillis());
                            Log.i(TYPE, "Servicio en proceso") ;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy(){
        Log.i(TYPE, "Servicio destruido");
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }



}
package com.example.tema9;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class SMSbroadcast extends BroadcastReceiver {
    private static String SMS = "android.provider.Telephony.SMS_RECEIVED";

    @Override
    public void onReceive(Context context, Intent intent) {

        try {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {

                Object[] objects = (Object[]) bundle.get("pdus");

                SmsMessage[] messages = new SmsMessage[objects.length];
                for (int i = 0; i < objects.length; i++) {
                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) objects[i]);
                    String phoneNumber = currentMessage.getDisplayOriginatingAddress();

                    messages[i] = currentMessage;
                    String senderNum = phoneNumber;
                    String message = currentMessage.getDisplayMessageBody();
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                    Log.e(message, "Exception smsReceiver" );
                }
            } // bundle is null

        } catch (Exception e) {
            Log.e("SmsReceiver", "Exception smsReceiver" + e);


        }
    }
}
package com.example.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;


public class Reciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent){
        String a = intent.getAction();
        if(!a.equals("com.example.SHIVAM_BROADCAST")) {
            Toast.makeText(context, "Custom message received", Toast.LENGTH_SHORT).show();
        }
        else if (isAirplaneModeOn(context)) {
            Log.d("SHIVAM"," airplane mode on");
            Toast.makeText(context, "AirPlane mode is on", Toast.LENGTH_SHORT).show();
        } else {
            Log.d("SHIVAM","off");
            Toast.makeText(context, "AirPlane mode is off", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isAirplaneModeOn(Context context) {
       // Log.d("SHIVAM","off");

        return Settings.System.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
    }


}

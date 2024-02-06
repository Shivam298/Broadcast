package com.example.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Broadcast extends AppCompatActivity {

    BroadcastReceiver reciver=new Reciever();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button send=findViewById(R.id.send);
        IntentFilter filter=new IntentFilter();
        filter.addAction("com.example.SHIVAM_BROADCAST");
        getApplicationContext().registerReceiver(reciver,filter, Context.RECEIVER_NOT_EXPORTED);
        send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    Log.d("SHivam","Message recieved");
                    Intent intent=new Intent();
                    intent.setPackage("com.example.broadcast");
                    intent.setAction("com.example.SHIVAM_BROADCAST");
                    sendBroadcast(intent);
                }
        });
    }
}

package com.example.broadcastsdemo;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MyBroadcastReceiver br = new MyBroadcastReceiver();
    private static final String DEMO_ACTION = "com.example.broadcastsdemo.DemoAction";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter filter = new IntentFilter();
        filter.addAction(DEMO_ACTION);
        this.registerReceiver(br, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.unregisterReceiver(br);
    }

    public void sendBroadcast(View view) {
        Intent intent = new Intent();
        intent.setAction(DEMO_ACTION);
        intent.putExtra("data","Hello, world!");
        sendBroadcast(intent);
    }

}

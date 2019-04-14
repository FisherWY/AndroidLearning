package com.fisher.helloandroid;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BroadcastActivity extends AppCompatActivity {
    private final String ACTION_CUSTOM_BOARDCAST = BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BOARDCAST";

    private CustomReceiver receiver = new CustomReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcast_layout);

        // 电池充电状态监听
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
//        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
//        this.registerReceiver(receiver, intentFilter);

        // 自定义广播
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, new IntentFilter(ACTION_CUSTOM_BOARDCAST));
    }

    @Override
    protected void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
        this.unregisterReceiver(receiver);
        super.onDestroy();
    }

    public void sendCustomBroadcast(View view) {
        Intent intent = new Intent(ACTION_CUSTOM_BOARDCAST);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
}

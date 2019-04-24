package com.fisher.helloandroid.test1_6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.fisher.helloandroid.R;
import com.fisher.helloandroid.test1_6.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        Button forceOffline = findViewById(R.id.force_offline);
        forceOffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.fisher.helloandroid.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });
    }
}

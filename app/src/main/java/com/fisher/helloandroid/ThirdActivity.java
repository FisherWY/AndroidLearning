package com.fisher.helloandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends BaseActivity {

    private static final String TAG = "ThirdActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);

        Button button = findViewById(R.id.button_3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityController.finishAll();
            }
        });
    }

    public static void actionStart(Context context) {
        Log.w(TAG, "actionStart: Third Activity Start");
        Intent intent = new Intent(context, ThirdActivity.class);
        context.startActivity(intent);
    }
}

package com.fisher.helloandroid.test1_6;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.fisher.helloandroid.R;

public class SecondActivity extends BaseActivity {
    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

//        接受来自父活动的数据
//        Intent intent = getIntent();
//        String data = intent.getStringExtra("extra_data");
//        Log.d(TAG, "onCreate: " + data);

        Button button = (Button) findViewById(R.id.button_2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ThirdActivity.actionStart(SecondActivity.this);

                HelloWorldActivity.actionStart(SecondActivity.this, "翁瑜 20172005079");
//                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
//                startActivity(intent);
//                intent.setData(Uri.parse("http://www.google.com"));
//                startActivity(intent);
//                intent.putExtra("data_return", "GOGOGOGOGOGO");
//                setResult(RESULT_OK, intent);
//                finish();
            }
        });
    }

//    用户按下返回键时向父窗口传递数据
    @Override
    public void onBackPressed() {
//        Intent intent = new Intent();
//        intent.putExtra("data_return", "GOOGOOGOGO");
//        setResult(RESULT_OK, intent);

        Log.w(TAG, "onBackPressed: Press back");
//        HelloWorldActivity.actionStart(SecondActivity.this);
        finish();
    }

//    活动的actionstart
    public static void actionStart(Context context, String data0, String data1) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("data0", data0);
        intent.putExtra("data1", data1);
        context.startActivity(intent);
    }
}

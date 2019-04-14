package com.fisher.helloandroid;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HelloWorldActivity extends BaseActivity {
    private static final String TAG = "HelloWorldActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Log.w(TAG, "onCreate method");

        Button button = (Button) findViewById(R.id.button_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                消息框
//                Toast.makeText(HelloWorldActivity.this, "You clicked Button 1", Toast.LENGTH_SHORT).show();
//                Log.w(TAG, "onClick: click button1");

//                显式intent
//                Intent intent = new Intent(HelloWorldActivity.this, SecondActivity.class);
//                startActivity(intent);

//                隐式intent
//                Intent intent = new Intent("com.fisher.helloandroid.ACTION_START");
//                intent.addCategory("com.fisher.helloandroid.MY_CATEGORY");
//                String data = "gogogo";
//                intent.putExtra("extra_data", data);
//                startActivity(intent);
//                startActivityForResult(intent, 1);

//                Log.w(TAG, "onClick: Start SecondActivity" );
//                SecondActivity.actionStart(HelloWorldActivity.this, "datadsad", "gogogo");

                Log.w(TAG, "onClick: Start fourth activity");
                FourthActivity.actionStart(HelloWorldActivity.this);
            }
        });
    }

//    创建menu函数
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

//    选择menu的item时的监听函数
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                Log.w(TAG, "onOptionsItemSelected: Add");
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                Log.w(TAG, "onOptionsItemSelected: Remove");
                break;
            default:
                Log.w(TAG, "onOptionsItemSelected: Defalut");
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    Log.w(TAG, "onActivityResult: " + data.getStringExtra("data_return"));
                }
                break;
            default:
                Log.w(TAG, "onActivityResult: 没有收到任何回应");
        }
    }

    public static void actionStart(Context context, String data) {
        Log.w(TAG, "actionStart: HelloWorld Activity start");
        Intent intent = new Intent(context, HelloWorldActivity.class);
        intent.putExtra("data", data);
        context.startActivity(intent);

        intent.getStringExtra("data");
        Log.w(TAG, "actionStart: " + data);
    }
}

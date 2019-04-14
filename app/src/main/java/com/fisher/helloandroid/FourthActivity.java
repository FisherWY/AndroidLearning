package com.fisher.helloandroid;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class FourthActivity extends AppCompatActivity{
    private static final String TAG = "Fourth Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth_layout);

        Button button = findViewById(R.id.buttonin4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gogo(0);
            }
        });
    }

    private void gogo(int type) {
        switch (type) {
            case 0:
                AlertDialog.Builder dialog = new AlertDialog.Builder(FourthActivity.this);
                dialog.setTitle("This is a dialog");
                dialog.setMessage("Sth important");
                dialog.setCancelable(true);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i(TAG, "onClick: Click OK~!");
                    }
                });
                dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i(TAG, "onClick: Click cancel~!");
                    }
                });
                dialog.show();
                break;
            case 1:
                ProgressDialog progressDialog = new ProgressDialog(FourthActivity.this);
                progressDialog.setTitle("This is progress bar");
                progressDialog.setMessage("Loading.....");
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
            default:
                break;
        }
    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.buttonin4:
//                AlertDialog.Builder dialog = new AlertDialog.Builder(FourthActivity.this);
//                dialog.setTitle("This is a dialog");
//                dialog.setMessage("Sth important");
//                dialog.setCancelable(true);
//                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Log.i(TAG, "onClick: Click OK~!");
//                    }
//                });
//                dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Log.i(TAG, "onClick: Click cancel~!");
//                    }
//                });
//                dialog.show();
//                break;
//            default:
//                break;
//        }
//    }

    public static void actionStart(Context context) {
        Log.w(TAG, "actionStart: Fourth Activity Start");
        Intent intent = new Intent(context, ThirdActivity.class);
        context.startActivity(intent);
    }
}

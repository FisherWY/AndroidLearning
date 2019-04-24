package com.fisher.helloandroid.test1_6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.fisher.helloandroid.BuildConfig;

public class CustomReceiver extends BroadcastReceiver {
    private final String ACTION_CUSTOM_BOARDCAST = BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BOARDCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        String IntentAction = intent.getAction();
        if (IntentAction != null) {
            String toastMsg = "unknow intent msg";
            switch (IntentAction) {
                case Intent.ACTION_POWER_CONNECTED:
                    toastMsg = "Power connected!";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMsg = "Power disconnected!";
                    break;
                case ACTION_CUSTOM_BOARDCAST:
                    toastMsg = "20172005079 翁瑜 软工2班";
                    break;
            }
            Toast.makeText(context, toastMsg, Toast.LENGTH_SHORT).show();
        }

    }
}

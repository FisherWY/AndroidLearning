package com.fisher.helloandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * @Author: Fisher
 * @Date: 2019-04-03 10:40
 */

public class LoginActivity extends BaseActivity {

    private SharedPreferences preferences;

    private SharedPreferences.Editor preferencesEditor;

    private EditText accountEdit;

    private EditText passwordEdit;

    private CheckBox rememberCheck;

    private Button login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_layout);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferencesEditor = PreferenceManager.getDefaultSharedPreferences(this).edit();

        accountEdit = findViewById(R.id.account);
        passwordEdit = findViewById(R.id.password);
        rememberCheck = findViewById(R.id.login_checkbox);
        login = findViewById(R.id.login);

        if (preferences.getBoolean("remember", false)) {
            accountEdit.setText(preferences.getString("account", ""));
            passwordEdit.setText(preferences.getString("password", ""));
            rememberCheck.setChecked(true);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                // 如果账号是admin且密码是123456，即认为登录成功
                if (account.equals("20172005079") && password.equals("123456")) {
                    // 如果勾选了记住密码
                    if (rememberCheck.isChecked()) {
                        preferencesEditor.putString("account", account);
                        preferencesEditor.putString("password", password);
                        preferencesEditor.putBoolean("remember", rememberCheck.isChecked());
                    } else {
                        preferencesEditor.clear();
                    }
                    preferencesEditor.apply();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "account or password invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

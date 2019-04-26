package com.fisher.helloandroid.test8;

/**
 * @Author Fisher
 * @Date 2019/4/26 19:04
 **/

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.fisher.helloandroid.R;
import com.fisher.helloandroid.test7.MyDatabaseHelper;

/**
 * @Author Fisher
 * @Date 2019/4/17 11:01
 **/


public class test8providermain extends AppCompatActivity {

    private static final String TAG = "MyDatabaseMain";

    private String newId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mydatabasehelper_main);

        // add data button
        Button addData = findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDataFun();
            }
        });

        // update data button
        Button updateData = findViewById(R.id.update_data);
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDataFun();
            }
        });

        // delete data button
        Button deleteData = findViewById(R.id.delete_data);
        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteDataFun();
            }
        });

        // select data button
        Button selectData = findViewById(R.id.select_data);
        selectData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDataFun();
            }
        });
    }

    private void addDataFun() {
        Uri uri = Uri.parse("content://com.fisher.helloworld.provider/book");
        ContentValues values = new ContentValues();

        values.put("name", "Hello");
        values.put("author", "fisher");
        values.put("pages", 454);
        values.put("price", 16.96);
        Uri newUri = getContentResolver().insert(uri, values);
        values.clear();
        newId = newUri.getPathSegments().get(1);

        Toast.makeText(this, "Add success", Toast.LENGTH_SHORT).show();
    }

    private void updateDataFun() {
        Uri uri = Uri.parse("content://com.fisher.helloworld.provider/book/" + newId);
        ContentValues values = new ContentValues();

        values.put("price", 99999);
        getContentResolver().update(uri, values, "id = ?", new String[] {"1"});
        values.clear();

        Toast.makeText(this, "Update success", Toast.LENGTH_SHORT).show();
    }

    private void deleteDataFun() {
        Uri uri = Uri.parse("content://com.fisher.helloworld.provider/book");
        getContentResolver().delete(uri, "id > ?", new String[] {"2"});

        Toast.makeText(this, "Delete success", Toast.LENGTH_SHORT).show();
    }

    private void selectDataFun() {
        Uri uri = Uri.parse("content://com.fisher.helloworld.provider/book");

        // 查询表中所有的数据
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                // 遍历并打印
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String author = cursor.getString(cursor.getColumnIndex("author"));
                int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                double price = cursor.getDouble(cursor.getColumnIndex("price"));

                Log.d(TAG, "selectDataFun: book name -> " + name);
                Log.d(TAG, "selectDataFun: book author -> " + author);
                Log.d(TAG, "selectDataFun: book page -> " + pages);
                Log.d(TAG, "selectDataFun: book price -> " + price);
            } while (cursor.moveToNext());
        }
        cursor.close();

        Toast.makeText(this, "Select success", Toast.LENGTH_SHORT).show();
    }
}


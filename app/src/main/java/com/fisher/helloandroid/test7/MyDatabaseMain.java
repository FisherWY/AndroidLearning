package com.fisher.helloandroid.test7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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


public class MyDatabaseMain extends AppCompatActivity {

    private static final String TAG = "MyDatabaseMain";

    private MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mydatabasehelper_main);
        myDatabaseHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);

        // create button
        Button createDatabase = (Button) findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDatabaseHelper.getWritableDatabase();
            }
        });

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
        SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        // 第一条数据
        values.put("name", "Hello");
        values.put("author", "fisher");
        values.put("pages", 454);
        values.put("price", 16.96);
        db.insert("Book", null, values);
        values.clear();

        // 第二条数据
        values.put("name", "World");
        values.put("author", "yung");
        values.put("pages", 123);
        values.put("price", 14.32);
        db.insert("Book", null, values);
        values.clear();

        Toast.makeText(this, "Add success", Toast.LENGTH_SHORT).show();
    }

    private void updateDataFun() {
        SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("price", 99999);
        db.update("Book", values, "id = ?", new String[] {"1"});
        values.clear();

        Toast.makeText(this, "Update success", Toast.LENGTH_SHORT).show();
    }

    private void deleteDataFun() {
        SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
        db.delete("Book", "id > ?", new String[] {"2"});

        Toast.makeText(this, "Delete success", Toast.LENGTH_SHORT).show();
    }

    private void selectDataFun() {
        SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();

        // 查询表中所有的数据
        Cursor cursor = db.query("Book", null, null, null, null, null, null);
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

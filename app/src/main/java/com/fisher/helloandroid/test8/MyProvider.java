package com.fisher.helloandroid.test8;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * @Author Fisher
 * @Date 2019/4/26 17:35
 **/

public class MyProvider extends ContentProvider {

    public static final int TABLE1_DIR = 0;

    public static final int TABLE1_ITEM = 1;

    public static final int TABLE2_DIR = 2;

    public static final int TABLE2_ITEM = 3;

    private static UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI("com.fisher.helloworld.provider", "table1", TABLE1_DIR);
        uriMatcher.addURI("com.fisher.helloworld.provider", "table1/#", TABLE1_ITEM);
        uriMatcher.addURI("com.fisher.helloworld.provider", "table2", TABLE2_DIR);
        uriMatcher.addURI("com.fisher.helloworld.provider", "table2/#", TABLE2_ITEM);
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, String sortOrder) {
        switch (uriMatcher.match(uri)) {
            case TABLE1_DIR:
                // 查询table1中表的所有数据
                break;
            case TABLE1_ITEM:
                // 查询table1中表的单条数据
                break;
            case TABLE2_DIR:
                // 查询table2中表的所有数据
                break;
            case TABLE2_ITEM:
                // 查询table2中表的单条数据
                break;
            default:
                break;
        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (uriMatcher.match(uri)) {
            case TABLE1_DIR:
                return "vnd.android.cursor.dir/vnd.com.fisher.helloworld.provider.table1";
            case TABLE1_ITEM:
                return "vnd.android.cursor.item/vnd.com.fisher.helloworld.provider.table1";
            case TABLE2_DIR:
                return "vnd.android.cursor.dir/vnd.com.fisher.helloworld.provider.table2";
            case TABLE2_ITEM:
                return "vnd.android.cursor.item/vnd.com.fisher.helloworld.provider.table1";
            default:
                break;
        }
        return null;
    }
}

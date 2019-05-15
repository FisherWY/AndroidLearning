package com.fisher.helloandroid.test10;

/**
 * @Author Fisher
 * @Date 2019/5/15 10:28
 **/


public interface DownloadListener {
    void onProgress(int progress);

    void onSuccess();

    void onFailed();

    void onPaused();

    void onCanceled();
}

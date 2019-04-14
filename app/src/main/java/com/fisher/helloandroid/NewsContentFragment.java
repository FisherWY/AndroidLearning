package com.fisher.helloandroid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @Author Fisher
 * @Date 2019/3/20 20:30
 **/


public class NewsContentFragment extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_content_frag, container, false);
        return view;
    }

    public void refresh(String newsTitle, String newsContent) {
        View visibilityLayout = view.findViewById(R.id.visibility_layout);
        visibilityLayout.setVisibility(View.VISIBLE);
        TextView newsTittleText = view.findViewById(R.id.news_tittle);
        TextView newsContentText = view.findViewById(R.id.news_content);
//        刷新新闻标题
        newsTittleText.setText(newsTitle);
//        刷新新闻内容
        newsContentText.setText(newsContent);
    }
}

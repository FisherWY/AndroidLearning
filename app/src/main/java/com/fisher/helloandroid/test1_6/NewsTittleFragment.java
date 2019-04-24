package com.fisher.helloandroid.test1_6;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.fisher.helloandroid.R;
import com.fisher.helloandroid.test1_6.News;
import com.fisher.helloandroid.test1_6.NewsContentActivity;
import com.fisher.helloandroid.test1_6.NewsContentFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author Fisher
 * @Date 2019/3/20 21:03
 **/


public class NewsTittleFragment extends Fragment {
    private boolean isTwoPane;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_tittle_frag, container, false);

        RecyclerView newsTittleRecyclerView = (RecyclerView) view.findViewById(R.id.news_tittle_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        newsTittleRecyclerView.setLayoutManager(layoutManager);
        NewsAdapter adapter = new NewsAdapter(getNews());
        newsTittleRecyclerView.setAdapter(adapter);

        return view;
    }

    private List<News> getNews() {
        List<News> newsList = new ArrayList<>();
        News n = new News();
        n.setTittle("20172005079 翁瑜");
        n.setContent("20172005079 翁瑜 20172005079 翁瑜 20172005079 翁瑜 20172005079 翁瑜 20172005079 翁瑜");
        newsList.add(n);
        for (int i=1; i<50; i++) {
            News news = new News();
            news.setTittle("This is tittle " + i);
            news.setContent(getRandomLengthContent("This is news content " + i + ". "));
            newsList.add(news);
        }
        return newsList;
    }

    private String getRandomLengthContent(String content) {
        Random random = new Random();
        int length = random.nextInt(20)+1;
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<length; i++) {
            builder.append(content);
        }
        return builder.toString();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.news_content) != null) {
            isTwoPane = true;
        } else {
            isTwoPane = false;
        }
    }

    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

        private List<News> mNewsList;

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView newsTittleText;

            public ViewHolder(View view) {
                super(view);
                newsTittleText = (TextView) view.findViewById(R.id.news_tittle);
            }
        }

        public NewsAdapter(List<News> newsList) {
            mNewsList = newsList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_item, viewGroup, false);
            final ViewHolder holder = new ViewHolder(view);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    News news = mNewsList.get(holder.getAdapterPosition());
                    if (isTwoPane) {
                        // 如果是双页模式，则刷新NewsContentFragment中的内容
                        NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager().findFragmentById(R.id.news_content_fragment);
                        newsContentFragment.refresh(news.getTittle(), news.getContent());
                    } else {
                        // 如果是单页模式，则直接启动NewsContentActivity
                        NewsContentActivity.actionStart(getActivity(), news.getTittle(), news.getContent());
                    }
                }
            });

            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            News news = mNewsList.get(position);
            holder.newsTittleText.setText(news.getTittle());
        }

        @Override
        public int getItemCount() {
            return mNewsList.size();
        }
    }

    public boolean isTwoPane() {
        return isTwoPane;
    }
}

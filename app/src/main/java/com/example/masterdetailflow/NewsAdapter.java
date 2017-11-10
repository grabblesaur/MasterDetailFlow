package com.example.masterdetailflow;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.masterdetailflow.model.News;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Majo on 10.11.17.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private ArrayList<News> mNewsArrayList;
    private NewsAdapterListener mListener;

    public NewsAdapter(ArrayList<News> news) {
        mNewsArrayList = news;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        holder.onBind(mNewsArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return mNewsArrayList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_news_tv_title)
        TextView mTitleTextView;

        public NewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void onBind(final News news) {
            mTitleTextView.setText(news.getTitle());
            mTitleTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mListener != null)
                        mListener.onNewsClicked(news);
                }
            });
        }
    }

    public void setListener(NewsAdapterListener listener) {
        mListener = listener;
    }

    public interface NewsAdapterListener {
        void onNewsClicked(News news);
    }
}

package com.example.masterdetailflow;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.masterdetailflow.model.News;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Majo on 10.11.17.
 */

public class DetailFlowFragment extends Fragment {

    private static final String NEWS_TITLE = "news_title";
    private static final String NEWS_DESC = "news_desc";

    @BindView(R.id.df_tv_title)
    TextView mTitleTextView;
    @BindView(R.id.df_tv_desc)
    TextView mDescTextView;

    public static DetailFlowFragment newInstance(News news) {
        DetailFlowFragment fragment = new DetailFlowFragment();
        Bundle bundle = new Bundle();
        if (news != null) {
            bundle.putString(NEWS_TITLE, news.getTitle());
            bundle.putString(NEWS_DESC, news.getDescription());
        }
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_flow, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            String title = getArguments().getString(NEWS_TITLE, "");
            String desc = getArguments().getString(NEWS_DESC, "");
//        News news = new News(title, desc);
            mTitleTextView.setText(title);
            mDescTextView.setText(desc);
        }
    }
}

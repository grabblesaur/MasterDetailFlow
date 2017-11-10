package com.example.masterdetailflow;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.masterdetailflow.model.News;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Majo on 10.11.17.
 */

public class MasterFragment extends Fragment implements NewsAdapter.NewsAdapterListener {

    @BindView(R.id.master_recycler_view)
    RecyclerView mRecyclerView;
    private NewsAdapter newsAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_master, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // место для работы и инициализации ui элементов
        newsAdapter = new NewsAdapter(News.getNews());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(newsAdapter);
        newsAdapter.setListener(this);
    }

    @Override
    public void onNewsClicked(News news) {
        Toast.makeText(getActivity(), news.getTitle(), Toast.LENGTH_SHORT).show();
        ((MainActivity) getActivity()).showDetailFlowFragment(news);
    }
}

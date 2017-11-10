package com.example.masterdetailflow.model;

import java.util.ArrayList;

/**
 * Created by Majo on 10.11.17.
 */

public class News {

    private String mTitle;
    private String mDescription;

    public News(String title, String description) {
        mTitle = title;
        mDescription = description;
    }

    public News() {

    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public static ArrayList<News> getNews() {
        ArrayList<News> news = new ArrayList<>();
        news.add(new News("a", "aaaaa"));
        news.add(new News("b", "bbbb"));
        news.add(new News("c", "cccc"));
        news.add(new News("d", "dddd"));
        return news;
    }
}

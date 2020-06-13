package com.integro.sjii.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NewsList {

    private String success;

    private String message;

    @SerializedName("sjii_news")
    private ArrayList<News> newsArrayList;

    public NewsList(String success, String message, ArrayList<News> newsArrayList) {
        this.success = success;
        this.message = message;
        this.newsArrayList = newsArrayList;
    }

    public String getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<News> getNewsArrayList() {
        return newsArrayList;
    }
}

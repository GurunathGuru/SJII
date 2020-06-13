package com.integro.sjii.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NewsImagesList {

    private String success;

    private String message;

    @SerializedName("newsimages")
    private ArrayList<NewsImages> newsImagesArrayList;

    public NewsImagesList(String success, String message, ArrayList<NewsImages> newsImagesArrayList) {
        this.success = success;
        this.message = message;
        this.newsImagesArrayList = newsImagesArrayList;
    }

    public String getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<NewsImages> getNewsImagesArrayList() {
        return newsImagesArrayList;
    }
}

package com.integro.sjii.models;

import java.io.Serializable;

public class NewsImages implements Serializable {

    private String image;

    private String updated_at;

    private String id;

    private String news_id;

    public NewsImages(String image, String updated_at, String id, String news_id) {
        this.image = image;
        this.updated_at = updated_at;
        this.id = id;
        this.news_id = news_id;
    }

    public String getImage() {
        return image;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getId() {
        return id;
    }

    public String getNews_id() {
        return news_id;
    }
}

package com.integro.sjii.models;

import java.io.Serializable;

public class News implements Serializable {

    private String date;

    private String image;

    private String updated_at;

    private String description;

    private String id;

    private String title;

    public News(String date, String image, String updated_at, String description, String id, String title) {
        this.date = date;
        this.image = image;
        this.updated_at = updated_at;
        this.description = description;
        this.id = id;
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public String getImage() {
        return image;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}

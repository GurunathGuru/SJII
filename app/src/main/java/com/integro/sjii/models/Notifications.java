package com.integro.sjii.models;

import java.io.Serializable;

public class Notifications implements Serializable {

    private String date;

    private String updated_at;

    private String description;

    private String id;

    private String title;

    public Notifications(String date, String updated_at, String description, String id, String title) {
        this.date = date;
        this.updated_at = updated_at;
        this.description = description;
        this.id = id;
        this.title = title;
    }

    public String getDate() {
        return date;
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

package com.integro.sjii.models;

import java.io.Serializable;

public class Announcements implements Serializable {

    private String date;

    private String pdf;

    private String updated_at;

    private String id;

    private String title;

    public String getDate() {
        return date;
    }

    public String getPdf() {
        return pdf;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}

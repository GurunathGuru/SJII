package com.integro.sjii.models;

import java.io.Serializable;

public class Faculty implements Serializable {

    private String image;

    private String institution;

    private String updated_at;

    private String name;

    private String id;

    private String designation;

    public String getImage() {
        return image;
    }

    public String getInstitution() {
        return institution;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getDesignation() {
        return designation;
    }
}

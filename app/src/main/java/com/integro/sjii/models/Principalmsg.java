package com.integro.sjii.models;

import java.io.Serializable;

public class Principalmsg implements Serializable {

    private String image;

    private String updated_at;

    private String name;

    private String description;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    private String id;

    private String tag;

    private String designation;


    public String getImage ()
    {
        return image;
    }

    public void setImage (String image)
    {
        this.image = image;
    }

    public String getUpdated_at ()
    {
        return updated_at;
    }

    public void setUpdated_at (String updated_at)
    {
        this.updated_at = updated_at;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getDesignation ()
    {
        return designation;
    }

    public void setDesignation (String designation)
    {
        this.designation = designation;
    }

}

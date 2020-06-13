package com.integro.sjii.models;

import java.io.Serializable;

public class SjiiPTA implements Serializable {

    private String image;

    private String updated_at;

    private String name;

    private String id;

    private String designation;

    private String position;

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

    public String getPosition ()
    {
        return position;
    }

    public void setPosition (String position)
    {
        this.position = position;
    }
}

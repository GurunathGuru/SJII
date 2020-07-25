package com.integro.sjii.models;

import java.io.Serializable;

public class Alumni implements Serializable {

    private String image;

    private String updated_at;

    private String name;

    private String batch;

    private String id;

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

    public String getBatch ()
    {
        return batch;
    }

    public void setBatch (String batch)
    {
        this.batch = batch;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
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

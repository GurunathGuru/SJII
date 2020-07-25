package com.integro.sjii.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AlumniList {

    @SerializedName("sjii_alumni")
    private ArrayList<Alumni> alumniArrayList;

    private String success;

    private String message;

    public ArrayList<Alumni> getAlumniArrayList() {
        return alumniArrayList;
    }

    public void setAlumniArrayList(ArrayList<Alumni> alumniArrayList) {
        this.alumniArrayList = alumniArrayList;
    }

    public String getSuccess ()
    {
        return success;
    }

    public void setSuccess (String success)
    {
        this.success = success;
    }

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }
}

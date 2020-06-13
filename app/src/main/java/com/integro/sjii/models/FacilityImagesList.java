package com.integro.sjii.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FacilityImagesList {

    private String success;

    private String message;

    @SerializedName("facilityimages")
    private ArrayList<FacilityImages> facilityImagesArrayList;

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

    public ArrayList<FacilityImages> getFacilityImagesArrayList() {
        return facilityImagesArrayList;
    }

    public void setFacilityImagesArrayList(ArrayList<FacilityImages> facilityImagesArrayList) {
        this.facilityImagesArrayList = facilityImagesArrayList;
    }
}

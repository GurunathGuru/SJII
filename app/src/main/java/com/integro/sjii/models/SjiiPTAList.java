package com.integro.sjii.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SjiiPTAList {

    private String success;

    @SerializedName("sjii_pta")
    private ArrayList<SjiiPTA>sjiiPTAArrayList;

    private String message;

    public String getSuccess ()
    {
        return success;
    }

    public void setSuccess (String success)
    {
        this.success = success;
    }

    public ArrayList<SjiiPTA> getSjiiPTAArrayList() {
        return sjiiPTAArrayList;
    }

    public void setSjiiPTAArrayList(ArrayList<SjiiPTA> sjiiPTAArrayList) {
        this.sjiiPTAArrayList = sjiiPTAArrayList;
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

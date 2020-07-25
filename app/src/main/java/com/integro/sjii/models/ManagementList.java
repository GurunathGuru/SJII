package com.integro.sjii.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ManagementList {

    private String success;

    private String message;

    @SerializedName("sjii_management")
    private ArrayList<Management> managementArrayList;

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

    public ArrayList<Management> getManagementArrayList() {
        return managementArrayList;
    }

    public void setManagementArrayList(ArrayList<Management> managementArrayList) {
        this.managementArrayList = managementArrayList;
    }
}

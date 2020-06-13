package com.integro.sjii.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class InstitutionList {

    private String success;

    @SerializedName("sjii_institution")
    private ArrayList<Institution> institutionArrayList;

    private String message;

    public String getSuccess ()
    {
        return success;
    }

    public void setSuccess (String success)
    {
        this.success = success;
    }

    public ArrayList<Institution> getInstitutionArrayList() {
        return institutionArrayList;
    }

    public void setInstitutionArrayList(ArrayList<Institution> institutionArrayList) {
        this.institutionArrayList = institutionArrayList;
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

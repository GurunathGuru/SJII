package com.integro.sjii.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PrincipalmsgList {

    private String success;

    @SerializedName("principal_msg")
    private ArrayList<Principalmsg> principalmsgArrayList;

    private String message;

    public PrincipalmsgList(String success, ArrayList<Principalmsg> principalmsgArrayList, String message) {
        this.success = success;
        this.principalmsgArrayList = principalmsgArrayList;
        this.message = message;
    }

    public String getSuccess() {
        return success;
    }

    public ArrayList<Principalmsg> getPrincipalmsgArrayList() {
        return principalmsgArrayList;
    }

    public String getMessage() {
        return message;
    }
}

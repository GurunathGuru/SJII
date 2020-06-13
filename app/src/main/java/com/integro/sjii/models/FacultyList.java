package com.integro.sjii.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FacultyList {

    private String success;

    @SerializedName("sjii_faculty")
    private ArrayList<Faculty> facultyArrayList;

    private String message;

    public String getSuccess() {
        return success;
    }

    public ArrayList<Faculty> getFacultyArrayList() {
        return facultyArrayList;
    }

    public String getMessage() {
        return message;
    }
}

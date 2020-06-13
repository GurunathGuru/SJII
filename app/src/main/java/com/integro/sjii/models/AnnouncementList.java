package com.integro.sjii.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AnnouncementList {

    private String success;

    private String message;

    @SerializedName("sjii_announcement")
    private ArrayList<Announcements> announcementsArrayList;

    public String getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<Announcements> getAnnouncementsArrayList() {
        return announcementsArrayList;
    }
}

package com.integro.sjii.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NotificationsList {

    private String success;

    private String message;

    @SerializedName("pta")
    private ArrayList<Notifications> notificationsArrayList;


    public NotificationsList(String success, String message, ArrayList<Notifications> notificationsArrayList) {
        this.success = success;
        this.message = message;
        this.notificationsArrayList = notificationsArrayList;
    }

    public String getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<Notifications> getNotificationsArrayList() {
        return notificationsArrayList;
    }
}

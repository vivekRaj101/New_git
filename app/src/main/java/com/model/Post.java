package com.model;

import com.google.gson.annotations.SerializedName;

public class Post {
    private int userID;
    private int iD;
    private String title;

    @SerializedName("body ")
    private String text;


    public int getUserID() {
        return userID;
    }

    public int getiD() {
        return iD;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}

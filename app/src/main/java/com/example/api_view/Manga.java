package com.example.api_view;

import com.google.gson.annotations.SerializedName;

public class Manga    {
    @SerializedName ("1d_Manga")
    private int id;
    @SerializedName ("manga_Name")
    private String name;
    @SerializedName ("manga_Detail")
    private String detail;
    @SerializedName ("manga_Img")
    private String image;
    @SerializedName ("student_FIO")
    private String student;
    @SerializedName ("student_Score")
    private int score;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDetail() {
        return detail;
    }

    public String getImage() {
        return image;
    }

    public String getStudent() {
        return student;
    }

    public int getScore() {
        return score;
    }
}

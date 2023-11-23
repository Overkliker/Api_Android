package com.example.api_view;

import com.google.gson.annotations.SerializedName;

public class Manga    {
    private int id;

    private String name;

    private String image;

    public Manga(int id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

}

package com.example.api_view;

import com.google.gson.annotations.SerializedName;

public class Car    {
    @SerializedName("carId")
    private int id;
    @SerializedName("carName")
    private String name;
    @SerializedName("carEngine")
    private String engine;
    @SerializedName("carImg")
    private String img;
}

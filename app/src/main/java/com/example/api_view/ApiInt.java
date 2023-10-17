package com.example.api_view;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInt {
    @GET("manga")
    Call<ArrayList<Car>> getCarsList();
}

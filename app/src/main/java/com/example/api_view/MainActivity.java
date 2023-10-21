package com.example.api_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    ApiInt apiInt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.list);
        apiInt = ServiceBuilder.buildRequest().create(ApiInt.class);

        Call<ArrayList<Manga>> getMangaList = apiInt.getMangaList();

        getMangaList.enqueue(new Callback<ArrayList<Manga>>() {
            @Override
            public void onResponse(Call<ArrayList<Manga>> call, Response<ArrayList<Manga>> response) {
                if (response.isSuccessful()){
                    rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    rv.setHasFixedSize(true);


                    ArrayList<Manga> mangaList = response.body();
                    System.out.println(mangaList.get(0).getName());
                    System.out.println(mangaList.get(0).getImage());
                    RecycleAdapter adapter = new RecycleAdapter(getApplicationContext(), mangaList);
                    rv.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Manga>> call, Throwable t) {

            }
        });



    }
}
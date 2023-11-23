package com.example.api_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    Button addBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.list);
        addBtn = findViewById(R.id.addBtn);


        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddManga.class);
                startActivity(intent);
            }
        });


        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);

        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv.setHasFixedSize(true);

        RecycleAdapter adapter = new RecycleAdapter(getApplicationContext(), dataBaseHelper.getMangaList());
        rv.setAdapter(adapter);

    }
}
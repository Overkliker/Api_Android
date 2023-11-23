package com.example.api_view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddManga extends AppCompatActivity {
    EditText manga_name, manga_img;
    Button addBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_manga);

        manga_name = findViewById(R.id.manga_name);
        manga_img = findViewById(R.id.manga_img);
        addBtn = findViewById(R.id.add_manga);

        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Manga manga = new Manga(0, manga_name.getText().toString(),
                        manga_img.getText().toString());
                dataBaseHelper.addManga(manga);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
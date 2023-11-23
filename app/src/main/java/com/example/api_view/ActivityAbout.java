package com.example.api_view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ActivityAbout extends AppCompatActivity {
    TextView tvManga;
    ImageView ivManga;
    Button delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Intent intent = getIntent();
        String message = intent.getStringExtra("id");
        String img = intent.getStringExtra("img");

        tvManga = findViewById(R.id.nameAbout);
        ivManga = findViewById(R.id.imgAboute);
        delete = findViewById(R.id.delBtn);
        tvManga.setText(message);

        Picasso.with(this).load(img).into(ivManga);
        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dataBaseHelper.deleteRow(message);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
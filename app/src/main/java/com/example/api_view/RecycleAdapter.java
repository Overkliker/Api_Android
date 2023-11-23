package com.example.api_view;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    private final Context context;
    private ArrayList<Manga> mangaList;

    public RecycleAdapter(Context context, ArrayList<Manga> carsList) {
        this.context = context;
        this.mangaList = carsList;
    }

    @NonNull
    @Override
    public RecycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.block_car, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.ViewHolder holder, int position) {
        Manga manga = mangaList.get(position);
        holder.url = manga.getImage();
        holder.manga.setText(manga.getName());


        Context context = holder.mangaImg.getContext();
        Picasso.with(context).load(manga.getImage()).into(holder.mangaImg);
    }

    @Override
    public int getItemCount() {
        return mangaList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView manga;
        String url;
        ImageView mangaImg;
        public final static String EXTRA_MESSAGE = "id";
        public final static String EXTRA_IMAGE = "img";
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            manga = itemView.findViewById(R.id.mangaName);
            mangaImg = itemView.findViewById(R.id.mangaImg);

            itemView.setOnClickListener(new  View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Intent intent;
                    intent = new Intent(view.getContext(), ActivityAbout.class);
                    CharSequence message = manga.getText();
                    mangaImg.getDrawable();



                    intent.putExtra(EXTRA_MESSAGE, message);
                    intent.putExtra(EXTRA_IMAGE, url);


                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().startActivity(intent);

                }
            });
        }
    }
}

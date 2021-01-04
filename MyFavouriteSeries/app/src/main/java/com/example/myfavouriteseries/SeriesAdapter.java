package com.example.myfavouriteseries;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SeriesAdapter extends RecyclerView.Adapter {

    ArrayList<Series> sArray;
    Context context;

    public SeriesAdapter(ArrayList<Series> sArray, Context context) {
        this.sArray = sArray;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //connecting adapter to series_card
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.series_card,parent,false);
        ViewHolder vh= new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).ratingBar.setRating((float) sArray.get(position).getRating());
        ((ViewHolder) holder).showedGenre.setText(sArray.get(position).getGenre());
        ((ViewHolder) holder).poster.setImageResource(sArray.get(position).getImage());
        ((ViewHolder) holder).title.setText(sArray.get(position).getName());
        ((ViewHolder) holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(context, Details.class);
                i.putExtra("series object", sArray.get(position));
                context.startActivity(i);
                
            }
        });
    }

    @Override
    public int getItemCount() {
        return sArray.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public TextView showedGenre;
        public ImageView poster;
        public RatingBar ratingBar;
        public View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            poster = itemView.findViewById(R.id.imageView);
            showedGenre = itemView.findViewById(R.id.TextView3);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            title= itemView.findViewById(R.id.textView3);
        }
    }
}

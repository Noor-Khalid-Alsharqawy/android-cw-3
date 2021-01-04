package com.example.myfavouriteseries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle b= getIntent().getExtras();
        Series item= (Series) b.getSerializable("series object");


        ImageView im= findViewById(R.id.imageView2);
        TextView name= findViewById(R.id.textView);
        TextView genre= findViewById(R.id.genre2);
        TextView year= findViewById(R.id.year2);
        TextView lang= findViewById(R.id.language2);
        TextView seasons= findViewById(R.id.seasons2);
        TextView episodes= findViewById(R.id.episodes2);
        RatingBar rate= findViewById(R.id.ratingBar2);
        ImageView go2List= findViewById(R.id.imageView4);

        im.setImageResource(item.getImage());
        name.setText(item.getName());   genre.setText(item.getGenre());
        year.setText(item.getYear());   lang.setText(item.getLanguage());
        seasons.setText(item.getSeasons()+"");     episodes.setText(item.getEpisodes()+"");
        rate.setRating((float) item.getRating());
        go2List.setImageResource(R.drawable.ic_baseline_view_list_24);

        go2List.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {
                Intent i= new Intent(Details.this,MainActivity.class);
                startActivity(i);
            }
        });

    }
}
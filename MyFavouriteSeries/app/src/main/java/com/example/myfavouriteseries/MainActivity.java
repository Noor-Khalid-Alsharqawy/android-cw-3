package com.example.myfavouriteseries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Series> myList= new ArrayList<>();
        myList.add(new Series("Payitaht Abdülhamid", 5, 131,
                4.5, R.drawable.pyitaht_poster,
                "Historical", "2017", "Turkish"));
        myList.add(new Series("Mehmedçik", 2, 33,
                4.5, R.drawable.mehmedcik_poster,
                "Historical", "2018", "Turkish"));
        myList.add(new Series("filinta", 2, 56,
                4, R.drawable.filinta_poster,
                "Action", "2014", "Turkish"));

        RecyclerView seriesList= findViewById(R.id.rv);

        seriesList.setHasFixedSize(true);
        RecyclerView.LayoutManager lm= new LinearLayoutManager(this);
        seriesList.setLayoutManager(lm);

        SeriesAdapter sv= new SeriesAdapter(myList, MainActivity.this);
        seriesList.setAdapter(sv);


    }
}
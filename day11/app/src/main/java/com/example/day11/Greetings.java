package com.example.day11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Greetings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings);

        Handler h= new Handler(getMainLooper());
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                //this code will run after 3 seconds
                Intent i= new Intent(Greetings.this, UserData.class);
                startActivity(i);
            }
        }, 3000);
    }
}
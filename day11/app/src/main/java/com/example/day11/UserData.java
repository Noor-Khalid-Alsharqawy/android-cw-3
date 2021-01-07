package com.example.day11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

        final EditText userName= findViewById(R.id.edit1);
        final EditText userEmail= findViewById(R.id.edit2);
        final EditText userPhone= findViewById(R.id.edit3);
        final EditText userLocation= findViewById(R.id.edit4);


        Button b1= findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(UserData.this,MainActivity.class);
                String name= userName.getText().toString();
                i.putExtra("user\'s name",name); //intent.putExtra("tag",variable or any value);
                //in case of more than one variable to be transformed:::
                //i.putExtra(....); i.putExtra(....); i.putExtra(....); ....
                i.putExtra("user\'s e-mail", userEmail.getText().toString());
                i.putExtra("user\'s phone", userPhone.getText().toString());
                i.putExtra("user\'s location", userLocation.getText().toString());
                startActivity(i);
            }
        });
    }
}
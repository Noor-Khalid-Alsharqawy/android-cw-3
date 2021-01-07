package com.example.day11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //write activity in onCrete function

        Bundle b= getIntent().getExtras();
        TextView t1= findViewById(R.id.textView4);
        TextView t2= findViewById(R.id.textView5);
        TextView t3= findViewById(R.id.textView6);
        TextView t4= findViewById(R.id.textView7);

        String ism= b.getString("user\'s name");
        t1.setText(ism);
        String e_mail= b.getString("user\'s e-mail").toLowerCase();
        t2.setText(e_mail);
        String phone= b.getString("user\'s phone");
        t3.setText(phone);
        String location= b.getString("user\'s location");
        t4.setText(location);

        // connecting variable usdCurrency to xml
        EditText usdCurrency= findViewById(R.id.usd_currency);//hold ctrl+click id
        TextView kwdCurrency= findViewById(R.id.kwd_currency);//let the ide complete the code to enable it to import more packages
        Button convert= findViewById(R.id.button);
        //we need a listener for the button
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//what should happen when 'convert' button is clicked
                String usdString = usdCurrency.getText().toString();
                double kwd= Double.parseDouble(usdString)*0.3;
                kwdCurrency.setText(kwd+"");
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email= new Intent(Intent.ACTION_SENDTO);
                email.putExtra(Intent.EXTRA_EMAIL, e_mail);
                email.putExtra(Intent.EXTRA_SUBJECT, "your data");
                String body= ism + "\n" + phone + "\n" + e_mail;
                email.putExtra(Intent.EXTRA_TEXT, body);
                email.setType("text/plain");
                startActivity(Intent.createChooser(email,"Send email:"));
            }
        });

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+phone));
                startActivity(callIntent);
            }
        });

        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q="+Uri.encode(location));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }
}
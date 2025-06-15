package com.example.homework4;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CardView cardCountries = findViewById(R.id.cardCountries);
        CardView cardLeaders = findViewById(R.id.cardLeaders);
        CardView cardMuseums = findViewById(R.id.cardMuseums);
        CardView cardWonders = findViewById(R.id.cardWonders);

        cardCountries.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CountriesActivity.class);
            startActivity(intent);
        });

        cardLeaders.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LeadersActivity.class);
            startActivity(intent);
        });

        cardMuseums.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MuseumsActivity.class);
            startActivity(intent);
        });

        cardWonders.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, WondersActivity.class);
            startActivity(intent);
        });
    }
}
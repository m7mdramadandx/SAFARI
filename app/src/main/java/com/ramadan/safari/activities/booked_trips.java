package com.ramadan.safari.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.ramadan.safari.R;

public class booked_trips extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booked_trips);
        BottomNavigationViewEx bottomNavigationView = findViewById(R.id.bottomBar);
        bottomNavigationView.setSelectedItemId(R.id.navigation_booked_trips);
        bottomNavigationView.enableShiftingMode(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_booked_trips:
                        return true;
                    case R.id.navigation_dashboard:
                        startActivity(new Intent(booked_trips.this, dashboard.class));
                        Animatoo.animateSwipeLeft(booked_trips.this);
                        return true;
                    case R.id.navigation_favorite:
                        startActivity(new Intent(booked_trips.this, favorite.class));
                        Animatoo.animateSwipeLeft(booked_trips.this);
                        return true;
                }
                return false;
            }
        });


    }
}

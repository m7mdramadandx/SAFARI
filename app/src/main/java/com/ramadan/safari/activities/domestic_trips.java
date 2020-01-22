package com.ramadan.safari.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.ramadan.safari.R;


public class domestic_trips extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.domestic_trip);
        BottomNavigationViewEx bottomNavigationView = findViewById(R.id.bottomBar);
        bottomNavigationView.enableShiftingMode(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_dashboard:
                        startActivity(new Intent(domestic_trips.this, dashboard.class));
                        Animatoo.animateSlideRight(domestic_trips.this);
                        return true;
                    case R.id.navigation_booked_trips:
                        startActivity(new Intent(domestic_trips.this, booked_trips.class));
                        Animatoo.animateSlideRight(domestic_trips.this);
                        return true;
                    case R.id.navigation_favorite:
                        startActivity(new Intent(domestic_trips.this, favorite.class));
                        Animatoo.animateSlideRight(domestic_trips.this);
                        return true;
                }
                return false;
            }
        });


    }

    public void Alexandria(View view) {
        startActivity(new Intent(this, alex_hotel.class));
        Animatoo.animateFade(domestic_trips.this);
    }


    public void Sharm_Alsheikh(View view) {
        startActivity(new Intent(this, sharm_hotel.class));
        Animatoo.animateFade(domestic_trips.this);
    }

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        startActivity(new Intent(this, dashboard.class));    }

}

package com.ramadan.safari.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.ramadan.safari.R;


public class abroad_trips extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abroad_trip);
        BottomNavigationViewEx bottomNavigationView = findViewById(R.id.bottomBar);
        bottomNavigationView.enableShiftingMode(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_dashboard:
                        startActivity(new Intent(abroad_trips.this, dashboard.class));
                        Animatoo.animateSlideRight(abroad_trips.this);
                        return true;
                    case R.id.navigation_booked_trips:
                        startActivity(new Intent(abroad_trips.this, booked_trips.class));
                        Animatoo.animateSlideRight(abroad_trips.this);
                        return true;
                    case R.id.navigation_favorite:
                        startActivity(new Intent(abroad_trips.this, favorite.class));
                        Animatoo.animateSlideRight(abroad_trips.this);
                        return true;
                }
                return false;
            }
        });


    }


    public void Paris(View view) {
        Toast.makeText(this, "COMING SOON!", Toast.LENGTH_SHORT).show();
    }

    public void Venice(View view) {
        Toast.makeText(this, "COMING SOON!", Toast.LENGTH_SHORT).show();
    }


}


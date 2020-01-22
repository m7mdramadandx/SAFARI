package com.ramadan.safari.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.ramadan.safari.R;


public class dashboard extends AppCompatActivity implements View.OnClickListener {
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        mAuth = FirebaseAuth.getInstance();
        BottomNavigationViewEx bottomNavigationView = findViewById(R.id.bottomBar);
        bottomNavigationView.setSelectedItemId(R.id.navigation_dashboard);
        bottomNavigationView.enableShiftingMode(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_dashboard:
                        return true;
                    case R.id.navigation_booked_trips:
                        startActivity(new Intent(dashboard.this, booked_trips.class));
                        Animatoo.animateSwipeRight(dashboard.this);
                        return true;
                    case R.id.navigation_favorite:
                        startActivity(new Intent(dashboard.this, favorite.class));
                        Animatoo.animateSwipeLeft(dashboard.this);
                        return true;
                }
                return false;
            }
        });
        initObjects();
    }

    private void initObjects() {

        CardView domestic_trips = findViewById(R.id.domestic_trips);
        CardView abroad_trips = findViewById(R.id.abroad_trips);
        CardView booked_trips = findViewById(R.id.booked_trips);
        CardView favorite = findViewById(R.id.favorite);
        CardView profile = findViewById(R.id.profile);
        CardView about = findViewById(R.id.about);
        CardView rate = findViewById(R.id.rate);
        CardView logout = findViewById(R.id.logout);
        domestic_trips.setOnClickListener(this);
        abroad_trips.setOnClickListener(this);
        booked_trips.setOnClickListener(this);
        favorite.setOnClickListener(this);
        profile.setOnClickListener(this);
        about.setOnClickListener(this);
        rate.setOnClickListener(this);
        logout.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.domestic_trips:
                startActivity(new Intent(this, domestic_trips.class));
                Animatoo.animateZoom(dashboard.this);
                break;
            case R.id.abroad_trips:
                startActivity(new Intent(this, abroad_trips.class));
                Animatoo.animateZoom(dashboard.this);
                break;
            case R.id.booked_trips:
                startActivity(new Intent(this, booked_trips.class));
                Animatoo.animateZoom(dashboard.this);
                break;
            case R.id.favorite:
                startActivity(new Intent(this, favorite.class));
                Animatoo.animateZoom(dashboard.this);
                break;
            case R.id.profile:
                startActivity(new Intent(this, profile.class));
                Animatoo.animateZoom(dashboard.this);
                break;
            case R.id.about:
                startActivity(new Intent(this, about.class));
                Animatoo.animateZoom(dashboard.this);
                break;
            case R.id.rate:
                startActivity(new Intent(this, rate.class));
                Animatoo.animateZoom(dashboard.this);
                break;
            case R.id.logout:
                mAuth.signOut();
                startActivity(new Intent(this, main.class));
                Animatoo.animateFade(dashboard.this);
                finish();
                break;
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

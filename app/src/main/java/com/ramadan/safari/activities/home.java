package com.ramadan.safari.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ramadan.safari.R;


public class home extends AppCompatActivity implements View.OnClickListener {
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;
    private CardView domestic_trips;
    private CardView abroad_trips;
    private CardView booked_trips;
    private CardView favorite;
    private CardView about;
    private CardView profile;
    private CardView logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        mAuth = FirebaseAuth.getInstance();
        mAuth.removeAuthStateListener(mAuthListener);
            mAuthListener = new FirebaseAuth.AuthStateListener() {
                @Override
                public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    if (user == null) {
                        Intent intent = new Intent(home.this, main.class);
                        startActivity(intent);
                        finish();
                    }
                }
            };

        initObjects();

    }

    private void initObjects() {

        domestic_trips = findViewById(R.id.domestic_trips);
        abroad_trips = findViewById(R.id.abroad_trips);
        booked_trips = findViewById(R.id.booked_trips);
        favorite = findViewById(R.id.favorite);
        profile = findViewById(R.id.profile);
        about = findViewById(R.id.about);
        logout = findViewById(R.id.logout);
        domestic_trips.setOnClickListener(this);
        abroad_trips.setOnClickListener(this);
        booked_trips.setOnClickListener(this);
        favorite.setOnClickListener(this);
        profile.setOnClickListener(this);
        about.setOnClickListener(this);
        logout.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.domestic_trips:
                startActivity(new Intent(this, domestic_trips.class));
                break;
            case R.id.abroad_trips:
                startActivity(new Intent(this, abroad_trips.class));
                break;
            case R.id.booked_trips:
                Toast.makeText(this, "Soon!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MapsActivity.class));
                break;
            case R.id.favorite:
                Toast.makeText(this, "Soon!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.profile:
                startActivity(new Intent(this, profile.class));
                break;
            case R.id.about:
                startActivity(new Intent(this, about.class));
                break;
            case R.id.logout:
                mAuth.signOut();
                startActivity(new Intent(this, main.class));
                break;

        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

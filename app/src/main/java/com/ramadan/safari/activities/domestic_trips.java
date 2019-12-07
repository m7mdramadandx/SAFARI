package com.ramadan.safari.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.ramadan.safari.R;


public class domestic_trips extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.domestic_trip);
        mAuth = FirebaseAuth.getInstance();

    }

    public void Alexandria(View view) {
        startActivity(new Intent(this, alex_hotel.class));
    }


    public void Sharm_Alsheikh(View view) {
        startActivity(new Intent(this, sharm_hotel.class));    }

}

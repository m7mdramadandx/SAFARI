package com.ramadan.safari.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.ramadan.safari.R;


public class abroad_trips extends AppCompatActivity
         {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abroad_trip);
        mAuth = FirebaseAuth.getInstance();

    }


    public void Paris(View view) {
        Toast.makeText(this, "COMING SOON!", Toast.LENGTH_SHORT).show();
    }

    public void Venice(View view) {
        Toast.makeText(this, "COMING SOON!", Toast.LENGTH_SHORT).show();
    }


}


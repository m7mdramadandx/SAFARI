package com.ramadan.safari.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.ramadan.safari.R;

public class welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void checked(View view) {
        startActivity(new Intent(this, dashboard.class));
        Animatoo.animateZoom(welcome.this);
        finish();
    }
}


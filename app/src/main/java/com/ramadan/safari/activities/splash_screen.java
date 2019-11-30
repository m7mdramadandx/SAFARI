package com.ramadan.safari.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.ramadan.safari.R;

public class splash_screen extends AppCompatActivity {
    LinearLayout l1, l2;
    Animation uptodown, downtoup;
    FirebaseAuth mAuth;
    private static final int splash_screen_timeout = 2500;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splash_screen.this, home.class);
                startActivity(intent);
                finish();
            }
        }, splash_screen_timeout);

        l1 = findViewById(R.id.layout1);
        l2 = findViewById(R.id.layout2);
        uptodown = AnimationUtils.loadAnimation(this, R.anim.up_to_down);
        downtoup = AnimationUtils.loadAnimation(this, R.anim.down_to_up);
        l1.setAnimation(uptodown);
        l2.setAnimation(downtoup);

    }

}


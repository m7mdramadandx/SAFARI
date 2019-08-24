package com.ramadan.safari.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ramadan.safari.R;

public class splash_screen extends AppCompatActivity {
    RelativeLayout l1, l2;
    Animation uptodown, downtoup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        l1 = findViewById(R.id.l1);
        l2 = findViewById(R.id.l2);
        uptodown = AnimationUtils.loadAnimation(this, R.anim.up_to_down);
        downtoup = AnimationUtils.loadAnimation(this, R.anim.down_to_up);
        l1.setAnimation(uptodown);
        l2.setAnimation(downtoup);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void main_page(View view) {
        Intent intent = new Intent(this, home.class);
        intent.putExtra("status", "hey");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivities(new Intent[]{intent});
        finish();
    }
}

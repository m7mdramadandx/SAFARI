package com.ramadan.safari.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ramadan.safari.R;

public class payment extends AppCompatActivity {
    TextView total_cost;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);
        total_cost = findViewById(R.id.total_cost);
        int hotel_cost = sharm_landmark.hotel_cost;
        String i= getIntent().getExtras().getString("landmark_cost");
        int landmark_cost = Integer.parseInt(i);
        System.out.println(hotel_cost + "  87878787 HOTEL");
        System.out.println(landmark_cost + "  87878787 LANDMARK");
        total_cost.setText(String.valueOf(hotel_cost + landmark_cost));
    }
}

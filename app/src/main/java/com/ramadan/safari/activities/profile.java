package com.ramadan.safari.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.ramadan.safari.R;
import com.ramadan.safari.model.User;

import static android.widget.Toast.makeText;

public class profile extends AppCompatActivity {
    FirebaseAuth mAuth;
    DatabaseReference mRef;
    TextView full_name, email, phone, city, password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        mAuth = FirebaseAuth.getInstance();
        BottomNavigationViewEx bottomNavigationView = findViewById(R.id.bottomBar);
        bottomNavigationView.enableShiftingMode(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_dashboard:
                        startActivity(new Intent(profile.this, dashboard.class));
                        Animatoo.animateSlideRight(profile.this);
                        return true;
                    case R.id.navigation_booked_trips:
                        startActivity(new Intent(profile.this, booked_trips.class));
                        Animatoo.animateSlideRight(profile.this);
                        return true;
                    case R.id.navigation_favorite:
                        startActivity(new Intent(profile.this, favorite.class));
                        Animatoo.animateSlideRight(profile.this);
                        return true;
                }
                return false;
            }
        });

        full_name = findViewById(R.id.user_full_name);
        email = findViewById(R.id.user_email);
        phone = findViewById(R.id.user_phone);
        city = findViewById(R.id.user_city);
        password = findViewById(R.id.user_password);
        try {
            mRef = FirebaseDatabase.getInstance().getReference().child("user").child(mAuth.getCurrentUser().getUid());
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    User user = dataSnapshot.getValue(User.class);
                    full_name.setText(user.getFirst_name() + " " + user.getLast_name());
                    email.setText(user.getEmail());
                    phone.setText(user.getPhone());
                    city.setText(user.getCity());
                    password.setText(user.getPassword());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    makeText(profile.this, "error to load data", Toast.LENGTH_SHORT).show();
                }
            });

        } catch (Exception e) {
            makeText(this, "error to load data", Toast.LENGTH_SHORT).show();
        }

    }

}

package com.ramadan.safari.activities;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
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
        full_name = findViewById(R.id.user_full_name);
        email = findViewById(R.id.user_email);
        phone = findViewById(R.id.user_phone);
        city = findViewById(R.id.user_city);
        password = findViewById(R.id.user_password);
        try {
            mRef = FirebaseDatabase.getInstance().getReference().child("users").child(mAuth.getCurrentUser().getUid());
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

package com.ramadan.safari.activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ramadan.safari.R;

import static android.widget.Toast.makeText;

public class rate extends AppCompatActivity {
    RatingBar ratingBar;
    EditText feedback;
    FirebaseAuth mAuth;
    DatabaseReference mRef;
    AlertDialog.Builder dialogBuilder;
    AlertDialog alertDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rate);
        ratingBar = findViewById(R.id.ratingBar);
        feedback = findViewById(R.id.feedback);
        mAuth = FirebaseAuth.getInstance();


    }

    public void submit(View view) {
        final String user_rate = String.valueOf(ratingBar.getRating());
        final String user_feedback = feedback.getText().toString();
        try {
            mRef = FirebaseDatabase.getInstance().getReference().child("user").child(mAuth.getCurrentUser().getUid());
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String user_id = mAuth.getCurrentUser().getUid();
                    DatabaseReference current_user_db = mRef.child(user_id);
                    current_user_db.child("user_rate").setValue(user_rate);
                    current_user_db.child("user_feedback").setValue(user_feedback);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    makeText(rate.this, "re open app!", Toast.LENGTH_SHORT).show();
                }
            });

        } catch (Exception e) {
            makeText(this, "re open app please!", Toast.LENGTH_SHORT).show();
        }
        showAlertDialog(R.layout.thanks);

    }

    private void showAlertDialog(int layout) {
        dialogBuilder = new AlertDialog.Builder(this);
        View layoutView = getLayoutInflater().inflate(layout, null);
        Button dialogButton = layoutView.findViewById(R.id.btnDialog);
        dialogBuilder.setView(layoutView);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(rate.this, dashboard.class));
            }
        });
    }

}

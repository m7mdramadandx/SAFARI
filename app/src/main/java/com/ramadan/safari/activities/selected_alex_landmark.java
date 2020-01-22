package com.ramadan.safari.activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.bumptech.glide.Glide;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.ramadan.safari.R;
import com.ramadan.safari.model.Landmark_Blog;


public class selected_alex_landmark extends AppCompatActivity {
    static FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    TextView landmark_desc, landmark_name, landmark_location, landmark_rate, one_ticket, two_ticket, three_ticket, four_ticket, landmark_map;
    ImageView landmark_img_url;
    AlertDialog.Builder dialogBuilder;
    AlertDialog alertDialog;
    String latitude, longitude, key;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selected_landmark);

        landmark_name = findViewById(R.id.landmark_name);
        landmark_location = findViewById(R.id.landmark_location);
        landmark_desc = findViewById(R.id.landmark_desc);
        landmark_rate = findViewById(R.id.landmark_rate);
        landmark_img_url = findViewById(R.id.landmark_img);
        one_ticket = findViewById(R.id.one_ticket);
        two_ticket = findViewById(R.id.two_ticket);
        three_ticket = findViewById(R.id.three_ticket);
        four_ticket = findViewById(R.id.four_ticket);
        ///////
        Bundle bundle = getIntent().getExtras();
        key = bundle.getString("landmark_name");
        method();
        /////////
        landmark_map = findViewById(R.id.landmark_map);
        landmark_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(selected_alex_landmark.this, MapsActivity.class);
                intent.putExtra("latitude", latitude);
                intent.putExtra("longitude", longitude);
                intent.putExtra("label", key);
                startActivity(intent);
                Animatoo.animateFade(selected_alex_landmark.this);

            }
        });

    }

    private void method() {
        Query query = mDatabase.getReference().child("domestic_trips").child("alexandria").child("alex_landmark").orderByChild("landmark_name").equalTo(key);
        mDatabase.getReference().keepSynced(true);
        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, String s) {
                Landmark_Blog mlandmark_blog = dataSnapshot.getValue(Landmark_Blog.class);
                assert mlandmark_blog != null;
                Glide.with(selected_alex_landmark.this).asBitmap().load(mlandmark_blog.getLandmark_img_url()).into(landmark_img_url);
                landmark_name.setText(mlandmark_blog.getLandmark_name());
                landmark_desc.setText(mlandmark_blog.getLandmark_desc());
                landmark_location.setText(mlandmark_blog.getLandmark_location());
                landmark_rate.setText(mlandmark_blog.getLandmark_rate());
                one_ticket.setText(mlandmark_blog.getLandmark_cost());
                int x = Integer.parseInt(one_ticket.getText().toString());
                int x1 = (int) (x * 1.8);
                int x2 = (int) (x * 2.6);
                int x3 = (int) (x * 3.4);
                two_ticket.setText(String.valueOf(x1));
                three_ticket.setText(String.valueOf(x2));
                four_ticket.setText(String.valueOf(x3));
                latitude = mlandmark_blog.getLandmark_latitude();
                longitude = mlandmark_blog.getLandmark_longitude();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    public void one_ticket(View view) {
        dialogBuilder = new AlertDialog.Builder(this);
        View layoutView = getLayoutInflater().inflate(R.layout.confirm_landmark, null);
        Button confirm_act = layoutView.findViewById(R.id.confirm_action);
        Button cancel_act = layoutView.findViewById(R.id.cancel_action);
        dialogBuilder.setView(layoutView);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
        confirm_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(selected_alex_landmark.this, payment.class);
                intent.putExtra("landmark_cost", one_ticket.getText().toString());
                startActivity(intent);
            }
        });
    }

    public void two_ticket(View view) {
        dialogBuilder = new AlertDialog.Builder(this);
        View layoutView = getLayoutInflater().inflate(R.layout.confirm_landmark, null);
        Button confirm_act = layoutView.findViewById(R.id.confirm_action);
        Button cancel_act = layoutView.findViewById(R.id.cancel_action);
        dialogBuilder.setView(layoutView);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
        confirm_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(selected_alex_landmark.this, payment.class);
                intent.putExtra("landmark_cost", two_ticket.getText().toString());
                startActivity(intent);
            }
        });
    }

    public void three_ticket(View view) {
        dialogBuilder = new AlertDialog.Builder(this);
        View layoutView = getLayoutInflater().inflate(R.layout.confirm_landmark, null);
        Button confirm_act = layoutView.findViewById(R.id.confirm_action);
        Button cancel_act = layoutView.findViewById(R.id.cancel_action);
        dialogBuilder.setView(layoutView);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
        confirm_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(selected_alex_landmark.this, payment.class);
                intent.putExtra("landmark_cost", three_ticket.getText().toString());
                startActivity(intent);
            }
        });
    }

    public void four_ticket(View view) {
        dialogBuilder = new AlertDialog.Builder(this);
        View layoutView = getLayoutInflater().inflate(R.layout.confirm_landmark, null);
        Button confirm_act = layoutView.findViewById(R.id.confirm_action);
        Button cancel_act = layoutView.findViewById(R.id.cancel_action);
        dialogBuilder.setView(layoutView);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
        confirm_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(selected_alex_landmark.this, payment.class);
                intent.putExtra("landmark_cost", four_ticket.getText().toString());
                startActivity(intent);
            }
        });
    }
}



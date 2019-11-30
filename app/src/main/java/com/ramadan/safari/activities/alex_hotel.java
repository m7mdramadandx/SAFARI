package com.ramadan.safari.activities;

//import com.google.firebase.database.core.Context;

//import com.google.api.Context;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.ramadan.safari.R;
import com.ramadan.safari.adapter.alex_hotel_rcv_adp;
import com.ramadan.safari.model.Hotel_Blog;

import java.util.ArrayList;
import java.util.List;

public class alex_hotel extends AppCompatActivity {
    static FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    private ArrayList<Hotel_Blog> mHotelBlog = new ArrayList<>();
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alex_hotel);
        method();


    }

    private void method() {
        Query query = mDatabase.getReference().child("domestic_trips").child("alexandria").child("alex_hotels");
        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, String s) {
                Hotel_Blog mhotel_blog = dataSnapshot.getValue(Hotel_Blog.class);
                mHotelBlog.add(mhotel_blog);
                setRvadapter(mHotelBlog);
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


    private void setRvadapter(List<Hotel_Blog> mHotelBlog) {
        RecyclerView myrv = findViewById(R.id.recycler_view);
        GridLayoutManager mGrid = new GridLayoutManager(this, 1);
        myrv.setLayoutManager(mGrid);
        myrv.setHasFixedSize(true);
        myrv.setNestedScrollingEnabled(false);
        alex_hotel_rcv_adp myAdapter = new alex_hotel_rcv_adp(this, (ArrayList) mHotelBlog);
        myrv.setAdapter(myAdapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this,domestic_trips.class);
        startActivity(intent);
        finish();
    }
}

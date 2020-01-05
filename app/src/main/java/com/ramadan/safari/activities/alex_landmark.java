package com.ramadan.safari.activities;

//import com.google.firebase.database.core.Context;


import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.ramadan.safari.R;
import com.ramadan.safari.adapter.alex_landmark_rcv_adp;
import com.ramadan.safari.model.Landmark_Blog;

import java.util.ArrayList;
import java.util.List;

public class alex_landmark extends AppCompatActivity {
    static FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    private ArrayList<Landmark_Blog> mLandmarkBlog = new ArrayList<>();
    private FirebaseAuth mAuth;
    public static int hotel_cost;
    private CoordinatorLayout mCLayout;
    private Toolbar mToolbar;
    private CollapsingToolbarLayout mCToolbarLayout;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landmark);

        mCLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mCToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        setSupportActionBar(mToolbar);
        mCToolbarLayout.setTitle("Alexandria Landmarks");
        mCToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        mCToolbarLayout.setExpandedTitleColor(Color.WHITE);
        String x = getIntent().getExtras().getString("hotel_cost");
        hotel_cost = Integer.parseInt(x);
        method();

    }


    private void method() {
        Query query = mDatabase.getReference().child("domestic_trips").child("alexandria").child("alex_landmark");
        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, String s) {
                Landmark_Blog mlandmark_blog = dataSnapshot.getValue(Landmark_Blog.class);
                mLandmarkBlog.add(mlandmark_blog);
                setRvadapter(mLandmarkBlog);

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


    private void setRvadapter(List<Landmark_Blog> mLandmarkBlog) {
        RecyclerView myrv = findViewById(R.id.recycler_view);
        GridLayoutManager mGrid = new GridLayoutManager(this, 1);
        myrv.setLayoutManager(mGrid);
        myrv.setHasFixedSize(true);
        myrv.setNestedScrollingEnabled(false);
        alex_landmark_rcv_adp myAdapter = new alex_landmark_rcv_adp(this, (ArrayList) mLandmarkBlog);
        myrv.setAdapter(myAdapter);
    }

}

package com.ramadan.safari.activities;

//import com.google.firebase.database.core.Context;

//import com.google.api.Context;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alex_landmark);
        method();

    }


    private void method() {
        Query query = mDatabase.getReference().child("domestic_trips").child("alexandria").child("alex_landmark");
        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, String s) {
                //Landmark_Blog Landmark_Blog = SharedPrefManager.getInstance(context).getUser();
                // Landmark_Blog mlandmark_blog = new Landmark_Blog();
                Landmark_Blog mlandmark_blog = dataSnapshot.getValue(Landmark_Blog.class);
                /*mlandmark_blog.setLandmark_name((String) dataSnapshot.child("landmark_name").getValue());
                mlandmark_blog.setLandmark_location((String) dataSnapshot.child("landmark_location").getValue());
                mlandmark_blog.setLandmark_rate((String) dataSnapshot.child("landmark_rate").getValue());
                mlandmark_blog.setLandmark_beachfront((String) dataSnapshot.child("landmark_beach").getValue());
                String slandmark_blog = (String) dataSnapshot.child("landmark_location").getValue();
                mlandmark_blog.setLandmark_img_url((String) dataSnapshot.child("landmark_img_url").getValue());*/
                mLandmarkBlog.add(mlandmark_blog);
                setRvadapter(mLandmarkBlog);
//                String firebase_key = dataSnapshot.getKey();
                //User.setAdmin(isadmin);
                //SharedPrefManager.getInstance(context).userLogin(user);

            }


            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, String s) {
//                User User=dataSnapshot.getValue(User.class);
//                Boolean isadmin = (Boolean) dataSnapshot.child("isAdmin").getValue();
//                User.setAdmin(isadmin);
//                SharedPrefManager.getInstance(context).userLogin(User);
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
/*
                SharedPrefManager.getInstance(context).logout();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                context.startActivity(intent);*/
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
        RecyclerView myrv = findViewById(R.id.alex_landmark_rcv);
        GridLayoutManager mGrid = new GridLayoutManager(this, 1);
        myrv.setLayoutManager(mGrid);
        myrv.setHasFixedSize(true);
        myrv.setNestedScrollingEnabled(false);
        alex_landmark_rcv_adp myAdapter = new alex_landmark_rcv_adp(this, (ArrayList) mLandmarkBlog);
        myrv.setAdapter(myAdapter);
        //myrv.setLayoutManager(new LinearLayoutManager(this));
    }


}

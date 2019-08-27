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
import com.ramadan.safari.adapter.RvAdapter2;
import com.ramadan.safari.model.Hotel_blog;

import java.util.ArrayList;
import java.util.List;

public class youmna extends AppCompatActivity {
    static FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    private ArrayList<Hotel_blog> mHotelBlog = new ArrayList<>();
    private RecyclerView myrv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alex);
        method();

    }


    private void method() {
        Query query = mDatabase.getReference().child("Hotel");
        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, String s) {
                //Hotel_blog Hotel_blog = SharedPrefManager.getInstance(context).getUser();
                // Hotel_blog mhotel_blog = new Hotel_blog();
                Hotel_blog mhotel_blog = dataSnapshot.getValue(Hotel_blog.class);
                /*mhotel_blog.setHotel_name((String) dataSnapshot.child("hotel_name").getValue());
                mhotel_blog.setHotel_location((String) dataSnapshot.child("hotel_location").getValue());
                mhotel_blog.setHotel_rate((String) dataSnapshot.child("hotel_rate").getValue());
                mhotel_blog.setHotel_beachfront((String) dataSnapshot.child("hotel_beach").getValue());
                String shotel_blog = (String) dataSnapshot.child("hotel_location").getValue();
                mhotel_blog.setHotel_img_url((String) dataSnapshot.child("hotel_img_url").getValue());*/
                mHotelBlog.add(mhotel_blog);
                setRvadapter(mHotelBlog);
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


    private void setRvadapter(List<Hotel_blog> mHotelBlog) {
        myrv = findViewById(R.id.recyclerview);
        GridLayoutManager mGrid = new GridLayoutManager(this, 1);
        myrv.setLayoutManager(mGrid);
        myrv.setHasFixedSize(true);
        myrv.setNestedScrollingEnabled(false);
        RvAdapter2 myAdapter = new RvAdapter2(this, (ArrayList) mHotelBlog);
        myrv.setAdapter(myAdapter);
        //myrv.setLayoutManager(new LinearLayoutManager(this));
    }


}

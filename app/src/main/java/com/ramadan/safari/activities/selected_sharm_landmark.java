package com.ramadan.safari.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.ramadan.safari.R;
import com.ramadan.safari.model.Landmark_Blog;


public class selected_sharm_landmark extends AppCompatActivity {
    static FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    String key;
    //mDatabase.getReference("your_node").keepSynced(true);
    TextView landmark_desc, landmark_name, landmark_location, landmark_rate, landmark_cost;
    ImageView landmark_img_url;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selected_sharm_landmark);

        landmark_name = findViewById(R.id.landmark_name);
        landmark_location = findViewById(R.id.landmark_location);
        landmark_desc = findViewById(R.id.landmark_desc);
        landmark_rate = findViewById(R.id.landmark_rate);
        landmark_cost = findViewById(R.id.landmark_cost);
        landmark_img_url = findViewById(R.id.landmark_img);


        ///////
        Bundle bundle = getIntent().getExtras();
        key = bundle.getString("landmark_name");
        method();


    }

    private void method() {
        Query query = mDatabase.getReference().child("domestic_trips").child("sharm_alsheikh").child("sharm_landmark").orderByChild("landmark_name").equalTo(key);
        mDatabase.getReference().keepSynced(true);
        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, String s) {
                Landmark_Blog mlandmark_blog = dataSnapshot.getValue(Landmark_Blog.class);
                assert mlandmark_blog != null;
                Glide.with(selected_sharm_landmark.this).asBitmap().load(mlandmark_blog.getLandmark_img_url()).into(landmark_img_url);
                landmark_name.setText(mlandmark_blog.getLandmark_name());
                landmark_desc.setText(mlandmark_blog.getLandmark_desc());
                landmark_location.setText(mlandmark_blog.getLandmark_location());
                landmark_rate.setText(mlandmark_blog.getLandmark_rate());
                landmark_cost.setText(mlandmark_blog.getLandmark_cost());

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


    public void single_ticket(View view) {
    }
}



package com.ramadan.safari.activities;

import android.os.Bundle;
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
import com.ramadan.safari.model.Hotel_Blog;


public class selected_hotel extends AppCompatActivity {
    static FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    String key, xx, ww;
    //mDatabase.getReference("your_node").keepSynced(true);
    TextView hotel_desc, hotel_name, hotel_location, hotel_rate, hotel_beach, hotel_bar, hotel_airport, hotel_spa, hotel_swimming_pool,
            hotel_double, hotel_double_double, hotel_gym, hotel_king, hotel_quadruple, hotel_queen, hotel_single, hotel_triple;
    ImageView hotel_img_url;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selected_hotel);
        hotel_name = findViewById(R.id.hotel_name);
        hotel_location = findViewById(R.id.hotel_location);
        hotel_desc = findViewById(R.id.hotel_desc);
        hotel_rate = findViewById(R.id.hotel_rate);
        hotel_bar = findViewById(R.id.hotel_bar);
        hotel_beach = findViewById(R.id.hotel_beach);
        hotel_airport = findViewById(R.id.hotel_aiport);
        hotel_gym = findViewById(R.id.hotel_gym);
        hotel_spa = findViewById(R.id.hotel_spa);
        hotel_swimming_pool = findViewById(R.id.hotel_swimming_pool);
        hotel_img_url = findViewById(R.id.hotel_img);


        ///////
        Bundle bundle = getIntent().getExtras();
        key = bundle.getString("hotel_name");
        method();


    }

    private void method() {
        Query query = mDatabase.getReference().child("domestic_trips").child("alexandria").child("alex_hotels").orderByChild("hotel_name").equalTo(key);
        mDatabase.getReference().keepSynced(true);
        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, String s) {
                Hotel_Blog mhotel_blog = dataSnapshot.getValue(Hotel_Blog.class);
                hotel_desc.setText(mhotel_blog.getHotel_desc());
                hotel_name.setText(mhotel_blog.getHotel_name());
                hotel_location.setText(mhotel_blog.getHotel_location());
                hotel_rate.setText(mhotel_blog.getHotel_rate());
                hotel_beach.setText(mhotel_blog.getHotel_beach());
                hotel_bar.setText(mhotel_blog.getHotel_bar());
                hotel_airport.setText(mhotel_blog.getHotel_airport());
                hotel_spa.setText(mhotel_blog.getHotel_spa());
                hotel_swimming_pool.setText(mhotel_blog.getHotel_swimming_pool());
                Glide.with(selected_hotel.this).asBitmap().load(mhotel_blog.getHotel_img_url()).into(hotel_img_url);


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


}



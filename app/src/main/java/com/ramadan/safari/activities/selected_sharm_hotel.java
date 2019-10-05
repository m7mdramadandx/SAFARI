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

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.ramadan.safari.R;
import com.ramadan.safari.model.Hotel_Blog;


public class selected_sharm_hotel extends AppCompatActivity {
    static FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    String key;
    TextView hotel_desc, hotel_name, hotel_location, hotel_rate, hotel_beach, hotel_bar, hotel_airport, hotel_spa, hotel_swimming_pool,
            hotel_double, hotel_double_double, hotel_gym, hotel_king, hotel_quadruple, hotel_queen, hotel_single, hotel_triple;
    ImageView hotel_img_url;
    private FirebaseAuth mAuth;
    AlertDialog.Builder dialogBuilder;
    AlertDialog alertDialog;


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
        hotel_single = findViewById(R.id.single_room);
        hotel_double = findViewById(R.id.double_room);
        hotel_triple = findViewById(R.id.triple_room);
        hotel_quadruple = findViewById(R.id.quadruple_room);
        hotel_double_double = findViewById(R.id.double_double_room);
        hotel_queen = findViewById(R.id.queen_room);
        hotel_king = findViewById(R.id.king_room);
        ///////
        Bundle bundle = getIntent().getExtras();
        key = bundle.getString("hotel_name");
        method();

    }


    private void method() {
        Query query = mDatabase.getReference().child("domestic_trips").child("sharm_alsheikh").child("sharm_hotels").orderByChild("hotel_name").equalTo(key);
        mDatabase.getReference().keepSynced(true);
        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, String s) {
                Hotel_Blog mhotel_blog = dataSnapshot.getValue(Hotel_Blog.class);
                assert mhotel_blog != null;
                Glide.with(selected_sharm_hotel.this).asBitmap().load(mhotel_blog.getHotel_img_url()).into(hotel_img_url);
                hotel_name.setText(mhotel_blog.getHotel_name());
                hotel_desc.setText(mhotel_blog.getHotel_desc());
                hotel_location.setText(mhotel_blog.getHotel_location());
                hotel_rate.setText(mhotel_blog.getHotel_rate());
                hotel_beach.setText(mhotel_blog.getHotel_beach());
                hotel_bar.setText(mhotel_blog.getHotel_bar());
                hotel_airport.setText(mhotel_blog.getHotel_airport());
                hotel_spa.setText(mhotel_blog.getHotel_spa());
                hotel_swimming_pool.setText(mhotel_blog.getHotel_swimming_pool());
                hotel_single.setText(mhotel_blog.getHotel_single());
                hotel_double.setText(mhotel_blog.getHotel_double());
                hotel_triple.setText(mhotel_blog.getHotel_triple());
                hotel_quadruple.setText(mhotel_blog.getHotel_quadruple());
                hotel_double_double.setText(mhotel_blog.getHotel_double_double());
                hotel_queen.setText(mhotel_blog.getHotel_queen());
                hotel_king.setText(mhotel_blog.getHotel_king());

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

    public void single_room(View view) {
        dialogBuilder = new AlertDialog.Builder(this);
        View layoutView = getLayoutInflater().inflate(R.layout.confirm_hotel, null);
        Button confirm_act = layoutView.findViewById(R.id.confirm_action);
        Button cancel_act = layoutView.findViewById(R.id.cancel_action);
        dialogBuilder.setView(layoutView);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
        confirm_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(selected_sharm_hotel.this, sharm_landmark.class);
                intent.putExtra("hotel_cost", hotel_single.getText().toString());
                startActivity(intent);
            }
        });
        cancel_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(selected_sharm_hotel.this, selected_sharm_hotel.class));
            }
        });
    }

    public void double_room(View view) {
        dialogBuilder = new AlertDialog.Builder(this);
        View layoutView = getLayoutInflater().inflate(R.layout.confirm_hotel, null);
        Button confirm_act = layoutView.findViewById(R.id.confirm_action);
        Button cancel_act = layoutView.findViewById(R.id.cancel_action);
        dialogBuilder.setView(layoutView);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
        confirm_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(selected_sharm_hotel.this, sharm_landmark.class);
                intent.putExtra("hotel_cost", hotel_double.getText().toString());
                startActivity(intent);
            }
        });
        cancel_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(selected_sharm_hotel.this, selected_sharm_hotel.class));
            }
        });
    }

    public void triple_room(View view) {
        dialogBuilder = new AlertDialog.Builder(this);
        View layoutView = getLayoutInflater().inflate(R.layout.confirm_hotel, null);
        Button confirm_act = layoutView.findViewById(R.id.confirm_action);
        Button cancel_act = layoutView.findViewById(R.id.cancel_action);
        dialogBuilder.setView(layoutView);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
        confirm_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(selected_sharm_hotel.this, sharm_landmark.class);
                intent.putExtra("hotel_cost", hotel_triple.getText().toString());
                startActivity(intent);
            }
        });
        cancel_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(selected_sharm_hotel.this, selected_sharm_hotel.class));
            }
        });
    }

    public void quadruple_room(View view) {
        dialogBuilder = new AlertDialog.Builder(this);
        View layoutView = getLayoutInflater().inflate(R.layout.confirm_hotel, null);
        Button confirm_act = layoutView.findViewById(R.id.confirm_action);
        Button cancel_act = layoutView.findViewById(R.id.cancel_action);
        dialogBuilder.setView(layoutView);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
        confirm_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(selected_sharm_hotel.this, sharm_landmark.class);
                intent.putExtra("hotel_cost", hotel_quadruple.getText().toString());
                startActivity(intent);
            }
        });
        cancel_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(selected_sharm_hotel.this, selected_sharm_hotel.class));
            }
        });
    }

    public void double_double_room(View view) {
        dialogBuilder = new AlertDialog.Builder(this);
        View layoutView = getLayoutInflater().inflate(R.layout.confirm_hotel, null);
        Button confirm_act = layoutView.findViewById(R.id.confirm_action);
        Button cancel_act = layoutView.findViewById(R.id.cancel_action);
        dialogBuilder.setView(layoutView);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
        confirm_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(selected_sharm_hotel.this, sharm_landmark.class);
                intent.putExtra("hotel_cost", hotel_double_double.getText().toString());
                startActivity(intent);
            }
        });
        cancel_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(selected_sharm_hotel.this, selected_sharm_hotel.class));
            }
        });
    }

    public void queen_room(View view) {
        dialogBuilder = new AlertDialog.Builder(this);
        View layoutView = getLayoutInflater().inflate(R.layout.confirm_hotel, null);
        Button confirm_act = layoutView.findViewById(R.id.confirm_action);
        Button cancel_act = layoutView.findViewById(R.id.cancel_action);
        dialogBuilder.setView(layoutView);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
        confirm_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(selected_sharm_hotel.this, sharm_landmark.class);
                intent.putExtra("hotel_cost", hotel_queen.getText().toString());
                startActivity(intent);
            }
        });
        cancel_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(selected_sharm_hotel.this, selected_sharm_hotel.class));
            }
        });
    }

    public void king_room(View view) {
        dialogBuilder = new AlertDialog.Builder(this);
        View layoutView = getLayoutInflater().inflate(R.layout.confirm_hotel, null);
        Button confirm_act = layoutView.findViewById(R.id.confirm_action);
        Button cancel_act = layoutView.findViewById(R.id.cancel_action);
        dialogBuilder.setView(layoutView);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
        confirm_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(selected_sharm_hotel.this, sharm_landmark.class);
                intent.putExtra("hotel_cost", hotel_king.getText().toString());
                startActivity(intent);
            }
        });
        cancel_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(selected_sharm_hotel.this, selected_sharm_hotel.class));
            }
        });
    }

    private void showAlertDialog(int layout) {
        dialogBuilder = new AlertDialog.Builder(this);
        View layoutView = getLayoutInflater().inflate(layout, null);
        Button confirm_act = layoutView.findViewById(R.id.confirm_action);
        Button cancel_act = layoutView.findViewById(R.id.cancel_action);
        dialogBuilder.setView(layoutView);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
        confirm_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(selected_sharm_hotel.this, sharm_landmark.class));
            }
        });
        cancel_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(selected_sharm_hotel.this, selected_sharm_hotel.class));
            }
        });
    }

}



package com.ramadan.safari.activities;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.ramadan.safari.R;
import com.ramadan.safari.adapter.database_handler;

public class alexandria extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    database_handler db;
    Dialog myDialog;
    RelativeLayout layoutvisibility3, layoutvisibility4, layoutvisibility5, layoutvisibility6;
    ///////////////////////////-----3 DAYS OFFER-----//////////////////////////
    TextView hotel_name3, transportation3, cost3, availability3;
    ImageView img_31, img_32, img_33, img_34;
    RatingBar ratingBar3;
    String transportation_type3 = null;
    ///////////////////////////-----4 DAYS OFFER-----//////////////////////////
    TextView hotel_name4, transportation4, cost4, availability4;
    ImageView img_41, img_42, img_43, img_44;
    RatingBar ratingBar4;
    String transportation_type4 = null;
    ///////////////////////////-----5 DAYS OFFER-----//////////////////////////
    TextView hotel_name5, transportation5, cost5, availability5;
    ImageView img_51, img_52, img_53, img_54;
    RatingBar ratingBar5;
    String transportation_type5 = null;
    ///////////////////////////-----6 DAYS OFFER-----//////////////////////////
    TextView hotel_name6, transportation6, cost6, availability6;
    ImageView img_61, img_62, img_63, img_64;
    RatingBar ratingBar6;
    String transportation_type6 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alexandria);
        db = new database_handler(this);
        myDialog = new Dialog(this);
        //////////////////////------NAV BAR------//////////////////
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        ///////////////////////////-----3 DAYS OFFER-----//////////////////////////
        hotel_name3 = findViewById(R.id.hotel_name3);
        transportation3 = findViewById(R.id.transportation3);
        cost3 = findViewById(R.id.cost3);
        availability3 = findViewById(R.id.availability3);
        img_31 = findViewById(R.id.img_31);
        img_32 = findViewById(R.id.img_32);
        img_33 = findViewById(R.id.img_33);
        img_34 = findViewById(R.id.img_34);
        ratingBar3 = findViewById(R.id.hotel_rate3);
        layoutvisibility3 = findViewById(R.id.layout_visibility3);
        ///////////////////////////-----4 DAYS OFFER-----//////////////////////////
        hotel_name4 = findViewById(R.id.hotel_name4);
        transportation4 = findViewById(R.id.transportation4);
        cost4 = findViewById(R.id.cost4);
        availability4 = findViewById(R.id.availability4);
        img_41 = findViewById(R.id.img_41);
        img_42 = findViewById(R.id.img_42);
        img_43 = findViewById(R.id.img_43);
        img_44 = findViewById(R.id.img_44);
        ratingBar4 = findViewById(R.id.hotel_rate4);
        layoutvisibility4 = findViewById(R.id.layout_visibility4);
        ///////////////////////////-----5 DAYS OFFER-----//////////////////////////
        hotel_name5 = findViewById(R.id.hotel_name5);
        transportation5 = findViewById(R.id.transportation5);
        cost5 = findViewById(R.id.cost5);
        availability5 = findViewById(R.id.availability5);
        img_51 = findViewById(R.id.img_51);
        img_52 = findViewById(R.id.img_52);
        img_53 = findViewById(R.id.img_53);
        img_54 = findViewById(R.id.img_54);
        ratingBar5 = findViewById(R.id.hotel_rate5);
        layoutvisibility5 = findViewById(R.id.layout_visibility5);
        ///////////////////////////-----6 DAYS OFFER-----//////////////////////////
        hotel_name6 = findViewById(R.id.hotel_name6);
        transportation6 = findViewById(R.id.transportation6);
        cost6 = findViewById(R.id.cost6);
        availability6 = findViewById(R.id.availability6);
        img_61 = findViewById(R.id.img_61);
        img_62 = findViewById(R.id.img_62);
        img_63 = findViewById(R.id.img_63);
        img_64 = findViewById(R.id.img_64);
        ratingBar6 = findViewById(R.id.hotel_rate6);
        layoutvisibility6 = findViewById(R.id.layout_visibility6);
        //////////////////////////////////////////////////////////////////////////////
        Cursor cursor3 = db.getReadableDatabase().rawQuery(" select * from offer where location='alexandria' and duration='3 days' ;", null);
        Cursor cursor4 = db.getReadableDatabase().rawQuery(" select * from offer where location='alexandria' and duration='4 days' ;", null);
        Cursor cursor5 = db.getReadableDatabase().rawQuery(" select * from offer where location='alexandria' and duration='5 days' ;", null);
        Cursor cursor6 = db.getReadableDatabase().rawQuery(" select * from offer where location='alexandria' and duration='6 days' ;", null);

        ///////////////////////////-----3 DAYS OFFER-----//////////////////////////
        if (cursor3.moveToNext()) {
            hotel_name3.setText(cursor3.getString(cursor3.getColumnIndex("hotel_name")));
            transportation3.setText(cursor3.getString(cursor3.getColumnIndex("transportation")));
            transportation_type3 = transportation3.getText().toString();
            ratingBar3.setRating(Float.parseFloat(cursor3.getString(cursor3.getColumnIndex("rate"))));
            cost3.setText(cursor3.getString(cursor3.getColumnIndex("cost")));

        } else {
            layoutvisibility3.setVisibility(View.GONE);
            availability3.setVisibility(View.VISIBLE);
        }
        ///////////////////////////-----4 DAYS OFFER-----//////////////////////////
        if (cursor4.moveToNext()) {
            hotel_name4.setText(cursor4.getString(cursor4.getColumnIndex("hotel_name")));
            transportation4.setText(cursor4.getString(cursor4.getColumnIndex("transportation")));
            transportation_type4 = transportation4.getText().toString();
            ratingBar4.setRating(Float.parseFloat(cursor4.getString(cursor4.getColumnIndex("rate"))));
            cost4.setText(cursor4.getString(cursor4.getColumnIndex("cost")));
        } else {
            layoutvisibility4.setVisibility(View.GONE);
            availability4.setVisibility(View.VISIBLE);
        }
        ///////////////////////////-----5 DAYS OFFER-----//////////////////////////
        if (cursor5.moveToNext()) {
            hotel_name5.setText(cursor5.getString(cursor5.getColumnIndex("hotel_name")));
            transportation5.setText(cursor5.getString(cursor5.getColumnIndex("transportation")));
            transportation_type5 = transportation5.getText().toString();
            ratingBar5.setRating(Float.parseFloat(cursor5.getString(cursor5.getColumnIndex("rate"))));
            cost5.setText(cursor5.getString(cursor5.getColumnIndex("cost")));
        } else {
            layoutvisibility5.setVisibility(View.GONE);
            availability5.setVisibility(View.VISIBLE);
        }
        ///////////////////////////-----6 DAYS OFFER-----//////////////////////////
        if (cursor6.moveToNext()) {
            hotel_name6.setText(cursor6.getString(cursor6.getColumnIndex("hotel_name")));
            transportation6.setText(cursor6.getString(cursor6.getColumnIndex("transportation")));
            transportation_type6 = transportation6.getText().toString();
            ratingBar6.setRating(Float.parseFloat(cursor6.getString(cursor6.getColumnIndex("rate"))));
            cost6.setText(cursor6.getString(cursor6.getColumnIndex("cost")));
        } else {
            layoutvisibility6.setVisibility(View.GONE);
            availability6.setVisibility(View.VISIBLE);
        }
    }

    ///////////////////////////-----3 DAYS OFFER-----//////////////////////////
    public void show_imgs3(View view) {
        switch (transportation_type3) {
            case "car":
                Intent intent = new Intent(this, car.class);
                startActivity(intent);
                finish();
                break;
            case "train":
                Intent intent1 = new Intent(this, train.class);
                startActivity(intent1);
                finish();
                break;

            case "bus":
                Intent intent3 = new Intent(this, bus.class);
                startActivity(intent3);
                finish();

        }
    }

    public void reserve3(View view) {
        TextView txtclose;
        Button confirm;
        myDialog.setContentView(R.layout.visa);
        txtclose = myDialog.findViewById(R.id.txtclose);
        txtclose.setText("M");
        confirm = myDialog.findViewById(R.id.confirm);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

    ///////////////////////////-----4 DAYS OFFER-----//////////////////////////
    public void show_imgs4(View view) {
        switch (transportation_type3) {
            case "car":
                Intent intent = new Intent(this, car.class);
                startActivity(intent);
                finish();
                break;
            case "train":
                Intent intent1 = new Intent(this, train.class);
                startActivity(intent1);
                finish();
                break;

            case "bus":
                Intent intent3 = new Intent(this, bus.class);
                startActivity(intent3);
                finish();

        }
    }

    public void reserve4(View view) {
        TextView txtclose;
        Button confirm;
        myDialog.setContentView(R.layout.visa);
        txtclose = myDialog.findViewById(R.id.txtclose);
        txtclose.setText("M");
        confirm = myDialog.findViewById(R.id.confirm);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

    ///////////////////////////-----5 DAYS OFFER-----//////////////////////////
    public void show_imgs5(View view) {
        switch (transportation_type3) {
            case "car":
                Intent intent = new Intent(this, car.class);
                startActivity(intent);
                finish();
                break;
            case "train":
                Intent intent1 = new Intent(this, train.class);
                startActivity(intent1);
                finish();
                break;

            case "bus":
                Intent intent3 = new Intent(this, bus.class);
                startActivity(intent3);
                finish();

        }
    }

    public void reserve5(View view) {
        TextView txtclose;
        Button confirm;
        myDialog.setContentView(R.layout.visa);
        txtclose = myDialog.findViewById(R.id.txtclose);
        txtclose.setText("M");
        confirm = myDialog.findViewById(R.id.confirm);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

    ///////////////////////////-----6 DAYS OFFER-----//////////////////////////
    public void show_imgs6(View view) {
        switch (transportation_type3) {
            case "car":
                Intent intent = new Intent(this, car.class);
                startActivity(intent);
                finish();
                break;
            case "train":
                Intent intent1 = new Intent(this, train.class);
                startActivity(intent1);
                finish();
                break;

            case "bus":
                Intent intent3 = new Intent(this, bus.class);
                startActivity(intent3);
                finish();

        }
    }

    public void reserve6(View view) {
        TextView txtclose;
        Button confirm;
        myDialog.setContentView(R.layout.visa);
        txtclose = myDialog.findViewById(R.id.txtclose);
        txtclose.setText("M");
        confirm = myDialog.findViewById(R.id.confirm);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

    //////////////////////------NAV BAR------//////////////////
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent intent = new Intent(this, home.class);
            startActivities(new Intent[]{intent});
            finish();

        } else if (id == R.id.nav_profile) {
            Intent intent = new Intent(this, offer.class);
            startActivities(new Intent[]{intent});
            finish();
        } else if (id == R.id.nav_offers) {
            Intent intent = new Intent(this, offer.class);
            startActivities(new Intent[]{intent});
            finish();
        } else if (id == R.id.nav_make_an_order) {
            Intent intent = new Intent(this, make_an_order.class);
            startActivities(new Intent[]{intent});
            finish();
        } else if (id == R.id.nav_setting) {
            Intent intent = new Intent(this, offer.class);
            startActivities(new Intent[]{intent});
            finish();
        } else if (id == R.id.nav_about) {
            Intent intent = new Intent(this, offer.class);
            startActivities(new Intent[]{intent});
            finish();
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
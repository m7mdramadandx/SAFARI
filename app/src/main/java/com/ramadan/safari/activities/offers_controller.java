package com.ramadan.safari.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.ramadan.safari.R;
import com.ramadan.safari.adapter.database_handler;

import java.util.ArrayList;

public class offers_controller extends Activity {
    EditText offer_id, hotel_name, location, duration, transportation, rate, cost;
    ListView data_list;
    database_handler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.offers_controller);
        db = new database_handler(this);
        offer_id = findViewById(R.id.offer_id);
        hotel_name = findViewById(R.id.hotel_name);
        location = findViewById(R.id.location);
        duration = findViewById(R.id.duration);
        transportation = findViewById(R.id.transportation);
        rate = findViewById(R.id.rate);
        cost = findViewById(R.id.cost);
        data_list = findViewById(R.id.listViewId);
        show_offer();
    }

    public void show_offer() {
        ArrayList arrayList = db.get_offer();
        ArrayAdapter arrayAdapter;
        if (arrayList.isEmpty()) {
            Toast.makeText(this, "NO DATA EXISTS!", Toast.LENGTH_SHORT).show();
            arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
            data_list.setAdapter(arrayAdapter);
        } else {
            arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
            data_list.setAdapter(arrayAdapter);
        }
    }

    public void insert_offer(View view) {
        String offer_id_ = offer_id.getText().toString();
        String hotel_name_ = hotel_name.getText().toString();
        String location_ = location.getText().toString();
        String duration_ = duration.getText().toString();
        String transportation_ = transportation.getText().toString();
        String rate_ = rate.getText().toString();
        String cost_ = cost.getText().toString();

        if (offer_id_.isEmpty() || hotel_name_.isEmpty() || location_.isEmpty() || duration_.isEmpty() || transportation_.isEmpty() || rate_.isEmpty() || cost_.isEmpty()) {
            Toast.makeText(this, "all fields are required!", Toast.LENGTH_SHORT).show();
        } else {
            float rate__ = Float.parseFloat(rate_);
            int cost__ = Integer.parseInt(cost_);
            db.insert_offer(offer_id_, hotel_name_, location_, duration_, transportation_, rate__, cost__);
            offer_id.setText(null);
            hotel_name.setText(null);
            location.setText(null);
            duration.setText(null);
            transportation.setText(null);
            rate.setText(null);
            cost.setText(null);
            show_offer();
            Toast.makeText(this, "an offer is inserted!", Toast.LENGTH_SHORT).show();
        }
    }

    public void update_offer(View view) {
        String offer_id_ = offer_id.getText().toString();
        String hotel_name_ = hotel_name.getText().toString();
        String location_ = location.getText().toString();
        String duration_ = duration.getText().toString();
        String transportation_ = transportation.getText().toString();
        String rate_ = rate.getText().toString();
        String cost_ = cost.getText().toString();
        if (offer_id_.isEmpty() || hotel_name_.isEmpty() || location_.isEmpty() || duration_.isEmpty() || transportation_.isEmpty() || rate_.isEmpty() || cost_.isEmpty()) {
            Toast.makeText(this, "all fields are required!", Toast.LENGTH_SHORT).show();

        } else {
            float rate__ = Float.parseFloat(rate_);
            int cost__ = Integer.parseInt(cost_);
            boolean status = db.update_offer(offer_id_, hotel_name_, location_, duration_, transportation_, rate__, cost__);
            if (status == true) {
                Toast.makeText(this, "updated!", Toast.LENGTH_SHORT).show();
                offer_id.setText(null);
                hotel_name.setText(null);
                location.setText(null);
                duration.setText(null);
                transportation.setText(null);
                rate.setText(null);
                cost.setText(null);
                show_offer();
            } else {
                Toast.makeText(this, "failed to update", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void delete_offer(View view) {
        String offer_id_ = offer_id.getText().toString();
        if (offer_id_.isEmpty()) {
            Toast.makeText(this, "Offer ID is empty", Toast.LENGTH_SHORT).show();
        } else {
            if (true) {
                db.delete_offer(offer_id_);
                Toast.makeText(this, "deleted!", Toast.LENGTH_SHORT).show();
                hotel_name.setText("");
                location.setText("");
                duration.setText("");
                transportation.setText("");
                rate.setText("");
                cost.setText("");
                show_offer();
            } else {
                Toast.makeText(this, "failed to delete!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void search_offer(View view) {
        String offer_id_ = offer_id.getText().toString();
        if (offer_id_.isEmpty()) {
            Toast.makeText(this, "Offer ID is empty!", Toast.LENGTH_SHORT).show();
        } else {
            String result = db.search_offer(offer_id_);
            AlertDialog.Builder adb = new AlertDialog.Builder(offers_controller.this);
            adb.setTitle("SEARCH RESULT");
            adb.setMessage(result);
            adb.show();
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, staff_home.class);
        startActivity(intent);
        finish();
    }
}

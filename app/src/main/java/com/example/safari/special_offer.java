package com.example.safari;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class special_offer extends Activity {
    String[] location_array, duration_array, transportation_array, rate_array, tickets_num_array;
    Spinner loc_spin, dur_spin, trans_spin, rate_spin, tickets_num_spinner;
    String selected_location, selected_duration, selected_transportation, selected_rate, selected_tickets_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.special_offer);

        ///////////////////////////////////////----Location----//////////////////////////////
        location_array = new String[]{" ", "Alexandria", "Aswan", "Cairo", "Sharm Alsheikh"};
        loc_spin = (Spinner) findViewById(R.id.location_spinner);
        ArrayAdapter loc_aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, location_array);
        loc_aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        loc_spin.setAdapter(loc_aa);
        loc_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                selected_location = location_array[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(special_offer.this, "nothing is selected!", Toast.LENGTH_SHORT).show();
            }
        });


        ///////////////////////////////////////----Duration----//////////////////////////////
        duration_array = new String[]{" ", "3 Days", "4 Days", "5 Days", "6 Days", "1 Week"};
        dur_spin = (Spinner) findViewById(R.id.duration_spinner);
        ArrayAdapter dur_aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, duration_array);
        dur_aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dur_spin.setAdapter(dur_aa);
        dur_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                selected_duration = duration_array[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(special_offer.this, "nothing is selected!", Toast.LENGTH_SHORT).show();
            }
        });

        ///////////////////////////////////////----Transportation----//////////////////////////////
        transportation_array = new String[]{" ", "Train", "Bus", "Car"};
        trans_spin = (Spinner) findViewById(R.id.transportation_spinner);
        ArrayAdapter trans_aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, transportation_array);
        trans_aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        trans_spin.setAdapter(trans_aa);
        trans_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                selected_transportation = transportation_array[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(special_offer.this, "nothing is selected!", Toast.LENGTH_SHORT).show();
            }
        });


        ///////////////////////////////////////----Rate----//////////////////////////////
        rate_array = new String[]{" ", "3 Stars", "4 Stars", "5 Stars", "6 Stars", "7 Stars"};
        rate_spin = (Spinner) findViewById(R.id.rate_spinner);
        ArrayAdapter rate_aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, rate_array);
        rate_aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rate_spin.setAdapter(rate_aa);
        rate_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                selected_rate = rate_array[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(special_offer.this, "nothing is selected!", Toast.LENGTH_SHORT).show();
            }
        });

        ///////////////////////////////////////----Tickets Number----//////////////////////////////
        tickets_num_array = new String[]{" ", "1", "2", "3", "4", "5"};
        tickets_num_spinner = (Spinner) findViewById(R.id.tickets_num_spinner);
        ArrayAdapter ticket_num_aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, tickets_num_array);
        ticket_num_aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tickets_num_spinner.setAdapter(ticket_num_aa);
        tickets_num_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                selected_tickets_num = tickets_num_array[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(special_offer.this, "nothing is selected!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void submit(View view) {
        System.out.println("***" + selected_location + "***" + selected_duration + "****" + selected_transportation + "****" + selected_rate + "****" + selected_tickets_num);

    }
}

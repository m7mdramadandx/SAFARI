package com.ramadan.safari.activities;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.ramadan.safari.R;

import java.util.Calendar;

public class submition extends AppCompatActivity {
    EditText check_in, check_out;
    DatePickerDialog.OnDateSetListener setListener;
    int year;
    int month;
    int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submition);
        check_in = findViewById(R.id.check_in);
        check_out = findViewById(R.id.check_out);

        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);


    }

    public void check_in(View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int yy, int mm, int dd) {
                mm++;
                String date = dd + "/" + mm + "/" + yy;
                check_in.setText(date);
            }
        }, year, month, day);
        datePickerDialog.show();
    }

    public void check_out(View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int yy, int mm, int dd) {
                mm++;
                String date = dd + "/" + mm + "/" + yy;
                check_out.setText(date);
            }
        }, year, month, day);
        datePickerDialog.show();
    }
}

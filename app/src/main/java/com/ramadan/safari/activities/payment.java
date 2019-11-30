package com.ramadan.safari.activities;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.ramadan.safari.R;

import java.util.Calendar;

public class payment extends AppCompatActivity {
    TextView total_cost;
    EditText check_in, check_out;
    int day, month, year;
    AlertDialog.Builder dialogBuilder;
    AlertDialog alertDialog;
    private RadioGroup radioGroup;
    private RadioButton sound, vibration, silent;


    public static final String CHANNEL_ID = "alert";
    public static final String CHANNEL_NAME = "Successful!";
    public static final String CHANNEL_DESC = "The trip has been successfully paid";


    private void display_notification() {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID).
                setSmallIcon(R.drawable.logo_transperant).setContentTitle(CHANNEL_NAME).setContentText(CHANNEL_DESC).
                setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat mNotificationManagerCompat = NotificationManagerCompat.from(this);
        mNotificationManagerCompat.notify(1, mBuilder.build());
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);
        check_in = findViewById(R.id.check_in);
        check_out = findViewById(R.id.check_out);

        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        radioGroup = findViewById(R.id.radio_group);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.paypal) {
                } else if (checkedId == R.id.mastercard) {
                } else {
                }
            }

        });

        total_cost = findViewById(R.id.total_cost);
        int hotel_cost = sharm_landmark.hotel_cost;
        int hotel_cost1 = alex_landmark.hotel_cost;
        String i = getIntent().getExtras().getString("landmark_cost");
        int landmark_cost = Integer.parseInt(i);
        total_cost.setText(String.valueOf(hotel_cost1 + hotel_cost + landmark_cost));


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

    public void confirm(View view) {
        showAlertDialog(R.layout.confirm_payment);
        display_notification();
    }

    private void showAlertDialog(int layout) {
        dialogBuilder = new AlertDialog.Builder(this);
        View layoutView = getLayoutInflater().inflate(layout, null);
        Button dialogButton = layoutView.findViewById(R.id.btnDialog);
        dialogBuilder.setView(layoutView);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(payment.this, home.class));
            }
        });
    }

    public void expiry_date(View view) {
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

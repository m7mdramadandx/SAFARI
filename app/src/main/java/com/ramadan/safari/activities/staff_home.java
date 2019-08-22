package com.ramadan.safari.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.ramadan.safari.R;

public class staff_home extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.staff_home);
    }

    public void offers_controller(View view) {
        Intent intent = new Intent(this, offers_controller.class);
        startActivity(intent);
        finish();
    }

    public void specific_offer(View view) {
        Intent intent = new Intent(this, specific_offer.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, main.class);
        startActivity(intent);
        finish();
    }
}

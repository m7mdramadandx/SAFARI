package com.ramadan.safari.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.ramadan.safari.R;

public class car extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.car);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, domestic_trips.class);
        startActivity(intent);
        finish();
    }

}

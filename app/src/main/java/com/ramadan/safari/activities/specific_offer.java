package com.ramadan.safari.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.ramadan.safari.R;

public class specific_offer extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.specific_offer);
    }

    public void search_offer(View view) {
    }

    public void insert_img(View view) {
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, staff_home.class);
        startActivity(intent);
        finish();
    }
}

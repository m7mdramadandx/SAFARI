package com.example.safari;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class home_page extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
    }

    public void make_and_order(View view) {
        Intent intent = new Intent(this,special_offer.class);
        startActivity(intent);
        finish();
    }

    public void offers(View view) {
        Intent intent = new Intent(this, offer.class);
        startActivity(intent);
        finish();
    }
}

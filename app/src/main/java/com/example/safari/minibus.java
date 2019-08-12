package com.example.safari;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class minibus extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.minibus);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,offer.class);
        startActivity(intent);
        finish();
    }

}

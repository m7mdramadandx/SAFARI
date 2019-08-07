package com.example.safari;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class comming_soon extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comming_soon);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

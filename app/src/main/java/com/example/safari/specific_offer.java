package com.example.safari;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

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
}

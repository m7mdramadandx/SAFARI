package com.example.safari;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class train extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train);
    }
}

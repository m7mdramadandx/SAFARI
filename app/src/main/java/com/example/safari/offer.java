package com.example.safari;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.view.Window;
import android.widget.Button;
import android.view.ContextMenu;

public class offer extends Activity {

    Button alexandria, aswan, cairo, sharm_alsheikh;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.offers);
    }

    public void Alexandria(View view) {
        Intent intent = new Intent(this,alexandria.class);
        startActivities(new Intent[]{intent});
        finish();
    }

    public void Aswan(View view) {
        Intent intent = new Intent(this,aswan_offers.class);
        startActivities(new Intent[]{intent});
        finish();
    }

    public void Cairo(View view) {
        Intent intent = new Intent(this,cairo_offers.class);
        startActivities(new Intent[]{intent});
        finish();
    }

    public void Sharm_Alsheikh(View view) {
        Intent intent = new Intent(this,sharm_alsheikh_offers.class);
        startActivities(new Intent[]{intent});
        finish();
    }
}

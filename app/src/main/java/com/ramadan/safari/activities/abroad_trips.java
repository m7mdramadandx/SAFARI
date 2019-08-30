package com.ramadan.safari.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.ramadan.safari.R;


public class abroad_trips extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abroad_trip);
        mAuth = FirebaseAuth.getInstance();
        //////////////////////------NAV BAR------//////////////////
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.TRANSPARENT);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }


    //////////////////////------NAV BAR------//////////////////
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent intent = new Intent(this, home.class);
            intent.putExtra("status", "hey");
            startActivity(intent);
        }
    }

    public void moscow(View view) {
    }

    public void istanbul(View view) {
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent intent = new Intent(this, home.class);
            startActivities(new Intent[]{intent});
            finish();

        } else if (id == R.id.nav_profile) {
            Intent intent = new Intent(this, domestic_trips.class);
            startActivities(new Intent[]{intent});
            finish();
        } else if (id == R.id.nav_domestic_trip) {
            Intent intent = new Intent(this, domestic_trips.class);
            startActivities(new Intent[]{intent});
            finish();
        } else if (id == R.id.nav_abroad_trip) {
            Intent intent = new Intent(this, abroad_trips.class);
            startActivities(new Intent[]{intent});
            finish();
        } else if (id == R.id.nav_setting) {
            Intent intent = new Intent(this, domestic_trips.class);
            startActivities(new Intent[]{intent});
            finish();
        } else if (id == R.id.nav_about) {
            Intent intent = new Intent(this, domestic_trips.class);
            startActivities(new Intent[]{intent});
            finish();
        } else if (id == R.id.nav_logout) {
            mAuth.signOut();
            Intent intent = new Intent(this, main.class);
            startActivities(new Intent[]{intent});
            finish();
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}

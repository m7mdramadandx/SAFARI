package com.ramadan.safari.activities;

import android.content.Intent;
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


public class domestic_trips extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.domestic_trip);
        mAuth = FirebaseAuth.getInstance();
        //////////////////////------NAV BAR------//////////////////
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void Alexandria(View view) {
        Intent intent = new Intent(this, alex_hotel.class);
        startActivities(new Intent[]{intent});
        finish();
    }


    public void Sharm_Alsheikh(View view) {
        Intent intent = new Intent(this, sharm_hotel.class);
        startActivities(new Intent[]{intent});
        finish();
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

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_home:
                startActivity(new Intent(this, home.class));
                break;
            case R.id.nav_profile:
                startActivity(new Intent(this, profile.class));
                break;
            case R.id.nav_domestic_trip:
                startActivity(new Intent(this, domestic_trips.class));
                break;
            case R.id.nav_abroad_trip:
                startActivity(new Intent(this, abroad_trips.class));
                break;
            case R.id.nav_about:
                startActivity(new Intent(this, about.class));
                break;
            case R.id.nav_logout:
                mAuth.signOut();
                startActivity(new Intent(this, main.class));
                break;
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

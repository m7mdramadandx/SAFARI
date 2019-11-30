package com.ramadan.safari.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

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
            case R.id.nav_domestic_trips:
                startActivity(new Intent(this, domestic_trips.class));
                break;
            case R.id.nav_abroad_trips:
                startActivity(new Intent(this, abroad_trips.class));
                break;
            case R.id.nav_booked_trips:
                Toast.makeText(this, "Coming Soon!", Toast.LENGTH_SHORT).show();
            case R.id.nav_favourite:
                Toast.makeText(this, "Coming Soon!", Toast.LENGTH_SHORT).show();
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

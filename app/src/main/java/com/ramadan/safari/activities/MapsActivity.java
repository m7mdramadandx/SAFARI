package com.ramadan.safari.activities;

import android.os.Bundle;
import android.view.KeyEvent;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.ramadan.safari.R;

public class MapsActivity extends FragmentActivity
        implements OnMapReadyCallback {
    private GoogleMap mMap;
    // to visual the map
    private LatLngBounds.Builder mBounds = new LatLngBounds.Builder();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng toilp = new LatLng(31.232663, 29.946237);
        mMap.addMarker(new MarkerOptions().position(toilp).title("TOLIP Hotel Alexandria"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(toilp));


    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_3:
                mMap.animateCamera(CameraUpdateFactory.zoomIn());
                break;
            case KeyEvent.KEYCODE_1:
                mMap.animateCamera(CameraUpdateFactory.zoomOut());
                break;
        }
        return super.onKeyDown(keyCode, event);
    }
}






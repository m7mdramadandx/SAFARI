package com.ramadan.safari.activities;

import android.os.Bundle;
import android.view.KeyEvent;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.ramadan.safari.R;

public class MapsActivity extends FragmentActivity
        implements OnMapReadyCallback {
    private GoogleMap mMap;
    // to visual the map
    private LatLngBounds.Builder mBounds = new LatLngBounds.Builder();
    float latitude, longitude;
    String latit, longi, label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        latit = getIntent().getExtras().getString("latitude");
        longi = getIntent().getExtras().getString("longitude");
        label = getIntent().getExtras().getString("label");
        latitude = Float.parseFloat(latit);
        longitude = Float.parseFloat(longi);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng target = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(target).title(label).icon(BitmapDescriptorFactory.fromResource(R.drawable.map_logo)));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(target, 15), 5000, null);


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






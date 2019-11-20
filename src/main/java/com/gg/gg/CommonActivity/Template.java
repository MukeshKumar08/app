package com.gg.gg.CommonActivity;

import android.location.LocationManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Template extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback, GoogleMap.OnMarkerClickListener {

    private GoogleApi mgoogle;
    private LocationManager locationManager;
    private GoogleApiClient googleApiClient;
    private Marker mMarker = null;
    private static final int REQUEST_LOCATION=1;

    @Override
    public boolean onMarkerClick(Marker marker) {
//
//        SupportMapFragment supportMapFragment = marker.getPosition();


        return false;
    }
}

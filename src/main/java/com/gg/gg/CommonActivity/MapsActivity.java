package com.gg.gg.CommonActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.gg.gg.CommonActivity.MapData.Business;
import com.gg.gg.CommonActivity.MapData.Common;
import com.gg.gg.CommonActivity.MapData.IGoogleApiService;
import com.gg.gg.CommonActivity.MapData.My_places;
import com.gg.gg.R;
//import com.gg.gg.milk_value_map.MilkMarkerInterface;
//import com.gg.gg.milk_value_map.MilkMarkerPresent;
import com.gg.gg.search.Dashboard_Milk.MIlk_Adapter.MainAdapter;
import com.gg.gg.search.Dashboard_Milk.Milk_Data.PojoLatLongData;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, LocationListener, GoogleMap.OnMarkerClickListener {


    private static final int MY_PERMISSION_REQUEST_LOCATION = 99;
    private static final String TAG = "MapsActivity";
    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    Marker mCurrentLocationMarker;
    LocationRequest mLocationRequest;
    private GoogleMap mMap;
    private MarkerOptions value1, value2, value3, value4, mark;
    private double latitude, longitude;

    IGoogleApiService mService;

//    MainAdapter mainAdapter;
//    MilkMarkerInterface milkMarkerInterface;
//    MilkMarkerPresent milkMarkerPresent;


//    private List<PojoLatLongData> adapters = new ArrayList<>();


    //    Timer timer = new Timer();
//
//    private Template template;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        if (haveNetwork()) {

        } else if (!haveNetwork()) {
//            Toast.makeText(this, "please connect to network", Toast.LENGTH_SHORT).show();
        }

        //init Service
        mService = Common.getGoogleApiService();


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            CheckLocationPermission();
        }

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.map_Bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.nav_Food:
                        nearByPlace("Food");
                        break;
                    case R.id.nav_Milk:
                        nearByPlace("Milk");
                        break;
                    case R.id.nav_Vegetables:
                        nearByPlace("Vegetable");
                        break;
                    case R.id.nav_Tires:
                        nearByPlace("Tire");
                        break;
                }


                return true;
            }
        });


//
//        value1 = new MarkerOptions().position(new LatLng(12.7496, 77.8059)).title("Vendor 1")
//                .snippet("I am daily seller.I will be available from 7 Am to 10 Am");
//        value2 = new MarkerOptions().position(new LatLng(12.7461942, 77.8118)).title("Vendor 2").snippet("I am daily seller");
//        value3 = new MarkerOptions().position(new LatLng(12.7577, 77.7991)).title("Vendor 3").snippet("I am daily seller");
//        value4 = new MarkerOptions().position(new LatLng(12.7378, 77.8200)).title("Vendor 4").snippet("I am daily seller");

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    private void nearByPlace(String PlaceType) {
        mMap.clear();
        String url = getUrl(latitude, longitude, PlaceType);

        mService.getNearByPlaces(url)
                .enqueue(new Callback<My_places>() {
                    @Override
                    public void onResponse(Call<My_places> call, Response<My_places> response) {
                        if (response.isSuccessful()) {
                            for (int i = 0; i < response.body().getName().length(); i++) {
                                MarkerOptions markerOptions = new MarkerOptions();
                                My_places googlePlace = null;
                                double lat = Double.parseDouble(googlePlace.getLatitude());
                                double lng = Double.parseDouble(googlePlace.getLongitude());
                                String name = googlePlace.getName();
                                String city = googlePlace.getCity();
                                String state = googlePlace.getState();
                                String country = googlePlace.getCountry();
                                String pincode = googlePlace.getPincode();
                                LatLng latLng = new LatLng(lat, lng);
                                markerOptions.position(latLng);
                                markerOptions.title(name);
                                if (PlaceType.equals("Food"))
                                    markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                                else if (PlaceType.equals("Milk"))
                                    markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
                                else if (PlaceType.equals("Vegetable"))
                                    markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
                                else if (PlaceType.equals("Tire"))
                                    markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
                                else
                                    markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));

                                //Adding marker to Map

                                mMap.addMarker(markerOptions);

                                //Move Camera

                                mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                                mMap.animateCamera(CameraUpdateFactory.zoomTo(11));

                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<My_places> call, Throwable t) {

                    }
                });

    }

    private String getUrl(double latitude, double longitude, String placeType) {
//        http://localhost:8088/vendor_location/12.735283/77.827479/2

//        business_By_name/

        StringBuilder googleplacesUrl = new StringBuilder("http://192.168.1.110:8088/business_By_name/");
//        googleplacesUrl.append(latitude);
//        googleplacesUrl.append(longitude);
//        googleplacesUrl.append(2);
        googleplacesUrl.append(placeType);

        Log.d("getUrl", googleplacesUrl.toString());
        return googleplacesUrl.toString();
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        Log.d(TAG, "onMapReady: Add Marker ");
//        mMap.addMarker(value1);
//        mMap.addMarker(value2);
//        mMap.addMarker(value3);
//        mMap.addMarker(value4);


        //Adding Multiple Markers
//        addMarkersToMap();

        mMap.setMapType(googleMap.MAP_TYPE_NORMAL);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setAllGesturesEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);

            }
        } else {
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }


    }


    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();


    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        mGoogleApiClient.connect();
    }


    @Override
    public void onLocationChanged(Location location) {
        mLastLocation = location;
        if (mCurrentLocationMarker != null) {
            mCurrentLocationMarker.remove();
        }
        //Showing the current location marker on map

        latitude = location.getLatitude();
        longitude = location.getLongitude();

        LatLng userlatLng = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(userlatLng);
        LocationManager locationManager = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);
        String provider = locationManager.getBestProvider(new Criteria(), true);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        Location mLastLocation = locationManager.getLastKnownLocation(provider);
        List<String> providerList = locationManager.getAllProviders();
        if (null != location && null != providerList && providerList.size() > 0) {
            double longitude = location.getLongitude();
            double latitude = location.getLatitude();
            Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
            try {
                List<Address> listAddress = geocoder.getFromLocation(longitude, latitude, 1);

                if (null != listAddress && listAddress.size() > 0) {
                    String state = listAddress.get(0).getAdminArea();
                    String country = listAddress.get(0).getCountryName();
                    String subLocality = listAddress.get(0).getSubLocality();
                    markerOptions.title("My location" + userlatLng + "," + subLocality + "," + state + "," + country);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        mMap.addMarker(mark);

        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        mCurrentLocationMarker = mMap.addMarker(markerOptions);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(userlatLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(11));
        if (mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    public boolean CheckLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {

                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSION_REQUEST_LOCATION);

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSION_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {
            case MY_PERMISSION_REQUEST_LOCATION: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        if (mGoogleApiClient == null) {
                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }
                } else {
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }

        }


//            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {


        return false;
    }

    public boolean haveNetwork() {

        Boolean have_Wifi = false;
        Boolean have_MobileData = false;

        ConnectivityManager manager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo[] networkInfos = manager.getAllNetworkInfo();
        for (NetworkInfo info : networkInfos) {
            if (info.getTypeName().equalsIgnoreCase("WIFI")) {
                if (info.isConnected()) {
                    have_Wifi = true;

                    if (info.getTypeName().equalsIgnoreCase("MobileData")) {
                        if (info.isConnected()) {
                            have_MobileData = true;
                        }

                    }
                }
            }
        }
        return have_MobileData || have_Wifi;
    }


//    @Override
//    public void setVendorsNear(List<PojoLatLongData> pojoLatLongData) {
//
//
//    }

//    @Override
//    public void onItemClick(View view, int position) {
//
//
//    }
}


////    protected void createLocationRequest() {
////
////        LocationRequest locationRequest = LocationRequest.create();
////        locationRequest.setInterval(1000);
////        locationRequest.setFastestInterval(5000);
////        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
////
////        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest(locationRequest);
////
////        SettingsClient client = LocationServices.getSettingsClient(this);
////        Task<LocationSettingsResponse> task = client.checkLocationSettings(builder.build());
////
////        task.addOnSuccessListener(this, locationSettingsResponse -> {
////
////        });
////
////        task.addOnFailureListener(this, e -> {
////
////            if (e instanceof ResolvableApiException) {
////
////                try {
////
////                    ResolvableApiException resolvable = (ResolvableApiException) e;
////                    resolvable.startResolutionForResult(MapsActivity.this, REQUEST_CHECK_SETTING);
////                } catch (IntentSender.SendIntentException sendEx) {
////
////                }
////
////            }
////
////
////        });
//
//
//        }
//
//
//}





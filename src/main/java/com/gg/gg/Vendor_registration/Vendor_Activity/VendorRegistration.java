package com.gg.gg.Vendor_registration.Vendor_Activity;


import android.Manifest;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


import com.gg.gg.CommonActivity.MapsActivity;
import com.gg.gg.R;
import com.gg.gg.Vendor_registration.Vendor_Data.Vendor;
import com.gg.gg.Vendor_registration.Vendor_Data.VendorData;
import com.gg.gg.Vendor_registration.Vendor_Model.VendorInterface;
import com.gg.gg.vendor_product.Products;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VendorRegistration extends AppCompatActivity {


    public LinearLayout reg_main_linear;
    public ScrollView reg_scroll_view;
    public EditText vendor_name;
    public EditText vendor_city;
    public EditText vendor_state;
    public EditText vendor_country;
    public EditText vendor_pinCode;
    public EditText vendor_address;
    public EditText vendor_email;
    public EditText vendor_password;
    public EditText vendor_business;
    public EditText vendor_business_one;
    public EditText vendor_business_two;
    public EditText vendor_business_three;
    public TextView get_location_lat;
    public TextView get_location_long;
    public TextView tv_vendor_reg;
    public Button button_location;
    public Button vendor_submit;
//    public View reg_spinner;

    public ConnectivityManager connectivityManager;

    VendorInterface vendorInterface;

    public static final String TAG = "VendorRegistration";
    public static final int REQUEST_LOCATION = 1;
    LocationManager locationManager;
    String latitude, longitude;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_reg);


        reg_main_linear = findViewById(R.id.reg_main_linear);
        reg_scroll_view = findViewById(R.id.reg_scroll_view);
        vendor_name = findViewById(R.id.vendor_name);
        vendor_city = findViewById(R.id.vendor_city);
        vendor_state = findViewById(R.id.vendor_state);
        vendor_country = findViewById(R.id.vendor_country);
        vendor_pinCode = findViewById(R.id.vendor_pinCode);
        vendor_address = findViewById(R.id.vendor_address);
        vendor_email = findViewById(R.id.vendor_email);
        vendor_password = findViewById(R.id.vendor_password);
        vendor_business = findViewById(R.id.vendor_business);
        tv_vendor_reg = findViewById(R.id.tv_vendor_reg);
        button_location = findViewById(R.id.button_location);
        vendor_submit = findViewById(R.id.vendor_submit);
        vendor_business_one = findViewById(R.id.vendor_business_one);
        vendor_business_two = findViewById(R.id.vendor_business_two);
        vendor_business_three = findViewById(R.id.vendor_business_three);

        get_location_lat = findViewById(R.id.get_location_lat);
        get_location_long = findViewById(R.id.get_location_long);

//        reg_spinner = findViewById(R.id.reg_spinner);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);


        Gson gson = new GsonBuilder().serializeNulls().create();

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.110:8088/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okClient)
                .build();

        vendorInterface = retrofit.create(VendorInterface.class);
    }

    public void SaveContinue(View view) {


        String Name = vendor_name.getText().toString().trim();
        String City = vendor_city.getText().toString().trim();
        String State = vendor_state.getText().toString().trim();
        String Country = vendor_country.getText().toString().trim();
        String PinCode = vendor_pinCode.getText().toString().trim();
        String Address = vendor_address.getText().toString().trim();
        String Email = vendor_email.getText().toString().trim();
        String Password = vendor_password.getText().toString().trim();
        Double Latitudee = Double.valueOf((get_location_lat.getText().toString()));
        Double Longitudee = Double.valueOf((get_location_long.getText().toString()));
        String business = vendor_business.getText().toString().trim();
        String business_one = vendor_business_one.getText().toString().trim();
        String business_two = vendor_business_two.getText().toString().trim();
        String business_three = vendor_business_three.getText().toString().trim();

        Intent intent = new Intent(VendorRegistration.this, MapsActivity.class);
        intent.putExtra("Latitude",Latitudee);
        intent.putExtra("Longitude",Longitudee);
        startActivity(intent);




//        String Business = vendor_name.getText().toString().trim();
//        String name, String city, String state, String country, String pincode, String address, String email, String password, Double latitude, Double longitude, List<Business> business)

        List<Vendor.Business> businessList = new ArrayList<>();
        businessList.add(new Vendor.Business(business));
        businessList.add(new Vendor.Business(business_one));
        businessList.add(new Vendor.Business(business_two));
        businessList.add(new Vendor.Business(business_three));


        Call<VendorData> vendorDataCall = vendorInterface.sendVendor(new Vendor(Name, City, State, Country, PinCode, Address, Email, Password, Latitudee, Longitudee, businessList));
        vendorDataCall.enqueue(new Callback<VendorData>() {
            @Override
            public void onResponse(Call<VendorData> call, Response<VendorData> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    Log.e(TAG, "OnResponse" + response.body().getStatusCode());
                    if (!response.body().getDescription().toString().isEmpty()) {
                        Log.e(TAG, "Data inserted success");
                        Log.e(TAG, response.raw().body().toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<VendorData> call, Throwable t) {
                t.getLocalizedMessage();

            }
        });


    }

//    public static void addList(){
//        List<Vendor.Business>businessList = new ArrayList<>();
//        businessList.add(new Vendor.Business("businessName"));
//
//    }


    public void GetLocation(View view) {



        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {

            //check Gps is On are Off

            OnGPS();
//            connected();

        } else {

            // if the Gps is already On

            getLocation();

        }

        if (isNetworkAvaliable()){
            Toast.makeText(this, "Network Avaliable", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "connect to Inter    net", Toast.LENGTH_SHORT).show();
        }


    }

    public boolean isNetworkAvaliable(){

        try{

            ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = null;

            if (connectivityManager != null ){
                info = connectivityManager.getActiveNetworkInfo();
            }
            return info != null && info.isConnected();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    private void getLocation() {

        //again checking the permission
        if (ActivityCompat.checkSelfPermission(VendorRegistration.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(VendorRegistration.this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);


        } else {

            Location LocationGPS = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            Location LocationNetwork = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            Location LocationPassive = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);


            if (LocationGPS != null) {
                double lat = LocationGPS.getLatitude();
                double longi = LocationGPS.getLongitude();
                latitude = String.valueOf(lat);
                longitude = String.valueOf(longi);

                get_location_lat.setText(latitude);
                get_location_long.setText(longitude);
            } else if (LocationNetwork != null) {
                double lat = LocationNetwork.getLatitude();
                double longi = LocationNetwork.getLongitude();
                latitude = String.valueOf(lat);
                longitude = String.valueOf(longi);

                get_location_lat.setText(latitude);
                get_location_long.setText(longitude);

            } else if (LocationPassive != null) {
                double lat = LocationPassive.getLatitude();
                double longi = LocationPassive.getLongitude();
                latitude = String.valueOf(lat);
                longitude = String.valueOf(longi);

                get_location_lat.setText(latitude);
                get_location_long.setText(longitude);
            }

//            else {
//
//                Toast.makeText(this, "Check Your Internet Connection", Toast.LENGTH_SHORT).show();
//            }


        }


    }

    private void OnGPS() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Enable Gps").setCancelable(false).setPositiveButton("Yes", (dialog, which) -> startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))).setNegativeButton("No", (dialog, which) -> dialog.cancel());
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


}

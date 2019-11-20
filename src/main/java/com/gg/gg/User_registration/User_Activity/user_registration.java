package com.gg.gg.User_registration.User_Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gg.gg.Login_pages.Login_Data.UserData;
import com.gg.gg.R;
import com.gg.gg.User_registration.User_Data.user;
import com.gg.gg.User_registration.User_Model.UserInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class user_registration extends AppCompatActivity {

    public EditText signup_email;
    public EditText signup_username;
    public EditText signup_password;
    public EditText signup_phone_number;
    public TextView tv_user_reg;
    public Button signup_btn;
    public UserInterface userInterface;
    public TextView signup_latitude;
    public TextView signup_longitude;
    public Button signup_Location;
    public static final String TAG = "user_registration";

    public static final int REQUEST_LOCATION = 1;

    LocationManager locationManager;

    String latitude, longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        tv_user_reg = findViewById(R.id.tv_user_reg);
        signup_email = findViewById(R.id.signup_email);
        signup_username = findViewById(R.id.signup_username);
        signup_password = findViewById(R.id.signup_password);
        signup_phone_number = findViewById(R.id.signup_phone_number);
        signup_btn = findViewById(R.id.signup_btn);
        signup_latitude = findViewById(R.id.signup_latitude);
        signup_longitude = findViewById(R.id.signup_longitude);
        signup_Location = findViewById(R.id.signup_Location);


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

//         http://localhost:3000/ URL for the fake DB


        userInterface = retrofit.create(UserInterface.class);

//        UserApi.getRetrofit() <---- instead of above retrofit

    }


    public void Get_LocationUser(View view) {

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {

            //check Gps is On are Off

            OnGPS();

        } else {

            // if the Gps is already On

            getLocation();

        }

    }

    private void getLocation() {

        //again checking the permission
        if (ActivityCompat.checkSelfPermission(user_registration.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(user_registration.this,
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

                signup_latitude.setText(latitude);
                signup_longitude.setText(longitude);
            } else if (LocationNetwork != null) {
                double lat = LocationNetwork.getLatitude();
                double longi = LocationNetwork.getLongitude();
                latitude = String.valueOf(lat);
                longitude = String.valueOf(longi);

                signup_latitude.setText(latitude);
                signup_longitude.setText(longitude);

            } else if (LocationPassive != null) {
                double lat = LocationPassive.getLatitude();
                double longi = LocationPassive.getLongitude();
                latitude = String.valueOf(lat);
                longitude = String.valueOf(longi);

                signup_latitude.setText(latitude);
                signup_longitude.setText(longitude);
            } else {
                Toast.makeText(this, "Check Your Internet Connection", Toast.LENGTH_SHORT).show();
            }


        }


    }


    private void OnGPS() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Enable Gps").setCancelable(false).setPositiveButton("Yes", (dialog, which) -> startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))).setNegativeButton("No", (dialog, which) -> dialog.cancel());
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


    public void User_Submit(View view) {

        String email = signup_email.getText().toString().trim();
        String username = signup_username.getText().toString().trim();
        String password = signup_password.getText().toString().trim();
        String phonenumber = signup_phone_number.getText().toString().trim();
        Double UserLatitude = Double.valueOf(signup_latitude.getText().toString());
        Double UserLongitude = Double.valueOf(signup_longitude.getText().toString());

        Call<UserData> vendorUserDataCall = userInterface.sendUser(new user(email, username, password, phonenumber, UserLatitude, UserLongitude));

        vendorUserDataCall.enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    Log.e(TAG, "onResponse" + response.body().getStatusCode());
                    if (!response.body().getDescription().toString().isEmpty()) {

                        Log.e(TAG, "inserted success");
                        Log.e(TAG, response.raw().body().toString());
                        Toast.makeText(user_registration.this, "Registration Successful", Toast.LENGTH_SHORT).show();

                    }
                    finish();
                }
            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {

                Toast.makeText(user_registration.this, "Error please Re-Register", Toast.LENGTH_SHORT).show();
            }

        });


    }

}

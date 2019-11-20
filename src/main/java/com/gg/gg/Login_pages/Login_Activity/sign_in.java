package com.gg.gg.Login_pages.Login_Activity;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.gg.gg.Login_pages.Login_Data.Mobile;
import com.gg.gg.Login_pages.Login_Data.UserData;
//import com.gg.gg.Login_pages.Login_Model.sign_ApiClient;
import com.gg.gg.Login_pages.Login_Model.sign_ApiClient;
import com.gg.gg.Login_pages.Login_Model.signin_ApiInterface;
import com.gg.gg.Otp.OTP_Activity.otp_page;
import com.gg.gg.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDate;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class sign_in extends AppCompatActivity {

    public ImageView signin_image;
    public EditText signin_et_phonenumber;
    public signin_ApiInterface signin_apiInterface;
    public sign_ApiClient sign_apiClient;
    private static final String TAG = "sign_in";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        signin_image = findViewById(R.id.signin_image);
        signin_et_phonenumber = findViewById(R.id.signin_et_phonenumber);

        signin_apiInterface = sign_apiClient.getClient().create(signin_ApiInterface.class);


    }


    public void Submit(View view) {

//
        String et_phone = signin_et_phonenumber.getText().toString().trim();

        Call<UserData> dataPhone = signin_apiInterface.sendOtp(new Mobile(et_phone));
        dataPhone.enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    Log.e(TAG, "OnResponse" + response.body().getStatusCode());
                    if (!response.body().getDescription().toString().isEmpty()) {
                        Log.e(TAG, "Phone Number sent success");
                        Log.e(TAG, response.raw().body().toString());



                    }
                }
            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {
                t.getLocalizedMessage();

                signin_et_phonenumber.setError("Enter the Registered phone number");
                signin_et_phonenumber.requestFocus();

            }
        });
        Intent intent = new Intent(sign_in.this, otp_page.class);
        intent.putExtra("phoneNumber", et_phone);
        startActivity(intent);

    }
}


//    //                        if (view == signin_et_phonenumber) {
//    Intent intent = new Intent(getApplicationContext(), otp_page.class);
//    //                            intent.putExtra("value", signin_et_phonenumber.getText().toString().trim());
//    startActivity(intent);
////                        } else {
////                            signin_et_phonenumber.setError("Enter the Registered phone number");
////                            signin_et_phonenumber.requestFocus();
////                            return;
////                        }


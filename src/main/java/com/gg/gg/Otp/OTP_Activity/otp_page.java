package com.gg.gg.Otp.OTP_Activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.LongDef;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.gg.gg.Login_pages.Login_Activity.sign_in;
import com.gg.gg.Otp.OTP_Data.OtpData;
import com.gg.gg.Otp.OTP_Data.OtpResponse;
import com.gg.gg.Otp.OTP_Model.OtpInterface;
import com.gg.gg.Otp.OTP_Model.signin_ApiInterface;
import com.gg.gg.R;
import com.gg.gg.search.dashboard_cust;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class otp_page extends AppCompatActivity {

    public EditText otp_one;
    public EditText otp_two;
    public EditText otp_three;
    public EditText otp_four;
    public EditText otp_five;
    public EditText otp_six;
    public Button submit_otp;

    OtpInterface otpInterface;
    signin_ApiInterface signin_apiInterface;

    sign_in sign_in;

    private int phoneNumber;
    private int otp_validate;


    public static final String TAG = "OTP";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opt_page);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.RECEIVE_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.RECEIVE_SMS}, 1000);
        }


        otp_one = findViewById(R.id.otp_one);
        otp_two = findViewById(R.id.otp_two);
        otp_three = findViewById(R.id.otp_three);
        otp_four = findViewById(R.id.otp_four);
        otp_five = findViewById(R.id.otp_five);
        otp_six = findViewById(R.id.otp_six);
        submit_otp = findViewById(R.id.submit_otp);

        Gson gson = new GsonBuilder().serializeNulls().create();

        HttpLoggingInterceptor otphttpLoggingInterceptor = new HttpLoggingInterceptor();
        otphttpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(otphttpLoggingInterceptor)
                .build();

        Retrofit optRetrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.110:8088/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

//        http:
////192.168.1.110:8088/

        otpInterface = optRetrofit.create(OtpInterface.class);

        submit_otp.setOnClickListener(view -> {

            String one = (otp_one.getText().toString().trim());
            String two = (otp_two.getText().toString().trim());
            String three = (otp_three.getText().toString().trim());
            String four = (otp_four.getText().toString().trim());
            String five = (otp_five.getText().toString().trim());
            String six = (otp_six.getText().toString().trim());

            String otp_validate = one + two + three + four + five + six;

            Intent i = getIntent();
            String text = i.getStringExtra("phoneNumber");

            String url = getPhoneUrl(otp_validate);

            otpInterface.sendOpt(url, text).enqueue(new Callback<OtpData>() {
                @Override
                public void onResponse(Call<OtpData> call, Response<OtpData> response) {
                    if (response.isSuccessful()) {
                        assert response.body() != null;
                        Log.d(TAG, "OnResponse" + response.body().getStatus());
                        if (!response.body().getDescription().toString().isEmpty()) {
                            Log.d(TAG, "OnResponse success PhoneNumber and validate otp sent success");
                            Log.d(TAG, response.raw().body().toString());


                        }
                    }
                }

                @Override
                public void onFailure(Call<OtpData> call, Throwable t) {
                    t.getLocalizedMessage();

                }
            });

            Intent intent = new Intent(getApplicationContext(), dashboard_cust.class);
            startActivity(intent);
        });


        otp_one.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (otp_one.length() == 1) {
                    otp_two.requestFocus();
                } else {
                    otp_one.clearFocus();
                }
            }
        });

        otp_two.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (otp_two.length() == 1) {
                    otp_three.requestFocus();
                } else {
                    otp_two.requestFocus();
                }
            }
        });

        otp_three.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (otp_one.length() == 1) {
                    otp_four.requestFocus();
                } else {
                    otp_three.requestFocus();
                }

            }
        });

        otp_four.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (otp_four.length() == 1) {
                    otp_five.requestFocus();
                } else {
                    otp_four.requestFocus();
                }
            }
        });


        otp_five.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (otp_five.length() == 1) {
                    otp_six.requestFocus();

                } else {
                    otp_five.requestFocus();
                }
            }
        });

        otp_six.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (otp_six.length() == 1) {
                    otp_six.clearFocus();
                } else {
                    otp_six.clearFocus();
                }
            }
        });


    }

    private String getPhoneUrl(String otp_validate) {

        StringBuilder otpUrl = new StringBuilder("http://192.168.1.110:8088/validate_otp/");
        otpUrl.append(otp_validate);
        Log.d("getPhoneUrl", otpUrl.toString());
        return otpUrl.toString();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == 1000) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Permission not Granted", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

//    public void Resend(View view) {
//
//        Call<OtpData> ResendOptCall = signin_apiInterface.ResendOtp(new Mobile(""));
//        ResendOptCall.enqueue(new Callback<UserData>() {
//            @Override
//            public void onResponse(Call<UserData> call, Response<UserData> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<UserData> call, Throwable t) {
//
//            }
//        });
//
//
}




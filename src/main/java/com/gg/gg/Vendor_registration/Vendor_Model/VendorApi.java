package com.gg.gg.Vendor_registration.Vendor_Model;

import android.view.View;

import java.util.BitSet;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//public class VendorApi {
//
//    private static String BASE_URL = "http://192.168.1.110:8088/";
//    public static Retrofit retrofit = null;
//
//
//    public static OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS)
//            .readTimeout(60, TimeUnit.SECONDS)
//            .writeTimeout(60, TimeUnit.SECONDS)
//            .build();
//
//
//    public static Retrofit getvendor() {
//
//        if (retrofit == null) {
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .client(okHttpClient)
//                    .build();
//        }
//        return retrofit;
//    }
//
//    private VendorApi(Data data) {
//        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
//        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//    }
//
//
//}


//    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//// set your desired log level
//    logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//// add your other interceptors …
//
//// add logging as last interceptor
//            httpClient.addInterceptor(logging);  // <-- this is the important line!
//
//            Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl("http://192.168.1.110:8088/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(httpClient.build())
//            .build();
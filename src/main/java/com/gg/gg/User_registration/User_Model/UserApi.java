package com.gg.gg.User_registration.User_Model;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//public class UserApi {
//
//    private static String BASE_URL="http://192.168.1.110:8088/";
//    public static Retrofit retrofit = null;
//
//    private static OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(60, TimeUnit.SECONDS)
//            .readTimeout(60,TimeUnit.SECONDS)
//            .writeTimeout(60,TimeUnit.SECONDS)
//            .build();
//
//    public static Retrofit getRetrofit(){
//
//        if(retrofit==null){
//            retrofit=new Retrofit.Builder()
//                     .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .client(okHttpClient)
//                    .build();
//        }
//        return retrofit;
//    }
//
//}

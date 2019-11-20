package com.gg.gg.search.Dashboard_Milk.MIlk_Model;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class  ListApi {

    private static final String BASE_URL = "http://192.168.1.110:8088/";
    private static Retrofit retrofit = null;

    public static OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30,TimeUnit.SECONDS)
            .writeTimeout(30,TimeUnit.SECONDS)
            .build();

    public static Retrofit getList(){

        if (retrofit==null){

            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }


}

package com.gg.gg.search.Dashboard_Food.Food_Model;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListFoodApi {

    private static final String BASE_URL="";
    private static Retrofit retrofit = null;


    public static OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(50,TimeUnit.SECONDS)
            .writeTimeout(50,TimeUnit.SECONDS)
            .build();

    public static Retrofit getFood() {

        if (retrofit == null) {

            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();

        }
        return retrofit;
    }
}

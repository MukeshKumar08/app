package com.gg.gg.CommonActivity.MapData;

public class Common {

    private static final String GOOGLE_API_URL = "http://192.168.1.110:8088/";

    public static IGoogleApiService getGoogleApiService ()
    {
        return RetrofitClient.getMapRetrofit(GOOGLE_API_URL).create(IGoogleApiService.class);
    }
}

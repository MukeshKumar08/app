package com.gg.gg.CommonActivity.MapData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface IGoogleApiService {

    @GET
    Call<My_places> getNearByPlaces(@Url String url);
}

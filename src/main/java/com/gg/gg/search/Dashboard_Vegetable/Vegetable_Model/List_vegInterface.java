package com.gg.gg.search.Dashboard_Vegetable.Vegetable_Model;

import com.gg.gg.search.Dashboard_Vegetable.Vegetable_Data.List_vegData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface List_vegInterface {

    @GET
    Call<List_vegData> getVeg();



}

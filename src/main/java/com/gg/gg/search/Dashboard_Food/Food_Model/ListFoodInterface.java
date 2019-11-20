package com.gg.gg.search.Dashboard_Food.Food_Model;

import com.gg.gg.search.Dashboard_Food.Food_Data.ListFoodData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ListFoodInterface {

    @GET("vendor_Registration")
    Call<List<ListFoodData>> getFood();
}

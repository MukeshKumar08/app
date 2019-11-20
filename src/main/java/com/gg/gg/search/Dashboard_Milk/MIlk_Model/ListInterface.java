package com.gg.gg.search.Dashboard_Milk.MIlk_Model;

import com.gg.gg.search.Dashboard_Milk.Milk_Data.ListData;
import com.gg.gg.search.Dashboard_Milk.Milk_Data.PojoLatLongData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ListInterface {


    @GET("vendor")
    Call<List<ListData>> getData();


    @GET("vendor")
    Call<List<PojoLatLongData>> getMark();







}

//    "vendor_by_data/"

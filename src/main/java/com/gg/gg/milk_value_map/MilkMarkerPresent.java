package com.gg.gg.milk_value_map;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.gg.gg.search.Dashboard_Milk.MIlk_Model.ListApi;
import com.gg.gg.search.Dashboard_Milk.MIlk_Model.ListInterface;
import com.gg.gg.search.Dashboard_Milk.Milk_Data.PojoLatLongData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//public class MilkMarkerPresent extends AppCompatActivity implements MilkMarkerInterface.view {
//
//    MilkMarkerInterface.view view;
//
//    public MilkMarkerPresent(MilkMarkerInterface.view view) {
//        this.view = view;
//    }
//
//    public static final String TAG = "MilkMarkerPresent";
//    ListInterface listInterface;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        listInterface = ListApi.getList().create(ListInterface.class);
//
//
//    }
//
////    @Override
////    public void setVendorsNear(List<PojoLatLongData> pojoLatLongData)
////    {
////        List<PojoLatLongData> sample = new ArrayList<>();
////        Call<List<PojoLatLongData>> callData = listInterface.getMark();
////        callData.enqueue(new Callback<List<PojoLatLongData>>() {
////            @Override
////            public void onResponse(Call<List<PojoLatLongData>> call, Response<List<PojoLatLongData>> response) {
////                if (response.isSuccessful()) {
////                    assert response.body() != null;
////                    Log.d(TAG, "OnResponse" + response.body().size());
////                }
////            }
////
////            @Override
////            public void onFailure(Call<List<PojoLatLongData>> call, Throwable t) {
////                t.getLocalizedMessage();
////            }
////        });
////
////        view.setVendorsNear(sample);
////
////        return null;
////    }
//}

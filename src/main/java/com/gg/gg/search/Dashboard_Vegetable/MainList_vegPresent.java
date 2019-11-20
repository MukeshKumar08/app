package com.gg.gg.search.Dashboard_Vegetable;

import com.gg.gg.search.Dashboard_Vegetable.Vegetable_Data.List_vegData;
import com.gg.gg.search.Dashboard_Vegetable.Vegetable_Model.List_vegApi;
import com.gg.gg.search.Dashboard_Vegetable.Vegetable_Model.List_vegInterface;
import com.gg.gg.search.Dashboard_Vegetable.Vegetable_Model.MainvegView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainList_vegPresent {

    private MainvegView mainvegView;

    public MainList_vegPresent(MainvegView mainvegView) {
        this.mainvegView = mainvegView;
    }

    void getVegetables() {

        mainvegView.showLoading();

        List_vegInterface list_vegInterface = List_vegApi.getVeg().create(List_vegInterface.class);
        Call<List_vegData> callVeg = list_vegInterface.getVeg();
        callVeg.enqueue(new Callback<List_vegData>() {
            @Override
            public void onResponse(Call<List_vegData> call, Response<List_vegData> response) {
                mainvegView.hideLoading();
                if (response.isSuccessful() && response.body()!=null){
                    mainvegView.onGetResult((List<List_vegData>) response.body());
                }
            }

            @Override
            public void onFailure(Call<List_vegData> call, Throwable t) {
                mainvegView.hideLoading();
                mainvegView.onErrorLoading(t.getLocalizedMessage());

            }
        });

    }
}

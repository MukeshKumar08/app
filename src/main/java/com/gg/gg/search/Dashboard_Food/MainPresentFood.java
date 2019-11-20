package com.gg.gg.search.Dashboard_Food;

import com.gg.gg.search.Dashboard_Food.Food_Data.ListFoodData;
import com.gg.gg.search.Dashboard_Food.Food_Model.ListFoodApi;
import com.gg.gg.search.Dashboard_Food.Food_Model.ListFoodInterface;
import com.gg.gg.search.Dashboard_Food.Food_Model.MainViewFood;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresentFood {

    private MainViewFood viewFood;

    public MainPresentFood(MainViewFood viewFood) {
        this.viewFood = viewFood;
    }

    void GetFood() {

        viewFood.ShowLoading();

        ListFoodInterface foodInterface = ListFoodApi.getFood().create(ListFoodInterface.class);
        Call<List<ListFoodData>> foodDataCall = foodInterface.getFood();
        foodDataCall.enqueue(new Callback<List<ListFoodData>>() {
            @Override
            public void onResponse(Call<List<ListFoodData>> call, Response<List<ListFoodData>> response) {
                viewFood.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    viewFood.onGetResult(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<ListFoodData>> call, Throwable t) {
                viewFood.hideLoading();
                viewFood.onError(t.getLocalizedMessage());
            }
        });
    }

}

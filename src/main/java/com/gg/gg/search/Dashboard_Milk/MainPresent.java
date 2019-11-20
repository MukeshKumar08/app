package com.gg.gg.search.Dashboard_Milk;

import androidx.annotation.NonNull;

import com.gg.gg.search.Dashboard_Milk.MIlk_Model.ListApi;
import com.gg.gg.search.Dashboard_Milk.MIlk_Model.ListInterface;
import com.gg.gg.search.Dashboard_Milk.MIlk_Model.MainView;
import com.gg.gg.search.Dashboard_Milk.Milk_Data.ListData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresent {

    private MainView view;


    public MainPresent(MainView view) {
        this.view = view;
    }

    void getData() {

        view.showLoading();     //request data to server

        ListInterface listInterface = ListApi.getList().create(ListInterface.class);
        Call<List<ListData>> call = listInterface.getData();
        call.enqueue(new Callback<List<ListData>>() {
            @Override
            public void onResponse(@NonNull Call<List<ListData>> call, @NonNull Response<List<ListData>> response) {

                view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    view.onGetResult(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<ListData>> call, @NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }


}

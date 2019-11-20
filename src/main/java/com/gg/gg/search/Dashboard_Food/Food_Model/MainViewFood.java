package com.gg.gg.search.Dashboard_Food.Food_Model;

import com.gg.gg.search.Dashboard_Food.Food_Data.ListFoodData;

import java.util.List;

public interface MainViewFood {

    void ShowLoading();
    void hideLoading();
    void onGetResult(List<ListFoodData>listFoodData);
    void onError(String message);

}

package com.gg.gg.search.Dashboard_Milk.MIlk_Model;

import com.gg.gg.search.Dashboard_Milk.Milk_Data.ListData;

import java.util.List;

public interface MainView {

    void showLoading();
    void hideLoading();
    void onGetResult(List<ListData>listData);
    void onErrorLoading(String message);

}

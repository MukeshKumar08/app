package com.gg.gg.search.Dashboard_Vegetable.Vegetable_Model;

import com.gg.gg.search.Dashboard_Vegetable.Vegetable_Data.List_vegData;

import java.util.List;

public interface MainvegView {

    void showLoading();
    void hideLoading();
    void onGetResult(List<List_vegData>list_vegData);
    void onErrorLoading(String message);
}

package com.gg.gg.search.Dashboard_Vegetable;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.gg.gg.R;
import com.gg.gg.search.Dashboard_Vegetable.Vegetable_Adapter.MainList_vegAdapter;
import com.gg.gg.search.Dashboard_Vegetable.Vegetable_Data.List_vegData;
import com.gg.gg.search.Dashboard_Vegetable.Vegetable_Model.List_vegInterface;
import com.gg.gg.search.Dashboard_Vegetable.Vegetable_Model.MainvegView;

import java.util.List;

public class Vegetable_Recycler extends AppCompatActivity implements MainvegView {

    public RecyclerView recyclerView_vegetable;
    public EditText filter_et_veg;
    public Button filter_search_veg;
    public SwipeRefreshLayout swipe_veg;

    List_vegInterface list_vegInterface;
    MainList_vegPresent mainList_vegPresent;
    MainList_vegAdapter mainList_vegAdapter;

    MainList_vegAdapter.ItemClickListener vegitemClickListener;
    List<List_vegData> vegData;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        recyclerView_vegetable = findViewById(R.id.recyclerView_vegetable);
//        filter_et_veg = findViewById(R.id.filter_et_veg);
//        filter_search_veg = findViewById(R.id.filter_search_veg);
        swipe_veg = findViewById(R.id.swipe_veg);

        recyclerView_vegetable.setHasFixedSize(true);
        recyclerView_vegetable.setAdapter(mainList_vegAdapter);
        recyclerView_vegetable.setLayoutManager(new LinearLayoutManager(this));

        mainList_vegPresent = new MainList_vegPresent(this);
        mainList_vegPresent.getVegetables();

        swipe_veg.setOnRefreshListener(
                () -> mainList_vegPresent.getVegetables());

        vegitemClickListener = (((view, position) -> {
            String name = vegData.get(position).getName();
            Toast.makeText(this, "Name", Toast.LENGTH_SHORT).show();
        }));
    }


    @Override
    public void showLoading() {

        swipe_veg.setRefreshing(true);

    }

    @Override
    public void hideLoading() {
        swipe_veg.setRefreshing(false);
    }

    @Override
    public void onGetResult(List<List_vegData> list_vegData) {
        mainList_vegAdapter = new MainList_vegAdapter(this,list_vegData,vegitemClickListener);
        mainList_vegAdapter.notifyDataSetChanged();
        recyclerView_vegetable.setAdapter(mainList_vegAdapter);
        vegData = list_vegData;
    }

    @Override
    public void onErrorLoading(String message) {

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

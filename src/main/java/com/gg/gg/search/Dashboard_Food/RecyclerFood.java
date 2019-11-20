package com.gg.gg.search.Dashboard_Food;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gg.gg.R;
import com.gg.gg.search.Dashboard_Food.Food_Adapter.MainAdapterFood;
import com.gg.gg.search.Dashboard_Food.Food_Data.ListFoodData;
import com.gg.gg.search.Dashboard_Food.Food_Model.MainViewFood;

import java.util.List;

public class RecyclerFood extends AppCompatActivity implements MainViewFood {

    public EditText Food_search_et;
    public Button Food_search_btn;
    public SwipeRefreshLayout Food_Swipe;
    public RecyclerView Food_Recyclerview;

    MainAdapterFood mainAdapterFood;
    MainPresentFood mainPresentFood;
    MainAdapterFood.FoodViewAdapter.ItemClickListener itemClickListener;
    List<ListFoodData> FoodData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_food);

//        Food_search_et = findViewById(R.id.Food_search_et);
//        Food_search_btn = findViewById(R.id.Food_search_btn);
        Food_Swipe = findViewById(R.id.Food_Swipe);
        Food_Recyclerview = findViewById(R.id.Food_RecyclerView);


        Food_Recyclerview.setHasFixedSize(true);
        Food_Recyclerview.setAdapter(mainAdapterFood);
        Food_Recyclerview.setLayoutManager(new LinearLayoutManager(this));

        mainPresentFood = new MainPresentFood((MainViewFood) this);
        mainPresentFood.GetFood();

        Food_Swipe.setOnRefreshListener(() -> mainPresentFood.GetFood());


        itemClickListener = (((view, position) -> {

            String name = FoodData.get(position).getName();
            Toast.makeText(this, name, Toast.LENGTH_SHORT).show();

        }));


    }


    @Override
    public void ShowLoading() {
        Food_Swipe.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        Food_Swipe.setRefreshing(false);

    }

    @Override
    public void onGetResult(List<ListFoodData> listFoodData) {
        mainAdapterFood = new MainAdapterFood(this,listFoodData,itemClickListener);
        mainAdapterFood.notifyDataSetChanged();
        Food_Recyclerview.setAdapter(mainAdapterFood);
        FoodData = listFoodData;
    }

    @Override
    public void onError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

package com.gg.gg.search.Dashboard_Milk;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.gg.gg.CommonActivity.MapsActivity;
import com.gg.gg.R;
import com.gg.gg.search.Dashboard_Milk.MIlk_Adapter.MainAdapter;
import com.gg.gg.search.Dashboard_Milk.MIlk_Model.ListInterface;
import com.gg.gg.search.Dashboard_Milk.MIlk_Model.MainView;
import com.gg.gg.search.Dashboard_Milk.Milk_Data.ListData;

import java.util.List;


public class recycler_view_milk extends MapsActivity implements MainView {


    RecyclerView recyclerView;
    SwipeRefreshLayout swipe_refresh;
    SearchView search_list;


    ListInterface listInterface;

    double Latitude[];
    double Longitude[];


    public EditText filter_search;
    public Button btn_search_box;


    MainPresent present;
    MainAdapter adapter;
    MainAdapter.ItemClickListener itemClickListener;
    List<ListData> DataList;

//    public Button btn_search_box;
//    public EditText et_search_box;


    public static String TAG = "ITEM_MILK";


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.milk_recycler_view);


//        btn_search_box = findViewById(R.id.btn_search_box);

        recyclerView = findViewById(R.id.RecyclerView_milk);
        swipe_refresh = findViewById(R.id.swipe_refresh);
//        search_list = findViewById(R.id.search_list);

//        filter_search = findViewById(R.id.filter_search);

//        filter_search.setOnEditorActionListener(editorActionListener);


//        SearchView searchView = new SearchView(search_list.getContext());
//        searchView.setQueryHint("Search with city, state, country");

//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        present = new MainPresent(this);
        present.getData();

        swipe_refresh.setOnRefreshListener(
                () -> present.getData()
        );

        itemClickListener = ((view, position) -> {
            String name = DataList.get(position).getName();
            Toast.makeText(this, name, Toast.LENGTH_SHORT).show();

        });


    }


    @Override
    public void showLoading() {
        swipe_refresh.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        swipe_refresh.setRefreshing(false);
    }

    @Override
    public void onGetResult(List<ListData> listData) {
        adapter = new MainAdapter(this, listData, itemClickListener);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
        DataList = listData;

        Bundle argument = new Bundle();
        argument.putString("type", String.valueOf(listData));

    }

    @Override
    public void onErrorLoading(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }


    public void Get_Location(View view) {


//
//        getMapData.enqueue(new Callback<List<ListData>>() {
//            @Override
//            public void onResponse(Call<List<ListData>> call, Response<List<ListData>> response) {
//                if (response.isSuccessful() && response.body() != null) {
//
//                    for (int i = 0; i < Latitude.length; i++) {
//                        mapResponse.add(new JsonParseResponse(Latitude[i], Longitude[i]));
//
////                        Bundle bundle = new Bundle();
////                        bundle.putCharArray("coordinates",);
//
//                        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
//                        intent.putExtra("ExtraData", (Parcelable) mapResponse);
//                        startActivity(intent);
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<ListData>> call, Throwable t) {
//
//            }
//        });

        Intent intent = new Intent(this, MapsActivity.class);

        startActivity(intent);




    }



//    public void SearchBox(View view) {
//
//
//    }


}


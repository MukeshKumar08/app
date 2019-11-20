package com.gg.gg.search.Dashboard_Food.Food_Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.gg.gg.R;
import com.gg.gg.search.Dashboard_Food.Food_Data.ListFoodData;


import java.util.List;

public class MainAdapterFood extends RecyclerView.Adapter<MainAdapterFood.FoodViewAdapter> {

    private Context Foodcontext;
    private List<ListFoodData> listFoodData;
    private FoodViewAdapter.ItemClickListener itemClickListenerFood;

    public MainAdapterFood(Context foodcontext, List<ListFoodData> listFoodData, FoodViewAdapter.ItemClickListener itemClickListenerFood) {
        Foodcontext = foodcontext;
        this.listFoodData = listFoodData;
        this.itemClickListenerFood = itemClickListenerFood;
    }

    @NonNull
    @Override
    public FoodViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listing_food, parent, false);
        return new FoodViewAdapter(view, itemClickListenerFood);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewAdapter holder, int position) {
        ListFoodData Foodlist = listFoodData.get(position);
        holder.Food_getName.setText(Foodlist.getName());
        holder.Food_getCity.setText(Foodlist.getCity());
        holder.Food_getState.setText(Foodlist.getState());
        holder.Food_getCountry.setText(Foodlist.getCountry());
        holder.Food_getPincode.setText(Foodlist.getPincode());
        holder.Food_cardView.getCardBackgroundColor();

    }

    @Override
    public int getItemCount()
    {
        return listFoodData.size();
    }


    public static class FoodViewAdapter extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView Food_getName;
        private TextView Food_getCity;
        private TextView Food_getState;
        private TextView Food_getCountry;
        private TextView Food_getPincode;
        private CardView Food_cardView;

        ItemClickListener itemClickListenerFood;

        public FoodViewAdapter(@NonNull View itemView, ItemClickListener itemClickListenerFood) {
            super(itemView);

            Food_getName = itemView.findViewById(R.id.Food_getName);
            Food_getCity = itemView.findViewById(R.id.Food_getCity);
            Food_getState = itemView.findViewById(R.id.Food_getState);
            Food_getCountry = itemView.findViewById(R.id.Food_getCountry);
            Food_getPincode = itemView.findViewById(R.id.Food_getPincode);
            Food_cardView = itemView.findViewById(R.id.Food_cardView);

            this.itemClickListenerFood = itemClickListenerFood;
            Food_cardView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            itemClickListenerFood.onItemClick(v, getAdapterPosition());
        }

        public interface ItemClickListener {
            void onItemClick(View view, int position);
        }
    }
}

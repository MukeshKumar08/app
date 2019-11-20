package com.gg.gg.search.Dashboard_Vegetable.Vegetable_Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.gg.gg.R;
import com.gg.gg.search.Dashboard_Vegetable.Vegetable_Data.List_vegData;

import java.util.List;

public class MainList_vegAdapter extends RecyclerView.Adapter<MainList_vegAdapter.RecyclerViewAdapter> {


    private Context vegcontext;
    private List<List_vegData> list_vegData;
    private ItemClickListener itemClickListenerVeg;

    public MainList_vegAdapter(Context vegcontext, List<List_vegData> list_vegData, ItemClickListener itemClickListenerVeg) {
        this.vegcontext = vegcontext;
        this.list_vegData = list_vegData;
        this.itemClickListenerVeg = itemClickListenerVeg;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listing_vegetable, parent, false);

        return new RecyclerViewAdapter(view, itemClickListenerVeg);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter holder, int position) {

        List_vegData list = list_vegData.get(position);
        holder.get_name_veg.setText(list.getName());
        holder.get_city_veg.setText(list.getCity());
        holder.get_state_veg.setText(list.getState());
        holder.get_country_veg.setText(list.getCountry());
        holder.get_pincode_veg.setText(list.getPincode());
        holder.vegetable_card_view.getCardBackgroundColor();

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class RecyclerViewAdapter extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView get_name_veg;
        private TextView get_city_veg;
        private TextView get_state_veg;
        private TextView get_country_veg;
        private TextView get_pincode_veg;
        private CardView vegetable_card_view;


        ItemClickListener itemClickListenerVeg;


        public RecyclerViewAdapter(@NonNull View itemView, ItemClickListener itemClickListenerVeg) {
            super(itemView);

            get_name_veg = itemView.findViewById(R.id.get_name_veg);
            get_city_veg = itemView.findViewById(R.id.get_city_veg);
            get_state_veg = itemView.findViewById(R.id.get_state_veg);
            get_country_veg = itemView.findViewById(R.id.get_country_veg);
            get_pincode_veg = itemView.findViewById(R.id.get_pincode_veg);

            this.itemClickListenerVeg = MainList_vegAdapter.this.itemClickListenerVeg;
            vegetable_card_view = itemView.findViewById(R.id.vegetable_card_view);

        }

        @Override
        public void onClick(View v) {
            itemClickListenerVeg.onItemClick(v,getItemCount());
        }
    }



    public interface ItemClickListener {

        void onItemClick(View view, int position);

    }

}

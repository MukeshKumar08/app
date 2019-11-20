package com.gg.gg.search.Dashboard_Milk.MIlk_Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.gg.gg.R;
import com.gg.gg.search.Dashboard_Milk.Milk_Data.ListData;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.RecyclerViewAdapter> {

    private Context context;
    private List<ListData> listData;
    private ItemClickListener itemClickListener;

    public MainAdapter(Context context, List<ListData> listData, ItemClickListener itemClickListener) {
        this.context = context;
        this.listData = listData;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.milk_items, parent, false);
        return new RecyclerViewAdapter(view, itemClickListener);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter holder, int position) {
        ListData list = listData.get(position);
        holder.get_name.setText(list.getName());
        holder.get_city.setText(list.getCity());
        holder.get_state.setText(list.getState());
        holder.get_country.setText(list.getCountry());
        holder.get_pincode.setText(list.getPincode());
        holder.get_latitude.setText(list.getLatitude());
        holder.get_longitude.setText(list.getLongitude());
        holder.milk_card_view.getCardBackgroundColor();
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class RecyclerViewAdapter extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView get_name;
        private TextView get_city;
        private TextView get_state;
        private TextView get_country;
        private TextView get_pincode;
        private TextView get_latitude;
        private TextView get_longitude;
        private CardView milk_card_view;


        ItemClickListener itemClickListener;

        RecyclerViewAdapter(@NonNull View itemView, ItemClickListener itemClickListener) {
            super(itemView);

            get_name = itemView.findViewById(R.id.get_name);
            get_city = itemView.findViewById(R.id.get_city);
            get_state = itemView.findViewById(R.id.get_state);
            get_country = itemView.findViewById(R.id.get_country);
            get_pincode = itemView.findViewById(R.id.get_pincode);
            get_latitude = itemView.findViewById(R.id.get_latitude);
            get_longitude = itemView.findViewById(R.id.get_longitude);
            milk_card_view = itemView.findViewById(R.id.milk_card_view);



            this.itemClickListener = itemClickListener;
            milk_card_view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onItemClick(view, getAdapterPosition());


        }
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }


}



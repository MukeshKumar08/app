package com.gg.gg.milk_value_map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.gg.gg.R;
import com.gg.gg.search.Dashboard_Milk.MIlk_Adapter.MainAdapter;
import com.gg.gg.search.Dashboard_Milk.Milk_Data.PojoLatLongData;

import java.util.List;

public class MilkMarkerAdapter extends RecyclerView.Adapter<MilkMarkerAdapter.RecyclerViewAdapter> {

    private Context context;
    private List<PojoLatLongData> pojoLatLongData;
    private MainAdapter.ItemClickListener itemClickListener;

    public MilkMarkerAdapter(Context context, List<PojoLatLongData> pojoLatLongData, MainAdapter.ItemClickListener itemClickListener) {
        this.context = context;
        this.pojoLatLongData = pojoLatLongData;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.milk_items, parent, false);
        return new MilkMarkerAdapter.RecyclerViewAdapter(view, itemClickListener);

    }

    @Override
    public void onBindViewHolder(@NonNull MilkMarkerAdapter.RecyclerViewAdapter holder, int position) {
        PojoLatLongData list = pojoLatLongData.get(position);
        holder.get_name.setText(list.getName());
//        holder.get_latitude.setText(list.getLatitude());
//        holder.get_longitude.setText(list.getLongitude());
        holder.milk_card_view.getCardBackgroundColor();
    }

    @Override
    public int getItemCount() {
        return pojoLatLongData.size();
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


        MainAdapter.ItemClickListener itemClickListener;

        RecyclerViewAdapter(@NonNull View itemView, MainAdapter.ItemClickListener itemClickListener) {
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

    public interface MilkMarkerInterface {
        void setVendorsNear(List<PojoLatLongData>pojoLatLongData);
    }


}

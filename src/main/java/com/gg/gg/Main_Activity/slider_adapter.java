package com.gg.gg.Main_Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.gg.gg.R;

public class slider_adapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;


    public slider_adapter(Context context) {
    this.context=context;
    }

    public int[] slide_image = {

            R.drawable.gg,
            R.drawable.sevices,
            R.drawable.cservice
    };
    public String[] slide_heading = {

            "GG",
            "SERVICES",
            "ABOUT_US"
    };

    public String[] slide_desc = {

            "welcome to GG app to explore more",
            "welcome to GG app to explore more",
            "welcome to GG app to explore more",
    };


    @Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object)
    {
        return view == (LinearLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout,container,false);

        ImageView slideImageview = (ImageView)view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView)view.findViewById(R.id.slide_title);
        TextView slideDescription = (TextView)view.findViewById(R.id.slide_desc);

        slideImageview.setImageResource(slide_image[position]);
        slideHeading.setText(slide_heading[position]);
        slideDescription.setText(slide_desc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);

    }
}


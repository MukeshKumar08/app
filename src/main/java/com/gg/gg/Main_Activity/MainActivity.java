package com.gg.gg.Main_Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gg.gg.Login_pages.Login_Activity.sign_in;
import com.gg.gg.R;
import com.gg.gg.User_registration.User_Activity.user_registration;
import com.gg.gg.Vendor_registration.Vendor_Activity.VendorRegistration;

public class MainActivity extends AppCompatActivity {

    public Button next_btn;
    private ViewPager viewPager;
    private LinearLayout mDotLayout;
    private TextView[] mDots;
    public slider_adapter slider_adapter;

    public Button btn_new_vendor;
    public Button btn_new_user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_new_vendor = findViewById(R.id.btn_new_vendor);
        btn_new_user = findViewById(R.id.btn_new_user);
        next_btn=findViewById(R.id.next_btn);


        next_btn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), sign_in.class);
            startActivity(intent);
        });
        btn_new_vendor.setOnClickListener(view -> {
            Intent intent = new Intent (getApplicationContext(), VendorRegistration.class);
            startActivity(intent);
        });
        btn_new_user.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), user_registration.class);
            startActivity(intent);
        });

        viewPager = findViewById(R.id.view_page);
        mDotLayout=findViewById(R.id.view_liner);

        slider_adapter=new slider_adapter(this);
        viewPager.setAdapter(slider_adapter);
        mDotsindicator(0);
        viewPager.addOnPageChangeListener(view_Listner);
    }
public void mDotsindicator(int position){

        mDots = new TextView[3];
        for (int i=0;i<mDots.length;i++){
            mDots[i]=new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.transparent_white));

            mDotLayout.addView(mDots[i]);
        }

    if (mDots.length>0){
        mDots[position].setTextColor(getResources().getColor(R.color.gray));
    }
}

    ViewPager.OnPageChangeListener view_Listner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {
            mDotsindicator(i);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}


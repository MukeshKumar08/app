package com.gg.gg.CommonActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gg.gg.R;

public class Vendor_gpsEnable extends AppCompatActivity {

    public LinearLayout gps_one;
//    public LinearLayout gps_two;
    public TextView gps_tv;
//    public ImageView gps_iv;
    public Button gps_button;
    Animation upto;
//    Animation downtoup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_gps_enable);

//        gps_button = findViewById(R.id.gps_button);
        gps_one = findViewById(R.id.gps_one);
//        gps_two = findViewById(R.id.gps_two);
//        gps_iv = findViewById(R.id.gps_iv);
        gps_tv = findViewById(R.id.gps_tv);
        upto = AnimationUtils.loadAnimation(this,R.anim.upto);
        gps_one.setAnimation(upto);
//        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
//        gps_two.setAnimation(downtoup);
    }

    public void Enable_Gps(View view) {

    }
}

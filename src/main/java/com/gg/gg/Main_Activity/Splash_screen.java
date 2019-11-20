package com.gg.gg.Main_Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.gg.gg.R;

public class Splash_screen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT=2500;

    public LinearLayout linear_splash;
    public ImageView image_splash;
    public ProgressBar progress_splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        linear_splash = findViewById(R.id.linear_splash);
        image_splash = findViewById(R.id.image_splash);
        progress_splash = findViewById(R.id.progress_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(Splash_screen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME_OUT);



    }
}

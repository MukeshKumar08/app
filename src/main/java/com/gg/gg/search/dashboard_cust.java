package com.gg.gg.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.gg.gg.Login_pages.Login_Activity.sign_in;
import com.gg.gg.R;
import com.gg.gg.search.Dashboard_Milk.recycler_view_milk;

public class dashboard_cust extends AppCompatActivity {
    public ImageView iv_kebab;
    public ImageView iv_milk;
    public ImageView iv_veg;
    public ImageView iv_tire_repair;
    public ImageView iv_iron;
    public TextView tv_tires;
    public TextView tv_kebab;
    public TextView tv_milk;
    public TextView tv_vegetables;
    public TextView tv_iron;
    public CardView card_kebab;
    public CardView card_milk;
    public CardView card_vegetables;
    public CardView card_iron;
    public CardView card_tire;
    public ScrollView scroll_dashboard;
    public TextView logout_text;
    public LinearLayout linear_logOut;




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_cust);

        iv_kebab= findViewById(R.id.iv_kebab);
        iv_milk= findViewById(R.id.iv_milk);
        iv_veg=findViewById(R.id.iv_veg);
        iv_tire_repair= findViewById(R.id.iv_tire_repair);
        iv_iron=findViewById(R.id.iv_iron);
        tv_kebab = findViewById(R.id.tv_kebab);
        tv_milk = findViewById(R.id.tv_milk);
        tv_vegetables = findViewById(R.id.tv_vegetables);
        tv_tires = findViewById(R.id.tv_tires);
        tv_iron =findViewById(R.id.tv_iron);
        card_kebab = findViewById(R.id.card_kebab);
        card_milk = findViewById(R.id.card_milk);
        card_vegetables =findViewById(R.id.card_vegetables);
        card_iron = findViewById(R.id.card_iron);
        card_tire = findViewById(R.id.card_tire);
        scroll_dashboard = findViewById(R.id.scroll_dashboard);
        logout_text = findViewById(R.id.logout_text);
        linear_logOut = findViewById(R.id.linear_logOut);




        iv_kebab.setOnClickListener(view -> {

            Intent intent = new Intent(getApplicationContext(), recycler_view_milk.class);
            startActivity(intent);

        });

        iv_milk.setOnClickListener(view -> {
            Intent intent  = new Intent (getApplicationContext(),recycler_view_milk.class);
            startActivity(intent);
        });

        iv_iron.setOnClickListener(view -> {
            Intent intent  = new  Intent (getApplicationContext(),recycler_view_milk.class);
            startActivity(intent);
        });

        iv_veg.setOnClickListener(view -> {
            Intent intent = new Intent (getApplicationContext(), recycler_view_milk.class);
            startActivity(intent);
        });
        iv_tire_repair.setOnClickListener(view -> {
            Intent intent = new Intent (getApplicationContext(),recycler_view_milk.class);
            startActivity(intent);
        });
    }


    public void logout(View view) {
        Intent intent = new Intent(getApplicationContext(), sign_in.class);
        startActivity(intent);

    }
}

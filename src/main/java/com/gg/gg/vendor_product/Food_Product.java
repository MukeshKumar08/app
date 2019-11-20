package com.gg.gg.vendor_product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gg.gg.R;

public class Food_Product extends AppCompatActivity {

    public LinearLayout food_linear_main;
    public ImageButton food_ib_otherFood;
    public ImageButton food_ib_kebab;
    public ImageButton food_ib_biryani;
    public TextView food_tv_otherFood;
    public TextView food_tv_kebab;
    public TextView food_tv_biryani;
    public CardView food_card_kebab;
    public CardView food_card_biryani;
    public CardView food_card_otherFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food__product);

        food_linear_main = findViewById(R.id.food_linear_main);
        food_ib_otherFood = findViewById(R.id.food_ib_otherFood);
        food_ib_kebab = findViewById(R.id.food_ib_kebab);
        food_ib_biryani = findViewById(R.id.food_ib_biryani);
        food_tv_otherFood = findViewById(R.id.food_tv_otherFood);
        food_tv_kebab = findViewById(R.id.food_tv_kebab);
        food_tv_biryani = findViewById(R.id.food_tv_biryani);
        food_card_biryani = findViewById(R.id.food_card_biryani);
        food_card_kebab = findViewById(R.id.food_card_kebab);
        food_card_otherFood = findViewById(R.id.food_card_otherFood);
    }

    public void Biryani(View view) {
        Intent intent = new Intent(getApplicationContext(), Item_registration.class);
        startActivity(intent);
    }

    public void kebab(View view) {
        Intent intent = new Intent(getApplicationContext(), Item_registration.class);
        startActivity(intent);
    }


    public void OtherFoods(View view) {
        Intent intent = new Intent(getApplicationContext(), Item_registration.class);
        startActivity(intent);
    }
}

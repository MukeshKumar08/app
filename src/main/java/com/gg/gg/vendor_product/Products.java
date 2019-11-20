package com.gg.gg.vendor_product;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gg.gg.R;


public class Products extends AppCompatActivity {

    public LinearLayout product_LL_main;
    public ImageButton product_ib_food;
    public ImageButton product_ib_milk;
    public ImageButton product_ib_vegetables;
    public ImageButton product_ib_iron;
    public ImageButton product_ib_tire;
    public TextView product_tv_food;
    public TextView product_tv_milk;
    public TextView product_tv_vegetables;
    public TextView product_tv_iron;
    public TextView product_tv_tire;
    public CardView product_card_food;
    public CardView product_card_milk;
    public CardView product_card_vegetables;
    public CardView product_card_iron;
    public CardView product_card_tire;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        product_LL_main = findViewById(R.id.product_LL_main);
        product_ib_food = findViewById(R.id.product_ib_food);
        product_ib_milk = findViewById(R.id.product_ib_milk);
        product_ib_vegetables = findViewById(R.id.product_ib_vegetables);
        product_ib_iron = findViewById(R.id.product_ib_iron);
        product_ib_tire = findViewById(R.id.product_ib_tire);
        product_tv_food = findViewById(R.id.product_tv_food);
        product_tv_milk = findViewById(R.id.product_tv_milk);
        product_tv_vegetables = findViewById(R.id.product_tv_vegetables);
        product_tv_iron = findViewById(R.id.product_tv_iron);
        product_tv_tire = findViewById(R.id.product_tv_tire);
        product_card_food = findViewById(R.id.product_card_food);
        product_card_milk = findViewById(R.id.product_card_milk);
        product_card_vegetables = findViewById(R.id.product_card_vegetables);
        product_card_iron = findViewById(R.id.product_card_iron);
        product_card_tire = findViewById(R.id.product_card_tire);


    }


    public void card_food(View view) {
        Intent intent = new Intent(getApplicationContext(), Food_Product.class);
        startActivity(intent);

    }

    public void card_milk(View view) {

        Intent intent = new Intent(getApplicationContext(), Item_registration.class);
        startActivity(intent);


    }

    public void card_vegetables(View view) {
        Intent intent = new Intent(getApplicationContext(), Item_registration.class);
        startActivity(intent);


    }

    public void card_iron(View view) {
        Intent intent = new Intent(getApplicationContext(), Item_registration.class);
        startActivity(intent);


    }

    public void card_tire(View view) {
        Intent intent = new Intent(getApplicationContext(), Item_registration.class);
        startActivity(intent);


    }

    public void card_other(View view) {
        Intent intent = new Intent(getApplicationContext(), Item_registration.class);
        startActivity(intent);
    }

    public void ImageFood(View view) {
        Intent intent = new Intent(getApplicationContext(), Item_registration.class);
        startActivity(intent);
    }

    public void ImageMilk(View view) {
        Intent intent = new Intent(getApplicationContext(), Item_registration.class);
        startActivity(intent);
    }

    public void ImageVegetables(View view) {
        Intent intent = new Intent(getApplicationContext(), Item_registration.class);
        startActivity(intent);
    }

    public void ImageIron(View view) {
        Intent intent = new Intent(getApplicationContext(), Item_registration.class);
        startActivity(intent);
    }

    public void ImageTire(View view) {
        Intent intent = new Intent(getApplicationContext(), Item_registration.class);
        startActivity(intent);
    }

    public void ImageOther(View view) {
        Intent intent = new Intent(getApplicationContext(), Item_registration.class);
        startActivity(intent);
    }
}

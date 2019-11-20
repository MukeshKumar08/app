package com.gg.gg.vendor_product;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gg.gg.R;
import com.gg.gg.CommonActivity.Vendor_gpsEnable;

public class Item_registration extends AppCompatActivity {

    public EditText item_reg_1;
    public EditText item_reg_2;
    public EditText item_reg_3;
    public EditText item_reg_4;
    public EditText item_reg_5;
    public EditText item_reg_6;
    public EditText item_reg_7;
    public EditText item_reg_8;
    public EditText item_reg_9;
    public EditText item_reg_10;
    public EditText item_reg_11;
    public EditText item_reg_12;
    public EditText item_reg_13;
    public EditText item_reg_14;
    public EditText item_reg_15;
    public EditText item_reg_16;
    public EditText item_reg_17;
    public EditText item_reg_18;
    public EditText item_reg_19;
    public EditText item_reg_20;
    public EditText item_reg_rate_1;
    public EditText item_reg_rate_2;
    public EditText item_reg_rate_3;
    public EditText item_reg_rate_4;
    public EditText item_reg_rate_5;
    public EditText item_reg_rate_6;
    public EditText item_reg_rate_7;
    public EditText item_reg_rate_8;
    public EditText item_reg_rate_9;
    public EditText item_reg_rate_10;
    public EditText item_reg_rate_11;
    public EditText item_reg_rate_12;
    public EditText item_reg_rate_13;
    public EditText item_reg_rate_14;
    public EditText item_reg_rate_15;
    public EditText item_reg_rate_16;
    public EditText item_reg_rate_17;
    public EditText item_reg_rate_18;
    public EditText item_reg_rate_19;
    public EditText item_reg_rate_20;
    public Button item_reg_save_btn;
    public Button item_reg_update_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_registration);

        item_reg_1 = findViewById(R.id.item_reg_1);
        item_reg_2 = findViewById(R.id.item_reg_2);
        item_reg_3 = findViewById(R.id.item_reg_3);
        item_reg_4 = findViewById(R.id.item_reg_4);
        item_reg_5 = findViewById(R.id.item_reg_5);
        item_reg_6 = findViewById(R.id.item_reg_6);
        item_reg_7 = findViewById(R.id.item_reg_7);
        item_reg_8 = findViewById(R.id.item_reg_8);
        item_reg_9 = findViewById(R.id.item_reg_9);
        item_reg_10 = findViewById(R.id.item_reg_10);
        item_reg_11 = findViewById(R.id.item_reg_11);
        item_reg_12 = findViewById(R.id.item_reg_12);
        item_reg_13 = findViewById(R.id.item_reg_13);
        item_reg_14 = findViewById(R.id.item_reg_14);
        item_reg_15 = findViewById(R.id.item_reg_15);
        item_reg_16 = findViewById(R.id.item_reg_16);
        item_reg_17 = findViewById(R.id.item_reg_17);
        item_reg_18 = findViewById(R.id.item_reg_18);
        item_reg_19 = findViewById(R.id.item_reg_19);
        item_reg_20 = findViewById(R.id.item_reg_20);
        item_reg_rate_1 = findViewById(R.id.item_reg_rate_1);
        item_reg_rate_2 = findViewById(R.id.item_reg_rate_2);
        item_reg_rate_3 = findViewById(R.id.item_reg_rate_3);
        item_reg_rate_4 = findViewById(R.id.item_reg_rate_4);
        item_reg_rate_5 = findViewById(R.id.item_reg_rate_5);
        item_reg_rate_6 = findViewById(R.id.item_reg_rate_6);
        item_reg_rate_7 = findViewById(R.id.item_reg_rate_7);
        item_reg_rate_8 = findViewById(R.id.item_reg_rate_8);
        item_reg_rate_9 = findViewById(R.id.item_reg_rate_9);
        item_reg_rate_10 = findViewById(R.id.item_reg_rate_10);
        item_reg_rate_11 = findViewById(R.id.item_reg_rate_11);
        item_reg_rate_12 = findViewById(R.id.item_reg_rate_12);
        item_reg_rate_13 = findViewById(R.id.item_reg_rate_13);
        item_reg_rate_14 = findViewById(R.id.item_reg_rate_14);
        item_reg_rate_15 = findViewById(R.id.item_reg_rate_15);
        item_reg_rate_16 = findViewById(R.id.item_reg_rate_16);
        item_reg_rate_17 = findViewById(R.id.item_reg_rate_17);
        item_reg_rate_18 = findViewById(R.id.item_reg_rate_18);
        item_reg_rate_19 = findViewById(R.id.item_reg_rate_19);
        item_reg_rate_20 = findViewById(R.id.item_reg_rate_20);
        item_reg_save_btn = findViewById(R.id.item_reg_save_btn);
        item_reg_update_btn = findViewById(R.id.item_reg_update_btn);


    }

    public void SaveItems(View view) {

        Toast.makeText(this, "Your item is saved Successfully", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), Vendor_gpsEnable.class);
        startActivity(intent);
    }

    public void UpdateItems(View view) {

        Toast.makeText(this, "Your item is updated Successfully", Toast.LENGTH_SHORT).show();
        finish();
    }
}

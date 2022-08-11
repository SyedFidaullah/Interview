package com.example.interviewproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    ImageView imgProduct, btnBack;
    TextView tvName;
    TextView tvPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen);

        imgProduct = findViewById(R.id.imgProductBig);
        tvName = findViewById(R.id.tvNameProduct);
        tvPrice = findViewById(R.id.tvPriceProduct);
        btnBack = findViewById(R.id.btnBack);

        Intent intent = getIntent();

        int img = intent.getIntExtra("img",0);
        String name = intent.getStringExtra("name");
        String price = intent.getStringExtra("price");

        imgProduct.setImageResource(img);
        tvName.setText(name);
        tvPrice.setText(price);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
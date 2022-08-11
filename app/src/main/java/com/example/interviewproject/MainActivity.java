package com.example.interviewproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etSearch;
    RecyclerView rvProduct;
    ArrayList<ProductsModelClass> classArrayList;
    TrendingProductsAdapter trendingProductsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSearch  = findViewById(R.id.etSearch);
        rvProduct = findViewById(R.id.rvTrendingProducts);
        etSearch.setFocusable(false);
        etSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etSearch.setFocusable(true);
            }
        });

        classArrayList = new ArrayList<>();

        classArrayList.add(new ProductsModelClass(R.drawable.img1,"New Sofa","1200 RS/month"));
        classArrayList.add(new ProductsModelClass(R.drawable.img2,"Used Sofa","1000 RS/month"));
        classArrayList.add(new ProductsModelClass(R.drawable.img3,"Sofa","1500 RS/month"));
        classArrayList.add(new ProductsModelClass(R.drawable.img4,"Dining Table","2000 RS/month"));
        classArrayList.add(new ProductsModelClass(R.drawable.img5,"Table","2500 RS/month"));
        classArrayList.add(new ProductsModelClass(R.drawable.img6,"Dining Table","1560 RS/month"));


        rvProduct.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        trendingProductsAdapter = new TrendingProductsAdapter(classArrayList, this, new OnItemClickListener() {
            @Override
            public void onItemClick(int pos, int imgProduct, String price, String name) {
                Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                intent.putExtra("img",imgProduct);
                intent.putExtra("price",price);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
        rvProduct.setAdapter(trendingProductsAdapter);
    }
}

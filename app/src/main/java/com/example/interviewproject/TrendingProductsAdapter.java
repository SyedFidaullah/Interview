package com.example.interviewproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class TrendingProductsAdapter extends RecyclerView.Adapter<TrendingProductsAdapter.ViewHolder> {

    ArrayList<ProductsModelClass> productsModelClasses;
    Context context;
    OnItemClickListener onItemClickListener;

    public TrendingProductsAdapter(ArrayList<ProductsModelClass> productsModelClasses, Context context, OnItemClickListener onItemClickListener) {
        this.productsModelClasses = productsModelClasses;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rv_products, parent, false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        ProductsModelClass productsModelClass = productsModelClasses.get(position);

        Glide.with(context).load(productsModelClass.imgProduct).into(holder.imgProduct);

        holder.tvName.setText(productsModelClass.getProductName());
        holder.tvPrice.setText(productsModelClass.getProductPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(position,productsModelClass.imgProduct,productsModelClass.productPrice,productsModelClass.productName);
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgProduct;
        TextView tvName;
        TextView tvPrice;
        public ViewHolder(View itemView){
            super(itemView);

            imgProduct = itemView.findViewById(R.id.imgProduct);
            tvName = itemView.findViewById(R.id.productName);
            tvPrice = itemView.findViewById(R.id.productPrice);


        }
    }



    @Override
    public int getItemCount() {
        return productsModelClasses.size();
    }


}


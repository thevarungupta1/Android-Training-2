package com.thevarungupta.recyclerview;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder> {

    Context context;
    ArrayList<Product> mList;

    public AdapterProduct(Context context, ArrayList<Product> list) {
        this.context = context;
        this.mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_product_adapter, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = mList.get(position);
        holder.productNameTextView.setText(product.getpName());

        // Price is in int convert into string to show in text view
        holder.productPriceTextView.setText("Rs." + String.valueOf(product.getPrice()));

        Picasso.get()
                .load(product.getpImage())
                .placeholder(R.drawable.no_image)
                .into(holder.productImageView);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView productImageView;
        TextView productNameTextView, productPriceTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            productImageView = itemView.findViewById(R.id.image_product);
            productNameTextView = itemView.findViewById(R.id.text_view_product_name);
            productPriceTextView = itemView.findViewById(R.id.text_view_product_price);
        }
    }
}
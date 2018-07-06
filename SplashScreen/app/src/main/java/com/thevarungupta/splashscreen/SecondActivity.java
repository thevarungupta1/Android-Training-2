package com.thevarungupta.splashscreen;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterProduct adapterProduct;
    ArrayList<Product> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ImageView imageView = findViewById(R.id.image_view);
        Glide.with(this)
                .load("https://media1.tenor.com/images/13f9e9b47f297b708395ca05308dc8c1/tenor.gif?itemid=9531490")
                .asGif()
                .into(imageView);

//        getData();
//
//        recyclerView = findViewById(R.id.recycle_view);
//        adapterProduct = new AdapterProduct(this,list );
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapterProduct);
    }

    private void getData(){
        Product product;

        product = new Product();
        product.setName("a");
        product.setTitle("t");
        list.add(product);

        product = new Product();
        product.setName("a");
        product.setTitle("t");
        list.add(product);

        product = new Product();
        product.setName("a");
        product.setTitle("t");
        list.add(product);

        product = new Product();
        product.setName("a");
        product.setTitle("t");
        list.add(product);

        product = new Product();
        product.setName("a");
        product.setTitle("t");
        list.add(product);
    }
}

package com.thevarungupta.splashscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterProduct adapterProduct;
    ArrayList<Product> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getData();

        recyclerView = findViewById(R.id.recycle_view);
        adapterProduct = new AdapterProduct(this,list );
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterProduct);
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

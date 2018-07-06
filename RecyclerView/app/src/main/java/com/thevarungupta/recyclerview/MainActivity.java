package com.thevarungupta.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    AdapterProduct adapterProduct;
    ArrayList<Product> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateData();

        recyclerView = findViewById(R.id.recycle_view);
        adapterProduct = new AdapterProduct(this, list);

        // Linear Layout
        //layoutManager = new LinearLayoutManager(this);

        // Grid Layout
        layoutManager = new GridLayoutManager(this, 2);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterProduct);
    }

    private void generateData() {
        Product product;

        product = new Product();
        product.setpName("Product 1");
        product.setPrice(1000);
        product.setpImage("https://www.lg.com/lk/images/mobile-phones/md05851337/G6-image350-n.jpg");
        list.add(product);

        product = new Product();
        product.setpName("Product 2");
        product.setPrice(2000);
        product.setpImage("https://www.lg.com/lk/images/mobile-phones/md05851337/G6-image350-n.jpg");
        list.add(product);

        product = new Product();
        product.setpName("Product 3");
        product.setPrice(3000);
        product.setpImage("https://www.lg.com/lk/images/mobile-phones/md05851337/G6-image350-n.jpg");
        list.add(product);

        product = new Product();
        product.setpName("Product 4");
        product.setPrice(4000);
        product.setpImage("https://www.lg.com/lk/images/mobile-phones/md05851337/G6-image350-n.jpg");
        list.add(product);

        product = new Product();
        product.setpName("Product 1");
        product.setPrice(1000);
        product.setpImage("https://www.lg.com/lk/images/mobile-phones/md05851337/G6-image350-n.jpg");
        list.add(product);

        product = new Product();
        product.setpName("Product 2");
        product.setPrice(2000);
        product.setpImage("https://www.lg.com/lk/images/mobile-phones/md05851337/G6-image350-n.jpg");
        list.add(product);

        product = new Product();
        product.setpName("Product 3");
        product.setPrice(3000);
        product.setpImage("https://www.lg.com/lk/images/mobile-phones/md05851337/G6-image350-n.jpg");
        list.add(product);

        product = new Product();
        product.setpName("Product 4");
        product.setPrice(4000);
        product.setpImage("https://www.lg.com/lk/images/mobile-phones/md05851337/G6-image350-n.jpg");
        list.add(product);
    }
}

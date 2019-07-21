package com.example.recyclerviewproject.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.recyclerviewproject.R;
import com.example.recyclerviewproject.adapters.AdapterPostGrid;
import com.example.recyclerviewproject.models.Post;

import java.util.ArrayList;

public class RecyclerViewGridActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    ArrayList<Post> list;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    AdapterPostGrid adapterPostGrid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_recycler_view);

        generateData();
        init();
    }

    private void init() {
        button = findViewById(R.id.button);
        button.setOnClickListener(this);

        mRecyclerView = findViewById(R.id.recycler_view);
        mLayoutManager = new GridLayoutManager(this, 4);
        adapterPostGrid = new AdapterPostGrid(this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(adapterPostGrid);
        adapterPostGrid.setAdapterData(list);

    }

    private void generateData(){
         list= new ArrayList<>();
        Post post;

        post = new Post();
        post.setTitle("Title 1");
        post.setImage(R.drawable.ic_assessment_black_24dp);
        list.add(post);

        post = new Post();
        post.setTitle("Title 2");
        post.setImage(R.drawable.ic_backup_black_24dp);
        list.add(post);

        post = new Post();
        post.setTitle("Title 3");
        post.setImage(R.drawable.ic_assessment_black_24dp);
        list.add(post);

        post = new Post();
        post.setTitle("Title 4");
        post.setImage(R.drawable.ic_backup_black_24dp);
        list.add(post);
    }

    @Override
    public void onClick(View v) {
        generateData();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        adapterPostGrid.setAdapterData(list);

    }
}

package com.example.recyclerviewproject.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.recyclerviewproject.R;
import com.example.recyclerviewproject.adapters.AdapterUser;
import com.example.recyclerviewproject.models.User;

import java.util.ArrayList;

public class RecyclerViewLinearActivity extends AppCompatActivity {


    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    AdapterUser adapterUser;
    ArrayList<User> mList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_recycler_view);

        generateData();

        init();
    }

    private void init() {

        // Initializations
        mRecyclerView = findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        adapterUser = new AdapterUser(this, mList );

        // Set the values for adapter
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(adapterUser);
    }

    private void generateData(){
        mList = new ArrayList<>();
        User user;

        user = new User("Mark", "9999", "mark@gmail.com");
        mList.add(user);

        user = new User("Paul", "9999", "mark@gmail.com");
        mList.add(user);

        user = new User("Smith", "9999", "mark@gmail.com");
        mList.add(user);

        user = new User("Watson", "9999", "mark@gmail.com");
        mList.add(user);

    }
}

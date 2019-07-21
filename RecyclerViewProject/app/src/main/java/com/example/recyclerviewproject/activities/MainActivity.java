package com.example.recyclerviewproject.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.recyclerviewproject.R;
import com.example.recyclerviewproject.adapters.AdapterUser;
import com.example.recyclerviewproject.models.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonRecyclerLinearView, buttonRecyclerGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        buttonRecyclerLinearView = findViewById(R.id.button_recycler_linear);
        buttonRecyclerGridView = findViewById(R.id.button_recycler_grid);
        buttonRecyclerLinearView.setOnClickListener(this);
        buttonRecyclerGridView.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_recycler_linear:
                startActivity(new Intent(this, RecyclerViewLinearActivity.class));
                break;
            case R.id.button_recycler_grid:
                startActivity(new Intent(this, RecyclerViewGridActivity.class));
                break;
        }
    }
}

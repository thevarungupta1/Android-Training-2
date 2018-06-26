package com.thevarungupta.sqldatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button addButton, viewButton, updateButton, deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = findViewById(R.id.button_add);
        viewButton = findViewById(R.id.button_view);
        updateButton = findViewById(R.id.button_update);
        deleteButton = findViewById(R.id.button_delete);

        addButton.setOnClickListener(this);
        viewButton.setOnClickListener(this);
        updateButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_add:
                startActivity(new Intent(MainActivity.this, UserAddActivity.class));
                break;
            case R.id.button_view:
                startActivity(new Intent(MainActivity.this, UserAddActivity.class));
                break;
            case R.id.button_update:
                startActivity(new Intent(MainActivity.this, UserAddActivity.class));
                break;
            case R.id.button_delete:
                startActivity(new Intent(MainActivity.this, UserAddActivity.class));
                break;
        }
    }
}

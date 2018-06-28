package com.thevarungupta.sqlite;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button addButton;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper dbHelper = new DBHelper(this);
        ArrayList<User> user = dbHelper.showAllUsers();

        listView = findViewById(R.id.list_view);
        MyAdapter adapter = new MyAdapter(this,user);
        listView.setAdapter(adapter);

        addButton = findViewById(R.id.button_add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddItemActivity.class));
            }
        });
    }


    @Override
    public void onClick(View view) {

    }
}

package com.thevarungupta.httprequest.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.thevarungupta.httprequest.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_1:
                startActivity(new Intent(MainActivity.this, HttpUrlActivity.class));
                break;
            case R.id.button_2:
                startActivity(new Intent(MainActivity.this, VolleyActivity.class));
                break;
        }
    }
}

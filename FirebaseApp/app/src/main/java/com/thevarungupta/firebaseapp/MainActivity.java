package com.thevarungupta.firebaseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button registerButton, loginButton, saveButton, displayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerButton = findViewById(R.id.button_register);
        loginButton = findViewById(R.id.button_login);
        saveButton = findViewById(R.id.button_save);
        displayButton = findViewById(R.id.button_display);

        registerButton.setOnClickListener(this);
        loginButton.setOnClickListener(this);
        saveButton.setOnClickListener(this);
        displayButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_register:
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
                break;
            case R.id.button_login:
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                break;
            case R.id.button_save:
                startActivity(new Intent(MainActivity.this, SaveDataActivity.class));
                break;
            case R.id.button_display:
                startActivity(new Intent(MainActivity.this, DisplayDataActivity.class));
                break;
        }
    }
}

package com.thevarungupta.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonOne, buttonTwo, buttonThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOne = findViewById(R.id.button_1);
        buttonTwo = findViewById(R.id.button_2);
        buttonThree = findViewById(R.id.button_3);

        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
        buttonThree.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_1:
                
                break;
            case R.id.button_2:
                break;
            case R.id.button_3:
                break;
        }
    }


}

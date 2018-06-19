package com.thevarungupta.components;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    CheckBox cricketCheckBox, footballCheckBox, hockeyCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cricketCheckBox = findViewById(R.id.check_cricket);
        footballCheckBox = findViewById(R.id.check_football);
        hockeyCheckBox = findViewById(R.id.check_hockey);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        String message = null;

        switch (compoundButton.getId()) {
            case R.id.check_cricket:
                message = "Cricket is ";
                break;
            case R.id.check_football:
                message = "Football is ";
                break;
            case R.id.check_hockey:
                message = "Hockey is ";
                break;
        }

        message += b ? "Checked" : "Unchecked";

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

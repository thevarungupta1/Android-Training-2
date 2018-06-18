package com.thevarungupta.components;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CheckRadioActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener{

    CheckBox cricketCheckBox, footballCheckBox, hockeyCheckBox;
    RadioGroup cityRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        cricketCheckBox = findViewById(R.id.check_cricket);
        footballCheckBox = findViewById(R.id.check_football);
        hockeyCheckBox = findViewById(R.id.check_hockey);

        cityRadioGroup = findViewById(R.id.radio_group_city);
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

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i){
            case R.id.radio_button_delhi:
                Toast.makeText(this, "Delhi", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_button_mumbai:
                Toast.makeText(this, "Mumbai", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_button_punjab:
                Toast.makeText(this, "Punjab", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

package com.thevarungupta.radiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radio_group_city);
        radioGroup.setOnCheckedChangeListener(this);
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

package com.thevarungupta.loginapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton selectedRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final RadioGroup radioGroup = findViewById(R.id.radio_group);

        Button button = findViewById(R.id.button_register);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedRadio =  findViewById(radioGroup.getCheckedRadioButtonId());
                Toast.makeText(RegisterActivity.this, ""+selectedRadio.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

package com.thevarungupta.activitynavigation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button submitButton;
    EditText nameEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEdit = findViewById(R.id.edit_name);
        submitButton = findViewById(R.id.button_submit);
        submitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String name = nameEdit.getText().toString();
        Intent intent = new Intent(this, WelcomeActivity.class);
        intent.putExtra("NAME", name);
        startActivity(intent);
    }
}

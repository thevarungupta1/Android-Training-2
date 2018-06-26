package com.thevarungupta.sqldatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserAddActivity extends AppCompatActivity {

    EditText editName, editEmail, editPassword;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_add);

        editName = findViewById(R.id.edit_name);
        editEmail = findViewById(R.id.edit_email);
        editPassword = findViewById(R.id.edit_password);
        saveButton = findViewById(R.id.button_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}

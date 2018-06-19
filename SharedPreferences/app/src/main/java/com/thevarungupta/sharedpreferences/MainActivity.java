package com.thevarungupta.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String SHARED_PREF_NAME = "my_pref";
    private static final String KEY_NAME = "name";

    Button saveButton, showButton, deleteButton;
    EditText nameEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEdit = findViewById(R.id.edit_name);
        saveButton = findViewById(R.id.button_save);
        showButton = findViewById(R.id.button_show);
        deleteButton = findViewById(R.id.button_delete);

        saveButton.setOnClickListener(this);
        showButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_save:
                saveName();
                break;
            case R.id.button_show:
                displayName();
                break;
            case R.id.button_delete:
                deleteName();
                break;
        }
    }

    private void saveName() {
        String name = nameEdit.getText().toString();
        if (name.isEmpty()) {
            nameEdit.setError("Name required");
            nameEdit.requestFocus();
            return;
        }
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_NAME, name);
        editor.apply();
        nameEdit.setText("");
    }

    private void displayName() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String name = sharedPreferences.getString(KEY_NAME, null);
        if (name != null) {
            Toast.makeText(this, "Welcome "+name, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "No Name", Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteName(){
        // remove only key
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("KEY");
        editor.apply();

        // remove complete shared file
        editor.clear();
        editor.apply();
        Toast.makeText(this, "Delete Successfully", Toast.LENGTH_SHORT).show();
    }
}

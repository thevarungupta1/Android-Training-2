package com.thevarungupta.alertdialog;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String FILE_NAME = "myFile";
    private static final String KEY_NAME = "name";

    Button saveButton, showButton, deleteButton;
    EditText editName;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.edit_name);
        saveButton = findViewById(R.id.button_save);
        showButton = findViewById(R.id.button_show);
        deleteButton = findViewById(R.id.button_delete);

        saveButton.setOnClickListener(this);
        showButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_save:
                saveName();
                break;
            case R.id.button_show:
               showName();
                break;
            case R.id.button_delete:
                deleteName();
                break;
        }
    }

    private void saveName(){
        String name = editName.getText().toString();
        SharedPreferences sharedPreferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_NAME,name );
        editor.apply();

    }

    private void showName(){
        SharedPreferences sharedPreferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        String name = sharedPreferences.getString(KEY_NAME, null);
        Toast.makeText(this, "Name is "+name, Toast.LENGTH_SHORT).show();
    }

    private void deleteName(){
        SharedPreferences sharedPreferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();

        // remove entire file
        editor.clear();

        // remove only one key
        //editor.remove(KEY_NAME);

        editor.apply();
    }











}

package com.example.sqlitecrudoperation.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sqlitecrudoperation.R;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    Button buttonInsert, buttonUpdate, buttonDelete, buttonRead, buttonListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        buttonInsert = findViewById(R.id.button_insert);
        buttonUpdate = findViewById(R.id.button_update);
        buttonDelete = findViewById(R.id.button_delete);
        buttonRead = findViewById(R.id.button_read);
        buttonListView = findViewById(R.id.button_list);

        buttonInsert.setOnClickListener(this);
        buttonUpdate.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
        buttonRead.setOnClickListener(this);
        buttonListView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_insert:
                startActivity(new Intent(this, EmployeeInsertActivity.class));
                break;
            case R.id.button_update:
                startActivity(new Intent(this, EmployeeUpdateActivity.class));
                break;
            case R.id.button_delete:
                startActivity(new Intent(this, EmployeeDeleteActivity.class));
                break;
            case R.id.button_read:
                startActivity(new Intent(this, EmployeeReadActivity.class));
                break;
            case R.id.button_list:
                startActivity(new Intent(this, CustomListViewActivity.class));
                break;
        }
    }
}

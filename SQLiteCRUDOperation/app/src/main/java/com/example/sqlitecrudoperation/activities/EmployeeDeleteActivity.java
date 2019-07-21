package com.example.sqlitecrudoperation.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sqlitecrudoperation.R;
import com.example.sqlitecrudoperation.database.DbHelper;
import com.example.sqlitecrudoperation.model.Employee;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class EmployeeDeleteActivity extends AppCompatActivity {

    EditText editTextId;
    Button buttonDelete;
    Spinner spinnerId;

    DbHelper dbHelper;

    ArrayAdapter<Integer> adapter;
    ArrayList<Employee> list;
    ArrayList<Integer> spinnerData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_delete);

        dbHelper = new DbHelper(this);

        init();
    }

    private  void init(){
        // spinner
        spinnerId = findViewById(R.id.spinner_id);
        setAdapterData();



        buttonDelete = findViewById(R.id.button_delete);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = spinnerId.getSelectedItem().toString();
                delete(Integer.parseInt(id));
            }
        });
    }

    private void setAdapterData(){
        list = new ArrayList<>();
        spinnerData = new ArrayList<>();

        // data which I want to show in my spinner
        list = dbHelper.readAllEmployee();
        for(int i=0; i<list.size();i++){
            spinnerData.add(list.get(i).getId());
        }
        // create adapter for spinner
        adapter  = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerData);
        spinnerId.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void delete(int id){
        dbHelper.deleteEmployee(id);
        setAdapterData();
        Toast.makeText(this, "Employee delete successfully", Toast.LENGTH_SHORT).show();
    }
}

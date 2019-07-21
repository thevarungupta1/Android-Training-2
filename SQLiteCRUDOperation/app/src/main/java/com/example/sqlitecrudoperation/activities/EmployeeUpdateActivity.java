package com.example.sqlitecrudoperation.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlitecrudoperation.R;
import com.example.sqlitecrudoperation.database.DbHelper;
import com.example.sqlitecrudoperation.model.Employee;

public class EmployeeUpdateActivity extends AppCompatActivity {

    EditText editTextId, editTextName, editTextDepartment, editTextSalary;
    Button buttonUpdate;

    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_update);

        dbHelper = new DbHelper(this);

        init();
    }

    private  void init(){
        editTextId = findViewById(R.id.edit_text_id);
        editTextName = findViewById(R.id.edit_text_name);
        editTextDepartment = findViewById(R.id.edit_text_department);
        editTextSalary = findViewById(R.id.edit_text_salary);
        buttonUpdate = findViewById(R.id.button_update);
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Employee employee = new Employee();
                employee.setName(editTextName.getText().toString());
                employee.setDepartment(editTextDepartment.getText().toString());
                employee.setSalary(editTextSalary.getText().toString());
                employee.setId( Integer.parseInt(editTextId.getText().toString()));
                update(employee);
            }
        });
    }

    private void update(Employee employee){
        dbHelper.updateEmployee(employee);
        Toast.makeText(this, "Employee Update", Toast.LENGTH_SHORT).show();

    }
}

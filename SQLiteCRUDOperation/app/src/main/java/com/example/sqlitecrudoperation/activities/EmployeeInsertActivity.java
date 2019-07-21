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

public class EmployeeInsertActivity extends AppCompatActivity {

    EditText editTextName, editTextDepartment, editTextSalary;
    Button buttonInsert;

    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_insert);

        dbHelper = new DbHelper(this);

        init();


    }

    private void init(){
        editTextName = findViewById(R.id.edit_text_name);
        editTextDepartment = findViewById(R.id.edit_text_department);
        editTextSalary = findViewById(R.id.edit_text_salary);
        buttonInsert = findViewById(R.id.button_insert);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputName, inputDepartment, inputSalary;
                inputName = editTextName.getText().toString();
                inputDepartment = editTextDepartment.getText().toString();
                inputSalary = editTextSalary.getText().toString();

                Employee emp = new Employee();
                emp.setName(inputName);
                emp.setDepartment(inputDepartment);
                emp.setSalary(inputSalary);
                insert(emp);
            }
        });
    }

    private void insert(Employee employee){
        dbHelper.addEmployee(employee);
        Toast.makeText(this, "Employee Inserted Successfully", Toast.LENGTH_SHORT).show();
    }
}

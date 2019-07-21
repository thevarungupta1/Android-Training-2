package com.example.sqlitecrudoperation.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sqlitecrudoperation.R;
import com.example.sqlitecrudoperation.database.DbHelper;
import com.example.sqlitecrudoperation.model.Employee;

import java.util.ArrayList;

public class EmployeeReadActivity extends AppCompatActivity {

    TextView textViewReadData;

    DbHelper dbHelper;
    ArrayList<Employee> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_read);

        dbHelper = new DbHelper(this);

        init();
    }

    private  void init(){
        textViewReadData = findViewById(R.id.text_view);

        list =  dbHelper.readAllEmployee();
        String text = "";
        StringBuilder builder = new StringBuilder();

        for(int i=0;i<list.size(); i++){
            //Toast.makeText(this, "Employee Name: "+list.get(i).getName(), Toast.LENGTH_SHORT).show();
            //text += list.get(i).getName();
            builder.append( "Id: "+list.get(i).getId()+" ,Name: "+ list.get(i).getName() + "\n");
        }

        textViewReadData.setText(builder.toString());




    }
}

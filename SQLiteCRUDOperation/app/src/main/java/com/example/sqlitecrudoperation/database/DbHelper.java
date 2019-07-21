package com.example.sqlitecrudoperation.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import com.example.sqlitecrudoperation.model.Employee;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "employeedb";
    private static final int DATABASE_VERSION = 1;
    Context mContext;

    private static final String TABLE_NAME = "employee";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DEPARTMENT = "department";
    private static final String COLUMN_SALARY = "salary";

    SQLiteDatabase database;


    public DbHelper(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
        this.mContext = context;
        database = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME +" (" +
                COLUMN_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME +" VARCHAR, "+
                COLUMN_DEPARTMENT+" VARCHAR, "+
                COLUMN_SALARY +" VARCHAR) ";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TABLE = "DROP TABLE "+ TABLE_NAME;
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public void addEmployee(Employee employee){

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, employee.getName());
        values.put(COLUMN_DEPARTMENT, employee.getDepartment());
        values.put(COLUMN_SALARY, employee.getSalary());
        database.insert(TABLE_NAME, null, values);
    }

    public void updateEmployee(Employee employee){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, employee.getName());
        values.put(COLUMN_DEPARTMENT, employee.getDepartment());
        values.put(COLUMN_SALARY, employee.getSalary());
        database.update(TABLE_NAME, values, COLUMN_ID + "=?", new String[]{String.valueOf(employee.getId())} );
    }


    public ArrayList<Employee> readAllEmployee(){
        ArrayList<Employee> employeeList = new ArrayList<>();
        String [] columns = {COLUMN_ID, COLUMN_NAME, COLUMN_DEPARTMENT, COLUMN_SALARY};
         Cursor cursor = database.query(TABLE_NAME, columns, null,null, null, null, null, null);
         if(cursor !=null && cursor.moveToFirst()){
             do{
                 Employee employee = new Employee();
                 employee.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_ID))));
                 employee.setName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)));
                 employee.setDepartment(cursor.getString(cursor.getColumnIndex(COLUMN_DEPARTMENT)));
                 employee.setSalary(cursor.getString(cursor.getColumnIndex(COLUMN_SALARY)));
                 employeeList.add(employee);
             }
             while(cursor.moveToNext());
         }
         cursor.close();
         return employeeList;
    }

    /*
    * delete method return a integer value
    * 1 : mean data delete successfully
    * -1: mean not deleted
    * */
    public void deleteEmployee(int id){
        String whereClause = COLUMN_ID + "=?";
        String[] whereArgs = new String[]{String.valueOf(id)};
        database.delete(TABLE_NAME, whereClause, whereArgs);
    }





}

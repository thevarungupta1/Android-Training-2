package com.thevarungupta.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {


    SQLiteDatabase sqLiteDatabase;

    private static final String DATABASE_NAME = "demo";
    private static final int VERSION = 1;
    Context mContext;

    private static final String TABLE_NAME = "user";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.mContext = context;
        sqLiteDatabase = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER primary key autoincrement, " +
                COLUMN_NAME + " INTEGER, " +
                COLUMN_PHONE + " VARCHAR, " +
                COLUMN_EMAIL + " VARCHAR )";
        sqLiteDatabase.execSQL(query);
        Toast.makeText(mContext, "OnCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        mContext.deleteDatabase(DATABASE_NAME);
        onCreate(sqLiteDatabase);
        Toast.makeText(mContext, "onUpgrade", Toast.LENGTH_SHORT).show();
    }

    public void insertUser(User user) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID, user.getId());
        contentValues.put(COLUMN_NAME, user.getName());
        contentValues.put(COLUMN_EMAIL, user.getEmail());
        contentValues.put(COLUMN_PHONE, user.getPhone());

        long id = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        Toast.makeText(mContext, "Inserted " + id, Toast.LENGTH_SHORT).show();
    }

    public ArrayList<User> showAllUsers() {
        // String query = "select * from TABLE_NAME";
        ArrayList<User> list=new ArrayList<>();
        String[] columns = {COLUMN_ID, COLUMN_NAME, COLUMN_PHONE, COLUMN_EMAIL};
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                String phone = cursor.getString(cursor.getColumnIndex(COLUMN_PHONE));
                String email = cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL));
                User user = new User(id, name, phone,email);
                list.add(user);
            }while(cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    // Getting cart Count
    public int getUserCount() {
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        // return count
        return count;
    }

    public void updateStudent(String id, String name) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        sqLiteDatabase.update(TABLE_NAME, values, COLUMN_ID + "=?", new String[]{id});

        Toast.makeText(mContext, "Rows Updated " ,Toast.LENGTH_SHORT).show();
    }

    public void deleteUser(String id){
        String whereClause = COLUMN_ID +"=?";
        String[] whereArgs = new String[]{id};
        sqLiteDatabase.delete(TABLE_NAME, whereClause, whereArgs);
        Toast.makeText(mContext, "Rows Deleted", Toast.LENGTH_SHORT).show();
    }
    public void deleteAll() {
        String delete = "DELETE FROM " + TABLE_NAME;
        sqLiteDatabase.rawQuery(delete, null);
        sqLiteDatabase.delete(TABLE_NAME, null, null);
        Toast.makeText(mContext, "All row deleted", Toast.LENGTH_SHORT).show();
    }

    public boolean checkLogin(String email, String password){
        // array of columns to fetch
        String[] columns = {
                COLUMN_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_EMAIL + " = ?" + " AND " + COLUMN_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {email, password};

        // query user table with conditions

        Cursor cursor = db.query(TABLE_NAME, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }


}

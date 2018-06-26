package com.thevarungupta.sqldatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private SQLiteDatabase sqLiteDatabase = null;
    private Context context;

    private static final String DATABASE_NAME = "demo";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "user";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        sqLiteDatabase = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                KEY_ID + " INTEGER primary key autoincrement, " +
                KEY_NAME + " VARCHAR, " +
                KEY_EMAIL + " VARCHAR, " +
                KEY_PASSWORD + " VARCHAR )";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        context.deleteDatabase(TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void insertUser(String name, String  email, String password) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME,name );
        contentValues.put(KEY_EMAIL, email);
        contentValues.put(KEY_PASSWORD, password);
         sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
    }

    public User getNote(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME,
                new String[]{Note.COLUMN_ID, Note.COLUMN_NOTE, Note.COLUMN_TIMESTAMP},
                Note.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare note object
        Note note = new Note(
                cursor.getInt(cursor.getColumnIndex(Note.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(Note.COLUMN_NOTE)),
                cursor.getString(cursor.getColumnIndex(Note.COLUMN_TIMESTAMP)));

        // close the db connection
        cursor.close();

        return note;
    }

    public void deleteUser(String id){

    }

}

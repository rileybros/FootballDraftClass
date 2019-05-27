package com.example.footballdraftclass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    String TABLE_NAME;

    private static final String TAG         = "DatabaseHelper";

    private static final String COL1        = "ID";
    private static final String COL2        = "Name";
    private static final String COL3        = "School";
    private static final String COL4        = "Height";
    private static final String COL5        = "Weight";
    private static final String COL6        = "Class";


    public DatabaseHelper(Context context, String TABLE_NAME) {
        super(context, TABLE_NAME, null, 1);
        this.TABLE_NAME = TABLE_NAME;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println(TABLE_NAME);
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String item, String Column) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Column, item);

        Log.d(TAG, "addData: Adding " + item + "to " + TABLE_NAME + "Column " + Column);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String queryQB = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(queryQB, null);
        return data;
    }
}

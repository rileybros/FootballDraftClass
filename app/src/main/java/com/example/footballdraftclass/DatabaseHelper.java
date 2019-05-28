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
    private static final String COL3        = "Class";
    private static final String COL4        = "Height";
    private static final String COL5        = "Weight";
    private static final String COL6        = "School";


    public DatabaseHelper(Context context, String TABLE_NAME) {
        super(context, TABLE_NAME, null, 1);
        this.TABLE_NAME = TABLE_NAME;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println(TABLE_NAME);
        if (TABLE_NAME.equals("Quarterbacks")) {
            String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL2 + " TEXT, " + COL3 + " TEXT, " + COL4 + " TEXT, " + COL5 + " INTEGER)";
            db.execSQL(createTable);
        }
        if (TABLE_NAME.equals("RunningBacks")){
            String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL2 + " TEXT, " + COL3 + " TEXT)";
            db.execSQL(createTable);
        }
        else{

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String name, String c, String h, double w) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, name);
        contentValues.put(COL3, c);
        contentValues.put(COL4, h);
        contentValues.put(COL5, w);

        Log.d(TAG, "addData: Adding " + name + " to " + TABLE_NAME + " Column " + COL2 + " and " + c + " to " + COL3 + " and " + h + " to " + COL4
                + " and " + w + " to " + COL5);

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
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getItem(String name, String COL) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL + " FROM " + TABLE_NAME + " WHERE " + COL2 + " = '" +
                name + "'";
        Log.d(TAG, query);
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public void updateName(String newName, int id, String oldName){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL2 + " = '" + newName + "' WHERE " + COL1 +
                " = '" + id + "'" + " AND " + COL2 + " = '" + oldName + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting name to " + newName);
        db.execSQL(query);
    }

    public void deletePlayer(int id, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE " + COL1 + " = '" + id + "'" + " AND " +
                COL2 + " = '" + name + "'";
        Log.d(TAG, "deletePlayer: query: " + query);
        Log.d(TAG, "deletePlayer: Deleting " + name + " from database.");
        db.execSQL(query);
    }
}

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

    //QB ratings
    private static final String QB1         = "Speed";
    private static final String QB2         = "Acceleration";
    private static final String QB3         = "Agility";
    private static final String QB4         = "Awareness";
    private static final String QB5         = "ThrowPower";
    private static final String QB6         = "ThrowAccuracy";
    private static final String QB7         = "BreakTackle";
    private static final String QB8         = "Elusiveness";
    private static final String QB9         = "Trucking";
    private static final String QB10        = "Carrying";
    private static final String QB11        = "Stamina";
    private static final String QB12        = "Injury";


    public DatabaseHelper(Context context, String TABLE_NAME) {
        super(context, TABLE_NAME, null, 1);
        this.TABLE_NAME = TABLE_NAME;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQB = "CREATE TABLE " + "Quarterbacks " + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 + " TEXT, " + COL3 + " TEXT, " + COL4 + " TEXT, " + COL5 + " INTEGER, " +
                QB1 + " INTEGER, " + QB2 + " INTEGER, " + QB3 + " INTEGER, " + QB4 + " INTEGER, " +
                QB5 + " INTEGER, " + QB6 + " INTEGER, " + QB7 + " INTEGER, " + QB8 + " INTEGER, " +
                QB9 + " INTEGER, " + QB10 + " INTEGER, " + QB11 + " INTEGER, " + QB12 + " INTEGER)";

        String createTableRB = "CREATE TABLE " + "RunningBacks " + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 + " TEXT, " + COL3 + " TEXT, " + COL4 + " TEXT, " + COL5 + " INTEGER)";

        String createTableFB = "CREATE TABLE " + "FullBacks " + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 + " TEXT, " + COL3 + " TEXT, " + COL4 + " TEXT, " + COL5 + " INTEGER)";

        db.execSQL(createTableQB);
        db.execSQL(createTableRB);
        db.execSQL(createTableFB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addDataQB(String name, String c, String h, double w, double sp, double acc, double agil, double awa, double thp, double tha, double
                             btk, double elu, double tru, double car, double sta, double inj) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, name);
        contentValues.put(COL3, c);
        contentValues.put(COL4, h);
        contentValues.put(COL5, w);
        contentValues.put(QB1, sp);
        contentValues.put(QB2, acc);
        contentValues.put(QB3, agil);
        contentValues.put(QB4, awa);
        contentValues.put(QB5, thp);
        contentValues.put(QB6, tha);
        contentValues.put(QB7, btk);
        contentValues.put(QB8, elu);
        contentValues.put(QB9, tru);
        contentValues.put(QB10, car);
        contentValues.put(QB11, sta);
        contentValues.put(QB12, inj);

        Log.d(TAG, "addData: Adding all data to Quarterback database");

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean addDataRB(String Name, String Class, String Height, double Weight) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, Name);
        contentValues.put(COL3, Class);
        contentValues.put(COL4, Height);
        contentValues.put(COL5, Weight);

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

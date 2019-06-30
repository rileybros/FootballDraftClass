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

    private static final String OL1         = "Offensive Line Position";

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

    String createTableQB = "CREATE TABLE " + "Quarterbacks " + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL2 + " TEXT, " + COL3 + " TEXT, " + COL4 + " TEXT, " + COL5 + " INTEGER, " + "College" + " TEXT, " +
            "ProjectedRound" + " TEXT, "   + QB1 + " INTEGER, " + QB2 + " INTEGER, " + QB3 + " INTEGER, " + QB4 + " INTEGER, "
            + QB5 + " INTEGER, " + QB6 + " INTEGER, " + QB7 + " INTEGER, " + QB8 + " INTEGER, " + QB9 + " INTEGER, " +
            QB10 + " INTEGER, " + QB11 + " INTEGER, " + QB12 + " INTEGER)";

    String createProTableQB = "CREATE TABLE" + "ProQuarterbacks" + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL2 + " TEXT, " + COL3 + " TEXT, " + COL4 + " TEXT, " + COL5 + " INTEGER, " + "BestOverall" + " INTEGER, " + "College" + " TEXT, "
            + "ProDevelopment" + " TEXT, " + "Age" + " TEXT, " + QB1 + " INTEGER, " + QB2 + " INTEGER, " + QB3 + " INTEGER, " + "Strength" +
            " INTEGER, " + QB4 + " INTEGER, " + QB10 + " INTEGER, " + QB5 + " INTEGER, " + "ShortThrowAcc" + " INTEGER, " + "MediumThrowAcc"
            + " INTEGER, " + "DeepThrowAcc" + " INTEGER, " + QB12 + " INTEGER, " + QB9 + " INTEGER, " + "ThrowOnRun" + " INTEGER, " +
            "ThrowUnderPressure" + " INTEGER, " + "PlayAction" + " INTEGER, " + "BreakSack" + " INTEGER, " + "ProBCV" + " INTEGER, " +
            "ProBreakTack" + " INTEGER, " + "ProCatching" + " INTEGER, " + "ProElusive" + " INTEGER, " + "ProHitPower" + " INTEGER, " +
            "ProJuke" + " INTEGER, " + "ProSpC" + " INTEGER, " + "ProJumping" + " INTEGER, " + "ProPursuit" + " INTEGER, " + "ProSpin" + " INTEGER, "
            + "ProStiff" + " INTEGER, " + "ProTackle" + " INTEGER, " + "ProTough" + " INTEGER)";

    String createTableRB = "CREATE TABLE " + "RunningBacks " + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL2 + " TEXT, " + COL3 + " TEXT, " + COL4 + " TEXT, " + COL5 + " INTEGER," + "Speed" +
            " INTEGER, " +  "Acceleration" + " INTEGER, " +  "Agility" + " INTEGER, " + "Awareness" +
            " INTEGER, " +  "BreakTackle" + " INTEGER, " + "Elusiveness" + " INTEGER, " + "Trucking" +
            " INTEGER, " + "Carrying" + " INTEGER, " +  "Stamina" + " INTEGER, " + "Injury" + " INTEGER)";

    String createTableFB = "CREATE TABLE " + "FullBacks " + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL2 + " TEXT, " + COL3 + " TEXT, " + COL4 + " TEXT, " + COL5 + " INTEGER)";

    String createTableWR = "CREATE TABLE " + "WideReceivers " + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL2 + " TEXT, " + COL3 + " TEXT, " + COL4 + " TEXT, " + COL5 + " INTEGER)";

    String createTableTE = "CREATE TABLE " + "TightEnds " + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL2 + " TEXT, " + COL3 + " TEXT, " + COL4 + " TEXT, " + COL5 + " INTEGER)";

    String createTableOL = "CREATE TABLE " + "OffensiveLine " + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL2 + " TEXT, " + COL3 + " TEXT, " + COL4 + " TEXT, " + COL5 + " INTEGER, " + "Position" + " TEXT)";

    public DatabaseHelper(Context context, String TABLE_NAME) {
        super(context, TABLE_NAME, null, 1);
        this.TABLE_NAME = TABLE_NAME;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTableQB);
        db.execSQL(createTableRB);
        db.execSQL(createTableFB);
        db.execSQL(createProTableQB);
        //db.execSQL(createTableOL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addDataQB(Quarterback q) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, q.FullName);
        contentValues.put(COL3, q.Class);
        contentValues.put(COL4, q.Height);
        contentValues.put(COL5, q.Weight);
        contentValues.put("BestOverall", q.BestOverall);
        contentValues.put("College", q.college);
        contentValues.put("ProjectedRound", q.round);
        contentValues.put(QB1, q.Speed);
        contentValues.put(QB2, q.Accel);
        contentValues.put(QB3, q.Agile);
        contentValues.put(QB4, q.Aware);
        contentValues.put(QB5, q.NCAATHP);
        contentValues.put(QB6, q.NCAATHA);
        contentValues.put(QB7, q.BreakTack);
        contentValues.put(QB8, q.Elusive);
        contentValues.put(QB9, q.Trucking);
        contentValues.put(QB10, q.Carry);
        contentValues.put(QB11, q.Stamina);
        contentValues.put(QB12, q.Injury);

        Log.d(TAG, "addData: Adding all data to Quarterback database");

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean addDataProQB(Quarterback q) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, q.FullName);
        contentValues.put(COL3, q.Class);
        contentValues.put(COL4, q.Height);
        contentValues.put(COL5, q.Weight);
        contentValues.put(QB1, q.ProSpeed);
        contentValues.put(QB2, q.ProAccel);
        contentValues.put(QB3, q.ProAgile);
        contentValues.put(QB4, q.ProAware);
        contentValues.put(QB5, q.ProTHP);
        contentValues.put("ShortThrowAcc", q.STA);
        contentValues.put("MediumThrowAcc", q.MTA);
        contentValues.put("DeepThrowAcc", q.DTA);
        contentValues.put(QB7, q.ProBreakTack);
        contentValues.put(QB8, q.ProElusive);
        contentValues.put(QB9, q.ProTruck);
        contentValues.put(QB10, q.ProCarry);
        contentValues.put(QB11, q.ProStamina);
        contentValues.put(QB12, q.ProInjury);
        contentValues.put("ProDevelopment", q.ProDevelop);
        contentValues.put("Strength", q.ProStrength);
        contentValues.put("ThrowOnRun", q.TOR);
        contentValues.put("ThrowUnderPressure", q.TUP);
        contentValues.put("PlayAction", q.PAC);
        contentValues.put("BreakSack", q.BSK);
        contentValues.put("ProBCV", q.ProBCV);
        contentValues.put("ProCatching", q.ProCatching);
        contentValues.put("ProElusive", q.ProElusive);
        contentValues.put("ProHitPower", q.ProPOW);
        contentValues.put("ProJuke", q.ProJuke);
        contentValues.put("ProSpC", q.ProSpC);
        contentValues.put("ProJumping", q.ProJumping);
        contentValues.put("ProPursuit", q.ProPursuit);
        contentValues.put("ProSpin", q.ProSpin);
        contentValues.put("ProStiff", q.ProStiff);
        contentValues.put("ProTackle", q.ProTackle);
        contentValues.put("ProTough", q.ProTough);
        contentValues.put("Age", q.Age);
        contentValues.put("BestOverall", q.BestOverall);

        Log.d(TAG, "addData: Adding all data to Quarterback database");

        long result = db.insert("ProQuarterbacks", null, contentValues);

        if (result == -1){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean addDataRB(String Name, String Class, String Height, double Weight, double sp, double acc, double agil, double awa, double btk,
                             double elu, double tru, double car, double sta, double inj) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, Name);
        contentValues.put(COL3, Class);
        contentValues.put(COL4, Height);
        contentValues.put(COL5, Weight);
        contentValues.put("Speed", sp);
        contentValues.put("Acceleration", acc);
        contentValues.put("Agility", agil);
        contentValues.put("Awareness", awa);
        contentValues.put("BreakTackle", btk);
        contentValues.put("Elusiveness", elu);
        contentValues.put("Trucking", tru);
        contentValues.put("Carrying", car);
        contentValues.put("Stamina", sta);
        contentValues.put("Injury", inj);

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
        String query = "SELECT " + COL + COL3 + " FROM " + TABLE_NAME + " WHERE " + COL2 + " = '" +
                name + "'";
        Log.d(TAG, query);
        Cursor data = db.rawQuery(query, null);
        System.out.println(data);
        return data;
    }

    public Cursor getPlayer(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL2 + " = '" + name + "'";
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

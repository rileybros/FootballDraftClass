package com.example.footballdraftclass;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CreateDraft extends AppCompatActivity {

    private static final String TAG = "Create Draft";
    private String Database;

    DatabaseHelper mDBHelper;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_draft);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar != null) {

        }

        Intent receivedIntent = getIntent();
        Database = receivedIntent.getStringExtra("Database");

        listView = (ListView) findViewById(R.id.listview);
        mDBHelper = new DatabaseHelper(this, Database);
        
        populatelistview();
    }

    private void populatelistview() {
        Log.d(TAG, "populatelistview: Displaying data in listview ");
        Log.d(TAG, "opening: opening " + Database + " database!");

        Cursor data = mDBHelper.getData();
        ArrayList<String> listArray = new ArrayList<>();
        while(data.moveToNext()){
            listArray.add(data.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listArray);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = adapterView.getItemAtPosition(i).toString();
                Log.d(TAG, "onItemClick: You Clicked on " + name);

                Cursor data = mDBHelper.getPlayer(name);
                int itemID = -1;
                String Class = " Bad Man ";
                String Weight = " ";
                String Height = " ";
                String College = " ";
                String ProjRound = " ";
                String speed = " ";
                String accel = " ";
                String agile = " ";
                String aware = " ";
                String thp = " ";
                String tha = " ";
                String btk = " ";
                String elu = " ";
                String truck = " ";
                String car = " ";
                String sta = " ";
                String inj = " ";
                while (data.moveToNext())
                {
                    itemID = data.getInt(0);
                    Class = data.getString(2);
                    Weight = data.getString(4);
                    Height = data.getString(3);
                    College = data.getString(5);
                    ProjRound = data.getString(6);
                    speed = Double.toString(data.getDouble(7));
                    accel = Double.toString(data.getDouble(8));
                    agile = Double.toString(data.getDouble(9));
                    aware = Double.toString(data.getDouble(10));
                    thp = Double.toString(data.getDouble(11));
                    tha = Double.toString(data.getDouble(12));
                    btk = Double.toString(data.getDouble(13));
                    elu = Double.toString(data.getDouble(14));
                    truck = Double.toString(data.getDouble(15));
                    car = Double.toString(data.getDouble(16));
                    sta = Double.toString(data.getDouble(17));
                    inj = Double.toString(data.getDouble(18));

                }
                if (itemID > -1) {
                    Log.d(TAG, "onItemClick: The ID is " + itemID);
                    Intent next = new Intent(getApplicationContext(), EditPlayer.class);
                    next.putExtra("id", itemID);
                    next.putExtra("name", name);
                    next.putExtra("class", Class);
                    next.putExtra("weight", Weight);
                    next.putExtra("height", Height);
                    next.putExtra("college", College);
                    next.putExtra("project", ProjRound);
                    next.putExtra("speed", speed);
                    next.putExtra("acceleration", accel);
                    next.putExtra("agile", agile);
                    next.putExtra("aware", aware);
                    next.putExtra("thp", thp);
                    next.putExtra("tha", tha);
                    next.putExtra("btk", btk);
                    next.putExtra("elu", elu);
                    next.putExtra("car", car);
                    next.putExtra("truck", truck);
                    next.putExtra("sta", sta);
                    next.putExtra("inj", inj);
                    next.putExtra("Database", Database);
                    startActivity(next);
                    finish();
                }
                else {
                    toastMessage("No ID is associated with this Name");
                }
            }
        });
    }
    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

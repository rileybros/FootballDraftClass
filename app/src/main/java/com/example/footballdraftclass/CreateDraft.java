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
        Log.d(TAG, "opening: opeing " + Database + " database!");

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

                Cursor data = mDBHelper.getItemID(name);
                int itemID = -1;
                while (data.moveToNext())
                {
                    itemID = data.getInt(0);
                }
                if (itemID > -1) {
                    Log.d(TAG, "onItemClick: The ID is " + itemID);
                    Intent next = new Intent(getApplicationContext(), EditPlayer.class);
                    next.putExtra("id", itemID);
                    next.putExtra("name", name);
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

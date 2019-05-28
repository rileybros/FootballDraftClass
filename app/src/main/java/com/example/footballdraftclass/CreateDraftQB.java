package com.example.footballdraftclass;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CreateDraftQB extends AppCompatActivity {

    private static final String TAG = "Create Draft";

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

        listView = (ListView) findViewById(R.id.listview);
        mDBHelper = new DatabaseHelper(this, "Quarterbacks");
        
        populatelistview();
    }

    private void populatelistview() {
        Log.d(TAG, "populatelistview: Displaying data in listview ");

        Cursor data = mDBHelper.getData();
        ArrayList<String> listarray = new ArrayList<>();
        while(data.moveToNext()){
            listarray.add(data.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listarray);
        listView.setAdapter(adapter);
    }
}

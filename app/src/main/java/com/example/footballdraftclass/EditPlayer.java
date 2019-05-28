package com.example.footballdraftclass;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class EditPlayer extends AppCompatActivity {

    private static final String TAG = "EditPlayer";

    private Button save, delete;
    private EditText name;

    DatabaseHelper mDBhelper;

    private String insertedname;
    private int playerid;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_player);
        save = (Button) findViewById(R.id.Save);
        delete = (Button) findViewById(R.id.Delete);
        name = (EditText) findViewById(R.id.FullNameEdit);
        mDBhelper = new DatabaseHelper(this, "Quarterbacks");
    }
}

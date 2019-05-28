package com.example.footballdraftclass;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EditPlayer extends AppCompatActivity {

    private static final String TAG = "EditPlayer";

    private Button save, delete;
    private EditText name;

    DatabaseHelper mDBhelper;

    private String insertedname;
    private String Database;
    private int playerid;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_player);
        makeSpinners();
        save = (Button) findViewById(R.id.Save);
        delete = (Button) findViewById(R.id.Delete);
        name = (EditText) findViewById(R.id.FullNameEdit);

        Intent receivedIntent = getIntent();
        insertedname = receivedIntent.getStringExtra("name");
        playerid = receivedIntent.getIntExtra("id", -1);
        Database = receivedIntent.getStringExtra("Database");


        mDBhelper = new DatabaseHelper(this, Database);

        name.setText(insertedname);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String item = name.getText().toString();
                if(!item.equals("")){
                    mDBhelper.updateName(item, playerid, insertedname);
                    finish();
                }else {
                    toastMessage("You must enter Player's name!");
                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDBhelper.deletePlayer(playerid, insertedname);
                name.setText(" ");
                toastMessage("Player deleted from database");
                finish();
            }
        });
    }
    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void makeSpinners() {
        Spinner spinner = findViewById(R.id.ClassYear);
        Spinner spinner1 = findViewById(R.id.Height);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.year_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.heights, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner1.setAdapter(adapter1);
    }
}

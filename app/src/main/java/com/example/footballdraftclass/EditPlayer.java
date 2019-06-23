package com.example.footballdraftclass;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EditPlayer extends AppCompatActivity {

    private static final String TAG = "EditPlayer";

    private Button save, delete;
    private EditText name, Wei, coll, sp, acc, ag, aw, THP, THA, BTK, ELU,CAR, tru, STA, INJ;

    DatabaseHelper mDBhelper;

    private String insertedname;
    private String Database;
    private String cla, weight, height, college, projectR, speed, accel, agile, aware;
    private String thp, tha, btk, elu, car, truck, sta, inj;
    private int playerid;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_player);
        ReceivedIntent();
        makeSpinners();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar != null) {

        }

        identifyViews();

        mDBhelper = new DatabaseHelper(this, Database);

        name.setText(insertedname);
        Wei.setText(weight);
        coll.setText(college);
        sp.setText(speed);
        acc.setText(accel);
        ag.setText(agile);
        aw.setText(aware);
        THP.setText(thp);
        THA.setText(tha);
        BTK.setText(btk);
        ELU.setText(elu);
        CAR.setText(car);
        tru.setText(truck);
        STA.setText(sta);
        INJ.setText(inj);

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

    private void identifyViews() {
        save = (Button) findViewById(R.id.Save);
        delete = (Button) findViewById(R.id.Delete);
        name = (EditText) findViewById(R.id.FullNameEdit);
        Wei = (EditText) findViewById(R.id.Weight);
        coll = (EditText) findViewById(R.id.School);
        sp = (EditText) findViewById(R.id.Speed);
        acc = (EditText) findViewById(R.id.Accel);
        ag = (EditText) findViewById(R.id.Agile);
        aw = (EditText) findViewById(R.id.Aware);
        THP = (EditText) findViewById(R.id.TP);
        THA = (EditText) findViewById(R.id.TA);
        BTK = (EditText) findViewById(R.id.BTK);
        ELU = (EditText) findViewById(R.id.Elusive);
        CAR = (EditText) findViewById(R.id.Carry);
        tru = (EditText) findViewById(R.id.TRK);
        STA = (EditText) findViewById(R.id.Stamina);
        INJ = (EditText) findViewById(R.id.Injury);
    }

    private void ReceivedIntent() {
        Intent receivedIntent = getIntent();
        cla = receivedIntent.getStringExtra("class");
        insertedname = receivedIntent.getStringExtra("name");
        playerid = receivedIntent.getIntExtra("id", -1);
        weight = receivedIntent.getStringExtra("weight");
        height = receivedIntent.getStringExtra("height");
        college = receivedIntent.getStringExtra("college");
        projectR = receivedIntent.getStringExtra("project");
        speed = receivedIntent.getStringExtra("speed");
        accel = receivedIntent.getStringExtra("acceleration");
        agile = receivedIntent.getStringExtra("agile");
        aware = receivedIntent.getStringExtra("aware");
        thp = receivedIntent.getStringExtra("thp");
        tha = receivedIntent.getStringExtra("tha");
        btk = receivedIntent.getStringExtra("btk");
        elu = receivedIntent.getStringExtra("elu");
        car = receivedIntent.getStringExtra("car");
        truck =receivedIntent.getStringExtra("truck");
        sta = receivedIntent.getStringExtra("sta");
        inj = receivedIntent.getStringExtra("inj");


        Database = receivedIntent.getStringExtra("Database");
    }

    public void makeSpinners() {
        String comparevalue1 = cla;
        String comparevalue2 = height;
        String comparevalue3 = projectR;
        Spinner spinner = findViewById(R.id.ClassYear);
        Spinner spinner1 = findViewById(R.id.Height);
        Spinner spinner2 = findViewById(R.id.ProjRound);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.year_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.heights, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.projRound, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        if (comparevalue1 != null) {
            int spinnerPosition = adapter.getPosition(comparevalue1);
            spinner.setSelection(spinnerPosition);
        }
        spinner1.setAdapter(adapter1);
        if (comparevalue2 != null) {
            int spinnerPosition = adapter1.getPosition(comparevalue2);
            spinner1.setSelection(spinnerPosition);
        }
        spinner2.setAdapter(adapter2);
        if (comparevalue3 != null) {
            int spinnerPosition = adapter2.getPosition(comparevalue3);
            spinner2.setSelection(spinnerPosition);
        }
    }
}

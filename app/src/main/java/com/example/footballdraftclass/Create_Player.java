package com.example.footballdraftclass;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Create_Player extends AppCompatActivity {

    private RadioGroup rdgroup1;    private RadioButton QB;     private RadioButton TE;
    private RadioGroup rdgroup2;    private RadioButton RB;     private RadioButton OL;
    private RadioGroup rdgroup3;    private RadioButton WR;     private RadioButton DL;
    private RadioGroup rdgroup4;    private RadioButton FB;     private RadioButton LB;
                                    private RadioButton CB;     private RadioButton FS;
                                    private RadioButton SS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__player);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar != null) {

        }

        rdgroup1 = findViewById(R.id.positionsgroup1);
        rdgroup2 = findViewById(R.id.positionsgroup2);
        rdgroup3 = findViewById(R.id.positionsgroup3);
        rdgroup4 = findViewById(R.id.positionsgroup4);
        QB = findViewById(R.id.QB);
        RB = findViewById(R.id.RB);
        WR = findViewById(R.id.WR);
        FB = findViewById(R.id.FB);
        CB = findViewById(R.id.CB);
        SS = findViewById(R.id.SS);
        TE = findViewById(R.id.TE);
        OL = findViewById(R.id.OL);
        DL = findViewById(R.id.DL);
        LB = findViewById(R.id.LB);
        FS = findViewById(R.id.FS);
    }

    public void Group1Click(View view) {
        rdgroup2.clearCheck();
        rdgroup3.clearCheck();
        rdgroup4.clearCheck();
    }

    public void Group2Click(View view) {
        rdgroup1.clearCheck();
        rdgroup3.clearCheck();
        rdgroup4.clearCheck();
    }

    public void Group3Click(View view) {
        rdgroup1.clearCheck();
        rdgroup2.clearCheck();
        rdgroup4.clearCheck();
    }

    public void Group4Click(View view) {
        rdgroup1.clearCheck();
        rdgroup2.clearCheck();
        rdgroup3.clearCheck();
    }

    private void helpme() {
        new AlertDialog.Builder(this)
                .setMessage("Position not selected. Please choose a position to create.").
                setPositiveButton(
                        "OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }
                ).
                create().
                show();
    }

    private void displayFunctionNotAvailable() {
        new AlertDialog.Builder(this)
                .setMessage("Player functionality not available at this time. Please choose a different position.").
                setPositiveButton(
                        "OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }
                ).
                create().
                show();
    }


    public void onClickPlayerAttributes(View view) {
        if (QB.isChecked()){
            startActivity(new Intent(getApplicationContext(), Quarterback.class));
            finish();
        }
        else if (RB.isChecked()){
            displayFunctionNotAvailable();
        }
        else if (WR.isChecked()){
            displayFunctionNotAvailable();
        }
        else if (FB.isChecked()){
            displayFunctionNotAvailable();
        }
        else if (TE.isChecked()){
            displayFunctionNotAvailable();
        }
        else if (OL.isChecked()){
            displayFunctionNotAvailable();
        }
        else if (DL.isChecked()){
            displayFunctionNotAvailable();
        }
        else if (LB.isChecked()){
            displayFunctionNotAvailable();
        }
        else if (CB.isChecked()){
            displayFunctionNotAvailable();
        }
        else if (FS.isChecked()){
            displayFunctionNotAvailable();
        }
        else if (SS.isChecked()){
            displayFunctionNotAvailable();
        }
        else{
            helpme();
        }
    }
}

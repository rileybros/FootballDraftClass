package com.example.footballdraftclass;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Create_Player extends AppCompatActivity {

    private RadioGroup rdgroup1;
    private RadioGroup rdgroup2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__player);

        rdgroup1 = findViewById(R.id.positionsgroup1);
        rdgroup2 = findViewById(R.id.positionsgroup2);

    }

    public void Group1Click(View view) {
        helpme();
        rdgroup2.clearCheck();
    }

    public void Group2Click(View view) {
        rdgroup1.clearCheck();
    }

    private void helpme() {
        new AlertDialog.Builder(this)
                .setMessage("Help me").
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
}

package com.example.footballdraftclass;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar != null) {

        }
    }

    public void CreatePlayerOnClick(View view) {
        Intent newIntent = (new Intent(getApplicationContext(), Create_Player.class));
        startActivity(newIntent);
    }

    public void CreateCurrentDraftOnClick(View view){
        startActivity(new Intent(getApplicationContext(), PlayerDraft.class));
    }

    private void displayFunctionNotAvailable() {
        new AlertDialog.Builder(this)
            .setMessage("Functionality not available at this time.").
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

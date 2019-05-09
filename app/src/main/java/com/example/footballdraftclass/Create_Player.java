package com.example.footballdraftclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class Create_Player extends AppCompatActivity {

    private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__player);


    }

    public void onRadioButtonClick(View view) {

        switch (view.getId()) {
            case R.id.QB:

        }
    }
}

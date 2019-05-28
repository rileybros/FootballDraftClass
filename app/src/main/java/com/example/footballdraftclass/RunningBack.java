package com.example.footballdraftclass;


import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.apache.commons.lang3.StringUtils;


public class RunningBack extends AppCompatActivity {

    int speedInt, accelInt, agileInt, awareInt;
    int BTKInt, ELUInt, TRKInt, CARInt, STAInt, InjInt;

    DatabaseHelper mDBhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rb);
        Toolbar toolbar = findViewById(R.id.toolbar);
        mDBhelper = new DatabaseHelper(this, "RunningBacks");
        setSupportActionBar(toolbar);
        makeSpinners();

        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar != null) {

        }


    }

    public class RunningBackPlayer extends Offense {



        //Base Ratings
        double  NCAATHP;
        double  NCAATHA;

        public RunningBackPlayer() {
            Position = "Running Back";

            update();
        }

        public void update() {
            this.FullName   = getFirstName().getText().toString() + " " + getLastName().getText().toString();
            this.Class      = getYearClass();
            this.height     = getHeight();
            this.Speed      = getSpeedInt();
            this.Accel      = getAccelInt();
            this.Agile      = getAgileInt();
            this.Aware      = getAwareInt();
            this.BreakTack  = getBTKInt();
            this.Elusive    = getELUInt();
            this.Trucking   = getTRKInt();
            this.Carry      = getCARInt();
            this.Stamina    = getSTAInt();
            this.Injury     = getInjInt();
        }
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

    public double getSpeedInt() {
        String speed = this.getSpeed().getText().toString();
        speedInt = Integer.parseInt(speed);
        return(speedInt);
    }
    public double getAccelInt() {
        String accel = this.getAcceleration().getText().toString();
        accelInt = Integer.parseInt(accel);
        return(accelInt);
    }
    public double getAgileInt() {
        String agile = this.getAgility().getText().toString();
        agileInt = Integer.parseInt(agile);
        return(agileInt);
    }
    public double getAwareInt() {
        String aware = this.getAwareness().getText().toString();
        awareInt = Integer.parseInt(aware);
        return (awareInt);
    }
    public double getBTKInt() {
        String BTK = this.getBreakTackle().getText().toString();
        BTKInt = Integer.parseInt(BTK);
        return(BTKInt);
    }
    public double getELUInt() {
        String ELU = this.getElusiveness().getText().toString();
        ELUInt = Integer.parseInt(ELU);
        return (ELUInt);
    }
    public double getTRKInt() {
        String Truck = this.getTrucking().getText().toString();
        TRKInt = Integer.parseInt(Truck);
        return TRKInt;
    }
    public double getCARInt() {
        String CAR = this.getCarrying().getText().toString();
        CARInt = Integer.parseInt(CAR);
        return (CARInt);
    }
    public double getSTAInt() {
        String STA = this.getStamina().getText().toString();
        STAInt = Integer.parseInt(STA);
        return STAInt;
    }
    public double getInjInt() {
        String Inj = this.getInjury().getText().toString();
        InjInt = Integer.parseInt(Inj);
        return InjInt;
    }

    public void RunningBackErrorCheck(View view) {
        if (StringUtils.isEmpty(this.getFirstName().getText().toString())) {
            new AlertDialog.Builder(this)
                    .setMessage("Please Enter Player's First Name")
                    .create()
                    .show();
            this.getFirstName().requestFocus();

            return;
        }
        if (StringUtils.isEmpty(this.getLastName().getText().toString())) {
            new AlertDialog.Builder(this)
                    .setMessage("Please Enter Player's Last Name")
                    .create()
                    .show();
            this.getLastName().requestFocus();

            return;
        }
        if (getYearClass().equals("Choose Class")){
            new AlertDialog.Builder(this)
                    .setMessage("Please Select Player's Class")
                    .create()
                    .show();

            return;
        }
        if (getHeight().equals("Choose Height")){
            new AlertDialog.Builder(this)
                    .setMessage("Please Select Player's Height")
                    .create()
                    .show();

            return;
        }
        if (StringUtils.isEmpty(this.getWeight().getText().toString())) {
            new AlertDialog.Builder(this)
                    .setMessage("Please Enter Player's Weight")
                    .create()
                    .show();
            this.getWeight().requestFocus();

            return;
        }
        if (StringUtils.isEmpty(this.getSpeed().getText().toString())) {
            new AlertDialog.Builder(this)
                    .setMessage("Please Enter Player's Speed rating")
                    .create()
                    .show();
            this.getSpeed().requestFocus();

            return;
        }
        if (StringUtils.isEmpty(this.getAcceleration().getText().toString())) {
            new AlertDialog.Builder(this)
                    .setMessage("Please Enter Player's Acceleration rating")
                    .create()
                    .show();
            this.getAcceleration().requestFocus();

            return;
        }
        if (StringUtils.isEmpty(this.getAgility().getText().toString())) {
            new AlertDialog.Builder(this)
                    .setMessage("Please Enter Player's Agility rating")
                    .create()
                    .show();
            this.getAgility().requestFocus();

            return;
        }
        if (StringUtils.isEmpty(this.getAwareness().getText().toString())) {
            new AlertDialog.Builder(this)
                    .setMessage("Please Enter Player's Awareness rating")
                    .create()
                    .show();
            this.getAwareness().requestFocus();

            return;
        }
        if (StringUtils.isEmpty(this.getBreakTackle().getText().toString())) {
            new AlertDialog.Builder(this)
                    .setMessage("Please Enter Player's Break Tackle rating")
                    .create()
                    .show();
            this.getAcceleration().requestFocus();

            return;
        }
        if (StringUtils.isEmpty(this.getElusiveness().getText().toString())) {
            new AlertDialog.Builder(this)
                    .setMessage("Please Enter Player's Elusiveness rating")
                    .create()
                    .show();
            this.getElusiveness().requestFocus();

            return;
        }
        if (StringUtils.isEmpty(this.getTrucking().getText().toString())) {
            new AlertDialog.Builder(this)
                    .setMessage("Please Enter Player's Trucking rating")
                    .create()
                    .show();
            this.getTrucking().requestFocus();

            return;
        }
        if (StringUtils.isEmpty(this.getCarrying().getText().toString())) {
            new AlertDialog.Builder(this)
                    .setMessage("Please Enter Player's Carrying rating")
                    .create()
                    .show();
            this.getCarrying().requestFocus();

            return;
        }
        if (StringUtils.isEmpty(this.getStamina().getText().toString())) {
            new AlertDialog.Builder(this)
                    .setMessage("Please Enter Player's Stamina rating")
                    .create()
                    .show();
            this.getStamina().requestFocus();

            return;
        }
        if (StringUtils.isEmpty(this.getInjury().getText().toString())) {
            new AlertDialog.Builder(this)
                    .setMessage("Please Enter Player's Injury rating")
                    .create()
                    .show();
            this.getInjury().requestFocus();

            return;
        }
        if (getSpeedInt() >= 100){
            new AlertDialog.Builder(this)
                    .setMessage("Player's Speed cannot be 100+")
                    .create()
                    .show();
            this.getSpeed().requestFocus();

            return;
        }
        if (getAccelInt() >= 100){
            new AlertDialog.Builder(this)
                    .setMessage("Player's Acceleration cannot be 100+")
                    .create()
                    .show();
            this.getAcceleration().requestFocus();

            return;
        }
        if (getAgileInt() >= 100){
            new AlertDialog.Builder(this)
                    .setMessage("Player's Agility cannot be 100+")
                    .create()
                    .show();
            this.getAgility().requestFocus();

            return;
        }
        if (getAwareInt() >= 100){
            new AlertDialog.Builder(this)
                    .setMessage("Player's Awareness cannot be 100+")
                    .create()
                    .show();
            this.getAwareness().requestFocus();

            return;
        }
        if (getBTKInt() >= 100){
            new AlertDialog.Builder(this)
                    .setMessage("Player's Break Tackle cannot be 100+")
                    .create()
                    .show();
            this.getBreakTackle().requestFocus();

            return;
        }
        if (getELUInt() >= 100){
            new AlertDialog.Builder(this)
                    .setMessage("Player's Elusiveness cannot be 100+")
                    .create()
                    .show();
            this.getElusiveness().requestFocus();

            return;
        }
        if (getTRKInt() >= 100){
            new AlertDialog.Builder(this)
                    .setMessage("Player's Truck cannot be 100+")
                    .create()
                    .show();
            this.getTrucking().requestFocus();

            return;
        }
        if (getCARInt() >= 100){
            new AlertDialog.Builder(this)
                    .setMessage("Player's Carrying cannot be 100+")
                    .create()
                    .show();
            this.getCarrying().requestFocus();

            return;
        }
        if (getSTAInt() >= 100){
            new AlertDialog.Builder(this)
                    .setMessage("Player's Stamina cannot be 100+")
                    .create()
                    .show();
            this.getStamina().requestFocus();

            return;
        }
        if (getInjInt() >= 100){
            new AlertDialog.Builder(this)
                    .setMessage("Player's Injury cannot be 100+")
                    .create()
                    .show();
            this.getInjury().requestFocus();

            return;
        }
        else{
            create();
        }
    }

    private void create() {
        RunningBackPlayer newer = new RunningBackPlayer();
        AddData(newer.FullName, "Name");
        finish();
    }

    public void AddData(String Entry, String Column){
        boolean insertData = mDBhelper.addData(Entry, Column);

        if(insertData){
            toastMessage("Successful");
        }
        else{
            toastMessage("Fail");
        }
    }

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


    private EditText getFirstName() {
        return (EditText) this.findViewById(R.id.FirstNameEdit);
    }
    private EditText getLastName() {
        return (EditText) this.findViewById(R.id.LastNameEdit);
    }
    private String getYearClass() {
        Spinner spinner = findViewById(R.id.ClassYear);
        String text = spinner.getSelectedItem().toString();
        return text;
    }
    private String getHeight() {
        Spinner spinner1 = findViewById(R.id.Height);
        String text = spinner1.getSelectedItem().toString();
        return text;
    }
    private EditText getWeight() {
        return (EditText) this.findViewById(R.id.Weight);
    }
    private EditText getSpeed() {
        return (EditText) this.findViewById(R.id.Speed);
    }
    private EditText getAcceleration() {
        return (EditText) this.findViewById(R.id.Accel);
    }
    private EditText getAgility() {
        return (EditText) this.findViewById(R.id.Agile);
    }
    private EditText getAwareness() {
        return (EditText) this.findViewById(R.id.Aware);
    }
    private EditText getBreakTackle() {
        return (EditText) this.findViewById(R.id.BTK);
    }
    private EditText getElusiveness() {
        return (EditText) this.findViewById(R.id.Elusive);
    }
    private EditText getTrucking() {
        return (EditText) this.findViewById(R.id.TRK);
    }
    private EditText getCarrying() {
        return (EditText) this.findViewById(R.id.Carry);
    }
    private EditText getStamina() {
        return (EditText) this.findViewById(R.id.Stamina);
    }
    private EditText getInjury() {
        return (EditText) this.findViewById(R.id.Injury);
    }
}

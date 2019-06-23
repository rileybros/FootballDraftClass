package com.example.footballdraftclass;


import android.app.AlertDialog;
import android.content.Intent;
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


public class PlayerCreator extends AppCompatActivity {

    int speedInt, accelInt, agileInt, awareInt, THPInt, weightInt;
    int THAInt, BTKInt, ELUInt, TRKInt, CARInt, STAInt, InjInt;

    DatabaseHelper mDBhelper;

    private String selectedDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        Intent receivedIntent = getIntent();
        Bundle args = receivedIntent.getBundleExtra("Bundle");
        selectedDatabase = receivedIntent.getStringExtra("Database");
        if (selectedDatabase.equals("Quarterbacks")) {
            setContentView(R.layout.activity_quarterback);
        }
        if (selectedDatabase.equals("RunningBacks")){
            setContentView(R.layout.activity_runningback);
        }
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        makeSpinners();

        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar != null) {

        }



        mDBhelper = new DatabaseHelper(this, selectedDatabase);

    }

    public void makeSpinners() {
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
        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);
    }

    public void QuarterbackErrorCheck(View view) {
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
        if (StringUtils.isEmpty(this.getSchool().getText().toString())){
            new AlertDialog.Builder(this)
                    .setMessage("Please Enter in Players's College")
                    .create()
                    .show();
            this.getSchool().requestFocus();
            return;
        }
        if (getProjRound().equals("Proj Round")) {
            new AlertDialog.Builder(this)
                    .setMessage("Please Select Player's Projected Round")
                    .create()
                    .show();
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
        if (StringUtils.isEmpty(this.getThrowPower().getText().toString())) {
            new AlertDialog.Builder(this)
                    .setMessage("Please Enter Player's Throw Power rating")
                    .create()
                    .show();
            this.getThrowPower().requestFocus();

            return;
        }
        if (StringUtils.isEmpty(this.getThrowAccuracy().getText().toString())) {
            new AlertDialog.Builder(this)
                    .setMessage("Please Enter Player's Throw Accuracy rating")
                    .create()
                    .show();
            this.getThrowAccuracy().requestFocus();

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
        if (getTHPInt() >= 100){
            new AlertDialog.Builder(this)
                    .setMessage("Player's Throw Power cannot be 100+")
                    .create()
                    .show();
            this.getThrowPower().requestFocus();

            return;
        }
        if (getTHAInt() >= 100){
            new AlertDialog.Builder(this)
                    .setMessage("Player's Throw Accuracy cannot be 100+")
                    .create()
                    .show();
            this.getThrowAccuracy().requestFocus();

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
        if (selectedDatabase.equals("Quarterbacks")){
            Quarterback newer = new Quarterback(getFirstName().getText().toString()+" "+getLastName().getText().toString(), getYearClass(), getHeight(), getWeightInt(), getSpeedInt(), getAccelInt(), getAgileInt(), getAwareInt(),
                    getTHPInt(), getTHAInt(), getBTKInt(), getELUInt(), getTRKInt(), getCARInt(), getSTAInt(), getInjInt(), getSchool().getText().toString(), getProjRound());
            AddDataQB(newer.FullName, newer.Class, newer.Height, newer.Weight, newer.Speed, newer.Accel, newer.Agile, newer.Aware, newer.NCAATHP,
                    newer.NCAATHA, newer.BreakTack, newer.Elusive, newer.Trucking, newer.Carry, newer.Stamina, newer.Injury);

            finish();
        }
        if (selectedDatabase.equals("RunningBacks")){
            RunningBackPlayer newer = new RunningBackPlayer(getFirstName().getText().toString()+" "+getLastName().getText().toString(), getYearClass(), getHeight(), getWeightInt(), getSpeedInt(), getAccelInt(), getAgileInt(), getAwareInt(),
                    getBTKInt(), getELUInt(), getTRKInt(), getCARInt(), getSTAInt(), getInjInt());
            AddDataRB(newer.FullName, newer.Class, newer.Height, newer.Weight, newer.Speed, newer.Accel, newer.Agile, newer.Aware,
                    newer.BreakTack, newer.Elusive, newer.Trucking, newer.Carry, newer.Stamina, newer.Injury);
            finish();
        }
        else {

        }
    }

    public void AddDataQB(String Name, String Class, String Height, double Weight, double sp, double acc, double agil, double awa, double thp,
                          double tha, double btk, double elu, double tru, double carr, double sta, double inj) {
        boolean insertData = mDBhelper.addDataQB(Name, Class, Height, Weight, sp, acc, agil, awa, thp, tha, btk, elu, tru, carr, sta, inj);

        if(insertData){
            toastMessage("Successful");
        }
        else{
            toastMessage("Fail");
        }
    }

    public void AddDataRB(String Name, String Class, String Height, double Weight, double sp, double acc, double agil, double awa, double btk,
                          double elu, double tru, double carr, double sta, double inj) {
        boolean insertData = mDBhelper.addDataRB(Name, Class, Height, Weight, sp, acc, agil, awa, btk, elu, tru, carr, sta, inj);

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
    public double getWeightInt() {
        String weight = this.getWeight().getText().toString();
        weightInt = Integer.parseInt(weight);
        return weightInt;
    }
    public double getTHPInt() {
        String THP = this.getThrowPower().getText().toString();
        THPInt = Integer.parseInt(THP);
        return(THPInt);
    }
    public double getTHAInt() {
        String THA = this.getThrowAccuracy().getText().toString();
        THAInt = Integer.parseInt(THA);
        return (THAInt);
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

    public EditText getFirstName() {
        return (EditText) this.findViewById(R.id.FirstNameEdit);
    }
    public EditText getLastName() {
        return (EditText) this.findViewById(R.id.LastNameEdit);
    }
    public String getYearClass() {
        Spinner spinner = findViewById(R.id.ClassYear);
        String text = spinner.getSelectedItem().toString();
        return text;
    }
    public String getHeight() {
        Spinner spinner1 = findViewById(R.id.Height);
        String text = spinner1.getSelectedItem().toString();
        return text;
    }
    public EditText getWeight() {
        return (EditText) this.findViewById(R.id.Weight);
    }
    public EditText getSchool() {
        return (EditText) this.findViewById(R.id.School);
    }
    public String getProjRound() {
        Spinner spinner = findViewById(R.id.ProjRound);
        String text = spinner.getSelectedItem().toString();
        return text;
    }
    public EditText getSpeed() {
        return (EditText) this.findViewById(R.id.Speed);
    }
    public EditText getAcceleration() {
        return (EditText) this.findViewById(R.id.Accel);
    }
    public EditText getAgility() {
        return (EditText) this.findViewById(R.id.Agile);
    }
    public EditText getAwareness() {
        return (EditText) this.findViewById(R.id.Aware);
    }
    public EditText getThrowPower() {
        return (EditText) this.findViewById(R.id.TP);
    }
    public EditText getThrowAccuracy() {
        return (EditText) this.findViewById(R.id.TA);
    }
    public EditText getBreakTackle() {
        return (EditText) this.findViewById(R.id.BTK);
    }
    public EditText getElusiveness() {
        return (EditText) this.findViewById(R.id.Elusive);
    }
    public EditText getTrucking() {
        return (EditText) this.findViewById(R.id.TRK);
    }
    public EditText getCarrying() {
        return (EditText) this.findViewById(R.id.Carry);
    }
    public EditText getStamina() {
        return (EditText) this.findViewById(R.id.Stamina);
    }
    public EditText getInjury() {
        return (EditText) this.findViewById(R.id.Injury);
    }


}

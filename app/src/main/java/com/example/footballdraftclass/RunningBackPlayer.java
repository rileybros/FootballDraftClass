package com.example.footballdraftclass;

public class RunningBackPlayer extends Offense {

    public RunningBackPlayer(String fName, String year, String height, double weight, double speed, double accel, double agile,
                             double aware, double Btk, double elu, double tru, double car, double sta, double inj){


        update(fName, year, height, weight, speed, accel, agile, aware, Btk, elu, tru, car, sta, inj);
    }

    public void update(String fName, String year, String height, double weight, double speed, double accel, double agile,
                       double aware, double Btk, double elu, double tru, double car, double sta, double inj) {
        this.FullName   = fName;
        this.Class      = year;
        this.Height     = height;
        this.Weight     = weight;
        this.Speed      = speed;
        this.Accel      = accel;
        this.Agile      = agile;
        this.Aware      = aware;
        this.BreakTack  = Btk;
        this.Elusive    = elu;
        this.Trucking   = tru;
        this.Carry      = car;
        this.Stamina    = sta;
        this.Injury     = inj;
    }
}

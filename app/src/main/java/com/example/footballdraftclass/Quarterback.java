package com.example.footballdraftclass;

public class Quarterback extends Offense {

        //QB-only Ratings
        double 	ProTHP;
        double 	STA;
        double 	MTA;
        double 	DTA ;
        double 	PAC;
        double 	TOR;
        double 	TUP;
        double	BSK;


        //Base Ratings
        double  NCAATHP;
        double  NCAATHA;

        public Quarterback(String fName, String year, String height, double weight, double speed, double accel, double agile, double aware, double THP,
                           double THA, double Btk, double elu, double tru, double car, double sta, double inj) {
            Position = "Quarterback";

            ProTHP  = 0;        NCAATHA = 0;
            STA     = 0;        NCAATHP = 0;
            MTA     = 0;
            DTA     = 0;
            PAC     = 0;
            TOR     = 0;
            TUP     = 0;
            BSK     = 0;

            update(fName, year, height, weight, speed, accel, agile, aware, THP, THA, Btk, elu, tru, car, sta, inj);
        }

    public void update(String fName, String year, String h, double w, double s, double a, double ag, double aw,
                       double p, double acc, double btk, double elu, double tru, double car, double sta, double inj) {
            this.FullName   = fName;
            this.Class      = year;
            this.Height     = h;
            this.Weight     = w;
            this.Speed      = s;
            this.Accel      = a;
            this.Agile      = ag;
            this.Aware      = aw;
            this.NCAATHP    = p;
            this.NCAATHA    = acc;
            this.BreakTack  = btk;
            this.Elusive    = elu;
            this.Trucking   = tru;
            this.Carry      = car;
            this.Stamina    = sta;
            this.Injury     = inj;


        }



}

package com.example.footballdraftclass;

import java.util.Random;

public class Quarterback extends Offense {

        //QB-only Ratings
        double 	ProTHP;     String college;
        double 	STA;        String round;
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
                           double THA, double Btk, double elu, double tru, double car, double sta, double inj, String school, String projRound) {
            Position = "Quarterback";

            ProTHP  = 0;        NCAATHA = 0;
            STA     = 0;        NCAATHP = 0;
            MTA     = 0;        college  = school;
            DTA     = 0;        round = projRound;
            PAC     = 0;
            TOR     = 0;
            TUP     = 0;
            BSK     = 0;

            update(fName, year, height, weight, speed, accel, agile, aware, THP, THA, Btk, elu, tru, car, sta, inj);
            update2(speed, accel, agile, aware, car, THP, THA, projRound);
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

        public void update2(double sp, double acc, double agile, double aware, double car, double THP, double THA, String projR) {

            this.ProSpeed = ProSp(sp);
            this.ProAccel = ProAcc(acc);
            this.ProAgile = ProAgil(agile);
            this.ProStrength = ProStr();
            this.ProAware = ProAwa(aware);
            this.ProCarry = ProCar(car);
            this.ProTHP = ProTHP(THP);
            this.STA    = STA(THA);
            this.MTA    = MTA(THA);
            this.DTA    = DTA(THA);
            this.TOR    = TOR();
            this.TUP    = TUP();
            this.PAC    = PAC();
            this.BSK    = BSK();
            this.ProDevelop = ProDevelop(projR);
            this.Age = determineAge(this.Class);

        }

        public double ProTHP(double THP){
            Random r = new Random();
            double max = THP;
            double min = (THP * .98);
            double temp = min + (max - min) * r.nextDouble();
            return temp;
        }
        public double ProSp(double sp) {
            Random r = new Random();
            double max = sp;
            double min = (sp * .98);
            double temp = min + (max - min) * r.nextDouble();
            return temp;
        }
        public double ProAcc(double acc) {
            Random r = new Random();
            double max = (acc * .98);
            double min = (acc * .90);
            double temp = min + (max - min) * r.nextDouble();
            return temp;
        }
        public double ProAgil(double agi) {
            Random r = new Random();
            double max = agi * .98;
            double min = agi * .9;
            double temp = min + (max - min) * r.nextDouble();
            return temp;
        }
        public double ProStr() {
            Random r = new Random();
            double min = 40;
            double max = 75;
            double temp = min + (max - min) * r.nextDouble();
            return temp;
        }
        public double ProAwa(double a) {
            Random r = new Random();
            double min = a * .55;
            double max = a * .75;
            double temp = min + (max - min) * r.nextDouble();
            return temp;
        }
        public double ProCar(double c) {
            Random r = new Random();
            double min = c * .75;
            double max = c;
            double temp = min + (max - min) * r.nextDouble();
            return temp;
        }
        public double STA(double a){
            Random r = new Random();
            double min = a * .90;
            double max = a * .97;
            double temp = min + (max - min) * r.nextDouble();
            return temp;
        }
        public double MTA(double a) {
            Random r = new Random();
            double min = a * .80;
            double max = a * .90;
            double temp = min + (max - min) * r.nextDouble();
            return temp;
        }
        public double DTA(double a) {
            Random r = new Random();
            double min = a * .73;
            double max = a * .80;
            double temp = min + (max - min) * r.nextDouble();
            return temp;
        }
        public double TOR() {
            Random r = new Random();
            double min = 65;
            double max = 80;
            double min1 = 81;
            double max1 = 99;
            double temp = min + (max - min) * r.nextDouble();
            double temp1 = min1 + (max1 - min1) * r.nextDouble();
            double tempfinal = temp + (temp1 - temp) * r.nextDouble();
            return tempfinal;
        }
        public double TUP() {
            Random r = new Random();
            double min = 65;
            double max = 80;
            double min1 = 81;
            double max1 = 99;
            double temp = min + (max - min) * r.nextDouble();
            double temp1 = min1 + (max1 - min1) * r.nextDouble();
            double tempfinal = temp + (temp1 - temp) * r.nextDouble();
            return tempfinal;
        }
        public double PAC() {
            Random r = new Random();
            double min = 65;
            double max = 80;
            double min1 = 81;
            double max1 = 99;
            double temp = min + (max - min) * r.nextDouble();
            double temp1 = min1 + (max1 - min1) * r.nextDouble();
            double tempfinal = temp + (temp1 - temp) * r.nextDouble();
            return tempfinal;
        }
        public double BSK() {
            Random r = new Random();
            double min = 65;
            double max = 80;
            double min1 = 81;
            double max1 = 99;
            double temp = min + (max - min) * r.nextDouble();
            double temp1 = min1 + (max1 - min1) * r.nextDouble();
            double tempfinal = temp + (temp1 - temp) * r.nextDouble();
            return tempfinal;
        }
        public String ProDevelop(String a) {
            Random r = new Random();
            int devel = r.nextInt(3);
            boolean val = (devel == 0);
            boolean val1 = (devel == 1);
            boolean val2 = (devel == 2);
            boolean val3 = (devel == 3);
            if(val){

            }


            return a;
        }
        public int determineAge(String year) {
            Random r  = new Random();
            if(year.equals("Sophomore (Redshirt)") || year.equals("Junior")) {
                int min = 20;
                int max = 22;
                int age = r.nextInt((max - min)+ 1) + min;
                return age;
            }
            if(year.equals("Junior (Redshirt)") || year.equals("Senior")) {
                int min = 21;
                int max = 23;
                int age = r.nextInt((max - min) + 1) + min;
                return age;
            }
            else {
                int min = 22;
                int max = 24;
                int age = r.nextInt((max-min)+1) + min;
                return age;
            }

        }



}

package com.example.footballdraftclass;

import java.util.Random;

public class Quarterback extends Offense {

        //QB-only Ratings
        double 	ProTHP;     String college;
        double 	STA;        String round;
        double 	MTA;        double ProPOW;
        double 	DTA ;       double ProPursuit;
        double 	PAC;        double ProTackle;
        double 	TOR;        double ProTough;
        double 	TUP;        double ProOverallTHA;
        double	BSK;        double BestOverall;


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
            PAC     = 0;        ProPOW = 0;
            TOR     = 0;        ProPursuit = 0;
            TUP     = 0;        ProTackle = 0;
            BSK     = 0;        ProTough = 0;
            ProOverallTHA = 0;
            BestOverall = 0;

            this.FullName   = fName;
            this.Class      = year;
            this.Height     = height;
            this.Weight     = weight;
            this.Speed      = speed;
            this.Accel      = accel;
            this.Agile      = agile;
            this.Aware      = aware;
            this.NCAATHP    = THP;
            this.NCAATHA    = THA;
            this.BreakTack  = Btk;
            this.Elusive    = elu;
            this.Trucking   = tru;
            this.Carry      = car;
            this.Stamina    = sta;
            this.Injury     = inj;

            update();
        }

        public void update() {

            this.ProSpeed = ProSp(this.Speed);
            this.ProAccel = ProAcc(this.Accel);
            this.ProAgile = ProAgil(this.Agile);
            this.ProStrength = ProStr();
            this.ProAware = ProAwa(this.Aware);
            this.ProCarry = ProCar(this.Carry);
            this.ProTHP = ProTHP(this.NCAATHP);
            this.STA    = STA(this.NCAATHA);
            this.MTA    = MTA(this.NCAATHA);
            this.DTA    = DTA(this.NCAATHA);
            this.ProOverallTHA = OverThAcc(this.NCAATHA);
            this.ProInjury = INJ(this.Injury);
            this.ProTruck = Trk(this.Trucking);
            this.ProStamina = proStam(this.Stamina);
            this.TOR    = TOR();
            this.TUP    = TUP();
            this.PAC    = PAC();
            this.BSK    = BSK();
            this.ProBCV = BCV();
            this.ProBreakTack = BTK();
            this.ProCatching = CTH();
            this.ProElusive = ELU();
            this.ProPOW = POW();
            this.ProJuke = JKM();
            this.ProSpC = SPC();
            this.ProJumping = JMP();
            this.ProPursuit = PUR();
            this.ProSpin = SPM();
            this.ProStiff = StiffArm();
            this.ProTackle = Tak();
            this.ProTough = Toughness();
            this.ProDevelop = ProDevelop(this.round);
            this.Age = determineAge(this.Class);
            this.BestOverall  = bestOverall();
        }

        public double bestOverall() {
            double a = 0;
            return a;
        }
        public double ProTHP(double THP){
            Random r = new Random();
            double max = Math.min(THP, 99);
            double min = Math.max((THP * .97), 82);
            double temp = min + (max - min) * r.nextDouble();
            return temp;
        }
        public double ProSp(double sp) {
            Random r = new Random();
            double max = Math.min(sp, 93);
            double min = Math.max((sp * .92), 70);
            double temp = min + (max - min) * r.nextDouble();
            return temp;
        }
        public double ProAcc(double acc) {
            Random r = new Random();
            double max = Math.min(acc, 94);
            double min = Math.max((acc * .94), 80);
            double temp = min + (max - min) * r.nextDouble();
            return temp;
        }
        public double ProAgil(double agi) {
            Random r = new Random();
            double max = Math.min(agi, 96);
            double min = Math.max((agi * .85), 65);
            double temp = min + (max - min) * r.nextDouble();
            return temp;
        }
        public double ProStr() {
            Random r = new Random();
            double min = 53;
            double max = 72;
            double t = min + (max - min) * r.nextDouble();
            double a = min + (max - min) * r.nextDouble();
            double temp = Math.max(t, a);
            return temp;
        }
        public double ProAwa(double a) {
            Random r = new Random();
            double min = Math.min((a*.65), 50);
            double max = Math.min(a, 78);
            double temp = min + (max - min) * r.nextDouble();
            return temp;
        }
        public double ProCar(double c) {
            Random r = new Random();
            double min = Math.min((c*.50), 49);
            double max = Math.min(c, 68);
            double temp = min + (max - min) * r.nextDouble();
            return temp;
        }
        public double STA(double a){
            Random r = new Random();
            double min = Math.max((a*.82), 77);
            double max = Math.min((a*.95), 90);
            double temp = min + (max - min) * r.nextDouble();
            return temp;
        }
        public double MTA(double a) {
            Random r = new Random();
            double min = Math.max((a*.75), 73);
            double max = Math.min((a*.85), 85);
            double temp = min + (max - min) * r.nextDouble();
            return temp;
        }
        public double DTA(double a) {
            Random r = new Random();
            double min = Math.max((a*.65), 63);
            double max = Math.min((a*.85), 81);
            double temp = min + (max - min) * r.nextDouble();
            return temp;
        }
        public double OverThAcc(double a) {
            Random r = new Random();
            double min = Math.max((a*.80), 70);
            double max = Math.min((a*.99), 97);
            double temp = min + (max - min) * r.nextDouble();
            return temp;
        }
        public double INJ(double i) {
            Random r = new Random();
            double min = Math.max((i*.85), 83);
            double max = Math.min((i*.95), 94);
            double temp = min + (max - min) * r.nextDouble();
            return temp;
        }
        public double Trk(double t) {
            Random r = new Random();
            double min = Math.max((t*.70), 21);
            double max = Math.min((t*.95), 67);
            double temp = min + (max - min) * r.nextDouble();
            return temp;
        }
        public double TOR() {
            Random r = new Random();
            double min = 71;
            double max = 80;
            double min1 = 81;
            double max1 = 89;
            double temp = min + (max - min) * r.nextDouble();
            double temp1 = min1 + (max1 - min1) * r.nextDouble();
            double tempfinal = temp + (temp1 - temp) * r.nextDouble();
            return tempfinal;
        }
        public double TUP() {
            Random r = new Random();
            double min = 63;
            double max = 77;
            double min1 = 78;
            double max1 = 87;
            double temp = min + (max - min) * r.nextDouble();
            double temp1 = min1 + (max1 - min1) * r.nextDouble();
            double tempfinal = temp + (temp1 - temp) * r.nextDouble();
            return tempfinal;
        }
        public double PAC() {
            Random r = new Random();
            double min = 68;
            double max = 77;
            double min1 = 78;
            double max1 = 85;
            double temp = min + (max - min) * r.nextDouble();
            double temp1 = min1 + (max1 - min1) * r.nextDouble();
            double tempfinal = temp + (temp1 - temp) * r.nextDouble();
            return tempfinal;
        }
        public double BSK() {
            Random r = new Random();
            double min = 40;
            double max = 65;
            double min1 = 66;
            double max1 = 89;
            double temp = min + (max - min) * r.nextDouble();
            double temp1 = min1 + (max1 - min1) * r.nextDouble();
            double tempfinal = temp + (temp1 - temp) * r.nextDouble();
            return tempfinal;
        }
        public double BCV() {
            Random r = new Random();
            double min1 = 31;
            double max1 = 60;
            double min2 = 61;
            double max2 = 93;
            double temp1 = min1 + (max1 - min1) * r.nextDouble();
            double temp2 = min2 + (max2 - min2) * r.nextDouble();
            double tempfinal = temp1 + (temp2 - temp1) * r.nextDouble();
            return tempfinal;
        }
        public double BTK() {
            Random r = new Random();
            double min1 = 22;
            double max1 = 52;
            double min2 = 53;
            double max2 = 81;
            double temp1 = min1 + (max1 - min1) * r.nextDouble();
            double temp2 = min2 + (max2 - min2) * r.nextDouble();
            double tempfinal = temp1 + (temp2 - temp1) * r.nextDouble();
            return tempfinal;
        }
        public double CTH() {
            Random r = new Random();
            double min1 = 18;
            double max1 = 38;
            double min2 = 39;
            double max2 = 59;
            double temp1 = min1 + (max1 - min1) * r.nextDouble();
            double temp2 = min2 + (max2 - min2) * r.nextDouble();
            double tempfinal = temp1 + (temp2 - temp1) * r.nextDouble();
            return tempfinal;
        }
        public double ELU() {
            Random r = new Random();
            double min1 = 28;
            double max1 = 56;
            double min2 = 57;
            double max2 = 85;
            double temp1 = min1 + (max1 - min1) * r.nextDouble();
            double temp2 = min2 + (max2 - min2) * r.nextDouble();
            double tempfinal = temp1 + (temp2 - temp1) * r.nextDouble();
            return tempfinal;
        }
        public double POW() {
            Random r = new Random();
            double min1 = 11;
            double max1 = 23;
            double min2 = 24;
            double max2 = 37;
            double temp1 = min1 + (max1 - min1) * r.nextDouble();
            double temp2 = min2 + (max2 - min2) * r.nextDouble();
            double tempfinal = temp1 + (temp2 - temp1) * r.nextDouble();
            return tempfinal;
        }
        public double JKM() {
            Random r = new Random();
            double min1 = 35;
            double max1 = 60;
            double min2 = 61;
            double max2 = 89;
            double temp1 = min1 + (max1 - min1) * r.nextDouble();
            double temp2 = min2 + (max2 - min2) * r.nextDouble();
            double tempfinal = temp1 + (temp2 - temp1) * r.nextDouble();
            return tempfinal;
        }
        public double JMP(){
            Random r = new Random();
            double min1 = 67;
            double max1 = 77;
            double min2 = 78;
            double max2 = 91;
            double temp1 = min1 + (max1 - min1) * r.nextDouble();
            double temp2 = min2 + (max2 - min2) * r.nextDouble();
            double tempfinal = temp1 + (temp2 - temp1) * r.nextDouble();
            return tempfinal;
        }
        public double SPC() {
            Random r = new Random();
            double min1 = 27;
            double max1 = 57;
            double min2 = 58;
            double max2 = 86;
            double temp1 = min1 + (max1 - min1) * r.nextDouble();
            double temp2 = min2 + (max2 - min2) * r.nextDouble();
            double tempfinal = temp1 + (temp2 - temp1) * r.nextDouble();
            return tempfinal;
        }
        public double PUR() {
            Random r = new Random();
            double min1 = 19;
            double max1 = 28;
            double min2 = 29;
            double max2 = 38;
            double temp1 = min1 + (max1 - min1) * r.nextDouble();
            double temp2 = min2 + (max2 - min2) * r.nextDouble();
            double tempfinal = temp1 + (temp2 - temp1) * r.nextDouble();
            return tempfinal;
        }
        public double SPM() {
            Random r = new Random();
            double min1 = 27;
            double max1 = 57;
            double min2 = 58;
            double max2 = 86;
            double temp1 = min1 + (max1 - min1) * r.nextDouble();
            double temp2 = min2 + (max2 - min2) * r.nextDouble();
            double tempfinal = temp1 + (temp2 - temp1) * r.nextDouble();
            return tempfinal;
        }
        public double StiffArm() {
            Random r = new Random();
            double min1 = 23;
            double max1 = 41;
            double min2 = 42;
            double max2 = 60;
            double temp1 = min1 + (max1 - min1) * r.nextDouble();
            double temp2 = min2 + (max2 - min2) * r.nextDouble();
            double tempfinal = temp1 + (temp2 - temp1) * r.nextDouble();
            return tempfinal;
        }
        public double Tak() {
            Random r = new Random();
            double min1 = 14;
            double max1 = 25;
            double min2 = 26;
            double max2 = 35;
            double temp1 = min1 + (max1 - min1) * r.nextDouble();
            double temp2 = min2 + (max2 - min2) * r.nextDouble();
            double tempfinal = temp1 + (temp2 - temp1) * r.nextDouble();
            return tempfinal;
        }
        public double Toughness() {
            Random r = new Random();
            double min1 = 70;
            double max1 = 83;
            double min2 = 84;
            double max2 = 96;
            double temp1 = min1 + (max1 - min1) * r.nextDouble();
            double temp2 = min2 + (max2 - min2) * r.nextDouble();
            double tempfinal = temp1 + (temp2 - temp1) * r.nextDouble();
            return tempfinal;
        }
        public double proStam(double s) {
            Random r = new Random();
            double min = Math.max((s*.90), 87);
            double max = Math.min(s, 96);
            double temp = min + (max - min) * r.nextDouble();
            return temp;
        }
        public String ProDevelop(String a) {
            Random r = new Random();
            if(a.equals("1")){
                int Development = r.nextInt(101);
                if(Development > 0 && Development <= 35){
                    return "Superstar";
                }
                else if(Development > 35 && Development <= 60) {
                    return "Star";
                }
                else if(Development > 60 && Development <= 85) {
                    return "Quick";
                }
                else {
                    return "Normal";
                }
            }
            else if(a.equals("2") || a.equals("3")) {
                int Development = r.nextInt(101);
                if(Development > 0 && Development <= 25){
                    return "Superstar";
                }
                else if(Development > 25 && Development <= 55) {
                    return "Star";
                }
                else if(Development > 55 && Development <= 80) {
                    return "Quick";
                }
                else {
                    return "Normal";
                }
            }
            else if(a.equals("4") || a.equals("5")) {
                int Development = r.nextInt(101);
                if(Development > 0 && Development <= 20){
                    return "Superstar";
                }
                else if(Development > 20 && Development <= 55) {
                    return "Star";
                }
                else if(Development > 55 && Development <= 75) {
                    return "Quick";
                }
                else {
                    return "Normal";
                }
            }
            else {
                int Development = r.nextInt(101);
                if(Development > 0 && Development <= 15){
                    return "Superstar";
                }
                else if(Development > 15 && Development <= 40) {
                    return "Star";
                }
                else if(Development > 40 && Development <= 70) {
                    return "Quick";
                }
                else {
                    return "Normal";
                }
            }
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

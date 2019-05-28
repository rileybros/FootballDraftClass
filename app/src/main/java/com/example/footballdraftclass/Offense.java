package com.example.footballdraftclass;

public class Offense {
    String  FullName;
    String  Class;
    String  Position;
    int     Age;
    String  Height;

    //Base Attributes        //Pro Base Ratings             //Offense-only Ratings
    double 	Speed;           double 	ProSpeed;           double 	ProBCV;
    double 	Accel;           double 	ProAccel;           double 	ProCIT;
    double 	Agile;           double 	ProAgile;           double 	ProSpC;
    double 	Aware;           double 	ProAware;           double 	ProStiff;
    double 	Stamina;         double 	ProStamina;         double 	ProSpin;
    double 	Injury;          double 	ProInjury;          double 	ProJuke;
    double 	BreakTack;       double 	ProBreakTack;       double 	SRT;
    double 	Elusive;         double 	ProElusive;         double 	MRT;
    double 	Carry;           double 	ProCarry;           double 	DRT;
    double 	Strength;        double 	ProStrength;        double 	ProIBK;
    double 	Catching;        double 	ProCatching;        double 	ProLBK;
    double 	Jumping;         double 	ProJumping;         double 	ProRBK;
    int		estDevelop;      String	    ProDevelop;         double 	ProRBP;
    double  Trucking;        String	    ProjectRound;       double 	ProRBF;
                                                            double 	ProPBK;
                                                            double 	ProPBP;
                                                            double 	ProPBF;
                                                            double 	ProRel;
                                                            double 	ProTruck;

    public Offense() {
        FullName    = " ";
        Class       = " ";
        Position    = " ";
        Age         = 0;

        //Base initializations          //Pro Initializations           //Offense-only Ratings
        Speed           = 0;            ProSpeed        = 0;            ProBCV      = 0;
        Accel           = 0;            ProAccel        = 0;            ProCIT      = 0;
        Agile           = 0;            ProAgile        = 0;            ProSpC      = 0;
        Aware           = 0;            ProAware        = 0;            ProStiff    = 0;
        Stamina         = 0;            ProStamina      = 0;            ProSpin     = 0;
        Injury          = 0;            ProInjury       = 0;            ProJuke     = 0;
        BreakTack       = 0;            ProBreakTack    = 0;            SRT         = 0;
        Elusive         = 0;            ProElusive      = 0;            MRT         = 0;
        Carry           = 0;            ProCarry        = 0;            DRT         = 0;
        Strength        = 0;            ProStrength     = 0;            ProIBK      = 0;
        Catching        = 0;            ProCatching     = 0;            ProLBK      = 0;
        Jumping         = 0;            ProJumping      = 0;            ProRBK      = 0;
        estDevelop      = 0;            ProDevelop      = " ";          ProRBP      = 0;
        ProjectRound    = " ";                                          ProRBF      = 0;
        Trucking        = 0;                                            ProPBK      = 0;
                                                                        ProPBP      = 0;
                                                                        ProPBF      = 0;
                                                                        ProRel      = 0;
                                                                        ProTruck    = 0;

        //
    }
}

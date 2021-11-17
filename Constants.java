package com.example.UpgradeSpectrumUtilization;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by roiya on 3/9/20.
 */
public class Constants {
    public static final String osnr_file_C = "Penalties_BTUK_C_C+L.csv";
    public static final String osnr_file_L = "Penalties_BTUK_L_C+L.csv";
    public static final String osnr_file_c = "Penalties_BTUK_C.csv";
    public static final String event_file =  "eventlist.txt";

    public static final int num_req =3230;
    public static final int print_point = 1;
    public static final int Time_duration = 1; //minute
    //public static final int [] traffic_matrix ={0,0,0,0,0,0,1,1,1,2,2,2,3,3,4,4,5,5,5,6,7,7,8,8,8,8,8,8,9,9,9,10,10,10,11,11,12,12,12,13,13,13,14,14,15,16,16,16,17,17,17,17,18,18,18,18,18,19,19,20,20,21};
    public static final ArrayList<Double> pmf = new ArrayList<Double>(Arrays.asList(0.005172414,0.026628352,0.038697318,0.023180077,0.057854406,0.094252874,0.083141762,0.023754789,0.024712644,0.017241379,0.019923372,0.033141762,0.097318008,0.053256705,0.00862069,0.052490421,0.114176245,0.090421456,0.029501916,0.005172414,0.086398467,0.014942529));

    public static int maximum_path = 3;
    public static double num_runs = 10;
    public static int num_links = 35;
    public static int num_nodes = 22;
    public static double node_ase = 0.0008361653;
    public static double launch_power = 0.707945784;
    public static int channels_perLink = 133;


}

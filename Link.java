package com.example.UpgradeSpectrumUtilization;
import java.awt.geom.Arc2D;
import java.util.ArrayList;

/**
 * Created by roiya on 3/9/20.
 */
public class Link {private int ID;

    public int hit_count;

    public double getCapacity() {
        return capacity;
    }

    public double getLength() {
        return length;
    }

    public int getStartNodeID() {
        return startNodeID;
    }

    public int getEndNodeID() {
        return endNodeID;
    }


    private double capacity; // link capacity
    private double length; // link length
    public int startNodeID;
    public int endNodeID;
    //private int typ;
    static int count = 0;
    public static int max_occ_slotId = 0;
    ArrayList<Integer> weights = new ArrayList<>(); // her linkin her node icin weighti var.
    public double avail_capacity;
    public ArrayList<Integer> slot_occupation_c = new ArrayList<Integer>();
    public ArrayList<Double> free_capacity_c = new ArrayList<Double>();

    public ArrayList<Integer> slot_occupation_l = new ArrayList<Integer>();
    public ArrayList<Double> free_capacity_l = new ArrayList<Double>();

    public int free_slots(){
        int count = 0;
        for (int i=0; i<Constants.channels_perLink; i++){
            if(slot_occupation_c.get(i)==0)
                count++;
        }
        return count;
    }


    public Link(int source, int dest, double capacity, double length) {
        this.startNodeID = source;
        this.endNodeID = dest;
       // this.capacity = capacity;
        this.length = length;
        this.avail_capacity = capacity;
        //this.typ = typ;
        this.ID = count++;

        for(int i=0;i< Constants.channels_perLink;i++) {
            slot_occupation_c.add(0);
            free_capacity_c.add(0.0);
            slot_occupation_l.add(0);
            free_capacity_l.add(0.0);
        }
    }


    public int getID() {
        return this.ID;
    }
    @Override
    public String toString() {
        String msg = startNodeID + "-"+endNodeID;
        return msg;
    }

    public void setCountZero(){
        count = 0;
    }

}

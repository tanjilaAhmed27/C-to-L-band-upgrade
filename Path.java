package com.example.UpgradeSpectrumUtilization;
import java.util.ArrayList;
import java.util.Vector;
import java.util.*;

/**
 * Created by roiya on 3/9/20.
 */
public class Path {
    private Vector<Link> links;
    public ArrayList<Integer> pathNodes = new ArrayList<>();
    public int hopNumber;
    private int sourceNodeID;
    private int destNodeID;
    public int pathLength;
    public int slot_taken;
    public double path_osnr_db;
    public double modulation;


    public Path(){}
    public Path(Vector<Link> listLinks) {

        this.links = listLinks;
        sourceNodeID = ((Link) this.links.get(0)).startNodeID;
        destNodeID = ((Link) this.links.get(this.links.size() - 1)).endNodeID;

        for (int i = 0; i < listLinks.size(); i++) {
            pathNodes.add(listLinks.get(i).startNodeID);
        }
        pathNodes.add(destNodeID); // destination node was not added in above loop

        hopNumber = links.size();
    }

    public int getWeight(){
        int weight = 0;
        for (int i = 0; i < links.size(); i++) {
            weight += links.get(i).weights.get(sourceNodeID);
            weight += links.get(i).weights.get(destNodeID);
        }
        return weight;
    }
    public Vector<Link> getLinks() {
        return links;
    }

    public int getSourceID() {
        return sourceNodeID;
    }


    public double getLength() {
        return pathLength;
    }

    public boolean containsLink(Link testLink) {

        for (Link link : links) {
            if (link.equals(testLink))
                return true;
        }
        return false;
    }
    public boolean contains(int linkID) {
        for (Link link : links) {
            if (link.getID() == linkID)
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String msg = "";
        for (int j = 0; j < links.size(); j++) {
            if (j == 0)
                msg += ((Link) links.get(j)).startNodeID + " - " + ((Link) links.get(j)).endNodeID;
            else
                msg += (" - " + ((Link) links.get(j)).endNodeID);
        }
        return msg;
    }

    public int getNumLinks() {
        return links.size();
    }

    public int getDestNodeID() {
        return destNodeID;
    }

    public void print(int printID) {

        System.out.print("\t" + printID + " <--> ");
        for (int j = 0; j < links.size(); j++) {
            if (j == 0)
                System.out.print(((Link) links.get(j)).startNodeID + " - " + ((Link) links.get(j)).endNodeID);
            else
                System.out.print(" - " + ((Link) links.get(j)).endNodeID);
        }
        System.out.println();
    }

    public boolean same2path (Path p){
        Vector<Link> links = p.getLinks();
        Vector<Link> this_links = this.getLinks();

        Boolean samepath = false;
        if (links.size()!=this_links.size()){
            return false;
        }
        else {
        /* calculate OSNR on shortest path */
            for (int i = 0; i < links.size(); i++) {
                if (links.get(i).startNodeID==this_links.get(i).startNodeID && links.get(i).endNodeID==this_links.get(i).endNodeID)
                    continue;
                else
                    return false;
            }
            return true;
        }

    }
}

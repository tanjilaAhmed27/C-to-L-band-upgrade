package com.example.UpgradeSpectrumUtilization;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by roiya on 3/9/20.
 */
public class Event {public String getEventType() {
    return eventType;
}

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }


    public int getEventTimeStart() {
        return eventTimeStart;
    }


    public double getReqBandwidth() {
        return req_bandwidth;
    }

    private int eventTimeStart;
    private String eventType;
    private double req_bandwidth;//100 Gbps

    public int getId() {
        return id;
    }

    public Path getEvent_path() {
        return event_path;
    }

    private int id;

    public void setEvent_path(Path event_path) {
        this.event_path = event_path;
    }

    public Path event_path = new Path();

    public ArrayList<ArrayList<Integer>> slot_ids = new ArrayList<>();

    public int getSource() {
        return source;
    }

    public int getDest() {
        return dest;
    }

    public void setSlotIDs(ArrayList<ArrayList<Integer>> slots){
        for(int i=0; i<slots.size();i++){
            ArrayList<Integer> s = new ArrayList<Integer>();
            for(int j=0; j<slots.get(i).size();j++) {
                s.add(slots.get(i).get(j));
            }
            slot_ids.add(s);
        }

    }
    public ArrayList<ArrayList<Integer>> getSlotIds(){return slot_ids;}

    private int source;
    private int dest;

    public int getMod_format() {
        return mod_format;
    }

    public void setMod_format(int mod_format) {
        this.mod_format = mod_format;
    }

    private int mod_format;

    public Event(int _id, int _eventTimeStart, String _event_type, Double _req, int _src, int _dest){
        eventTimeStart = _eventTimeStart;
        req_bandwidth = _req;
        eventType = _event_type;
        source = _src;
        dest = _dest;
        id = _id;

    }

    public String toString(){
        return id + "," + source + "," + dest;
    }
}

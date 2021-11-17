package com.example.UpgradeSpectrumUtilization;
import org.apache.commons.math3.analysis.function.Constant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
/**
 * Created by roiya on 3/9/20.
 */
public class ReadTopo {static public void readTopoFromFile(String fileName, Topology topo) throws IOException {
    ArrayList<Link> links = new ArrayList<Link>();
    ArrayList<Node> nodes = new ArrayList<Node>();
    topo.adjMatrix = new Vector[Constants.num_nodes][Constants.num_nodes];

    for (int i = 0; i < Constants.num_nodes; i++)
        for (int j = 0; j < Constants.num_nodes; j++) {
            topo.adjMatrix[i][j] = new Vector();
            topo.adjMatrix[i][j].addElement("0");
            topo.adjMatrix[i][j].addElement(new Object());
        }

    topo.pathMatrix = new Vector[Constants.num_nodes][Constants.num_nodes];
    for (int i = 0; i < Constants.num_nodes; i++)
        for (int j = 0; j < Constants.num_nodes; j++) {
            topo.pathMatrix[i][j] = new Vector();
            topo.pathMatrix[i][j].addElement(0);
            for(int k=0; k< Constants.maximum_path; k++)
                topo.pathMatrix[i][j].addElement(new Path());
        }

    boolean nodeisdone = false;

        FileReader f_read = new FileReader(fileName);
        BufferedReader b_read = new BufferedReader(f_read);


        while (b_read.ready()) {
            String line = b_read.readLine();
            if (line.equals("") || line.startsWith("#"))
                continue; // ignores blank lines

            String[] parts = line.split(",");
        if (parts.length == 5) {
            int source = Integer.parseInt(parts[0]);
            int dest = Integer.parseInt(parts[1]);
            //int typ = Integer.parseInt(parts[2]);
            double cap = Integer.parseInt(parts[3]);
            double length = Integer.parseInt(parts[4]);

            if (topo.linkExists(source, dest))
                continue;
            Link newLink = new Link(source, dest, cap, length);
            links.add(newLink);
            topo.adjMatrix[source][dest].set(0, "1");
            topo.adjMatrix[source][dest].set(1, newLink);

            Link newLinkReverse = new Link(dest, source, cap, length);
            links.add(newLinkReverse);
            topo.adjMatrix[dest][source].set(0, "1");
            topo.adjMatrix[dest][source].set(1, newLinkReverse);
        } else if (parts.length == 1) {
            int nodeid = Integer.parseInt(parts[0]);
            nodes.add(new Node(nodeid, 0, 0));
        }
    }

    topo.allLinks = new Link[Constants.num_links];
    topo.allNodes = new Node[Constants.num_nodes];

    for (int i = 0; i < topo.allLinks.length; i++) {
        topo.allLinks[i] = links.get(i);
        //System.out.println(allLinks[i].startNodeID + "-" + allLinks[i].endNodeID);
    }
    for (int i = 0; i < topo.allNodes.length; i++) {
        topo.allNodes[i] = nodes.get(i);
        //System.out.println(allNodes[i].nodeID + "-" + allNodes[i].xcoord + "-" + allNodes[i].ycoord);
    }
    topo.numNodes = topo.allNodes.length;
    //calculateLinkLengths(topo);

//		for (int i = 0; i < 14; i++) {
//
//			System.out.print("Neighbors of node " + i);
//
//			for (int j = 0; j < 14; j++) {
//				if (topo.adjMatrix[i][j].elementAt(0) == "1")
//					System.out.print(" " + j + " ");
//
//			}
//			System.out.println();
//		}
}
}

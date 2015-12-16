package com.network.heuristic;

/**
 * Created by Администратор on 21.09.2015.
 */
public class HeuristicNodePair {
    public HeuristicNode firstNode;
    public HeuristicNode secondNode;
    public double mutualInformation;

    public  HeuristicNodePair() {

    }

    public HeuristicNodePair(HeuristicNode h1, HeuristicNode h2, double mi) {
        firstNode = h1;
        secondNode = h2;
        mutualInformation = mi;
    }

}

package com.network.heuristic;

import com.network.util.NodeRelations;

/**
 * Created by Taran on 12.11.2015.
 */
public class FourNodes {
    HeuristicNode first;
    HeuristicNode second;
    NodeRelations firstToSecondRelations;
    HeuristicNode third;
    NodeRelations thirdToFourthRelations;
    HeuristicNode fourth;

    public FourNodes(HeuristicNode first, HeuristicNode second, HeuristicNode third, HeuristicNode fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }

    public FourNodes(HeuristicNode first, HeuristicNode second, NodeRelations firstToSecondRelations, HeuristicNode third, NodeRelations thirdToFourthRelations, HeuristicNode fourth) {
        this.first = first;
        this.second = second;
        this.firstToSecondRelations = firstToSecondRelations;
        this.third = third;
        this.thirdToFourthRelations = thirdToFourthRelations;
        this.fourth = fourth;
    }
}

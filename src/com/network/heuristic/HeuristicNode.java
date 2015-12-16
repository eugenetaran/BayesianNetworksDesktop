package com.network.heuristic;

import com.network.common.AbstractNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 21.09.2015.
 */
public class HeuristicNode extends AbstractNode {

    public HeuristicNode(String name) {
        this.name = name;
    }

    private List<HeuristicLink> heuristicLinks = new ArrayList<HeuristicLink>();

    public List<HeuristicLink> getHeuristicLinks() {
        return heuristicLinks;
    }

    public void setHeuristicLinks(List<HeuristicLink> heuristicLinks) {
        this.heuristicLinks = heuristicLinks;
    }
}

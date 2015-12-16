package com.network.common;

import java.util.List;

/**
 * Created by Администратор on 24.09.2015.
 */
public abstract class AbstractNode {
    protected String name;
    protected List<AbstractNode> directedNodes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AbstractNode> getDirectedNodes() {
        return directedNodes;
    }

    public void setDirectedNodes(List<AbstractNode> directedNodes) {
        this.directedNodes = directedNodes;
    }
}

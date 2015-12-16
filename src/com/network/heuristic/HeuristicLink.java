package com.network.heuristic;

/**
 * Created by Администратор on 21.09.2015.
 */
public class HeuristicLink {
    private HeuristicNode selectedHeuristicNode;
    private double MI;
    private double MDL;
    private boolean created = false;

    public double getMDL() {
        return MDL;
    }

    public void setMDL(double MDL) {
        this.MDL = MDL;
    }

    public HeuristicNode getSelectedHeuristicNode() {
        return selectedHeuristicNode;
    }

    public void setSelectedHeuristicNode(HeuristicNode selectedHeuristicNode) {
        this.selectedHeuristicNode = selectedHeuristicNode;
    }

    public double getMI() {
        return MI;
    }

    public void setMI(double MI) {
        this.MI = MI;
    }

    public boolean isCreated() {
        return created;
    }

    public void setCreated(boolean created) {
        this.created = created;
    }
}

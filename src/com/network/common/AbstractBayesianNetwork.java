package com.network.common;

import java.util.List;

/**
 * Created by Администратор on 21.09.2015.
 */
public abstract class AbstractBayesianNetwork {

    private DataTable dataTable;
    private List<AbstractNode> abstractNodes;

    public abstract void createBayesianNetwork();
    public abstract void doBayesianNetworkIteration();
    public abstract void addExpertOpinion();
    public abstract List<AbstractNode> getAbstractNodes();
    //public abstract void loadDataFromFile();
    public abstract void loadDataFromProgram();

    public DataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(DataTable dataTable) {
        this.dataTable = dataTable;
    }

    public void setAbstractNodes(List<AbstractNode> abstractNodes) {
        this.abstractNodes = abstractNodes;
    }
}

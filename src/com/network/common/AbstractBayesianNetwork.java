package com.network.common;

import java.lang.String;
import java.util.List;

/**
 * Created by Администратор on 21.09.2015.
 */
public abstract class AbstractBayesianNetwork {

    protected int[][] eventsTable;
    protected String[] eventsNames;

    public abstract void createBayesianNetwork();
    public abstract void doBayesianNetworkIteration();
    public abstract void addExpertOpinion();
    public abstract List<AbstractNode> getAbstractNodes();
    //public abstract void loadDataFromFile();
    public abstract void loadDataFromProgram();

}

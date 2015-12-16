package com.network.heuristic;

import com.network.common.AbstractBayesianNetwork;
import com.network.common.AbstractNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 21.09.2015.
 */
public class HeuristicBayesianNetwork extends AbstractBayesianNetwork {

    List<HeuristicNode> heuristicNodes = new ArrayList<HeuristicNode>();
    HeuristicDataTable hdt;
    //List<HeuristicNodePair> hdt.getMutualInformationTable() = new ArrayList<HeuristicNodePair>();

    @Override
    public void createBayesianNetwork() {
        fillMutualInformationTable();
        while(true) {
            doBayesianNetworkIteration();
        }
    }

    @Override
    public void doBayesianNetworkIteration() {
        int[] firstPair = foundBestMutualInformationPair();
        int[] secondPair = foundBestMutualInformationPair();
        //TwoNodePairs twoNodePairs = foundBestMutualInformationPairs();
        //buildBestLinks(twoNodePairs);
    }

    @Override
    public void addExpertOpinion() {

    }

    @Override
    public List<AbstractNode> getAbstractNodes() {
        List<AbstractNode> abstractNodes = new ArrayList<AbstractNode>();
        for (int i = 0; i < heuristicNodes.size(); i++) {
            abstractNodes.add((AbstractNode) heuristicNodes.get(i));
        }
        return abstractNodes;
    }

    @Override
    public void loadDataFromProgram() {
        int[][] eventTable = {{1, 1, 0},
                {1, 0, 1},
                {0, 1, 1}};
        HeuristicDataTable dt = new HeuristicDataTable();

        String names[] = {"A", "B", "C"};
        for (int i = 0; i < getDataTable().getEventsNames().length; i++) {
            heuristicNodes.add(new HeuristicNode(names[i]));
        }
        dt.setEventsNames(names);
        dt.setAdjacencyMatrix(new int[names.length][names.length]);
        hdt = dt;
    }

    private void fillMutualInformationTable() {
        hdt.setUsedPairs(new boolean[getDataTable().getEventsNames().length][getDataTable().getEventsNames().length]);
        hdt.setMutualInformationTable(new double[getDataTable().getEventsNames().length][getDataTable().getEventsNames().length]);
        for(int i = 0; i < getDataTable().getEventsNames().length; i++) {
            for(int j = i + 1; j < getDataTable().getEventsNames().length; j++) {
                double iFreq = calculateFrequency(i) / (double) getDataTable().getEventsTable().length;
                double jFreq = calculateFrequency(j) / (double) getDataTable().getEventsTable().length;
                double ijFreq = calculatePairFrequency(i,j) / (double) getDataTable().getEventsTable().length;
                double ijMI =  ijFreq * Math.log(ijFreq / (iFreq * jFreq));
                hdt.getMutualInformationTable()[i][j] = ijMI;
            }
        }
    }

    private int[] foundBestMutualInformationPair() {
        HeuristicNodePair maxMIpair = null;
        double maxMI = 0;
        int maxI = 0,maxJ = 0;
        for(int i = 0; i < hdt.getMutualInformationTable().length; i++) {
            for (int j = 0; j < hdt.getMutualInformationTable().length; j++) {
                if (hdt.getMutualInformationTable()[i][j] > maxMI && !hdt.getUsedPairs()[i][j]) {
                    maxI = i;
                    maxJ = j;
                    maxMI = hdt.getMutualInformationTable()[i][j];
                }
            }
        }
        hdt.getUsedPairs()[maxI][maxJ] = true;
        return new int[] {maxI, maxJ};
    }

    private int calculateFrequency(int k) {
        int res = 0;
        for (int col = 0; col < getDataTable().getEventsTable().length; col++) {
            res += getDataTable().getEventsTable()[col][k];
        }
        return res;
    }

    private int calculatePairFrequency(int i, int j) {
        int res = 0;
        for (int col = 0; col < getDataTable().getEventsTable().length; col++) {
            if (getDataTable().getEventsTable()[col][i] == 1 && getDataTable().getEventsTable()[col][j] == 1) {
                res += 1;
            }
        }
        return res;
    }

    private void buildBestLinks(TwoNodePairs twoNodePairs) {
        //TwoNodePairs calculatedPairs = calculateMDL(twoNodePairs);
        HeuristicNode a1 = new HeuristicNode("7");
        HeuristicNode a2 = new HeuristicNode("8");
        HeuristicNode a3 = new HeuristicNode("2");
        HeuristicNode a4 = new HeuristicNode("4");
        FourNodes fourNodes = new FourNodes(a1,a2,a3,a4);
        // HeuristicNodePair hnp = new HeuristicNodePair(a1,a2,0.251);
        //HeuristicNodePair hnp2 = new HeuristicNodePair(a3,a4,0.251);

    }

    //MDL - minimum description length
    private TwoNodePairs calculateMDL(TwoNodePairs twoNodePairs) {
        return new TwoNodePairs();
    }

    private class TwoNodePairs {
        HeuristicNodePair firstPair;
        HeuristicNodePair secondPair;
    }
}

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
    //List<HeuristicNodePair> mutualInformationTable = new ArrayList<HeuristicNodePair>();
    double[][] mutualInformationTable;
    boolean[][] usedPairs;
    int[][] adjacencyMatrix;


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
        this.eventsTable = eventTable;
        String names[] = {"A", "B", "C"};
        this.eventsNames = names;
        for (int i = 0; i < eventsNames.length; i++) {
            heuristicNodes.add(new HeuristicNode(names[i]));
        }
        adjacencyMatrix = new int[names.length][names.length];
    }

    private void fillMutualInformationTable() {
        usedPairs = new boolean[eventsNames.length][eventsNames.length];
        mutualInformationTable = new double[eventsNames.length][eventsNames.length];
        for(int i = 0; i < eventsNames.length; i++) {
            for(int j = i + 1; j < eventsNames.length; j++) {
                double iFreq = calculateFrequency(i) / (double) eventsTable.length;
                double jFreq = calculateFrequency(j) / (double) eventsTable.length;
                double ijFreq = calculatePairFrequency(i,j) / (double) eventsTable.length;
                double ijMI =  ijFreq * Math.log(ijFreq / (iFreq * jFreq));
                mutualInformationTable[i][j] = ijMI;
            }
        }
    }

    private int[] foundBestMutualInformationPair() {
        HeuristicNodePair maxMIpair = null;
        double maxMI = 0;
        int maxI = 0,maxJ = 0;
        for(int i = 0; i < mutualInformationTable.length; i++) {
            for (int j = 0; j < mutualInformationTable.length; j++) {
                if (mutualInformationTable[i][j] > maxMI && !usedPairs[i][j]) {
                    maxI = i;
                    maxJ = j;
                    maxMI = mutualInformationTable[i][j];
                }
            }
        }
        usedPairs[maxI][maxJ] = true;
        return new int[] {maxI, maxJ};
    }

    private int calculateFrequency(int k) {
        int res = 0;
        for (int col = 0; col < eventsTable.length; col++) {
            res += eventsTable[col][k];
        }
        return res;
    }

    private int calculatePairFrequency(int i, int j) {
        int res = 0;
        for (int col = 0; col < eventsTable.length; col++) {
            if (eventsTable[col][i] == 1 && eventsTable[col][j] == 1) {
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

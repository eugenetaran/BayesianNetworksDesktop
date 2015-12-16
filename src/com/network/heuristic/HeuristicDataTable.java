package com.network.heuristic;

import com.network.common.DataTable;

/**
 * Created by Taran on 16.12.2015.
 */
public class HeuristicDataTable extends DataTable {

    double[][] mutualInformationTable;
    boolean[][] usedPairs;
    int[][] adjacencyMatrix;

    public double[][] getMutualInformationTable() {
        return mutualInformationTable;
    }

    public void setMutualInformationTable(double[][] mutualInformationTable) {
        this.mutualInformationTable = mutualInformationTable;
    }

    public boolean[][] getUsedPairs() {
        return usedPairs;
    }

    public void setUsedPairs(boolean[][] usedPairs) {
        this.usedPairs = usedPairs;
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public void setAdjacencyMatrix(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
    }
}

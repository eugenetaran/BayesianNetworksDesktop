package com.network.common;

import java.util.Map;
import java.util.Set;

/**
 * Created by Taran on 17.12.2015.
 */
public class NodeProbabilityTable {
    private Map<Set<String>, Double> probabilities;

    public Map<Set<String>, Double> getProbabilities() {
        return probabilities;
    }

    public void setProbabilities(Map<Set<String>, Double> probabilities) {
        this.probabilities = probabilities;
    }
}

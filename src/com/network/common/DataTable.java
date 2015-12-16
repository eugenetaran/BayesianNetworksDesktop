package com.network.common;

/**
 * Created by Taran on 16.12.2015.
 */
public class DataTable {

    protected int[][] eventsTable;
    protected String[] eventsNames;

    public int[][] getEventsTable() {
        return eventsTable;
    }

    public void setEventsTable(int[][] eventsTable) {
        this.eventsTable = eventsTable;
    }

    public String[] getEventsNames() {
        return eventsNames;
    }

    public void setEventsNames(String[] eventsNames) {
        this.eventsNames = eventsNames;
    }
}

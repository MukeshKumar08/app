package com.gg.gg.search.Dashboard_Milk.Milk_Data;

public class MilkData {

    private int statuscode;
    private String description;

    public MilkData(int statuscode, String description) {
        this.statuscode = statuscode;
        this.description = description;
    }

    public int getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

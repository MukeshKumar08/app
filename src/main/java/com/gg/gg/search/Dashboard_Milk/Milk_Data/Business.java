package com.gg.gg.search.Dashboard_Milk.Milk_Data;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Business {

    @SerializedName("businessId")
    @Expose
    private Integer businessId;
    @SerializedName("businessName")
    @Expose
    private String businessName;
    @SerializedName("status")
    @Expose
    private Object status;

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Business{" +
                "businessId=" + businessId +
                ", businessName='" + businessName + '\'' +
                ", status=" + status +
                '}';
    }
}




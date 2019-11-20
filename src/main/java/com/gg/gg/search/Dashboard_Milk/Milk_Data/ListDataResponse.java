package com.gg.gg.search.Dashboard_Milk.Milk_Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListDataResponse {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("pincode")
    @Expose
    private String pincode;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;

    public ListDataResponse(String name, String city, String state, String country, String pincode, String address, String email, String password, Double latitude, Double longitude) {
        this.name = name;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
        this.address = address;
        this.email = email;
        this.password = password;
        this.latitude = latitude;
        this.longitude = longitude;
    }

//    public ListDataResponse(String name, String city, String state, String country, String pincode, String address, String email, String password, String s, String s1) {
//
//    }
//
//    public ListDataResponse(ListDataResponse listDataResponse) {
//
//    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getPincode() {
        return pincode;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}

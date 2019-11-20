package com.gg.gg.User_registration.User_Data;

public class UserRegData {
    int StatusCode;
    String description;

    public UserRegData(int statusCode, String description) {
        StatusCode = statusCode;
        this.description = description;
    }

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int statusCode) {
        StatusCode = statusCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

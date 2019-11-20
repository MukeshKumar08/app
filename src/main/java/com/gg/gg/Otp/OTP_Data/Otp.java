package com.gg.gg.Otp.OTP_Data;

public class Otp {

    int statusCode;
    String Description;

    public Otp(int statusCode, String description) {
        this.statusCode = statusCode;
        Description = description;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}

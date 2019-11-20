package com.gg.gg.Otp.OTP_Data;

public class OtpData {

    private int phoneNumber;
    private String description;
    private int status;

    public OtpData(int phoneNumber, String description, int status) {
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.status = status;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

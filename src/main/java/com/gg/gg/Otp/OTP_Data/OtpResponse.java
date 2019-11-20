package com.gg.gg.Otp.OTP_Data;

public class OtpResponse {

  String phoneNumber;
  int otp;

    public OtpResponse(String phoneNumber, int otp) {
        this.phoneNumber = phoneNumber;
        this.otp = otp;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    public String setOtp() {
        return null;
    }

    public String setPhoneNumber() {
        return null;
    }
}

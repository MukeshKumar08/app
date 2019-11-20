package com.gg.gg.Otp.OTP_Model;

import com.gg.gg.Otp.OTP_Data.Otp;
import com.gg.gg.Otp.OTP_Data.OtpData;
import com.gg.gg.Otp.OTP_Data.OtpResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface OtpInterface {


//    @GET("validate_otp/827299/+917598193103")

    @GET
    Call<OtpData> sendOpt(@Url String url,@Query("") String phoneNumber);



}

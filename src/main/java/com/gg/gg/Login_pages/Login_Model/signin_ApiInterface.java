package com.gg.gg.Login_pages.Login_Model;

import com.gg.gg.Login_pages.Login_Data.Mobile;
import com.gg.gg.Login_pages.Login_Data.UserData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface signin_ApiInterface {


    @POST("generate_otp")
    Call<UserData> sendOtp(@Body Mobile mobile);


}

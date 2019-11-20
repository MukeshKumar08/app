package com.gg.gg.User_registration.User_Model;

import com.gg.gg.Login_pages.Login_Data.UserData;
import com.gg.gg.User_registration.User_Data.user;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserInterface {

    @POST("user")
    Call<UserData> sendUser(@Body user user);


}

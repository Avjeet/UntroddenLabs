package com.example.android.untroddentestproject.MSG91;

import com.example.android.untroddentestproject.RealmModels.UTModel;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Your name on 01-12-2018.
 */
public interface MSG91api {

   @POST("/api/sendotp.php")
    Call<UTModel> sendMessage(@Query("authkey") String auth_key, @Query("message") String message, @Query("sender") String sender, @Query("mobile") String mobile, @Query("otp") String otp);
}

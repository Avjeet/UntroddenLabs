package com.example.android.untroddentestproject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Avjeet on 01-12-2018.
 */
public class MSG91APIAdapter {
    private static final String URL = "http://control.msg91.com";
    private static Retrofit retrofit;

    public static Retrofit getAdapter(){
        if(retrofit==null){
            Gson gson = new GsonBuilder().setLenient().create();
            retrofit = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        }
        return retrofit;
    }
}

package com.example.android.untroddentestproject;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by Avjeet on 29-12-2018.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}

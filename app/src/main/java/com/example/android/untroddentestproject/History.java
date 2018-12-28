package com.example.android.untroddentestproject;

import io.realm.RealmObject;

/**
 * Created by Your name on 29-12-2018.
 */
public class History extends RealmObject {

    public History(String contact, Long time) {
        this.contact = contact;
        this.time = time;
    }

    public History() {
    }

    public String getContact() {
        return contact;
    }


    private String contact;

    public Long getTime() {
        return time;
    }


    private Long time;
}

package com.example.android.untroddentestproject.RealmModels;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Your name on 28-12-2018.
 */
public class UTModel extends RealmObject {


    @PrimaryKey
    int position;

    String name;
    String contact;
    String address;
    String gender;

    public UTModel(int pos, String name, String contact, String address, String gender) {
        this.position = pos;
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.gender = gender;
    }

    public UTModel() {
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }


}

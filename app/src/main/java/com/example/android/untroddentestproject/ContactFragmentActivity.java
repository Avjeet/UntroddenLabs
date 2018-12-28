package com.example.android.untroddentestproject;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import io.realm.Realm;

public class ContactFragmentActivity extends AppCompatActivity {

    private UTPagerAdapter utpagerAdapter;
    ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_fragment);

        utpagerAdapter = new UTPagerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.view_pager);

        viewPager.setAdapter(utpagerAdapter);

        tabLayout =  findViewById(R.id.tab_layout);

        tabLayout.setupWithViewPager(viewPager);
    }


}

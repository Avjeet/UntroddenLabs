package com.example.android.untroddentestproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import io.realm.Realm;

public class OTPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        Realm realm = Realm.getDefaultInstance();

        UTModel entry = realm.where(UTModel.class).equalTo("position",getIntent().getIntExtra("position",0)).findFirst();

        TextView nameTV = findViewById(R.id.name);
        final TextView contactTV = findViewById(R.id.contact);
        TextView addressTV = findViewById(R.id.address);
        TextView genderTV = findViewById(R.id.gender);
        Button proceed = findViewById(R.id.proceedBtn);

        nameTV.setText(entry.getName());
        contactTV.setText(entry.getContact());
        addressTV.setText(entry.getAddress());
        genderTV.setText(entry.getGender());

        TextView otpTv = findViewById(R.id.otp);

        Random rnd = new Random();
        int n = 100000 + rnd.nextInt(900000);

        final String otpValue = String.valueOf(n);

        otpTv.setText(otpValue);

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OTPActivity.this,MessageActivity.class);
                intent.putExtra("mobile",contactTV.getText());
                intent.putExtra("otp",otpValue);
                startActivity(intent);
                finish();
            }
        });
    }
}

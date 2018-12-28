package com.example.android.untroddentestproject;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.POST;

public class MessageActivity extends AppCompatActivity {

    private static final String AUTH_KEY = "253998A1dSb8GC5c2639da";

    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        String otp = getIntent().getStringExtra("otp");
        final String mobile = getIntent().getStringExtra("mobile");


        ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);

        button = findViewById(R.id.button);

        editText = findViewById(R.id.editText);



        button.setOnClickListener(v -> {
            button.setClickable(false);
            button.setBackgroundColor(ContextCompat.getColor(MessageActivity.this,android.R.color.holo_blue_dark));
            progressBar.setVisibility(View.VISIBLE);
            progressBar.setIndeterminate(true);



            String message = "Your OTP is " + otp + ". " + editText.getText();

            MSG91api msg91APIAdapter = MSG91APIAdapter.getAdapter().create(MSG91api.class);
            Call<UTModel>  call = msg91APIAdapter.sendMessage(AUTH_KEY,message,"TESTIN",mobile,otp);

            Log.i("URL",call.request().url().toString());
            call.enqueue(new Callback<UTModel>() {
                @Override
                public void onResponse(Call<UTModel> call, Response<UTModel> response) {
                    Log.d("Req",String.valueOf(response.code()));
                    if (response.code() == 200) {
                        Toast.makeText(MessageActivity.this, "Otp Sent", Toast.LENGTH_SHORT).show();

                        Realm  realm = Realm.getDefaultInstance();

                        History data = new History(mobile,System.currentTimeMillis());

                        realm.beginTransaction();
                        realm.copyToRealm(data);
                        realm.commitTransaction();

                    }
                    finish();
                }

                @Override
                public void onFailure(Call<UTModel> call, Throwable t) {
                    Log.d("Req","Failure");
                }
            });
        });
    }
}

package com.example.mysomm;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(com.example.mysomm.SplashScreen.this, ProfileSetUp.class);
                startActivity(i);
                finish();
            }
        }, 5000);



    }
}
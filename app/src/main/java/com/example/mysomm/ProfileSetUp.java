package com.example.mysomm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileSetUp extends AppCompatActivity {

    private Button loginButton , signUpButton,guestLoginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        loginButton = findViewById(R.id.singupbtn);
        signUpButton = findViewById(R.id.lognbtn);
        guestLoginButton = findViewById(R.id.guestLogin);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(com.example.mysomm.ProfileSetUp.this , LoginActivity.class));
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(com.example.mysomm.ProfileSetUp.this , SignUp.class));
            }
        });

        guestLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(com.example.mysomm.ProfileSetUp.this , HomePage.class));
            }
        });

    }
}
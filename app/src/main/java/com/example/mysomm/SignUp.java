package com.example.mysomm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {

    private EditText emailSignUp , usernameSignUp , passwordSignUp;
    private Button signUpButton;
    private DataBaseHelperProfileSU myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        emailSignUp = findViewById(R.id.signupemail);
        usernameSignUp = findViewById(R.id.signupusername);
        passwordSignUp = findViewById(R.id.siguppassword);

        signUpButton = findViewById(R.id.signupbutton);

        myDB = new DataBaseHelperProfileSU(this);
        insertUser();
    }

    private void insertUser(){
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean var = myDB.registerUser(usernameSignUp.getText().toString() , emailSignUp.getText().toString() , passwordSignUp.getText().toString());
                if(var){
                    Toast.makeText(com.example.mysomm.SignUp.this, "User Registered Successfully !!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(com.example.mysomm.SignUp.this , ProfileSetUp.class));
                    finish();
                }
                else {
                    Toast.makeText(com.example.mysomm.SignUp.this, "Registration Error !!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
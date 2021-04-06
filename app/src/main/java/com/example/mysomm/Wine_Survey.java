package com.example.mysomm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Wine_Survey extends AppCompatActivity {

    private RadioGroup radioSweetGroup;
    private RadioButton radioSweetButton;

    private RadioGroup radioPriceGroup;
    private RadioButton radioPriceButton;

    private RadioGroup radioAcidGroup;
    private RadioButton radioAcidButton;

    private RadioGroup radioColorGroup;
    private RadioButton radioColorButton;

    private RadioGroup radioBodyGroup;
    private RadioButton radioBodyButton;

    private Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine__survey);

    }

    public void openSurveyWines()
    {

    }


}
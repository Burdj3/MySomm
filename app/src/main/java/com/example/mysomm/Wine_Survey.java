package com.example.mysomm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Wine_Survey extends AppCompatActivity {

    private RadioGroup radioSweetGroup;
    private RadioButton radioSweetButton;
    private int Sweet;

    private RadioGroup radioPriceGroup;
    private RadioButton radioPriceButton;
    private int Price;

    private RadioGroup radioAcidGroup;
    private RadioButton radioAcidButton;
    private int Acid;

    private RadioGroup radioColorGroup;
    private RadioButton radioColorButton;
    private String Color;

    private RadioGroup radioBodyGroup;
    private RadioButton radioBodyButton;
    private int Body;

    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine__survey);

        radioSweetGroup = findViewById(R.id.rgSweet);
        radioPriceGroup = findViewById(R.id.rgPrice);
        radioAcidGroup = findViewById(R.id.rgAcid);
        radioColorGroup = findViewById(R.id.rgColor);
        radioBodyGroup = findViewById(R.id.rgBody);

        submitButton = findViewById(R.id.button2);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int sweetSelectedID = radioSweetGroup.getCheckedRadioButtonId();
                radioSweetButton = findViewById(sweetSelectedID);
                String sweetText = radioSweetButton.getText().toString();
                //Toast.makeText(v.getContext(), text, Toast.LENGTH_SHORT).show();

                if (sweetText.matches("Dry"))
                {
                    Sweet = 1;
                    Toast.makeText(v.getContext(), "Dry was picked", Toast.LENGTH_SHORT).show();
                }

                else if (sweetText.matches("Between"))
                {
                    Sweet = 2;
                    Toast.makeText(v.getContext(), "Between was picked", Toast.LENGTH_SHORT).show();
                }

                else if (sweetText.matches("Sweet"))
                {
                    Sweet = 3;
                    Toast.makeText(v.getContext(), "Sweet was picked", Toast.LENGTH_SHORT).show();
                }

                else if (sweetText.matches("Don't Care"))
                {
                    //Sweet = 0;
                }


                int priceSelectedID = radioPriceGroup.getCheckedRadioButtonId();
                radioPriceButton = findViewById(priceSelectedID);
                String priceText = radioPriceButton.getText().toString();

                if (priceText.matches("$10"))
                {
                    Price = 10;
                }

                else if (priceText.matches("$50"))
                {
                    Price = 50;
                }

                else if (priceText.matches("Any"))
                {
                    //Price = 0;
                }

                int acidSelectedID = radioAcidGroup.getCheckedRadioButtonId();
                radioAcidButton = findViewById(acidSelectedID);
                String acidText = radioAcidButton.getText().toString();

                if (acidText.matches("Not"))
                {
                    Price = 1;
                }

                else if (acidText.matches("Somewhat"))
                {
                    Price = 2;
                }

                else if (acidText.matches("Very"))
                {
                    Price = 3;
                }

                else if (acidText.matches("Don't Care"))
                {
                    //Price = 0;
                }

                int colorSelectedID = radioColorGroup.getCheckedRadioButtonId();
                radioColorButton = findViewById(colorSelectedID);
                String colorText = radioColorButton.getText().toString();

                if (colorText.matches("White"))
                {
                    Color = "White";
                }

                else if (colorText.matches("Red"))
                {
                    Color = "Red";
                }

                else if (colorText.matches("Either"))
                {
                    //Color = ""
                }

                int bodySelectedID = radioBodyGroup.getCheckedRadioButtonId();
                radioBodyButton = findViewById(bodySelectedID);
                String bodyText = radioBodyButton.getText().toString();

                if (bodyText.matches("Light"))
                {
                    Body = 1;
                }

                else if (bodyText.matches("Medium"))
                {
                    Body = 2;
                }

                else if (bodyText.matches("Heavy"))
                {
                    Body = 3;
                }

                else if (bodyText.matches("Don't Care"))
                {
                    //Price = 0;
                }

            }
        });
    }


}
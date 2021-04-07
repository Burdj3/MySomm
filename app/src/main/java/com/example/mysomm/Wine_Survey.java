package com.example.mysomm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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
    public static final String EXTRA_SWEET = "com.example.application.mysomm.EXTRA_SWEET";

    private RadioGroup radioPriceGroup;
    private RadioButton radioPriceButton;
    public static final String EXTRA_PRICE = "com.example.application.mysomm.EXTRA_PRICE";

    private RadioGroup radioAcidGroup;
    private RadioButton radioAcidButton;
    public static final String EXTRA_ACID = "com.example.application.mysomm.EXTRA_ACID";

    private RadioGroup radioColorGroup;
    private RadioButton radioColorButton;
    public static final String EXTRA_COLOR = "com.example.application.mysomm.EXTRA_COLOR";

    private RadioGroup radioBodyGroup;
    private RadioButton radioBodyButton;
    public static final String EXTRA_BODY = "com.example.application.mysomm.EXTRA_BODY";

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


                int priceSelectedID = radioPriceGroup.getCheckedRadioButtonId();
                radioPriceButton = findViewById(priceSelectedID);
                String priceText = radioPriceButton.getText().toString();


                int acidSelectedID = radioAcidGroup.getCheckedRadioButtonId();
                radioAcidButton = findViewById(acidSelectedID);
                String acidText = radioAcidButton.getText().toString();


                int colorSelectedID = radioColorGroup.getCheckedRadioButtonId();
                radioColorButton = findViewById(colorSelectedID);
                String colorText = radioColorButton.getText().toString();


                int bodySelectedID = radioBodyGroup.getCheckedRadioButtonId();
                radioBodyButton = findViewById(bodySelectedID);
                String bodyText = radioBodyButton.getText().toString();


                openWineSurveyResults(sweetText,priceText,acidText,colorText,bodyText);
            }
        });
    }


    public void openWineSurveyResults(String swt, String prc, String acd, String clr, String bdy)
    {
        Intent intent = new Intent(this, WineSurveyResults.class);
        intent.putExtra(EXTRA_SWEET, swt);
        intent.putExtra(EXTRA_PRICE, prc);
        intent.putExtra(EXTRA_ACID, acd);
        intent.putExtra(EXTRA_COLOR, clr);
        intent.putExtra(EXTRA_BODY, bdy);
        startActivity(intent);
    }

}
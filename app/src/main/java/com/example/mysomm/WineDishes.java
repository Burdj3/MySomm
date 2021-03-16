package com.example.mysomm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WineDishes extends AppCompatActivity {

    private Button chickenButton;
    private Button beefButton;
    private Button fishButton;
    private Button turkeyButton;
    private Button dessertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine_dishes);

        chickenButton = findViewById(R.id.chickenButton);
        beefButton = findViewById(R.id.beefButton);
        fishButton = findViewById(R.id.fishButton);
        turkeyButton = findViewById(R.id.turkeyButton);
        dessertButton = findViewById(R.id.desertButton);

        chickenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWineRecommendations();
            }
        });
    }

    public void openWineRecommendations()
    {
        Intent intent2 = new Intent(this, WineRecommendations.class);
        startActivity(intent2);
    }
}
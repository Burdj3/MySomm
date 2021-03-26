package com.example.mysomm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WineDishes extends AppCompatActivity {

    private Button whiteMeatButton;
    private Button redMeatButton;
    private Button fishButton;
    private Button starchButton;
    private Button dessertButton;
    private Button cheesesButton;
    private Button shellFishButton;
    private Button curedMeatButton;
    private Button vegButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine_dishes);

        whiteMeatButton = findViewById(R.id.whiteMeatButton);
        redMeatButton = findViewById(R.id.redMeatButton);
        fishButton = findViewById(R.id.fishButton);
        starchButton = findViewById(R.id.starchButton);
        dessertButton = findViewById(R.id.desertButton);
        cheesesButton = findViewById(R.id.cheeseButton);
        shellFishButton = findViewById(R.id.shellFishButton);
        curedMeatButton = findViewById(R.id.curedMeatButton);
        vegButton = findViewById(R.id.vegetablesButton);

        whiteMeatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChickenWineRecommendations();
            }
        });

        redMeatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBeefWineRecommendations();
            }
        });

        fishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFishWineRecommendations();
            }
        });
    }

    public void openChickenWineRecommendations()
    {
        Intent intent = new Intent(this, ChickenWineRecommendations.class);
        startActivity(intent);
    }

    public void openBeefWineRecommendations()
    {
        Intent intent = new Intent(this, BeefWineRecommendations.class);
        startActivity(intent);
    }

    public void openFishWineRecommendations()
    {
        Intent intent = new Intent(this, FishWineRecommendations.class);
        startActivity(intent);
    }
}
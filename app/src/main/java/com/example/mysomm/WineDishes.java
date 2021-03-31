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
    private Button cheeseButton;
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
        cheeseButton = findViewById(R.id.cheeseButton);
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

        starchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStarchWineRecommendations();
            }
        });

        vegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVegWineRecommendations();
            }
        });

        dessertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDessertWineRecommendations();
            }
        });

        cheeseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCheeseWineRecommendations();
            }
        });

        curedMeatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCuredMeatWineRecommendations();
            }
        });

        shellFishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openShellFishWineRecommendations();
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

    public void openStarchWineRecommendations()
    {
        Intent intent = new Intent(this, StarchWineRecommendations.class);
        startActivity(intent);
    }

    public void openVegWineRecommendations()
    {
        Intent intent = new Intent(this, VegWineRecommendations.class);
        startActivity(intent);
    }

    public void openDessertWineRecommendations()
    {
        Intent intent = new Intent(this, DessertWineRecommendations.class);
        startActivity(intent);
    }

    public void openCheeseWineRecommendations()
    {
        Intent intent = new Intent(this, CheeseWineRecommendations.class);
        startActivity(intent);
    }

    public void openCuredMeatWineRecommendations()
    {
        Intent intent = new Intent(this, CuredMeatWineRecommendations.class);
        startActivity(intent);
    }

    public void openShellFishWineRecommendations()
    {
        Intent intent = new Intent(this, ShellFishWineRecommendations.class);
        startActivity(intent);
    }
}
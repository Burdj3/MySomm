package com.example.mysomm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button wineDishButton;
    private Button wineCollectionButton;
    private Button wineSurveyButton;

    DbHelper dbHelper = new DbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wineDishButton = findViewById(R.id.wineDishButton);
        wineCollectionButton = findViewById(R.id.wineCollectionButton);
        wineSurveyButton = findViewById(R.id.wineSurveyButton);

        fillDatabase();

        wineDishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWineDishes();
            }
        });

        wineCollectionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWineCollection();
            }
        });
    }

    public void fillDatabase()
    {
        dbHelper.deleteAllRows();
        dbHelper.saveToLocalDatabase("Pacific Rim","Riesling","3","It's pretty good", "1", "White", "Oregon", "3", "10", "https://upload.wikimedia.org/wikipedia/en/c/c0/Red_Wine_Glass.jpg");
        dbHelper.saveToLocalDatabase("Example 2","idk","1","It's alright", "2", "Red", "Texas", "2", "20", "https://d2gg9evh47fn9z.cloudfront.net/800px_COLOURBOX2879719.jpg");
        dbHelper.saveToLocalDatabase("Example 3","Riesling","3","It's pretty good", "1", "White", "Oregon", "3", "10", "https://upload.wikimedia.org/wikipedia/en/c/c0/Red_Wine_Glass.jpg");
        dbHelper.saveToLocalDatabase("Example 4","idk","1","It's alright", "2", "Red", "Texas", "2", "20", "https://d2gg9evh47fn9z.cloudfront.net/800px_COLOURBOX2879719.jpg");
    }

    public void openWineDishes()
    {
        Intent intent = new Intent(this, WineDishes.class);
        startActivity(intent);
    }

    public void openWineCollection()
    {
        Intent intent = new Intent(this, WineDatabaseCollection.class);
        startActivity(intent);
    }
}
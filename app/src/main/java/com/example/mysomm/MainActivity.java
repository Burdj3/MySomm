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
        dbHelper.saveToLocalDatabase("Pacific Rim Sweet Riesling","Riesling","4","Moderately sweet with flavors of pineapple, peach, and hints of honey. The finish is bright and crisp which cleanses the palate and provides good balance to the upfront fruit.", "2", "White", "Columbia Valley, Washington", "3", "9", "https://images.vivino.com/thumbs/uX9zZ6CqS8KIWIGtqK7gGA_pb_x960.png");
        dbHelper.saveToLocalDatabase("Savannah Rosé","Rosé","5","This sweet Rose has bold flavors of strawberry, peaches, and rose petal. Fruit-forward and sweet, this would be the perfect summer and spring drink to sip on all day long!", "1", "Rosé", "Texas", "1", "15", "https://filemanager-dfw.orderport.net/FiestaVineyardWinery/Catalog/40f862a1-c4b0-42b6-9bfb-d19c1b1a9f0d-Large.png?ts=637097745979370000");
        dbHelper.saveToLocalDatabase("Hunt and Harvest Merlot","Merlot","1","The wine has lifted aromatics of red plum, dark cherry, and dusty milk chocolate. The fruit on the palate is bright with satsuma plum and red berries. The finish has touches of bitter dark chocolate.", "3", "White", "Napa Valley, California", "1", "25", "https://images.vivino.com/thumbs/uvX4ikh7QWqoRNHFbLJERA_pb_x600.png");
        dbHelper.saveToLocalDatabase("F Bomb","Red Blend","2","Juicy aromas of strawberry jam, raspberry, and red plum jump out of the glass, with a light framing of toasty vanilla oak.", "3", "Red", "Santa Barbara County, California", "2", "20", "https://images.vivino.com/thumbs/3AR_6eNgSRyJhtu2tvrbAA_pb_x960.png");
        dbHelper.saveToLocalDatabase("Lindeman's Bin 45 Cabernet","Cabernet Sauvignon","1","You can't go wrong with an affordable wine sporting deep color, good tannin structure, moderate acidity and aromas of blackcurrant, tomato leaf, dark spices and cedarwood.", "3", "Red", "Australia", "2", "7", "https://images.vivino.com/thumbs/YIaCtGWfSpOOQ-ZP9AmlOg_pb_x600.png");
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
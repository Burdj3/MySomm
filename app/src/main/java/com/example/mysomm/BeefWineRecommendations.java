package com.example.mysomm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BeefWineRecommendations extends AppCompatActivity {

    private RecyclerView wineRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beef_wine_recommendations);

        wineRecyclerView = findViewById(R.id.beefWineDishRecyclerView);

        ArrayList<Wine> wines = new ArrayList<>();
        wines.add(new Wine("Syrah", "Type: Red", "Taste: Dry", "Syrah is typically bold and full-bodied, with aromatic notes of smoke, black fruit and pepper spice. Stylistically, it can be round and fruity, or dense and tannic."));
        wines.add(new Wine("Extra Brut Rosé", "Type: White", "Taste: Extra Dry", "Bright, fresh and lively, this wine has a touch of warm baking spices, licorice and toasted almonds that plays very nicely with cuts like hangar or skirt steak."));
        wines.add(new Wine("Merlot", "Type: Red", "Taste: Dry", "Merlot's taste has a range of flavors, ranging from graphite, herbs and blackberries, to black cherries, plums, and cocoa, often layered with notes of clove, vanilla, and cedar when aged in oak."));
        wines.add(new Wine("Les Champlots", "Type: White", "Taste: Sweet", "Les Champlots displays notes of nutmeg, sweet confit lemon, citrus zest and praline. On the palate, it's medium to full-bodied, satiny and pure with a fleshy attack that gives way to a more tensile, saline mid-palate and finish."));

        WineRecyclerViewAdapter adapter = new WineRecyclerViewAdapter(this);
        adapter.setWines(wines);

        wineRecyclerView.setAdapter(adapter);
        wineRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

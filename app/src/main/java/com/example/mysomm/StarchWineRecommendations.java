package com.example.mysomm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StarchWineRecommendations extends AppCompatActivity {

    private RecyclerView wineRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starch_wine_recommendations);

        wineRecyclerView = findViewById(R.id.starchWineDishRecyclerView);

        ArrayList<Wine> wines = new ArrayList<>();
        wines.add(new Wine("2013 Chateau Ste. Mechelle & Dr. Loosen Riesling Eroica", "White", "Off-dry riesling", "This never-fail, just off-dry riesling, with its zesty acidity and yellow stone fruit aromas and flavors, is a terrific value, too."));
        wines.add(new Wine("2013 Yalumba Viognier", "White", "Apricot and Pear", "From Australia's premier producer of viognier comes this richly textured but tangy and juicy white, full of tastes of apricot and pear, and a lingering finish."));
        wines.add(new Wine("2012 Maquis Cabernet Sauvignon", "Red", "Moderately Alcoholic and less tannic", "Moderately alcoholic and less tannic than many a cabernet (from any country), this is smooth, aromatic and finishes crisply, unusual for a rich red."));
        wines.add(new Wine("Bogle", "Red", "Cherry and bright cassis", "Deeply extracted cherry and bright cassis arrest the senses, holding captive on both the nose and the palate. Swiftly followed by red currant jam and black pepper, the supple mouthfeel fills out this full-bodied wine. Toasty vanilla from oak ageing heightens the dense fruit.\n" +
                "\n" +
                "The Bogle family takes advantage of many unique growing regions across the state of California. These fields are tended under Bogle’s watchful eye and the fruit harvested from them adds diverse and complex flavors to our wines."));


        WineRecyclerViewAdapter adapter = new WineRecyclerViewAdapter(this);
        adapter.setWines(wines);

        wineRecyclerView.setAdapter(adapter);
        wineRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

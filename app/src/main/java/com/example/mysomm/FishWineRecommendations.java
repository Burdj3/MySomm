// FishWineRecommendation.java
// Srinath Subramanian wrote this code
//

package com.example.mysomm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FishWineRecommendations extends AppCompatActivity {

    private RecyclerView wineRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish_wine_recommendations);

        wineRecyclerView = findViewById(R.id.fishWineDishRecyclerView);

        ArrayList<Wine> wines = new ArrayList<>();
        wines.add(new Wine("Pinos Grigio", "Type: White", "Taste: Dry", "Pinoss Grigio is most commonly described as dry white wines with relatively high acidity. These characteristics are complemented by aromas of lemon, lime, green apple and blossoms."));
        wines.add(new Wine("Roussanne", "Type: White", "Taste: Dry", "The aroma of Roussanne is often reminiscent of a flowery herbal tea. In warm climates, it produces wines of richness, with flavors of honey and pear, and full body."));
        wines.add(new Wine("Champagne", "Type: Sparkling", "Taste: Sweet", "Champagne wines are so subtly aromatic that the effervescence may mask their delicate bouquet."));
        wines.add(new Wine("Cava", "Type: Sparkling", "Taste: Dry", "You'll be surprised to know that Cava is far closer to Champagne (in terms of taste) than Prosecco. If you're looking for value bubbly, Cava might be your bag."));

        WineRecyclerViewAdapter adapter = new WineRecyclerViewAdapter(this);
        adapter.setWines(wines);

        wineRecyclerView.setAdapter(adapter);
        wineRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}


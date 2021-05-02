// StarchWineRecommendation.java
// Nathan Scheffler wrote this code
//

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
        wines.add(new Wine("Cabernet Sauvignon", "Color of Black-Berry", "Highly acidic and savory character", "Its primary flavor is that of black currant, with overtones of several other flavors, like mint, cherry, vanilla, tobacco, and even other overtones, like coffee, spice, cedar, cassis, etc."));
        wines.add(new Wine("Pinor Noir", "Red", "Light Structure", "This light red wine variety goes well with tomato-based pastas because of its lighter structure. Its fragrant, earthy character complements light tomato-based sauces like marinara."));
        wines.add(new Wine("Zinfandel", "White", "Rich Dark Color", "This wine is known for its rich, dark color and high tannin and alcohol content. It’s available in light, medium, and full-bodied varieties, varying on the basis of the spice and tannin content."));
        wines.add(new Wine("Chardonnay", "White", "Terroir and Oak", "America’s number 1 white wine variety, Chardonnay is the most consumed variety in the world. This world-famous wine pairs well with pasta dishes prepared with creamy sauces."));


        WineRecyclerViewAdapter adapter = new WineRecyclerViewAdapter(this);
        adapter.setWines(wines);

        wineRecyclerView.setAdapter(adapter);
        wineRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

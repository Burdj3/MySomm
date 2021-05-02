// Cured MeatWineRecommendation.java
// Jack Burdick wrote this code
//

package com.example.mysomm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CuredMeatWineRecommendations extends AppCompatActivity {

    private RecyclerView wineRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curedmeat_wine_recommendations);

        wineRecyclerView = findViewById(R.id.curedmeatWineDishRecyclerView);

        ArrayList<Wine> wines = new ArrayList<>();
        wines.add(new Wine("Pinot Noir", "Red", "Dry", "Known for it's silky-smooth tannins, Pinot Noir pairs well with any type of charcuterie board. We highly recommend a glass with any cut of cured pork."));
        wines.add(new Wine("Cabernet Sauvignon", "Red", "Dry", "If you are enjoying smokier meats, then reach for a bottle of Cabernet. Known as one of the 6 noble grapes, Cabernet brings a rustic taste that excels when paired with smoky flavors."));
        wines.add(new Wine("Riesling", "White", "Dry", "When building a charcuterie board with lighter meats such as Prosciutto or Serrano, you should reach for a sweeter, fruitier bottle of wine with a large amount of acidity. Try a dry Riesling for an exciting combination."));

        WineRecyclerViewAdapter adapter = new WineRecyclerViewAdapter(this);
        adapter.setWines(wines);

        wineRecyclerView.setAdapter(adapter);
        wineRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

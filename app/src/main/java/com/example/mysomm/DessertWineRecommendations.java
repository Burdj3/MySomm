package com.example.mysomm;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DessertWineRecommendations extends AppCompatActivity implements WineRecyclerViewAdapter.OnWineListener {

    private RecyclerView wineRecyclerView;
    ArrayList<Wine> wines = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert_wine_recommendations);

        wineRecyclerView = findViewById(R.id.dessertWineDishRecyclerView);

        wines.add(new Wine("Riesling", "Type: White", "Taste: Semi-Sweet", "Riesling is an aromatic grape variety displaying flowery, almost perfumed, aromas as well as high acidity. You’ll also often smell things like honeycomb, jasmine, or lime peel, along with a striking aroma that smells similar to petrol or petroleum wax.", "https://www.wineaccess.com/store/varietals/riesling/"));
        wines.add(new Wine("Moscatel", "Type: White", "Taste: Sweet", "Ranging from chestnut to an intense mahogany in colour, with a pronounced density and tearing. The characteristic varietal notes of muscatel grapes stand out in the nose with the presence of the floral aromas of jasmine, orange blossom and honey suckle in addition to citric notes of lime and grapefruit and other hints of sweetness.", "https://drizly.com/wine/white-wine/moscato/c196750"));
        wines.add(new Wine("Moscato", "Type: White", "Taste: Sweet", "Moscato is a sweet, medium to low-acidity wine. This wine includes a fragrant aroma, and fruit such as peach, apricot, and orange citrus, and delicate floral notes such rose petal and elderflower.a", "https://drizly.com/wine/white-wine/moscato/c196750"));
        wines.add(new Wine("Tawny Port", "Type: Red", "Taste: Sweet", "Tawny Port is a very sweet, barrel-aged Port made from red grapes. It is loved for it's mahogany hue and flavors of caramel, chocolate, dried fruit, and nuts. And, just like whiskey, much of the flavor comes from aging in wooden casks.", "https://www.wineaccess.com/store/search/Tawny%20Port/"));

        WineRecyclerViewAdapter adapter = new WineRecyclerViewAdapter(this, this);
        adapter.setWines(wines);

        wineRecyclerView.setAdapter(adapter);
        wineRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onWineClick(int position) {
        //where you navigate to new activity
        String myLink = wines.get(position).getLink();
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(myLink)));
    }
}

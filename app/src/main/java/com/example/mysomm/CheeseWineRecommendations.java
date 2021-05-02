// CheeseWineRecommendation.java
//  Srinath Subramanain wrote this code
//


package com.example.mysomm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CheeseWineRecommendations extends AppCompatActivity {

    private RecyclerView wineRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheese_wine_recommendations);

        wineRecyclerView = findViewById(R.id.cheeseWineDishRecyclerView);

        ArrayList<Wine> wines = new ArrayList<>();
        wines.add(new Wine("Malvasia", "Type: White", "Taste: Sweet", "Malvasia wines are characterized by their heavy body that is often described as \"round\" or \"fat\" and soft texture in the mouth. Common aroma notes associated with Malvasia include peaches, apricots and white currants."));
        wines.add(new Wine("Malbec", "Type: Red", "Taste: Dry", "Known for its plump, dark fruit flavors and smoky finish, Malbec wine offers a great alternative to higher priced Cabernet Sauvignon and Syrah."));
        wines.add(new Wine("Tempranillo", "Type: Red", "Taste: Dry", "Tempranillo delivers contrasting flavors of leather and cherries. The finer the wine, the more balance there is between earth and fruit. The finish is typically smooth and lingers with the taste of tannin on both sides of your mouth."));
        wines.add(new Wine("ZinFandel", "Type: Red", "Taste: Sweet", "Zinfandels are characterised by a dark colour and a nose with notes of spices and pepper, as well as jammy red berries."));

        WineRecyclerViewAdapter adapter = new WineRecyclerViewAdapter(this);
        adapter.setWines(wines);

        wineRecyclerView.setAdapter(adapter);
        wineRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

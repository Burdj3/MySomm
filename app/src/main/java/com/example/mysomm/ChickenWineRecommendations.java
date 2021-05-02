package com.example.mysomm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ChickenWineRecommendations extends AppCompatActivity {

    private RecyclerView wineRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine_recommendations);

        wineRecyclerView = findViewById(R.id.chickenWineDishRecyclerView);

        ArrayList<Wine> wines = new ArrayList<>();
        wines.add(new Wine("Oaked Chardonnay", "Type: White", "Taste: Sweet", "Oaked Chardonnays are rich, full-bodied and have additional flavors of vanilla, butter and even caramel from the oak. A cool climate, buttery Chardonnay will have more citrus flavors versus a warm climate Chardonnay, which will have more tropical fruit flavors."));
        wines.add(new Wine("Carbernet Sauvignon","Type: Red","Taste: Dry", "Carbernet Sauvignon is one of the most popular red wine grapes. This wine tends to be robust with medium acidity and tannins and flavors of rich, dark fruit. It has slightly elevated levels of alcohol for red wine and pairs well with food."));
        wines.add(new Wine("Chenin Blanc", "Type: White", "Taste: Dry", "Chenin Blanc is very diverse in its styles, from sparkling wines and lean, dry whites to sweet, golden nectars and brandy. It is often known for its notes of honey and straw as well as a palate that is rich in stone-fruit flavors."));
        wines.add(new Wine("Shiraz", "Type: Red", "Taste: Sweet", "Shiraz wines are well known for their rich and juicy mid-palate. You can expect to taste flavours of pepper, spice and sweet red fruit. We also often get a different feel on the palate, strong on the front in the mouth and on the finish but with a slightly different palate feel."));

        WineRecyclerViewAdapter adapter = new WineRecyclerViewAdapter(this);
        adapter.setWines(wines);

        wineRecyclerView.setAdapter(adapter);
        wineRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}
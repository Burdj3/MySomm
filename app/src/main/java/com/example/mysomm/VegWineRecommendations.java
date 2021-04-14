package com.example.mysomm;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VegWineRecommendations extends AppCompatActivity implements WineRecyclerViewAdapter.OnWineListener{

    private RecyclerView wineRecyclerView;
    ArrayList<Wine> wines = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veg_wine_recommendations);

        wineRecyclerView = findViewById(R.id.vegWineDishRecyclerView);


        wines.add(new Wine("Pinot Grigio", "Type: White", "Dry", "Pinot Grigio is a refreshing wine. It is a dry white wine with flavors of lemons, limes, green apples and honeysuckle."));
        wines.add(new Wine("Albariño", "Type: White", "Sweet", "Albariño is a white wine known for its rich stone fruit flavors, a hint of salinity, and high acidity."));
        wines.add(new Wine("Gamay", "Type: Red", "Sweet", "Gamay is a floral and fruity red wine, with pomegranate, blackberry and violet flavors.  "));
        wines.add(new Wine("Grenache", "Type: Red", "Sweet", "Grenache is a rich red wine with strawberry, plum, dried herbs and leather flavors."));

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

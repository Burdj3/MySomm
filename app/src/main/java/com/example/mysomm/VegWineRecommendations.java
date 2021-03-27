package com.example.mysomm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VegWineRecommendations extends AppCompatActivity {

    private RecyclerView wineRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veg_wine_recommendations);

        wineRecyclerView = findViewById(R.id.vegWineDishRecyclerView);

        ArrayList<Wine> wines = new ArrayList<>();
        wines.add(new Wine("", "", "", ""));
        wines.add(new Wine("", "", "", ""));
        wines.add(new Wine("", "", "", ""));
        wines.add(new Wine("", "", "", ""));

        WineRecyclerViewAdapter adapter = new WineRecyclerViewAdapter(this);
        adapter.setWines(wines);

        wineRecyclerView.setAdapter(adapter);
        wineRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

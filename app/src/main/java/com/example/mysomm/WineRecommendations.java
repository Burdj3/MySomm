package com.example.mysomm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class WineRecommendations extends AppCompatActivity {

    private RecyclerView wineRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine_recommendations);

        wineRecyclerView = findViewById(R.id.wineDishRecyclerView);

        ArrayList<Wine> wines = new ArrayList<>();
        wines.add(new Wine("Oaked Chardonnay", "Type: White", "Age: 3-5 Years", "Taste: Sweet", "Price: $200-$300", "https://www.broudys.com/images/products/img4982.png"));
        wines.add(new Wine("Carbernet Sauvignon","Type: Red","Age: 7-10 Years","Taste: Dry","Price: $10-$30","https://images.squarespace-cdn.com/content/v1/5c1a51eff2e6b12463ebc813/1546953866128-MZ0MPZTD16P9LB2L9YRX/ke17ZwdGBToddI8pDm48kCiC6x0kNpxliGpzQTkOLNUUqsxRUqqbr1mOJYKfIPR7LoDQ9mXPOjoJoqy81S2I8PaoYXhp6HxIwZIk7-Mi3Tsic-L2IOPH3Dwrhl-Ne3Z2ppk8fIk4OUdzzAJ58dNz9ksAnbOUWC6fgQEHg0Bz14hkOpdljO7Z-5qh0zg85Jnj/the-seeker-cab.jpg"));
        wines.add(new Wine("Test2","White2","12","Sweet2","$$$2", ""));

        WineRecyclerViewAdapter adapter = new WineRecyclerViewAdapter(this);
        adapter.setWines(wines);

        wineRecyclerView.setAdapter(adapter);
        wineRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

    }
}
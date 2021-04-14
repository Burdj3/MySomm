package com.example.mysomm;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShellFishWineRecommendations extends AppCompatActivity implements WineRecyclerViewAdapter.OnWineListener{

    private RecyclerView wineRecyclerView;
    ArrayList<Wine> wines = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shellfish_wine_recommendations);

        wineRecyclerView = findViewById(R.id.shellfishWineDishRecyclerView);


        wines.add(new Wine("Chardonnay", "White", "Dry", "The Chardonnay is a rich, polished style that won't be for everyone, but is still all class. Reductive notes of oyster shell and gun flint perch neatly beside baked apple, nougat and high-end oak on the nose."));
        wines.add(new Wine("Fume Blanc", "White", "Dry", "The Fume Blanc is known to be fruity, clean and bright on the palate. Full-bodied white is tantalizing in lime and salty stone, and displays a steely grip. Its sleekness is complemented and met by a robust voluptuous side that offers ample waves of green apple and oak."));
        wines.add(new Wine("Viognier", "White", "Dry", "The Viogner is Light mango, dried apple, lemon peel and a faint waft of seashore show on the nose of this bottling. The palate is brisk with lime, lemon and tangerine-peel flavors that are a bit sour, and a lingering maritime funk permeates the finish."));
        wines.add(new Wine("Pinot Gris", "White", "Sweet", "The Pinot Gris is sourced from the original vines, now a half century old. This is done in a subtle, elegant style that rewards your full attention. Hints of bee pollen, lemon rind and brioche adorn a deceptively light but textured and layered wine with a lingering finish."));

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

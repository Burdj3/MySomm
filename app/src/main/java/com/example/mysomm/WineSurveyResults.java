// Wine.java
// Nicholas Fontenot wrote lines 64, 72-76
// Srinath Subramanian wrote the remaining lines

package com.example.mysomm;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WineSurveyResults extends AppCompatActivity implements WineRecyclerViewDatabaseAdapter.OnWinedbListener {

    private RecyclerView wineRecyclerView;
    WineRecyclerViewDatabaseAdapter adapter;
    ArrayList<Wine> wines = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine_database_collection);

        Intent intent = getIntent();

        String Sweet = intent.getStringExtra(Wine_Survey.EXTRA_SWEET);
        String Price = intent.getStringExtra(Wine_Survey.EXTRA_PRICE);
        String Acid = intent.getStringExtra(Wine_Survey.EXTRA_ACID);
        String Color = intent.getStringExtra(Wine_Survey.EXTRA_COLOR);
        String Body = intent.getStringExtra(Wine_Survey.EXTRA_BODY);

        wineRecyclerView = findViewById(R.id.wineDatabaseCollectionRecyclerView);

        wineRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new WineRecyclerViewDatabaseAdapter(this, this);
        adapter.setWines(wines);
        wineRecyclerView.setAdapter(adapter);

        readFromFilteredLocalStorage(Sweet, Price, Acid, Color, Body);

    }

    public void readFromFilteredLocalStorage(String swt, String prce, String acd, String clr, String bdy)
    {
        wines.clear();
        DbHelper helper = new DbHelper(this);

        Cursor cursor = helper.readFromFilteredLocalDatabase2(swt, prce, acd, clr, bdy);

        while (cursor.moveToNext())
        {
            String name = cursor.getString(cursor.getColumnIndex(helper.NAME));
            String color = cursor.getString(cursor.getColumnIndex(helper.TYPE));
            String sweet = cursor.getString(cursor.getColumnIndex(helper.REGION));
            String desc = cursor.getString(cursor.getColumnIndex(helper.DESCRIPTION));
            String image = cursor.getString(cursor.getColumnIndex(helper.IMAGEURL));
            String link = cursor.getString(cursor.getColumnIndex(helper.LINK));
            wines.add(new Wine(name, color, sweet, desc, image, link));
        }
        adapter.notifyDataSetChanged();
        cursor.close();
        helper.close();
    }

    @Override
    public void onWinedbClick(int position) {
        String myLink = wines.get(position).getLink();
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(myLink)));
    }
}

// Wine.java
// Nicholas Fontenot wrote lines 60-61, 68-72
// Srinath Subramanian wrote the remaining lines

package com.example.mysomm;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WineDatabaseCollection extends AppCompatActivity implements WineRecyclerViewDatabaseAdapter.OnWinedbListener {

    private RecyclerView wineRecyclerView;
    WineRecyclerViewDatabaseAdapter adapter;
    ArrayList<Wine> wines = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine_database_collection);



        wineRecyclerView = findViewById(R.id.wineDatabaseCollectionRecyclerView);

        wineRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new WineRecyclerViewDatabaseAdapter(this, this);
        adapter.setWines(wines);
        wineRecyclerView.setAdapter(adapter);

        readFromLocalStorage();


    }


    public void readFromLocalStorage()
    {
        wines.clear();
        DbHelper helper = new DbHelper(this);

        Cursor cursor = helper.readFromLocalDatabase();

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

package com.example.mysomm;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WineDatabaseCollection extends AppCompatActivity {

    private RecyclerView wineRecyclerView;
    WineRecyclerViewDatabaseAdapter adapter;
    ArrayList<Wine> wines = new ArrayList<>();
    DbHelper dbHelper = new DbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine_database_collection);



        wineRecyclerView = findViewById(R.id.wineDatabaseCollectionRecyclerView);

        wineRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //dbHelper.saveToLocalDatabase("Pacific Rim","Riesling","3","It's pretty good", "1", "White", "Oregon", "3", "10", "https://upload.wikimedia.org/wikipedia/en/c/c0/Red_Wine_Glass.jpg");
        //dbHelper.saveToLocalDatabase("Example 2","idk","1","It's alright", "2", "Red", "Texas", "2", "20", "https://d2gg9evh47fn9z.cloudfront.net/800px_COLOURBOX2879719.jpg");
        //dbHelper.deleteAllRows();

        adapter = new WineRecyclerViewDatabaseAdapter(this);
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
            String color = cursor.getString(cursor.getColumnIndex(helper.COLOR));
            String sweet = cursor.getString(cursor.getColumnIndex(helper.SWEET));
            String desc = cursor.getString(cursor.getColumnIndex(helper.DESCRIPTION));
            String image = cursor.getString(cursor.getColumnIndex(helper.IMAGEURL));
            wines.add(new Wine(name, color, sweet, desc, image));
        }
        adapter.notifyDataSetChanged();
        cursor.close();
        helper.close();
    }
}

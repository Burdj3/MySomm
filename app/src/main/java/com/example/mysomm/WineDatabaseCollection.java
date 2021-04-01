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
    WineRecyclerViewAdapter adapter;
    ArrayList<Wine> wines = new ArrayList<>();
    DbHelper dbHelper = new DbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine_database_collection);



        wineRecyclerView = findViewById(R.id.wineDatabaseCollectionRecyclerView);

        wineRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //dbHelper.saveToLocalDatabase("Example","White","Sweet","Work");

        adapter = new WineRecyclerViewAdapter(this);
        adapter.setWines(wines);
        wineRecyclerView.setAdapter(adapter);

        readFromLocalStorage();


    }

    /*public void fillDatabase()
    {
        DbHelper dbHelper = new DbHelper(this);

        dbHelper.saveToLocalDatabase("Example","White","Sweet","Work");
    }*/

    public void readFromLocalStorage()
    {
        wines.clear();
        DbHelper helper = new DbHelper(this);

        Cursor cursor = helper.readFromLocalDatabase();

        while (cursor.moveToNext())
        {
            String name = cursor.getString(cursor.getColumnIndex(helper.NAME));
            String type = cursor.getString(cursor.getColumnIndex(helper.TYPE));
            String taste = cursor.getString(cursor.getColumnIndex(helper.TASTE));
            String desc = cursor.getString(cursor.getColumnIndex(helper.DESCRIPTION));
            wines.add(new Wine(name, type, taste, desc));
        }
        adapter.notifyDataSetChanged();
        cursor.close();
        helper.close();
    }
}

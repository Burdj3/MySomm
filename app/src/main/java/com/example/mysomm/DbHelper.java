package com.example.mysomm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "winedb";
    public static final String TABLE_NAME = "winesdb";
    public static final String ID = "ID";
    public static final String NAME = "NAME";
    public static final String TYPE = "TYPE";
    public static final String TASTE = "TASTE";
    public static final String DESCRIPTION = "DESCRIPTION";

    private static final int DATABASE_VERSION = 4;
    private static final String CREATE_TABLE = ("create table "+ TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, TYPE TEXT, TASTE TEXT, DESCRIPTION TEXT)");
    private static final String DROP_TABLE = "drop table if exists "+ TABLE_NAME;

    public DbHelper(Context context)
    {
        super(context,DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public boolean saveToLocalDatabase(String name, String type, String taste, String desc)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,name);
        contentValues.put(TYPE,type);
        contentValues.put(TASTE,taste);
        contentValues.put(DESCRIPTION,desc);
        long result = database.insert(TABLE_NAME, null, contentValues);

        if (result == 1)
            return false;
        else
            return true;
    }

    public Cursor readFromLocalDatabase()
    {

        SQLiteDatabase database = this.getWritableDatabase();
        Cursor res = database.rawQuery("select * from "+TABLE_NAME, null);
        return res;
    }


}

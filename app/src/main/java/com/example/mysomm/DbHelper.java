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
    public static final String SWEET = "SWEET";
    public static final String DESCRIPTION = "DESCRIPTION";
    public static final String BODY = "BODY";
    public static final String COLOR = "COLOR";
    public static final String REGION = "REGION";
    public static final String ACIDITY = "ACIDITY";
    public static final String PRICE = "PRICE";
    public static final String IMAGEURL = "IMAGEURL";

    private static final int DATABASE_VERSION = 6;
    private static final String CREATE_TABLE = ("create table "+ TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, TYPE TEXT, SWEET TEXT, DESCRIPTION TEXT, BODY TEXT, COLOR TEXT, REGION TEXT, ACIDITY TEXT, PRICE TEXT, IMAGEURL TEXT)");
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

    public boolean saveToLocalDatabase(String name, String type, String sweet, String desc, String body, String color, String region, String acidity, String price, String imageURL)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,name);
        contentValues.put(TYPE,type);
        contentValues.put(SWEET,sweet);
        contentValues.put(DESCRIPTION,desc);
        contentValues.put(BODY, body);
        contentValues.put(COLOR, color);
        contentValues.put(REGION, region);
        contentValues.put(ACIDITY, acidity);
        contentValues.put(PRICE, price);
        contentValues.put(IMAGEURL, imageURL);
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

    public Cursor readFromFilteredLocalDatabase(String swt, String prce, String acd, String clr, String bdy)
    {

        SQLiteDatabase database = this.getWritableDatabase();
        Cursor res = database.rawQuery("select * from winesdb where SWEET = '"+swt+"' and PRICE = '"+prce+"' and ACIDITY = '"+acd+"' and COLOR = '"+clr+"' and BODY = '"+bdy+"'", null);
        return res;
    }

    public Integer deleteRow(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }

    public void deleteAllRows()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, null, null);
        db.execSQL("delete from "+ TABLE_NAME);
    }


}

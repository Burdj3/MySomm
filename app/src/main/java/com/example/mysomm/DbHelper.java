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

    public Cursor readFromFilteredLocalDatabase2(String swt, String prce, String acd, String clr, String bdy)
    {

        SQLiteDatabase database = this.getWritableDatabase();

        if (swt.matches("Don't Care") && prce.matches("Any") && acd.matches("Don't Care") && clr.matches("Either") && bdy.matches("Don't Care"))
        {
            Cursor res29 = database.rawQuery("select * from "+TABLE_NAME, null);
            return res29;
        }
        if (bdy.matches("Don't Care") && acd.matches("Don't Care") && prce.matches("Any") && clr.matches("Either"))
        {
            Cursor res24 = database.rawQuery("select * from winesdb where SWEET = '"+swt+"' and (PRICE = 'Less than $20' or PRICE = 'Greater than $20') and (ACIDITY = 'Not Very' or ACIDITY = 'Somewhat' or ACIDITY = 'Very') and (COLOR = 'White' or COLOR = 'Red') and (BODY = 'Light' or BODY = 'Medium' or BODY = 'Heavy')", null);
            return res24;
        }
        if (swt.matches("Don't Care") && acd.matches("Don't Care") && prce.matches("Any") && clr.matches("Either"))
        {
            Cursor res25 = database.rawQuery("select * from winesdb where (SWEET = 'Dry' or SWEET = 'Between' or SWEET = 'Sweet') and (PRICE = 'Less than $20' or PRICE = 'Greater than $20') and (ACIDITY = 'Not Very' or ACIDITY = 'Somewhat' or ACIDITY = 'Very') and (COLOR = 'White' or COLOR = 'Red') and BODY = '"+bdy+"'", null);
            return res25;
        }
        if (swt.matches("Don't Care") && acd.matches("Don't Care") && bdy.matches("Don't Care") && clr.matches("Either"))
        {
            Cursor res26 = database.rawQuery("select * from winesdb where (SWEET = 'Dry' or SWEET = 'Between' or SWEET = 'Sweet') and PRICE = '"+prce+"' and (ACIDITY = 'Not Very' or ACIDITY = 'Somewhat' or ACIDITY = 'Very') and (COLOR = 'White' or COLOR = 'Red') and (BODY = 'Light' or BODY = 'Medium' or BODY = 'Heavy')", null);
            return res26;
        }
        if (swt.matches("Don't Care") && prce.matches("Any") && bdy.matches("Don't Care") && clr.matches("Either"))
        {
            Cursor res27 = database.rawQuery("select * from winesdb where (SWEET = 'Dry' or SWEET = 'Between' or SWEET = 'Sweet') and (PRICE = 'Less than $20' or PRICE = 'Greater than $20') and ACIDITY = '"+acd+"' and (COLOR = 'White' or COLOR = 'Red') and (BODY = 'Light' or BODY = 'Medium' or BODY = 'Heavy')", null);
            return res27;
        }
        if (swt.matches("Don't Care") && acd.matches("Don't Care") && prce.matches("Any") && bdy.matches("Don't Care"))
        {
            Cursor res28 = database.rawQuery("select * from winesdb where (SWEET = 'Dry' or SWEET = 'Between' or SWEET = 'Sweet') and (PRICE = 'Less than $20' or PRICE = 'Greater than $20') and (ACIDITY = 'Not Very' or ACIDITY = 'Somewhat' or ACIDITY = 'Very') and COLOR = '"+clr+"' and (BODY = 'Light' or BODY = 'Medium' or BODY = 'Heavy')", null);
            return res28;
        }
        if (bdy.matches("Don't Care") && clr.matches("Either") && acd.matches("Don't Care"))
        {
            Cursor res17 = database.rawQuery("select * from winesdb where SWEET = '"+swt+"' and PRICE = '"+prce+"' and (ACIDITY = 'Not Very' or ACIDITY = 'Somewhat' or ACIDITY = 'Very') and (COLOR = 'White' or COLOR = 'Red') and (BODY = 'Light' or BODY = 'Medium' or BODY = 'Heavy')", null);
            return res17;
        }
        if (bdy.matches("Don't Care") && clr.matches("Either") && prce.matches("Any"))
        {
            Cursor res18 = database.rawQuery("select * from winesdb where SWEET = '"+swt+"' and (PRICE = 'Less than $20' or PRICE = 'Greater than $20') and ACIDITY = '"+acd+"' and (COLOR = 'White' or COLOR = 'Red') and (BODY = 'Light' or BODY = 'Medium' or BODY = 'Heavy')", null);
            return res18;
        }
        if (bdy.matches("Don't Care") && clr.matches("Either") && swt.matches("Don't Care"))
        {
            Cursor res19 = database.rawQuery("select * from winesdb where (SWEET = 'Dry' or SWEET = 'Between' or SWEET = 'Sweet') and PRICE = '"+prce+"' and ACIDITY = '"+acd+"' and (COLOR = 'White' or COLOR = 'Red') and (BODY = 'Light' or BODY = 'Medium' or BODY = 'Heavy')", null);
            return res19;
        }
        if (clr.matches("Either") && acd.matches("Don't Care") && prce.matches("Any"))
        {
            Cursor res20 = database.rawQuery("select * from winesdb where SWEET = '"+swt+"' and (PRICE = 'Less than $20' or PRICE = 'Greater than $20') and (ACIDITY = 'Not Very' or ACIDITY = 'Somewhat' or ACIDITY = 'Very') and (COLOR = 'White' or COLOR = 'Red') and BODY = '"+bdy+"'", null);
            return res20;
        }
        if (clr.matches("Either") && acd.matches("Don't Care") && swt.matches("Don't Care"))
        {
            Cursor res21 = database.rawQuery("select * from winesdb where (SWEET = 'Dry' or SWEET = 'Between' or SWEET = 'Sweet') and PRICE = '"+prce+"' and (ACIDITY = 'Not Very' or ACIDITY = 'Somewhat' or ACIDITY = 'Very') and (COLOR = 'White' or COLOR = 'Red') and BODY = '"+bdy+"'", null);
            return res21;
        }
        if (swt.matches("Don't Care") && acd.matches("Don't Care") && prce.matches("Any"))
        {
            Cursor res22 = database.rawQuery("select * from winesdb where (SWEET = 'Dry' or SWEET = 'Between' or SWEET = 'Sweet') and (PRICE = 'Less than $20' or PRICE = 'Greater than $20') and (ACIDITY = 'Not Very' or ACIDITY = 'Somewhat' or ACIDITY = 'Very') and COLOR = '"+clr+"' and BODY = '"+bdy+"'", null);
            return res22;
        }
        if (bdy.matches("Don't Care") && acd.matches("Don't Care") && prce.matches("Any"))
        {
            Cursor res23 = database.rawQuery("select * from winesdb where SWEET = '"+swt+"' and (PRICE = 'Less than $20' or PRICE = 'Greater than $20') and (ACIDITY = 'Not Very' or ACIDITY = 'Somewhat' or ACIDITY = 'Very') and COLOR = '"+clr+"' and (BODY = 'Light' or BODY = 'Medium' or BODY = 'Heavy')", null);
            return res23;
        }
        if (bdy.matches("Don't Care") && acd.matches("Don't Care") && swt.matches("Don't Care"))
        {
            Cursor res30 = database.rawQuery("select * from winesdb where (SWEET = 'Dry' or SWEET = 'Between' or SWEET = 'Sweet') and PRICE = '"+prce+"' and (ACIDITY = 'Not Very' or ACIDITY = 'Somewhat' or ACIDITY = 'Very') and COLOR = '"+clr+"' and (BODY = 'Light' or BODY = 'Medium' or BODY = 'Heavy')", null);
            return res30;
        }
        if (swt.matches("Don't Care") && bdy.matches("Don't Care") && prce.matches("Any"))
        {
            Cursor res31 = database.rawQuery("select * from winesdb where (SWEET = 'Dry' or SWEET = 'Between' or SWEET = 'Sweet') and (PRICE = 'Less than $20' or PRICE = 'Greater than $20') and ACIDITY = '"+acd+"' and COLOR = '"+clr+"' and BODY = (BODY = 'Light' or BODY = 'Medium' or BODY = 'Heavy')", null);
            return res31;
        }
        if (bdy.matches("Don't Care") && clr.matches("Either"))
        {
            Cursor res7 = database.rawQuery("select * from winesdb where SWEET = '"+swt+"' and PRICE = '"+prce+"' and ACIDITY = '"+acd+"' and (COLOR = 'White' or COLOR = 'Red') and (BODY = 'Light' or BODY = 'Medium' or BODY = 'Heavy')", null);
            return res7;
        }
        if (clr.matches("Either") && acd.matches("Don't Care"))
        {
            Cursor res8 = database.rawQuery("select * from winesdb where SWEET = '"+swt+"' and PRICE = '"+prce+"' and (ACIDITY = 'Not Very' or ACIDITY = 'Somewhat' or ACIDITY = 'Very') and (COLOR = 'White' or COLOR = 'Red') and BODY = '"+bdy+"'", null);
            return res8;
        }
        if (acd.matches("Don't Care") && prce.matches("Any"))
        {
            Cursor res9 = database.rawQuery("select * from winesdb where SWEET = '"+swt+"' and (PRICE = 'Less than $20' or PRICE = 'Greater than $20') and (ACIDITY = 'Not Very' or ACIDITY = 'Somewhat' or ACIDITY = 'Very') and COLOR = '"+clr+"' and BODY = '"+bdy+"'", null);
            return res9;
        }
        if (prce.matches("Any") && swt.matches("Don't Care"))
        {
            Cursor res10 = database.rawQuery("select * from winesdb where (SWEET = 'Dry' or SWEET = 'Between' or SWEET = 'Sweet') and (PRICE = 'Less than $20' or PRICE = 'Greater than $20') and ACIDITY = '"+acd+"' and COLOR = '"+clr+"' and BODY = '"+bdy+"'", null);
            return res10;
        }
        if (swt.matches("Don't Care") && bdy.matches("Don't Care"))
        {
            Cursor res11 = database.rawQuery("select * from winesdb where (SWEET = 'Dry' or SWEET = 'Between' or SWEET = 'Sweet') and PRICE = '"+prce+"' and ACIDITY = '"+acd+"' and COLOR = '"+clr+"' and (BODY = 'Light' or BODY = 'Medium' or BODY = 'Heavy')", null);
            return res11;
        }
        if (bdy.matches("Don't Care") && prce.matches("Any"))
        {
            Cursor res12 = database.rawQuery("select * from winesdb where SWEET = '"+swt+"' and (PRICE = 'Less than $20' or PRICE = 'Greater than $20') and ACIDITY = '"+acd+"' and COLOR = '"+clr+"' and (BODY = 'Light' or BODY = 'Medium' or BODY = 'Heavy')", null);
            return res12;
        }
        if (bdy.matches("Don't Care") && acd.matches("Don't Care"))
        {
            Cursor res13 = database.rawQuery("select * from winesdb where SWEET = '"+swt+"' and PRICE = '"+prce+"' and (ACIDITY = 'Not Very' or ACIDITY = 'Somewhat' or ACIDITY = 'Very') and COLOR = '"+clr+"' and (BODY = 'Light' or BODY = 'Medium' or BODY = 'Heavy')", null);
            return res13;
        }
        if (clr.matches("Either") && prce.matches("Any"))
        {
            Cursor res14 = database.rawQuery("select * from winesdb where SWEET = '"+swt+"' and (PRICE = 'Less than $20' or PRICE = 'Greater than $20') and ACIDITY = '"+acd+"' and COLOR = ('White' or COLOR = 'Red') and BODY = '"+bdy+"'", null);
            return res14;
        }
        if (clr.matches("Either") && swt.matches("Don't Care"))
        {
            Cursor res15 = database.rawQuery("select * from winesdb where (SWEET = 'Dry' or SWEET = 'Between' or SWEET = 'Sweet') and PRICE = '"+prce+"' and ACIDITY = '"+acd+"' and (COLOR = 'White' or COLOR = 'Red') and BODY = '"+bdy+"'", null);
            return res15;
        }
        if (swt.matches("Don't Care") && acd.matches("Don't Care"))
        {
            Cursor res16 = database.rawQuery("select * from winesdb where (SWEET = 'Dry' or SWEET = 'Between' or SWEET = 'Sweet') and PRICE = '"+prce+"' and (ACIDITY = 'Not Very' or ACIDITY = 'Somewhat' or ACIDITY = 'Very') and COLOR = '"+clr+"' and BODY = '"+bdy+"'", null);
            return res16;
        }
        if (bdy.matches("Don't Care"))
        {
            Cursor res2 = database.rawQuery("select * from winesdb where SWEET = '"+swt+"' and PRICE = '"+prce+"' and ACIDITY = '"+acd+"' and COLOR = '"+clr+"' and (BODY = 'Light' or BODY = 'Medium' or BODY = 'Heavy')", null);
            return res2;
        }
        if (clr.matches("Either"))
        {
            Cursor res3 = database.rawQuery("select * from winesdb where SWEET = '"+swt+"' and PRICE = '"+prce+"' and ACIDITY = '"+acd+"' and (COLOR = 'White' or COLOR = 'Red') and BODY = '"+bdy+"'", null);
            return res3;
        }
        if (acd.matches("Don't Care"))
        {
            Cursor res4 = database.rawQuery("select * from winesdb where SWEET = '"+swt+"' and PRICE = '"+prce+"' and (ACIDITY = 'Not Very' or ACIDITY = 'Somewhat' or ACIDITY = 'Very') and COLOR = '"+clr+"' and BODY = '"+bdy+"'", null);
            return res4;
        }
        if (prce.matches("Any"))
        {
            Cursor res5 = database.rawQuery("select * from winesdb where SWEET = '"+swt+"' and (PRICE = 'Less than $20' or PRICE = 'Greater than $20') and ACIDITY = '"+acd+"' and COLOR = '"+clr+"' and BODY = '"+bdy+"'", null);
            return res5;
        }
        if (swt.matches("Don't Care"))
        {
            Cursor res6 = database.rawQuery("select * from winesdb where (SWEET = 'Dry' or SWEET = 'Between' or SWEET = 'Sweet') and PRICE = '"+prce+"' and ACIDITY = '"+acd+"' and COLOR = '"+clr+"' and BODY = '"+bdy+"'", null);
            return res6;
        }
        else
            {
                Cursor res1 = database.rawQuery("select * from winesdb where SWEET = '"+swt+"' and PRICE = '"+prce+"' and ACIDITY = '"+acd+"' and COLOR = '"+clr+"' and BODY = '"+bdy+"'", null);
                return res1;
            }

    }

    /*public Cursor readFromFilteredLocalDatabase(String swt, String prce, String acd, String clr, String bdy)
    {

        SQLiteDatabase database = this.getWritableDatabase();

        Cursor res = database.rawQuery("select * from winesdb where SWEET = '"+swt+"' and PRICE = '"+prce+"' and ACIDITY = '"+acd+"' and COLOR = '"+clr+"' and BODY = '"+bdy+"'", null);
        return res;

    }*/

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

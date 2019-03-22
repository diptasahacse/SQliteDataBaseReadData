package com.example.user.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {
    private static final String dbname = "mydb";
    private static final int version = 1;


    public DataBase(Context context) {
        super(context, dbname, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE PRODUCTS(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,DESCRIPTION TEXT,PRICE REAL)";
        db.execSQL(sql);
        insertdat("Jam","Fruit", (float) 99.6,db);
        insertdat("Bread","Fruit", (float) 100.60,db);
        insertdat("Mango","Fruit", (float) 110.60,db);
        insertdat("Banana","Fruit", (float) 145.60,db);
        insertdat("Litchi","Fruit", (float) 1110.60,db);
        insertdat("Dipta","Man", (float) 11087.60,db);
        insertdat("Mango","Fruit", (float) 11700.60,db);
        insertdat("Mango","Fruit", (float) 1140.60,db);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    void insertdat(String name,String description,float price,SQLiteDatabase dbase)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME",name);
        contentValues.put("DESCRIPTION",description);
        contentValues.put("PRICE",price);
        dbase.insert("PRODUCTS",null,contentValues);
    }
}

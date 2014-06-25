package com.example.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import static android.database.sqlite.SQLiteDatabase.openDatabase;

/**
 * Created by Mark on 23-6-14.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String
            KEY_ID = "_id" ,
            KEY_ARTIKEL = "Artikel",
            KEY_CODE = "code",
            KEY_PRIJS = "pijs";

    private static final String DATABASE_NAME = "svs.db",
            TABLE_ARTIKELEN = "artikelen";

    Context context;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_ARTIKELEN + "(" + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_CODE + " DOUBLE," + KEY_ARTIKEL + " TEXT," + KEY_PRIJS + " DOUBLE)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ARTIKELEN);

        onCreate(db);
    }

    public void insertArtikel(Artikel Artikel){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_CODE, Artikel.getCode());
        values.put(KEY_ARTIKEL, Artikel.getArtikel());
        values.put(KEY_PRIJS, Artikel.getPrijs());

        db.insert(TABLE_ARTIKELEN, null, values);
        db.close();
    }

    public Artikel getArtikel(int id) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TABLE_ARTIKELEN, new String[] {KEY_ID, KEY_CODE, KEY_ARTIKEL, KEY_PRIJS}, KEY_ID + "=?", new String[] {String.valueOf(id)}, null, null , null);

        if(cursor !=null){ cursor.moveToFirst();}

        Artikel artikel = new Artikel(Integer.parseInt(cursor.getString(0)), Double.parseDouble(cursor.getString(1)), cursor.getString(2), Double.parseDouble(cursor.getString(3)));
        db.close();
        cursor.close();
        return artikel;
    }

    public Cursor getArtikelen(){
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TABLE_ARTIKELEN, new String[] {KEY_ID, KEY_CODE, KEY_ARTIKEL, KEY_PRIJS}, null, null, null, null, null);

        return cursor;

    }

    public void deleteArtikel(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_ARTIKELEN, KEY_ID + "=?", new String[] {String.valueOf(id) });
        db.close();
    }

}

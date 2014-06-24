package com.example.app;

/**
 * Created by Mark on 23-6-14.
 */
public class Artikel {

    private String _artikel;
    private int _id;
    private double _code, _prijs;

    public Artikel(int id, double code, String artikel, double prijs){
        _id = id;
        _code = code;
        _artikel = artikel;
        _prijs = prijs;

    }

    public int getId(){
        return _id;
    }

    public double getCode(){
        return _code;
    }

    public double getPrijs(){
        return _prijs;
    }

    public String getArtikel(){
        return _artikel;
    }
}

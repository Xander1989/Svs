package com.example.app;



import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class factuurActivity extends Activity {

    public DatabaseHandler db;
    Spinner spinner, spinner2, spinner3, spinner4, spinner5;
    int a=0, b=0, c=0, d=0, e=0;
    Double subtotaal1, subtotaal2, subtotaal3, subtotaal4, subtotaal5, Subtotaal, BTW , PrijsTotaal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.factuur);

        db = new DatabaseHandler(getApplicationContext());

        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("Huidige Factuur");
        tabSpec.setContent(R.id.Factuur);
        tabSpec.setIndicator("Huidige Factuur");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("Artikelen");
        tabSpec.setContent(R.id.Artikelen);
        tabSpec.setIndicator("Artikelen");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("Resultaat");
        tabSpec.setContent(R.id.resultaat);
        tabSpec.setIndicator("Resultaat");
        tabHost.addTab(tabSpec);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner4 = (Spinner) findViewById(R.id.spinner4);
        spinner5 = (Spinner) findViewById(R.id.spinner5);


        getCode();
        populateList();


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View selectedItemview ,
            int pos, long id) {

                if(pos==0){
                    TextView naam = (TextView) findViewById(R.id.rij1_1);
                    naam.setText("Artikel");
                    TextView prijs = (TextView) findViewById(R.id.rij1_2);
                    prijs.setText("€");
                }

                else{
                    Artikel artikel = db.getArtikel(pos);
                    a = pos;
                    TextView naam = (TextView) findViewById(R.id.rij1_1);
                    naam.setText(artikel.getArtikel());
                    TextView prijs = (TextView) findViewById(R.id.rij1_2);
                    prijs.setText("€" + String.valueOf(artikel.getPrijs()));

                    EditText editText1 = (EditText)findViewById(R.id.editText);

                    double a = Double.parseDouble(editText1.getText().toString());
                    subtotaal1 = artikel.getPrijs() * a;



                    TextView code1 = (TextView) findViewById(R.id.code1);
                    code1.setText(String.valueOf(artikel.getCode()));
                    TextView artikel1 = (TextView) findViewById(R.id.artikel1);
                    artikel1.setText(artikel.getArtikel());
                    TextView stukprijs1 = (TextView) findViewById(R.id.stukprijs1);
                    stukprijs1.setText(String.valueOf(artikel.getPrijs()));
                    TextView prijs1 = (TextView) findViewById(R.id.prijs1);
                    prijs1.setText(String.valueOf(subtotaal1));

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }

        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View selectedItemview ,
                                       int pos, long id) {

                if(pos==0){
                    TextView naam = (TextView) findViewById(R.id.rij2_1);
                    naam.setText("Artikel");
                    TextView prijs = (TextView) findViewById(R.id.rij2_2);
                    prijs.setText("€");
                }

                else{
                    b = pos;
                    Artikel artikel = db.getArtikel(pos);
                    TextView naam = (TextView) findViewById(R.id.rij2_1);
                    naam.setText(artikel.getArtikel());
                    TextView prijs = (TextView) findViewById(R.id.rij2_2);
                    prijs.setText("€" + String.valueOf(artikel.getPrijs()));

                    EditText editText2 = (EditText)findViewById(R.id.editText2);

                    double a = Double.parseDouble(editText2.getText().toString());
                    subtotaal2 = artikel.getPrijs() * a;


                    TextView code1 = (TextView) findViewById(R.id.code2);
                    code1.setText(String.valueOf(artikel.getCode()));
                    TextView artikel1 = (TextView) findViewById(R.id.artikel2);
                    artikel1.setText(artikel.getArtikel());
                    TextView stukprijs1 = (TextView) findViewById(R.id.stukprijs2);
                    stukprijs1.setText(String.valueOf(artikel.getPrijs()));
                    TextView prijs1 = (TextView) findViewById(R.id.prijs2);
                    prijs1.setText(String.valueOf(subtotaal2));
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }

        });

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View selectedItemview ,
                                       int pos, long id) {

                if(pos==0){
                    TextView naam = (TextView) findViewById(R.id.rij3_1);
                    naam.setText("Artikel");
                    TextView prijs = (TextView) findViewById(R.id.rij3_2);
                    prijs.setText("€");
                }

                else{
                    c = pos;
                    Artikel artikel = db.getArtikel(pos);
                    TextView naam = (TextView) findViewById(R.id.rij3_1);
                    naam.setText(artikel.getArtikel());
                    TextView prijs = (TextView) findViewById(R.id.rij3_2);
                    prijs.setText("€" + String.valueOf(artikel.getPrijs()));

                    EditText editText3 = (EditText)findViewById(R.id.editText3);

                    double a = Double.parseDouble(editText3.getText().toString());
                    subtotaal3 = artikel.getPrijs() * a;


                    TextView code1 = (TextView) findViewById(R.id.code3);
                    code1.setText(String.valueOf(artikel.getCode()));
                    TextView artikel1 = (TextView) findViewById(R.id.artikel3);
                    artikel1.setText(artikel.getArtikel());
                    TextView stukprijs1 = (TextView) findViewById(R.id.stukprijs3);
                    stukprijs1.setText(String.valueOf(artikel.getPrijs()));
                    TextView prijs1 = (TextView) findViewById(R.id.prijs3);
                    prijs1.setText(String.valueOf(subtotaal3));
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }

        });

        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View selectedItemview ,
                                       int pos, long id) {

                if(pos==0){
                    TextView naam = (TextView) findViewById(R.id.rij4_1);
                    naam.setText("Artikel");
                    TextView prijs = (TextView) findViewById(R.id.rij4_2);
                    prijs.setText("€");
                }

                else{
                    d = pos;
                    Artikel artikel = db.getArtikel(pos);
                    TextView naam = (TextView) findViewById(R.id.rij4_1);
                    naam.setText(artikel.getArtikel());
                    TextView prijs = (TextView) findViewById(R.id.rij4_2);
                    prijs.setText("€" + String.valueOf(artikel.getPrijs()));

                    EditText editText4 = (EditText)findViewById(R.id.editText4);

                    double a = Double.parseDouble(editText4.getText().toString());
                    subtotaal4 = artikel.getPrijs() * a;


                    TextView code1 = (TextView) findViewById(R.id.code4);
                    code1.setText(String.valueOf(artikel.getCode()));
                    TextView artikel1 = (TextView) findViewById(R.id.artikel4);
                    artikel1.setText(artikel.getArtikel());
                    TextView stukprijs1 = (TextView) findViewById(R.id.stukprijs4);
                    stukprijs1.setText(String.valueOf(artikel.getPrijs()));
                    TextView prijs1 = (TextView) findViewById(R.id.prijs4);
                    prijs1.setText(String.valueOf(subtotaal4));
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }

        });

        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View selectedItemview ,
                                       int pos, long id) {

                if(pos==0){
                    TextView naam = (TextView) findViewById(R.id.rij5_1);
                    naam.setText("Artikel");
                    TextView prijs = (TextView) findViewById(R.id.rij5_2);
                    prijs.setText("€");
                }

                else{
                    e = pos;
                    Artikel artikel = db.getArtikel(pos);
                    TextView naam = (TextView) findViewById(R.id.rij5_1);
                    naam.setText(artikel.getArtikel());
                    TextView prijs = (TextView) findViewById(R.id.rij5_2);
                    prijs.setText("€" + String.valueOf(artikel.getPrijs()));

                    EditText editText1 = (EditText)findViewById(R.id.editText5);

                    double a = Double.parseDouble(editText1.getText().toString());
                    subtotaal5 = artikel.getPrijs() * a;


                    TextView code1 = (TextView) findViewById(R.id.code5);
                    code1.setText(String.valueOf(artikel.getCode()));
                    TextView artikel1 = (TextView) findViewById(R.id.artikel5);
                    artikel1.setText(artikel.getArtikel());
                    TextView stukprijs1 = (TextView) findViewById(R.id.stukprijs5);
                    stukprijs1.setText(String.valueOf(artikel.getPrijs()));
                    TextView prijs1 = (TextView) findViewById(R.id.prijs5);
                    prijs1.setText(String.valueOf(subtotaal5));
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }

        });




    }



    private void getCode(){
        db = new DatabaseHandler(getApplicationContext());
        Cursor cursor = db.getArtikelen();
        ArrayList<String> datalist = new ArrayList<String>();
        cursor.moveToFirst();
        String empty = "";
        datalist.add(empty);
        while(!cursor.isAfterLast()){
            String name = cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_ID));
            datalist.add(name);
            cursor.moveToNext();
        }

        ArrayAdapter<String> codeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datalist);
        spinner.setAdapter(codeAdapter);
        spinner2.setAdapter(codeAdapter);
        spinner3.setAdapter(codeAdapter);
        spinner4.setAdapter(codeAdapter);
        spinner5.setAdapter(codeAdapter);

        db.close();
    }

    public void populateList() {
        DatabaseHandler db = new DatabaseHandler(this);

        Cursor cursor = db.getArtikelen();

        String[] fromFieldIDs = new String[]
                {db.KEY_ARTIKEL, db.KEY_ID, db.KEY_PRIJS};
        int[] toViewIDs = new int[]
                {R.id.artikel_naam, R.id.artikel_code , R.id.artikel_prijs};


        SimpleCursorAdapter myCursorAdapter = new SimpleCursorAdapter(this, R.layout.listview_item, cursor, fromFieldIDs, toViewIDs);

        ListView idlist = (ListView) findViewById(R.id.listView2);
        idlist.setAdapter(myCursorAdapter);

    }

    public void result (View view){

        if(subtotaal1 == null){
            subtotaal1=0.0;
        }
        if(subtotaal2 == null){
            subtotaal2=0.0;
        }
        if(subtotaal3 == null){
            subtotaal3=0.0;
        }
        if(subtotaal4 == null){
            subtotaal4=0.0;
        }
        if(subtotaal5 == null){
            subtotaal5=0.0;
        }

        Subtotaal = subtotaal1 + subtotaal2 + subtotaal3 + subtotaal4 + subtotaal5;
        BTW = 0.21 * Subtotaal;
        PrijsTotaal = Subtotaal + BTW;

        TextView subtotaal = (TextView) findViewById(R.id.subtotaalvalue);
        subtotaal.setText(String.valueOf(Subtotaal));
        TextView btw = (TextView) findViewById(R.id.btwvalue);
        btw.setText(String.valueOf(BTW));
        TextView prijstotaal = (TextView) findViewById(R.id.totaalvalue);
        prijstotaal.setText(String.valueOf(PrijsTotaal));

    }

}




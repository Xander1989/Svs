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
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class factuurActivity extends Activity {

    public DatabaseHandler db;
    Spinner spinner, spinner2, spinner3, spinner4, spinner5;
    int a=0, b=0, c=0, d=0, e=0;
    Double subtotaal1, subtotaal2, subtotaal3, subtotaal4, subtotaal5, Subtotaal, BTW , PrijsTotaal;
    Artikel artikel_1, artikel_2, artikel_3, artikel_4, artikel_5;



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
            public void onItemSelected(AdapterView<?> parent, View selectedItemview,
                                       int pos, long id) {

                if (pos == 0) {
                    TextView naam = (TextView) findViewById(R.id.rij1_1);
                    naam.setText("Artikel");
                    TextView prijs = (TextView) findViewById(R.id.rij1_2);
                    prijs.setText("€");
                } else {
                    Artikel artikel = db.getArtikel(pos);
                    a = pos;
                    TextView naam = (TextView) findViewById(R.id.rij1_1);
                    naam.setText(artikel.getArtikel());
                    TextView prijs = (TextView) findViewById(R.id.rij1_2);
                    prijs.setText("€" + String.valueOf(artikel.getPrijs()));

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

        if(a == 0){
        }
        else{
            artikel_1= db.getArtikel(a);
            EditText editText1 = (EditText)findViewById(R.id.editText);
            double f = Double.parseDouble(editText1.getText().toString());
            subtotaal1 = artikel_1.getPrijs() * f;

            TextView code1 = (TextView) findViewById(R.id.code1);
            code1.setText(String.valueOf(artikel_1.getCode()));
            TextView artikel1 = (TextView) findViewById(R.id.artikel1);
            artikel1.setText(artikel_1.getArtikel());
            TextView stukprijs1 = (TextView) findViewById(R.id.stukprijs1);
            stukprijs1.setText(String.valueOf(artikel_1.getPrijs()));
            TextView prijs1 = (TextView) findViewById(R.id.prijs1);
            prijs1.setText(String.valueOf(subtotaal1));
        }
        if(b == 0){
        }
        else{
            artikel_2= db.getArtikel(b);
            EditText editText2 = (EditText)findViewById(R.id.editText2);
            double g = Double.parseDouble(editText2.getText().toString());
            subtotaal2 = artikel_2.getPrijs() * g;

            TextView code2 = (TextView) findViewById(R.id.code2);
            code2.setText(String.valueOf(artikel_2.getCode()));
            TextView artikel2 = (TextView) findViewById(R.id.artikel2);
            artikel2.setText(artikel_2.getArtikel());
            TextView stukprijs2 = (TextView) findViewById(R.id.stukprijs2);
            stukprijs2.setText(String.valueOf(artikel_2.getPrijs()));
            TextView prijs2 = (TextView) findViewById(R.id.prijs2);
            prijs2.setText(String.valueOf(subtotaal2));
        }
        if(c == 0){
        }
        else{
            artikel_3= db.getArtikel(c);
            EditText editText3 = (EditText)findViewById(R.id.editText3);
            double h = Double.parseDouble(editText3.getText().toString());
            subtotaal3 = artikel_3.getPrijs() * h;

            TextView code3 = (TextView) findViewById(R.id.code3);
            code3.setText(String.valueOf(artikel_3.getCode()));
            TextView artikel3 = (TextView) findViewById(R.id.artikel3);
            artikel3.setText(artikel_3.getArtikel());
            TextView stukprijs3 = (TextView) findViewById(R.id.stukprijs3);
            stukprijs3.setText(String.valueOf(artikel_3.getPrijs()));
            TextView prijs3 = (TextView) findViewById(R.id.prijs3);
            prijs3.setText(String.valueOf(subtotaal3));
        }
        if(d == 0){
        }
        else{
            artikel_4= db.getArtikel(d);
            EditText editText4 = (EditText)findViewById(R.id.editText4);
            double i = Double.parseDouble(editText4.getText().toString());
            subtotaal4 = artikel_4.getPrijs() * i;

            TextView code4 = (TextView) findViewById(R.id.code4);
            code4.setText(String.valueOf(artikel_4.getCode()));
            TextView artikel4 = (TextView) findViewById(R.id.artikel4);
            artikel4.setText(artikel_4.getArtikel());
            TextView stukprijs4 = (TextView) findViewById(R.id.stukprijs4);
            stukprijs4.setText(String.valueOf(artikel_4.getPrijs()));
            TextView prijs4 = (TextView) findViewById(R.id.prijs4);
            prijs4.setText(String.valueOf(subtotaal4));
        }
        if(e == 0){
        }
        else{
            artikel_5= db.getArtikel(e);
            EditText editText5 = (EditText)findViewById(R.id.editText5);
            double a = Double.parseDouble(editText5.getText().toString());
            subtotaal5 = artikel_5.getPrijs() * a;

            TextView code5 = (TextView) findViewById(R.id.code5);
            code5.setText(String.valueOf(artikel_5.getCode()));
            TextView artikel5 = (TextView) findViewById(R.id.artikel5);
            artikel5.setText(artikel_5.getArtikel());
            TextView stukprijs5 = (TextView) findViewById(R.id.stukprijs5);
            stukprijs5.setText(String.valueOf(artikel_5.getPrijs()));
            TextView prijs5 = (TextView) findViewById(R.id.prijs5);
            prijs5.setText(String.valueOf(subtotaal5));
        }

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

        DecimalFormat dec = new DecimalFormat("#.00");

        Subtotaal = subtotaal1 + subtotaal2 + subtotaal3 + subtotaal4 + subtotaal5;
        BTW = 0.21 * Subtotaal;
        PrijsTotaal = Subtotaal + BTW;

        TextView subtotaal = (TextView) findViewById(R.id.subtotaalvalue);
        subtotaal.setText(String.valueOf(dec.format(Subtotaal)));
        TextView btw = (TextView) findViewById(R.id.btwvalue);
        btw.setText(String.valueOf(dec.format(BTW)));
        TextView prijstotaal = (TextView) findViewById(R.id.totaalvalue);
        prijstotaal.setText(String.valueOf(dec.format(PrijsTotaal)));

    }

    public void sendEmail (View view){
        String[] resultaat = new String[]{artikel_1.getArtikel(), artikel_2.getArtikel(), artikel_3.getArtikel(), artikel_4.getArtikel(), artikel_5.getArtikel()};
        Double[] prijsresultaat = new Double[] {subtotaal1, subtotaal2, subtotaal3, subtotaal4, subtotaal5, Subtotaal, BTW, PrijsTotaal};
        String[] s = new String[prijsresultaat.length];

        for (int i = 0; i < s.length; i++)
            s[i] = String.valueOf(prijsresultaat[i]);

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"mark.vangerwen@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "Nieuwe Factuur");
        i.putExtra(Intent.EXTRA_TEXT   , s);
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(factuurActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }


}




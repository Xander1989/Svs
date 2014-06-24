package com.example.app;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TabHost;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 23-6-14.
 */
public class artikelActivity extends Activity {


    EditText codeTxt, artikelTxt, prijsTxt;
    List<Artikel> Artikelen = new ArrayList<Artikel>();
    ListView artikelListView;
    DatabaseHandler db;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artikel);

        codeTxt = (EditText) findViewById(R.id.artikelcode);
        artikelTxt = (EditText) findViewById(R.id.artikelnaam);
        prijsTxt = (EditText) findViewById(R.id.artikelprijs);
        artikelListView = (ListView) findViewById(R.id.listView);

        db = new DatabaseHandler(getApplicationContext());

        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("add_artikel");
        tabSpec.setContent(R.id.addArtikel);
        tabSpec.setIndicator("add_artikel");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("artikel_list");
        tabSpec.setContent(R.id.artikelList);
        tabSpec.setIndicator("artikel_list");
        tabHost.addTab(tabSpec);

        populateList();

        final Button addBtn = (Button) findViewById(R.id.artikel_button);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Artikel artikel = new Artikel(1, Double.parseDouble(codeTxt.getText().toString()), String.valueOf(artikelTxt.getText()), Double.parseDouble(prijsTxt.getText().toString()));
                db.insertArtikel(artikel);
                Artikelen.add(artikel);
                populateList();
                Toast.makeText(getApplicationContext(), artikelTxt.getText().toString() + " Has been added to your artikelen", Toast.LENGTH_SHORT).show();
            }
        });

    }


    public void populateList() {
        DatabaseHandler db = new DatabaseHandler(this);

        Cursor cursor = db.getArtikelen();

        String[] fromFieldIDs = new String[]
                {db.KEY_ARTIKEL, db.KEY_ID, db.KEY_PRIJS};
        int[] toViewIDs = new int[]
                {R.id.artikel_naam, R.id.artikel_code , R.id.artikel_prijs};


        SimpleCursorAdapter myCursorAdapter = new SimpleCursorAdapter(this, R.layout.listview_item, cursor, fromFieldIDs, toViewIDs);

        ListView idlist = (ListView) findViewById(R.id.listView);
        idlist.setAdapter(myCursorAdapter);

    }


}

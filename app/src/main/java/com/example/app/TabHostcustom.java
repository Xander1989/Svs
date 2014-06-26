package com.example.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;

/**
 * Created by Mark on 26-6-14.
 */
public class TabHostcustom extends Activity{


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.factuur);

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

    }
}

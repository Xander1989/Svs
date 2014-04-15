package com.example.app;

/**
 * Created by Mark on 14-4-14.
 */
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;
import android.content.Intent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;


public class resultActivity extends ActionBarActivity {

    double verhuiswagen1;
    double verhuizers1;
    double verhuislift1;
    double aanhanger1;
    double kilometers1;
    double wagen;
    double verhuizer;
    double verhuislift;
    double aanhanger;
    double kilometers;
    double subtotaal;
    double toeslag;
    double btw;
    double totaal;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_result);

        Intent intent = getIntent();

        verhuiswagen1 = intent.getDoubleExtra("verhuiswagen", 0.0);
        verhuizers1 = intent.getDoubleExtra("verhuizer", 0.0);
        verhuislift1 = intent.getDoubleExtra("verhuislift", 0.0);
        aanhanger1 = intent.getDoubleExtra("aanhanger", 0.0);
        kilometers1 = intent.getDoubleExtra("kilometers", 0.0);

        TextView verhuiswagenvalue;
        verhuiswagenvalue = (TextView) findViewById(R.id.verhuiswagenvalue);
        wagen = verhuiswagen1 * 24.50;

        TextView verhuizervalue;
        verhuizervalue = (TextView) findViewById(R.id.verhuizervalue);
        verhuizer = verhuizers1 * 24.50;

        TextView verhuisliftvalue;
        verhuisliftvalue = (TextView) findViewById(R.id.verhuisliftvalue);
        verhuislift = verhuislift1 * 45;

        TextView aanhangervalue;
        aanhangervalue = (TextView) findViewById(R.id.aanhangervalue);
        aanhanger = aanhanger1 * 12.50;

        TextView kilometersvalue;
        kilometersvalue = (TextView) findViewById(R.id.kilometersvalue);
        kilometers = kilometers1 * 0.5;
        if(kilometers>50){
            kilometers = 50;
        }
        else {
            kilometers = kilometers1 * 0.5;
        }

        TextView subtotaalvalue;
        TextView toeslagvalue;
        TextView btwvalue;
        TextView totaalvalue;

        subtotaalvalue = (TextView) findViewById(R.id.subtotaalvalue);
        toeslagvalue = (TextView) findViewById(R.id.toeslagvalue);
        btwvalue = (TextView) findViewById(R.id.btwvalue);
        totaalvalue = (TextView) findViewById(R.id.totaalvalue);

        DecimalFormat dec = new DecimalFormat("#.00");
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        dec.setDecimalFormatSymbols(dfs);


        subtotaal = wagen + verhuizer + verhuislift + aanhanger + kilometers;
        toeslag = subtotaal * 0.25;
        btw = subtotaal * 0.21;
        totaal = subtotaal + btw;


        verhuiswagenvalue.setText("" + Double.valueOf((dec.format(wagen))));
        verhuizervalue.setText("" + Double.valueOf((dec.format(verhuizer))));
        verhuisliftvalue.setText("" + Double.valueOf((dec.format(verhuislift))));
        aanhangervalue.setText("" + Double.valueOf((dec.format(aanhanger))));
        kilometersvalue.setText("" + Double.valueOf((dec.format(kilometers))));
        subtotaalvalue.setText("" + Double.valueOf((dec.format(subtotaal))));
        toeslagvalue.setText("" + Double.valueOf((dec.format(toeslag))));
        btwvalue.setText("" + Double.valueOf((dec.format(btw))));
        totaalvalue.setText("" + Double.valueOf((dec.format(totaal))));


    }
}

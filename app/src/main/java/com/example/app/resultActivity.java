package com.example.app;

/**
 * Created by Mark on 14-4-14.
 */
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;





public class resultActivity extends ActionBarActivity {

    double verhuiswagen1;
    double verhuizers1;
    double verhuislift1;
    double aanhanger1;
    double kilometers1;
    double subtotaal;
    double toeslag;
    double btw;
    double totaal;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_result);

        Intent intent = getIntent();

        TextView verhuiswagenvalue;
        verhuiswagenvalue = (TextView) findViewById(R.id.verhuiswagenvalue);
        double wagen = intent.getDoubleExtra("verhuiswagen", 0.0);

        TextView verhuizervalue;
        verhuizervalue = (TextView) findViewById(R.id.verhuizervalue);
        double verhuizer = intent.getDoubleExtra("verhuizer", 0.0);

        TextView verhuisliftvalue;
        verhuisliftvalue = (TextView) findViewById(R.id.verhuisliftvalue);
        double verhuislift = intent.getDoubleExtra("verhuislift", 0.0);

        TextView aanhangervalue;
        aanhangervalue = (TextView) findViewById(R.id.aanhangervalue);
        double aanhanger = intent.getDoubleExtra("aanhanger", 0.0);

        verhuiswagenvalue.setText("" + Double.valueOf(wagen));
        verhuizervalue.setText("" + Double.valueOf(verhuizer));
        verhuisliftvalue.setText("" + Double.valueOf(verhuislift));
        aanhangervalue.setText("" + Double.valueOf(aanhanger));

    }
}

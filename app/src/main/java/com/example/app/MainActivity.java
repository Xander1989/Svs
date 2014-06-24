package com.example.app;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends Activity {


    public DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        db = new DatabaseHandler(getApplicationContext());

     }


    public void newFactuur(View view) {
        Intent intent = new Intent(this, factuurActivity.class);
        startActivity(intent);
    }

    public void terms (View view) {
        Intent intent = new Intent(this, termsActivity.class);
        startActivity(intent);
    }

    public void login (View view){

        Intent intent = new Intent(this, loginActivity.class);
        startActivity(intent);
    }

}

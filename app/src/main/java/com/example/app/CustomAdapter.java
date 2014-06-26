package com.example.app;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mark on 26-6-14.
 */
class CustomAdapter extends BaseAdapter {

    ArrayAdapter<String> artikelen;
    Context ctxt;
    LayoutInflater inflater;


    public CustomAdapter(ArrayAdapter<String> array, Context c){
        artikelen = array;
        ctxt = c;
        inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 10;
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

    @Override
    public View getView(int arg0, View arg1, ViewGroup arg2) {
        // TODO Auto-generated method stub

        return arg1;
    }

}

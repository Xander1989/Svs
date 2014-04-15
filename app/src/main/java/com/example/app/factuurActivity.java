package com.example.app;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.CheckBox;



public class factuurActivity extends Activity implements OnClickListener{

    EditText text1;
    EditText text2;
    EditText text3;
    EditText text4;
    EditText text5;
    CheckBox checkBox;
    int a;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_factuur);

        text1= (EditText) findViewById(R.id.spinner1);
        text2= (EditText) findViewById(R.id.spinner2);
        text3= (EditText) findViewById(R.id.spinner3);
        text4= (EditText) findViewById(R.id.spinner4);
        text5= (EditText) findViewById(R.id.spinner5);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
        checkBox = (CheckBox) findViewById(R.id.weekend);
        btnSubmit.setOnClickListener(this);

    }

    public void onClick(View v) {

        if(((CheckBox) checkBox).isChecked()){
            a=1;
        }
        else{
            a=0;
        }


        Intent intent = new Intent(this, resultActivity.class);
        intent.putExtra("verhuiswagen", Double.parseDouble(text1.getText().toString()));
        intent.putExtra("verhuizer", Double.parseDouble(text2.getText().toString()));
        intent.putExtra("verhuislift", Double.parseDouble(text3.getText().toString()));
        intent.putExtra("aanhanger", Double.parseDouble(text4.getText().toString()));
        intent.putExtra("kilometers", Double.parseDouble(text5.getText().toString()));
        intent.putExtra("checkbox", a);
        startActivity(intent);
    }

}




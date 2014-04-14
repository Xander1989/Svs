package com.example.app;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;



public class factuurActivity extends Activity implements OnClickListener{

    private static double verhuiswagen ;
    private static double verhuizers ;
    private static double verhuislift ;
    private static double aanhanger ;

    EditText text1;
    EditText text2;
    EditText text3;
    EditText text4;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_factuur);

        text1= (EditText) findViewById(R.id.spinner1);
        text2= (EditText) findViewById(R.id.spinner2);
        text3= (EditText) findViewById(R.id.spinner3);
        text4= (EditText) findViewById(R.id.spinner4);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);

    }

    public void onClick(View v) {

        Intent intent = new Intent(this, resultActivity.class);
        intent.putExtra("verhuiswagen", Double.parseDouble(text1.getText().toString()));
        intent.putExtra("verhuizer", Double.parseDouble(text2.getText().toString()));
        intent.putExtra("verhuislift", Double.parseDouble(text3.getText().toString()));
        intent.putExtra("aanhanger", Double.parseDouble(text4.getText().toString()));
        startActivity(intent);
    }

}




package com.example.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Mark on 23-6-14.
 */
public class loginActivity extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        final Button btn_save = (Button)findViewById(R.id.button1);
        btn_save.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                final TextView username =(TextView)findViewById(R.id.editText1);
                final TextView password =(TextView)findViewById(R.id.editText2);
                String uname = username.getText().toString();
                String pass =  password.getText().toString();

                if(uname.equals("manager") && pass.equals("1234"))
                    startActivity(new Intent(loginActivity.this,artikelActivity.class).putExtra("usr",(CharSequence)uname));
                else
                    Toast.makeText(loginActivity.this, "Invalid UserName or Password", Toast.LENGTH_LONG).show();

            }
        });



    }

}

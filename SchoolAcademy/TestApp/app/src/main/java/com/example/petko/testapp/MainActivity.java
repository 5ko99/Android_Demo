package com.example.petko.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public int n=0;
    public int p=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText = (EditText) findViewById(R.id.editBox);
        String editT = editText.getText().toString();
        Toast.makeText(this,editT,Toast.LENGTH_SHORT).show();
    }

    public void buttonClcik(View view){
        TextView textView = (TextView) findViewById(R.id.TextView);
        n++;
        textView.setText("CLicked: "+n);
        Toast.makeText(this,"Clicked:"+n,Toast.LENGTH_SHORT).show();
        p+=20;
        textView.setPadding(p,0,p,0);
    }
}

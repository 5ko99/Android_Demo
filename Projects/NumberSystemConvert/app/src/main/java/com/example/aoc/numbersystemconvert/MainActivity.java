package com.example.aoc.numbersystemconvert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aoc.numbersystemconvert.Convert.Binar;
import com.example.aoc.numbersystemconvert.Convert.Decimal;
import com.example.aoc.numbersystemconvert.Math.Mathemathic;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void toDecimal(View view) {
        RadioButton radioButton = (RadioButton) view;
        EditText editText = (EditText) findViewById(R.id.number);
        String number;
        long result;

        number=editText.getText().toString();
        result=Decimal.ToDecimal(number);

        String check = number;
        String sResult = Long.toString(result);

        if(Mathemathic.isBinar(check)){
            editText.setText(sResult);
        }else{
            Toast.makeText(this, getString(R.string.errorMessage ),Toast.LENGTH_LONG).show();
        }
        
        
    }


    public void toBinar(View view) {
        RadioButton radioButton = (RadioButton) view;
        EditText editText = (EditText) findViewById(R.id.number);
        long number;
        String result;

        number=Integer.parseInt(editText.getText().toString());
        result= Binar.ToBinar(number);
        String sResult = result;

        editText.setText(sResult);
    }
}

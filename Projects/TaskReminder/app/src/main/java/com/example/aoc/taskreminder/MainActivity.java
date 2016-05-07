package com.example.aoc.taskreminder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reminder_list);
    }

    public void buttonClick(View view) {
        RadioButton radio_Button_1 =(RadioButton) findViewById(R.id.radio1);
        RadioButton radio_Button_2 =(RadioButton) findViewById(R.id.radio2);
        Button button = (Button) view;
        EditText editText = (EditText) findViewById(R.id.input);
        String toastMessage;
        toastMessage = editText.getText().toString();
        if(radio_Button_1.isChecked()){
            toastMessage+=" Male";
        }else{
            toastMessage+=" Female";
        }
        Toast.makeText(this,toastMessage,Toast.LENGTH_SHORT).show();
    }

    public void chechkBoxClicked(View view) {
        CheckBox checkBox = (CheckBox) view;
        Boolean isChecked = checkBox.isChecked();
        if(isChecked){
            checkBox.setText("Checked");
        }else{
            checkBox.setText("NOT Checked");
        }

        switch (checkBox.getId()){
            case R.id.checkbox_1: Toast.makeText(this,"checkbox_1",Toast.LENGTH_SHORT).show(); break;
            case R.id.checkbox_2: Toast.makeText(this,"checkbox_2",Toast.LENGTH_SHORT).show(); break;
            case R.id.checkbox_3: Toast.makeText(this,"checkbox_3",Toast.LENGTH_SHORT).show(); break;
        }
    }


}

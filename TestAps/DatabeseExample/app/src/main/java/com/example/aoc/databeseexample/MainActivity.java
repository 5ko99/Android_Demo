package com.example.aoc.databeseexample;

import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etInput;
    TextView txvResult;
    Button btnShow;
    Button btnSave;
    public static  String dbCreate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etInput = (EditText) findViewById(R.id.edit_input);
        txvResult = (TextView) findViewById(R.id.txv_main);
        btnShow = (Button) findViewById(R.id.btn_show);
        btnSave = (Button) findViewById(R.id.btn_save);
        btnShow.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        dbCreate=getString(R.string.onCreateDB);

    }

    @Override
    protected void onResume() {
        super.onResume();
        show();
    }

    @Override
    public void onClick(View v) {
        DBPref pref = new DBPref(getApplicationContext());  // Правим обекта
        //Проверяваме кой бутон е натиснат
        if(v.getId()==R.id.btn_save){
            pref.addRecord(etInput.getText().toString()); // Извикваме метода addRecord
            show();
            Toast.makeText(this,"Successful save "+etInput.getText().toString(),Toast.LENGTH_SHORT).show();
        }else{
           show();
        }
    }

    public void onClickDelete(View view) {
        String text = etInput.getText().toString();
        delete(text);
    }

    private void delete(String text) {
        DBPref pref = new DBPref(getApplicationContext());
        if(pref.delete(text)){
            Toast.makeText(this,"Successful delete "+text,Toast.LENGTH_SHORT).show();
            show();
        }else{
            Toast.makeText(this,"Error! No user with that name in DB",Toast.LENGTH_SHORT).show();
        }
    }

    private void show(){
        DBPref pref = new DBPref(getApplicationContext());
        Cursor c = pref.getVals(); // Правим курсор и взимаме информацията от базата

        StringBuilder b = new StringBuilder(); //Правим стринг билдер
        if(c.moveToFirst()){  // Слагаме курсора от начало ако няма записи това ще даде false ако има записи ще даде true
            do{ // Обхождаме курсора
                b.append(c.getString(c.getColumnIndex("val"))); //Добавяме към стринг билдера всички редове от колоната val
                b.append(","); // Добавяме разстояние и запетайка
            }while (c.moveToNext()); // Докато се премести на следващот

            c.close(); //Затваряме курсора
            pref.close(); // Затвяряме базата данни
            txvResult.setText(b.toString());
        }
    }
}

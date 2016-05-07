package com.example.petko.layout2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button delButton = (Button) findViewById(R.id.btnDelete);
        Button btn = (Button) findViewById(R.id.butn);
        final ListView listView = (ListView) findViewById(R.id.list);
        final ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPref", MODE_PRIVATE);
       String shared =  sharedPreferences.getString("key","[No Value]");
        EditText editText = (EditText) findViewById(R.id.EditText);
        editText.setText(shared);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = ((EditText) findViewById(R.id.EditText)).getText().toString();
                adapter.add(text);
                listView.setAdapter(adapter);
            }
        });
        final Intent intent = new Intent(this, DetailsActivity.class);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> myAdapter, View myView, int pos, long mylng) {
                String item =(listView.getItemAtPosition(pos).toString());
                intent.putExtra("MSG:",item);
                startActivity(intent);

            }
        });

        /*listView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
               if(event.getAction()==MotionEvent.ACTION_MOVE){
                   delButton.setVisibility(View.VISIBLE);
               }
                return true;
            }
        });*/

           /*  btn.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
               if(event.getAction()==MotionEvent.ACTION_BUTTON_RELEASE){
                   delButton.setVisibility(View.VISIBLE);
                   Toast.makeText(getApplicationContext(),"release",Toast.LENGTH_LONG).show();
               }
                return true;
            }
        });*/


}

    public void shared(View view) {
        EditText editText = (EditText) findViewById(R.id.EditText);
        String toSave = editText.getText().toString();
        SharedPreferences sharedPreferences = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("key", toSave);
        editor.commit();


        String shared =  sharedPreferences.getString("key","[No Value]");
        editText.setText(shared);
    }


}

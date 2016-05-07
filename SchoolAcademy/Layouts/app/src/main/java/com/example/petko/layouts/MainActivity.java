package com.example.petko.layouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.Id.btn);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2);
        adapter.add("Gosho");
        adapter.add("Ivancho");

        btn.setOnClickListener((view) -> {
            String text = ((EditText) this.findViewById(android.R.id.EditText)).getText().toString();
           adapter.add(text);
        });
    }
}
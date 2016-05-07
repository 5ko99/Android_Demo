package com.example.aoc.servicesdemo;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.aoc.servicesdemo.services.MyService;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





    }

    public void StartServices(View view) {
        Intent servicesIntent  = new Intent(this, MyService.class);
        startService(servicesIntent);
    }

    public void stopServices(View view) {
        Intent servicesIntent  = new Intent(this, MyService.class);
        stopService(servicesIntent);
    }








}

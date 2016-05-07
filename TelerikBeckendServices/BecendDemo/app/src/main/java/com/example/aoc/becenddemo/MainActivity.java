package com.example.aoc.becenddemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.telerik.everlive.sdk.core.EverliveApp;
import com.telerik.everlive.sdk.core.EverliveAppSettings;
import com.telerik.everlive.sdk.core.result.RequestResult;
import com.telerik.everlive.sdk.core.result.RequestResultCallbackAction;

public class MainActivity extends AppCompatActivity {
    public EditText editText;
    public static final String APP_ID = "89ujn00lk51rsno5";
    public EverliveApp myApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editText = (EditText) findViewById(R.id.et_name);
        initializeSdk();
    }

    private void initializeSdk() {
        EverliveAppSettings appSettings = new EverliveAppSettings();
        appSettings.setAppId(APP_ID);
        appSettings.setUseHttps(true);

        myApp = new EverliveApp(appSettings);
    }


    public void pullInfo(View view) {
    }

    public void pushName(View view) {
        createEntry();

    }

    private void createEntry() {
        String name = editText.getText().toString();
        CommonTable ct = new CommonTable();
        ct.setName(name);
        myApp.workWith().data(CommonTable.class).create(ct).executeAsync();

    }
}

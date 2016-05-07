package com.example.aoc.telerikbeckend;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.aoc.telerikbeckend.Data.CommonTable;
import com.telerik.everlive.sdk.core.EverliveApp;
import com.telerik.everlive.sdk.core.EverliveAppSettings;
import com.telerik.everlive.sdk.core.result.RequestResult;
import com.telerik.everlive.sdk.core.result.RequestResultCallbackAction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;


public class MainActivity extends AppCompatActivity {

        private static final String APP_ID = "89ujn00lk51rsno5";
        public EverliveApp myApp;
        public List<String> arr = new ArrayList<String>();
        public String name = "Asia";
        public int age = 40;
        public int count=0;
        public int size=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context context = getApplication();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        final ListView listView = (ListView) findViewById(R.id.listView);



        initializeSdk();
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                size=arr.size();
                getAllEntrys();

                if(size==arr.size() && count!=0){
                    Toast.makeText(context,"Nothing new on Server",Toast.LENGTH_SHORT).show();
                    count++;
                }else{
                    ListAdapter adapter = new ArrayAdapter<String>(context,R.layout.list_item,arr);
                    listView.setAdapter(adapter);
                    count++;
                }


               // printArrayList(arr);





            }
        });


    }

    private void printArrayList(ArrayList<String> arr) {
        System.out.println(arr.toString());
    }


    private void initializeSdk() {
        EverliveAppSettings appSettings = new EverliveAppSettings();
        appSettings.setAppId(APP_ID);
        appSettings.setUseHttps(true);

        myApp = new EverliveApp(appSettings);
    }


    private   void getAllEntrys() {
                arr.clear();
                final Context context = this.getApplicationContext();
                myApp.workWith().data(CommonTable.class).getAll().executeAsync(new RequestResultCallbackAction<ArrayList<CommonTable>>() {

                    @Override
                    public void invoke(RequestResult<ArrayList<CommonTable>> requestResult) {
                        if(requestResult.getSuccess()) {
                            for (CommonTable res  : requestResult.getValue()) {
                                arr.add(res.getName());
                            }
                        }
                        else {

                        }



            }

        });
    }


    private void createEntry() {
        CommonTable ct = new CommonTable();
        ct.setName(name);
        ct.setAge(age);
        myApp.workWith().data(CommonTable.class).create(ct).executeAsync(new RequestResultCallbackAction<CommonTable>() {
            @Override
            public void invoke(RequestResult<CommonTable> requestResult) {
                if(requestResult.getSuccess()) {
                    //System.out.println("===== Success: " +requestResult.getValue().getName());
                }
                else {
                    //System.out.println("===== Errror: " + requestResult.getError().toString());
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        createEntry();
    }
}

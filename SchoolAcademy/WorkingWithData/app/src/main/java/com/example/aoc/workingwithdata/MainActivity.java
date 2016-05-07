package com.example.aoc.workingwithdata;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.net.URI;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        final VideoView videoView = (VideoView) findViewById(R.id.videoView);
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse("rtsp://r8---sn-5hne6nl6.googlevideo.com/Cj0LENy73wIaNAmomp6i8MGsbBMYDSANFC3xdSxXMOCoAUIASARgucK2y7XLnKRWigELbFlCbU53N1h2cG8M/C60211C9DE7383A36B4EA1E43BCA91505B3EA1FD.B80FF66AF38E457E6D39929462B985819EE43C9F/yt6/1/video.3gp");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);

        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    videoView.requestFocus();
                    videoView.start();
                    Toast.makeText(getApplicationContext(),"Video Started",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


    public void onClick(View v) {
        String key = getString(R.string.username);
        EditText editText = (EditText) findViewById(R.id.et_text);
        String username = editText.getText().toString();

                 getPreferences(Context.MODE_PRIVATE) .edit().putString(key, username).commit();
                 Toast.makeText(this.getApplicationContext(), "Saved to preferences", Toast.LENGTH_SHORT).show();
    }

    public  void onClickShow(View v){
        String key = getString(R.string.username);

        String value =getPreferences(Context.MODE_PRIVATE).getString(key, "non existent");

        Toast.makeText(this.getApplicationContext(), key + " => " + value, Toast.LENGTH_SHORT).show();
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
}

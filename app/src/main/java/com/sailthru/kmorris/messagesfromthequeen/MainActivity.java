package com.sailthru.kmorris.messagesfromthequeen;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.carnival.sdk.Carnival;
import com.carnival.sdk.NotificationConfig;
import com.carnivalmobile.stream.card.CardStreamActivity;

public class MainActivity extends AppCompatActivity {
    MediaPlayer queen1;
    MediaPlayer queen2;
    MediaPlayer queen3;
    MediaPlayer queen4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Carnival.startEngine(getApplicationContext(), "0434e0e6402de1bf9a4fcc13c64a5804dc3af2d8");
        queen1 = MediaPlayer.create(this, R.raw.friedchicken);
        queen2 = MediaPlayer.create(this, R.raw.raven);
        queen3 = MediaPlayer.create(this, R.raw.largeandincharge);
        queen4 = MediaPlayer.create(this, R.raw.calmdownbeyonce);



        // setting a User ID after login
        Carnival.setUserId("kirsty_mobile_carnival", new Carnival.CarnivalHandler<Void>(){

            @Override
            public void onSuccess (Void value){
                //Do Something
            }

            @Override
            public void onFailure (Error error){
                //Do Something
            }
        });

        // setting a User Email after login
        Carnival.setUserEmail("kmorris+carnival@sailthru.com", new Carnival.CarnivalHandler<Void>(){

            @Override
            public void onSuccess (Void value){
                //Do Something
            }

            @Override
            public void onFailure (Error error){
                //Do Something
            }
        });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click action
                Intent intent = new Intent(MainActivity.this, MessageStream.class);
                startActivity(intent);
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

    public void queen2(View view) {
        queen1.start();
    }

    public void queen1(View view) {
        queen2.start();
    }

    public void queen3(View view) {
        queen3.start();
    }

    public void queen4(View view) {
        queen4.start();
    }



}


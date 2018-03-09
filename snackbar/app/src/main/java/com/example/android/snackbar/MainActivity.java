package com.example.android.snackbar;

import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.FloatingActionButton;
import android.view.*;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.shitij.goyal.slidebutton.SwipeButton;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //declarations
      
        Button btnWifi = (Button) findViewById(R.id.idBtnWifi);
        Button btnAdd = (Button) findViewById(R.id.idBtnAdd);
        Button btnChg;
        btnChg = (Button) findViewById(R.id.idBtnChg);
        final FloatingActionButton fabVoice = findViewById(R.id.idfabVoice);
        final Vibrator vibe = (Vibrator) MainActivity.this.getSystemService(Context.VIBRATOR_SERVICE);



        //voice floating button
        fabVoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce);
                fabVoice.startAnimation(animation);
            }
        });
        fabVoice.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                vibe.vibrate(1500);
                return true;
            }

        });

        //wifi settings
        btnWifi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WifiManager wifi = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                wifi.setWifiEnabled(true);
                Snackbar snackbar = Snackbar.make(findViewById(R.id.idLayout),"Wifi is ON",Snackbar.LENGTH_INDEFINITE)
                        .setAction("TURN OFF", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                WifiManager wifi = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                                wifi.setWifiEnabled(false);
                                Snackbar snackbar = Snackbar.make(findViewById(R.id.idLayout),"Wifi OFF",Snackbar.LENGTH_LONG);
                            }
                        });
                snackbar.show();
            }
        });
        btnWifi.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                return true;
            }

        });

        //room settings
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ScrollingActivity.class));
                Snackbar snackbar = Snackbar.make(findViewById(R.id.idLayout),"Device Add",Snackbar.LENGTH_LONG)
                        .setAction("Retry", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });
                snackbar.show();
            }
        });

        //status settings
        btnChg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,control_device.class));
                Snackbar snackbar = Snackbar.make(findViewById(R.id.idLayout),"Device on/off",Snackbar.LENGTH_LONG)
                        .setAction("Retry", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                            }
                        });
                snackbar.show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this,"Nilesh ur app is cool",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(this,"ohh wait!! nilesh is cool",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}

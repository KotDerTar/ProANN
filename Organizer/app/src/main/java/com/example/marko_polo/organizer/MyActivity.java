package com.example.marko_polo.organizer;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.*;
import java.net.*;



import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class MyActivity extends Activity {
    LinearLayout L1;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        L1 = (LinearLayout) findViewById(R.id.CreateNew);
        Button but = (Button) findViewById(R.id.start);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void goToExistConnectionActivity (View v) {
        Intent intent = new Intent(this, ExistConnectionActivity.class);
        startActivity(intent);
    }
    public void goToCreateNewActivity (View v) {
        Intent intent = new Intent(this, CreateNewActivity.class);
        startActivity(intent);
    }

    public void goToHelpActivity (View v){
        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);
    }
   /* public void onClick(View v){
        View v1 = L1.getRootView();
        v1.setDrawingCacheEnabled(true);
        Bitmap bm = v1.getDrawingCache();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bm);
        image = (ImageView) findViewById(R.id.CreateNew);
        image.setBackgroundDrawable(bitmapDrawable); }*/

}

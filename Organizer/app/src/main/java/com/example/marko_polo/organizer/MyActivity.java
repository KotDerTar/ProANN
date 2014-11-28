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
import android.widget.Toast;

import java.io.*;
import java.net.*;



import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class MyActivity extends Activity {
    LinearLayout L1;
    ImageView startANNImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        L1 = (LinearLayout) findViewById(R.id.CreateNew);
        Button but = (Button) findViewById(R.id.start);
        startANNImg = (ImageView)findViewById(R.id.imgStartANN);
        startANNImg.setImageResource(R.drawable.startANN);
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
}

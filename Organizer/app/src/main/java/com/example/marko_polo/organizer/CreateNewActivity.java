package com.example.marko_polo.organizer;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Button;
import android.graphics.Bitmap; import android.graphics.drawable.BitmapDrawable;

import android.widget.TextView;



/**
 * Created by Marko_Polo on 21.11.2014.
 */
public class CreateNewActivity extends Activity {
    LinearLayout L1;
    ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new);
    }
}







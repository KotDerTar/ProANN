package com.example.marko_polo.organizer;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Button;
import android.graphics.Bitmap; import android.graphics.drawable.BitmapDrawable;





/**
 * Created by Marko_Polo on 21.11.2014.
 */
public class CreateNewActivity extends Activity {
    LinearLayout L1;
    ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //MakeServer();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new);
        L1 = (LinearLayout) findViewById(R.id.CreateNew);
        Button but = (Button) findViewById(R.id.start);

    }
    public void onClick(View v){
        View v1 = L1.getRootView();
        v1.setDrawingCacheEnabled(true);
        Bitmap bm = v1.getDrawingCache();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bm);
        image = (ImageView) findViewById(R.id.CreateNew);
        image.setBackgroundDrawable(bitmapDrawable); }
   /* public void MakeServer(){
        try{
            ServerSocket serversoket = new ServerSocket(5000);
            while(true){
                Socket sock = serversoket.accept();
                PrintWriter printwriter = new PrintWriter(sock.getOutputStream());
                printwriter.println("Hello Kitti");
                printwriter.close();
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }

    }*/
}







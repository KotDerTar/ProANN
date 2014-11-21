package com.example.marko_polo.organizer;

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


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
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

    public void goToHelpActivity (View v){
        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);
    }
    public void MakeServer(){
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

    }
}

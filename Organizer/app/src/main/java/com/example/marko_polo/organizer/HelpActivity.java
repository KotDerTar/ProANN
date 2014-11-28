package com.example.marko_polo.organizer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class HelpActivity extends Activity {

    ImageView helpImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        helpImg = (ImageView)findViewById(R.id.imgHelp);
        helpImg.setImageResource(R.drawable.help_ann);
    }



    public void goToMyActivity(View v){
        Intent intent = new Intent(this,MyActivity.class);
        startActivity(intent);
    }
}

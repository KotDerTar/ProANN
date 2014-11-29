package com.example.marko_polo.organizer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
<<<<<<< HEAD
=======
import android.widget.ImageView;
>>>>>>> b894dcde7c17c7a52700d725390c1059040406f4
import android.widget.Toast;


public class HelpActivity extends Activity {

<<<<<<< HEAD
=======
    ImageView helpImg;

>>>>>>> b894dcde7c17c7a52700d725390c1059040406f4
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
<<<<<<< HEAD
=======
        helpImg = (ImageView)findViewById(R.id.imgHelp);
        helpImg.setImageResource(R.drawable.help_ann);
>>>>>>> b894dcde7c17c7a52700d725390c1059040406f4
    }



    public void goToMyActivity(View v){
        Intent intent = new Intent(this,MyActivity.class);
        startActivity(intent);
    }
}

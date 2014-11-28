package com.example.marko_polo.organizer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;


public class ProjectorActivity extends Activity {

    ImageView projectorImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projector);


        projectorImg = (ImageView)findViewById(R.id.imgProjector);
        makeExistConnection ();

      //  projectorImg.setImageResource(R.drawable.spider_yes_colored);
    }
    public void makeExistConnection () {

        Client client = new Client();
        try {
            client.run();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

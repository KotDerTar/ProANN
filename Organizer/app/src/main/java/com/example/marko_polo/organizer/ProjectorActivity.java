package com.example.marko_polo.organizer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by Natasha on 27.11.2014.
 */
public class ProjectorActivity extends Activity {

    ImageView projectorImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projector);

        projectorImg = (ImageView)findViewById(R.id.imgProjector);
        projectorImg.setImageResource(R.drawable.spider_yes_colored);
    }
}

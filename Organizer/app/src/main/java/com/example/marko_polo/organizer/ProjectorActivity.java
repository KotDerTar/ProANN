package com.example.marko_polo.organizer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

<<<<<<< HEAD
import java.io.IOException;

=======
>>>>>>> b894dcde7c17c7a52700d725390c1059040406f4

public class ProjectorActivity extends Activity {

    ImageView projectorImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projector);

<<<<<<< HEAD

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


=======
        projectorImg = (ImageView)findViewById(R.id.imgProjector);
        projectorImg.setImageResource(R.drawable.spider_yes_colored);
>>>>>>> b894dcde7c17c7a52700d725390c1059040406f4
    }
}

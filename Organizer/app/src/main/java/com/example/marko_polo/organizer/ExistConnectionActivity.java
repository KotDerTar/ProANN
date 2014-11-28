package com.example.marko_polo.organizer;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class ExistConnectionActivity extends Activity {

    EditText nameTxt, linkTxt, emailTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exist_connection);

        nameTxt = (EditText) findViewById(R.id.txtName);
        linkTxt = (EditText) findViewById(R.id.txtLink);
        emailTxt = (EditText) findViewById(R.id.txtEmail);
        final Button makeExistConnectionBtn = (Button) findViewById(R.id.btnMakeExistConnection);

        nameTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                makeExistConnectionBtn.setEnabled(!nameTxt.getText().toString().trim().isEmpty());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    public void goBackToMyActivity (View v) {
        Intent intent = new Intent(this, MyActivity.class);
        startActivity(intent);
    }

    public  void goToProjectorActivity (View v) {
        Intent intent = new Intent(this, ProjectorActivity.class);
        startActivity(intent);
    }




}

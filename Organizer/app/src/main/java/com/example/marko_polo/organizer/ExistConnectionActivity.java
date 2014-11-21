package com.example.marko_polo.organizer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


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

    public void makeExistConnection () {
        try{
            Socket s = new Socket ("127.0.0.1", 4242);
            InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);

            String advice = reader.readLine();
            System.out.println("hello" + advice);
            reader.close();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
    public static  void main (String[] args) {
        ExistConnectionActivity client = new ExistConnectionActivity();
    client.makeExistConnection();
    }

}

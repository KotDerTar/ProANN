package com.example.marko_polo.organizer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.minimize:
                Toast.makeText(this, "Minimize", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.close:
                System.exit(0);

        }


        return super.onOptionsItemSelected(item);
    }

    public void goBackToMyActivity (View v) {
        Intent intent = new Intent(this, MyActivity.class);
        startActivity(intent);
    }

    public void makeExistConnection () {
        try{
            Socket s = new Socket ("192.168.195.1", 5000);
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

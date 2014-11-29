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
<<<<<<< HEAD

=======
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
>>>>>>> b894dcde7c17c7a52700d725390c1059040406f4


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

<<<<<<< HEAD


=======
    public void makeExistConnection () {
        int serverPort = 6666; // здесь обязательно нужно указать порт к которому привязывается сервер.
        String address = "192.168.195.1"; // это IP-адрес компьютера, где исполняется наша серверная программа.
        // Здесь указан адрес того самого компьютера где будет исполняться и клиент.

        try {
            InetAddress ipAddress = InetAddress.getByName(address); // создаем объект который отображает вышеописанный IP-адрес.
            //System.out.println("Any of you heard of a socket with IP address " + address + " and port " + serverPort + "?");
            Socket socket = new Socket(ipAddress, serverPort); // создаем сокет используя IP-адрес и порт сервера.
            //System.out.println("Yes! I just got hold of the program.");

            // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиентом.
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            // Создаем поток для чтения с клавиатуры.
            //BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            ImageView screenView;
            Bitmap bm;
            DataInputStream dIn = new DataInputStream(sin);
            int length = dIn.readInt();
            if (length > 0){
                byte [] screen = new byte [length];
                dIn.readFully(screen, 0, screen.length);
                bm = BitmapFactory.decodeByteArray(screen, 0, screen.length);
                BitmapDrawable futureScreen = new BitmapDrawable(bm);
                screenView = (ImageView) findViewById(R.id.imgProjector);
                screenView.setBackgroundDrawable(futureScreen);
            }





            //String line = null;
            //System.out.println("Type in something and press enter. Will send it to the server and tell ya what it thinks.");
            //System.out.println();

            //    while (true) {
            //   bm = in.read(); // ждем пока пользователь введет что-то и нажмет кнопку Enter.
            //System.out.println("Sending this line to the server...");
            // out.writeUTF(line); // отсылаем введенную строку текста серверу.
            // out.flush(); // заставляем поток закончить передачу данных.
            //line = in.readUTF(); // ждем пока сервер отошлет строку текста.
            // byteScreen = in.readFully();
            //System.out.println("The server was very polite. It sent me this : " + line);
            //System.out.println("Looks like the server is pleased with us. Go ahead and enter more lines.");
            //System.out.println();
            //   }
        } catch (Exception x) {
            x.printStackTrace();
        }

    }
    public static  void main (String[] args) {
        ExistConnectionActivity client = new ExistConnectionActivity();
    client.makeExistConnection();
    }
>>>>>>> b894dcde7c17c7a52700d725390c1059040406f4

}

package com.example.marko_polo.organizer;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Button;
import android.graphics.Bitmap; import android.graphics.drawable.BitmapDrawable;

import android.widget.TextView;



/**
 * Created by Marko_Polo on 21.11.2014.
 */
public class CreateNewActivity extends Activity {
    LinearLayout L1;
    ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new);
        /*L1 = (LinearLayout) findViewById(R.id.CreateNew);
        Button but = (Button) findViewById(R.id.start);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MakeServer();
                View v1 = L1.getRootView();
                v1.setDrawingCacheEnabled(true);
                Bitmap bm = v1.getDrawingCache();
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bm);
                image = (ImageView) findViewById(R.id.imageViewSC);
                image.setBackgroundDrawable(bitmapDrawable);
            }
        });*/
    }

    public void onClick(View v){
        MakeServer();


    /*public void onClick(View v){
       /* View v1 = L1.getRootView();
        v1.setDrawingCacheEnabled(true);
        Bitmap bm = v1.getDrawingCache();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bm);
        image = (ImageView) findViewById(R.id.CreateNew);
        image.setBackgroundDrawable(bitmapDrawable); */
   //public void MakeServer(){
       /* try{
            ServerSocket serversoket = new ServerSocket(5000);
            while(true){
                Socket sock = serversoket.accept();
                PrintWriter printwriter = new PrintWriter(sock.getOutputStream());
                printwriter.println("Hello Kitti");
                printwriter.close();
            }
        }
        catch(IOException ex){
            ex.printStackTrace();*/

        }
   public void MakeServer(){
       int port = 6666; // случайный порт (может быть любое число от 1025 до 65535)
       try {
           ServerSocket ss = new ServerSocket(port); // создаем сокет сервера и привязываем его к вышеуказанному порту
           TextView TextShowState = (TextView) findViewById(R.id.textViewWorkingState);
           TextShowState.setText("Waiting for a client...");
          // System.out.println("Waiting for a client...");

           Socket socket = ss.accept(); // заставляем сервер ждать подключений и выводим сообщение когда кто-то связался с сервером
           TextShowState.setText("Got a client :) ... Finally, someone saw me through all the cover!");
           //System.out.println("Got a client :) ... Finally, someone saw me through all the cover!");
          // System.out.println();

           // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиенту.
           InputStream sin = socket.getInputStream();
           OutputStream sout = socket.getOutputStream();

           // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
           DataInputStream in = new DataInputStream(sin);
           DataOutputStream out = new DataOutputStream(sout);

           String line = null;
           while(true) {
               line = in.readUTF(); // ожидаем пока клиент пришлет строку текста.
               TextShowState.setText("The dumb client just sent me this line : " + line);
               //System.out.println("The dumb client just sent me this line : " + line);
               //System.out.println("I'm sending it back...");
               out.writeUTF(line); // отсылаем клиенту обратно ту самую строку текста.
               out.flush(); // заставляем поток закончить передачу данных.
               TextShowState.setText("Waiting for the next line...");
               //System.out.println("Waiting for the next line...");
               System.out.println();
           }
       } catch(Exception x) { x.printStackTrace(); }
   }
}







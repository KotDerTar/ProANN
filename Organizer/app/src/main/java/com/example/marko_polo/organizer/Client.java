package com.example.marko_polo.organizer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.wifi.p2p.WifiP2pManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import android.os.Bundle;
import android.app.Activity;

import java.io.IOException;

import java.net.Socket;

/**
 * Created by Marko_Polo on 28.11.2014.
 */
public class Client extends Activity{

    BufferedReader in;
    PrintWriter out;
    TextView textField = (TextView) findViewById(R.id.textViewSend);
    TextView areaMessage = (TextView) findViewById(R.id.textViewEntered);
    //JFrame frame = new JFrame("Chatter");
   // JTextField textField = new JTextField(40);
   // JTextArea messageArea = new JTextArea(8, 40);

    /**
     * Constructs the client by laying out the GUI and registering a
     * listener with the textfield so that pressing Return in the
     * listener sends the textfield contents to the server.  Note
     * however that the textfield is initially NOT editable, and
     * only becomes editable AFTER the client receives the NAMEACCEPTED
     * message from the server.
     */
    public Client() {

        // Layout GUI
       /* textField.setEditable(false);
        messageArea.setEditable(false);
        frame.getContentPane().add(textField, "North");
        frame.getContentPane().add(new JScrollPane(messageArea), "Center");
        frame.pack();*/



        // Add Listeners
        Button buttonStart = (Button) findViewById(R.id.buttonSend);
        buttonStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                out.println(textField.getText());
                textField.setText("");
            }

        });
       /* textField.addActionListener(new WifiP2pManager.ActionListener() {
            /**
             * Responds to pressing the enter key in the textfield by sending
             * the contents of the text field to the server.    Then clear
             * the text area in preparation for the next message.
             */
          /* public void actionPerformed(ActionEvent e) {
                out.println(textField.getText());
                textField.setText("");
            }
        });*/
    }

    /**
     * Prompt for and return the address of the server.
     */
    private String getServerAddress() {
        return "192.168.195.50";/*JOptionPane.showInputDialog(
                frame,
                "Enter IP Address of the Server:",
                "Welcome to the Chatter",
                JOptionPane.QUESTION_MESSAGE);*/
    }

    /**
     * Prompt for and return the desired screen name.
     */
    private String getName() {
        EditText name = (EditText) findViewById(R.id.txtName);
        return "SUBMITNAME " + name.getText();/*JOptionPane.showInputDialog(
                frame,
                "Choose a screen name:",
                "Screen name selection",
                JOptionPane.PLAIN_MESSAGE);*/
    }

    /**
     * Connects to the server then enters the processing loop.
     */
    public void run() throws IOException {

        // Make connection and initialize streams
        String serverAddress = getServerAddress();
        Socket socket = new Socket(serverAddress, 9001);
        DataInputStream in = new DataInputStream(
                socket.getInputStream());
        out = new PrintWriter(socket.getOutputStream(), true);
        out.println(getName());


        // Process all messages from server, according to the protocol.
        while (true) {
            ImageView screenView;
            Bitmap bm;
            DataInputStream dIn = new DataInputStream(in);
            int length = dIn.readInt();
            if (length > 0){
                byte [] screen = new byte [length];
                dIn.readFully(screen, 0, screen.length);
                bm = BitmapFactory.decodeByteArray(screen, 0, screen.length);
                BitmapDrawable futureScreen = new BitmapDrawable(bm);
                screenView = (ImageView) findViewById(R.id.imgProjector);
                screenView.setBackgroundDrawable(futureScreen);
            }
       }
    }

    /**
     * Runs the client as an application with a closeable frame.
     */

}

package com.mycompany.clientapp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private TextField TxtOut;
    @FXML
    private Button SendButton;
    @FXML
    private TextArea TxtIn;
    private Socket server;
    private DataInputStream ear;
    private PrintStream mouth;

    private Thread L = new Thread() {
        @Override
        public void run() {
            
                while (true) {
                    try {
                        String receivedMessage = ear.readLine();
                        if (receivedMessage != null) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    TxtIn.appendText(receivedMessage + "\n");
                                }
                            });
                        }
                    } catch (IOException ex) {
                    }
                }
            
        }
    };

    public PrimaryController() {
        try {
            server = new Socket("127.0.0.1", 5005);
            ear = new DataInputStream(server.getInputStream());
            mouth = new PrintStream(server.getOutputStream());
            L.start();

        }
        catch (IOException ex) {
        }
    }

    @FXML
    private void sendMessage() {
        String message = TxtOut.getText();
            mouth.println(message);
        
    }
}

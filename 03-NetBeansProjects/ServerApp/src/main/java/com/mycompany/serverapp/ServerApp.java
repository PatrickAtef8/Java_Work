/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.serverapp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author patrick
 */


public class ServerApp {
    private ServerSocket serverSocket;

    public ServerApp() {
        try {
            serverSocket = new ServerSocket(5005);
            while (true) {
                Socket s = serverSocket.accept();
                new ChatHandler(s);
            }
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) {
        new ServerApp();
    }
}

class ChatHandler extends Thread {
    private DataInputStream dis;
    private PrintStream ps;
    private static final Vector<ChatHandler> clientsVector = new Vector<>();
    private Socket clientSocket;

    public ChatHandler(Socket cs) {
        try {
            this.clientSocket = cs;
            dis = new DataInputStream(clientSocket.getInputStream());
            ps = new PrintStream(clientSocket.getOutputStream());
            clientsVector.add(this);
            start();
        } catch (IOException e) {
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                String str = dis.readLine();
                sendMessageToAll(str);
            }
        } catch (IOException e) {
        } 
        finally {
            try {
                ps.close();
                dis.close();
                clientSocket.close();
            } catch (IOException ex) {
                Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
 }
    }

    void sendMessageToAll(String msg) {
        for (int i = 0; i < clientsVector.size(); i++) {
            clientsVector.get(i).ps.println(msg);
        }
    }

  
}

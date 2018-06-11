/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

/**
 *
 * @author Arekl
 */
public class ApiThread extends Thread {

    Socket mySocket;

    public ApiThread(Socket socket) {
        super(); // konstruktor klasy Thread
        mySocket = socket;
    }

    public void run() {
        try {
            if (mySocket.getLocalPort() == 1100) {
                Database.polacz();
                InputStream inputStream = mySocket.getInputStream();
                ObjectInputStream objInputStream = null;
                objInputStream = new ObjectInputStream(inputStream);
                String option = (String) objInputStream.readObject();
                if(option.equalsIgnoreCase("test"))
                {
                    System.out.println(option);
                    objInputStream = new ObjectInputStream(inputStream);
                    String test = (String) objInputStream.readObject();
                    System.out.println(test);
                }
                if(option.equalsIgnoreCase("login"))
                {
                    System.out.println(option);
                    objInputStream = new ObjectInputStream(inputStream);
                    String numer = (String) objInputStream.readObject();
                    objInputStream = new ObjectInputStream(inputStream);
                    String haslo = (String) objInputStream.readObject();
                    int poziom = Database.login(Integer.parseInt(numer), Integer.parseInt(haslo));
                    OutputStream outputStream = mySocket.getOutputStream();
                    ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);
                    objOutputStream.writeObject(poziom);
                    objOutputStream.flush();
                }
                Database.zamknij();
            }
            mySocket.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}

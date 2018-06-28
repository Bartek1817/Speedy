/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import dane.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

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
                OutputStream outputStream = null;
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
                    outputStream = mySocket.getOutputStream();
                    ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);
                    objOutputStream.writeObject(poziom);
                    objOutputStream.flush();
                }
                if(option.equalsIgnoreCase("getLokacje"))
                {
                    System.out.println(option);
                    ArrayList<Lokacja> lokacje = Database.readLokacje();
                    outputStream = mySocket.getOutputStream();
                    ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);
                    objOutputStream.writeObject(lokacje.size());
                    objOutputStream.flush();
                    for(int i = 0; i<lokacje.size();i++)
                    {
                        System.out.println(i+":"+lokacje.get(i).getId());
                        objOutputStream = new ObjectOutputStream(outputStream);
                        objOutputStream.writeObject(lokacje.get(i).getId());
                        objOutputStream.flush();
                        objOutputStream = new ObjectOutputStream(outputStream);
                        objOutputStream.writeObject(lokacje.get(i).getNazwa());
                        objOutputStream.flush();
                        objOutputStream = new ObjectOutputStream(outputStream);
                        objOutputStream.writeObject(lokacje.get(i).getTyp());
                        objOutputStream.flush();
                        objOutputStream = new ObjectOutputStream(outputStream);
                        objOutputStream.writeObject(lokacje.get(i).getIp());
                        objOutputStream.flush();
                    }
                }
                if(option.equalsIgnoreCase("getZlecenia"))
                {
                    System.out.println(option);
                    ArrayList<Zlecenie> zlecenia = Database.readZlecenia();
                    outputStream = mySocket.getOutputStream();
                    ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);
                    objOutputStream.writeObject(zlecenia.size());
                    objOutputStream.flush();
                    for(int i = 0; i<zlecenia.size();i++)
                    {
                        System.out.println(i+":"+zlecenia.get(i).getId());
                        objOutputStream = new ObjectOutputStream(outputStream);
                        objOutputStream.writeObject(zlecenia.get(i).getId());
                        objOutputStream.flush();
                        objOutputStream = new ObjectOutputStream(outputStream);
                        objOutputStream.writeObject(zlecenia.get(i).getData());
                        objOutputStream.flush();
                    }
                }
                if(option.equalsIgnoreCase("addZlecenie"))
                {
                    System.out.println(option);
                    objInputStream = new ObjectInputStream(inputStream);
                    Date data = (Date) objInputStream.readObject();
                    Zlecenie z = new Zlecenie(0, data);
                    int b = Database.createZlecenie(z);
                    
                    outputStream = mySocket.getOutputStream();
                    ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);
                    objOutputStream.writeObject(b);
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

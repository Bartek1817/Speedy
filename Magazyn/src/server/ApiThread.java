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
            if (mySocket.getLocalPort() == 1101) {
                Database.polacz();
                InputStream inputStream = mySocket.getInputStream();
                OutputStream outputStream = null;
                ObjectInputStream objInputStream = null;
                ObjectOutputStream objOutputStream = null;
                objInputStream = new ObjectInputStream(inputStream);
                String option = (String) objInputStream.readObject();
                if(option.equalsIgnoreCase("getTowary"))
                {
                    System.out.println(option);
                    ArrayList<Towar> towary = Database.readTowary();
                    
                    outputStream = mySocket.getOutputStream();
                    objOutputStream = new ObjectOutputStream(outputStream);
                    objOutputStream.writeObject(towary.size());
                    objOutputStream.flush();
                    for(int i = 0; i<towary.size();i++)
                    {
                        objOutputStream = new ObjectOutputStream(outputStream);
                        objOutputStream.writeObject(towary.get(i).getId());
                        objOutputStream.flush();
                        objOutputStream = new ObjectOutputStream(outputStream);
                        objOutputStream.writeObject(towary.get(i).getNazwa());
                        objOutputStream.flush();
                    }
                }
                if(option.equalsIgnoreCase("getZamowienia"))
                {
                    System.out.println(option);
                    ArrayList<Zamowienie> zamowienia = Database.readZamowienia();
                    
                    outputStream = mySocket.getOutputStream();
                    objOutputStream = new ObjectOutputStream(outputStream);
                    objOutputStream.writeObject(zamowienia.size());
                    objOutputStream.flush();
                    for(int i = 0; i<zamowienia.size();i++)
                    {
                        objOutputStream = new ObjectOutputStream(outputStream);
                        objOutputStream.writeObject(zamowienia.get(i).getId());
                        objOutputStream.flush();
                        objOutputStream = new ObjectOutputStream(outputStream);
                        objOutputStream.writeObject(zamowienia.get(i).getIdZlecenia());
                        objOutputStream.flush();
                        objOutputStream = new ObjectOutputStream(outputStream);
                        objOutputStream.writeObject(zamowienia.get(i).getTowar().getId());
                        objOutputStream.flush();
                        objOutputStream = new ObjectOutputStream(outputStream);
                        objOutputStream.writeObject(zamowienia.get(i).getTowar().getNazwa());
                        objOutputStream.flush();
                        objOutputStream = new ObjectOutputStream(outputStream);
                        objOutputStream.writeObject(zamowienia.get(i).getIlosc());
                        objOutputStream.flush();
                        objOutputStream = new ObjectOutputStream(outputStream);
                        objOutputStream.writeObject(zamowienia.get(i).getStatus());
                        objOutputStream.flush();
                    }
                }
                if(option.equalsIgnoreCase("addZamowienie"))
                {
                    System.out.println(option);
                    objInputStream = new ObjectInputStream(inputStream);
                    int idZlecenia = (int) objInputStream.readObject();
                    objInputStream = new ObjectInputStream(inputStream);
                    int idTowaru = (int) objInputStream.readObject();
                    objInputStream = new ObjectInputStream(inputStream);
                    int ilosc = (int) objInputStream.readObject();
                    objInputStream = new ObjectInputStream(inputStream);
                    int status = (int) objInputStream.readObject();
                    Zamowienie z = new Zamowienie(0, idZlecenia, new Towar(idTowaru, ""), ilosc, status);
                    boolean b = Database.createZamowienie(z);
                    outputStream = mySocket.getOutputStream();
                    objOutputStream = new ObjectOutputStream(outputStream);
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

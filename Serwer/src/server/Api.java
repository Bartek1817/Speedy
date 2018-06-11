/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arekl
 */
public class Api extends Thread {

    ServerSocket serverSocket = null;
    int port;

    public Api(int port) {
        super();
        this.port = port;
    }

    public void run() {
        try {
            serverSocket = new ServerSocket(port);
            while (!Thread.interrupted()) {
                Socket socket = serverSocket.accept();
                (new ApiThread(socket)).start();
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException ex) {
                    Logger.getLogger(Api.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void close() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            Logger.getLogger(Api.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}

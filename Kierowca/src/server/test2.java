/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import dane.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Arekl
 */
public class test2 extends Application {


    @Override
    public void start(Stage primaryStage) {
        ProgressBar bar = new ProgressBar();
        Button btn = new Button();
        btn.setText("Send test");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                
                System.out.println("Hello World!");
                Task task = new Task<Void>() {//nowy wątek
                    @Override
                    public Void call() {
                        try {
                            Socket socket = new Socket("127.0.0.1", 1102);
                            socket.setTcpNoDelay(true);
                            InputStream inputStream = socket.getInputStream();
                            ObjectInputStream objInputStream = null;
                            
                            //wysyłanie pierwszego obiektu (w tym wypadku stringa) - docelowo z poleceniem do api
                            OutputStream outputStream = socket.getOutputStream();
                            ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);
                            objOutputStream.writeObject("getZamowienia");
                            objOutputStream.flush();
                            updateProgress(1, 3);//progres (obecny, max)

                            Thread.sleep(500);//uśpienie, żeby było widać progres

                            Thread.sleep(500);//uśpienie, żeby było widać progres

                            //odbieranie obiektu - lista lokacji
                            objInputStream = new ObjectInputStream(inputStream);
                            int ilosc = (int) objInputStream.readObject();
                            updateProgress(2, 4);//progres (obecny, max)
                            for(int i = 0;i<ilosc;i++)
                            {
                                Thread.sleep(500);//uśpienie, żeby było widać progres
                                objInputStream = new ObjectInputStream(inputStream);
                                int id = (int) objInputStream.readObject();
                                objInputStream = new ObjectInputStream(inputStream);
                                int idZlecenia = (int) objInputStream.readObject();
                                objInputStream = new ObjectInputStream(inputStream);
                                String lokalizacja = (String) objInputStream.readObject();
                                objInputStream = new ObjectInputStream(inputStream);
                                int status = (int) objInputStream.readObject();
                                System.out.println(id+":"+lokalizacja);
                                updateProgress(ilosc+i, ilosc+ilosc);//progres (obecny, max)
                            }
                            updateProgress(1, 1);//progres (obecny, max)
                            socket.close();
                        } catch (IOException | ClassNotFoundException | InterruptedException e) {
                            System.err.println(e);
                        }
                        return null;
                    }
                };
                Task task2 = new Task<Void>() {//nowy wątek
                    @Override
                    public Void call() {
                        try {
                            Socket socket = new Socket("127.0.0.1", 1102);
                            socket.setTcpNoDelay(true);
                            InputStream inputStream = socket.getInputStream();
                            ObjectInputStream objInputStream = null;
                            
                            //wysyłanie pierwszego obiektu (w tym wypadku stringa) - docelowo z poleceniem do api
                            OutputStream outputStream = socket.getOutputStream();
                            ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);
                            objOutputStream.writeObject("addZamowienie");
                            objOutputStream.flush();
                            updateProgress(1, 3);//progres (obecny, max)
                            objOutputStream = new ObjectOutputStream(outputStream);
                            objOutputStream.writeObject(0);
                            objOutputStream.flush();
                            objOutputStream = new ObjectOutputStream(outputStream);
                            objOutputStream.writeObject("testowo 12");
                            objOutputStream.flush();
                            objOutputStream = new ObjectOutputStream(outputStream);
                            objOutputStream.writeObject(2);
                            objOutputStream.flush();
                            objInputStream = new ObjectInputStream(inputStream);
                            boolean x = (boolean) objInputStream.readObject();
                            System.out.println(x);
                            updateProgress(1, 1);//progres (obecny, max)
                            socket.close();
                        } catch (Exception e) {
                            System.err.println(e);
                        }
                        return null;
                    }
                };
                //bar.progressProperty().bind(task.progressProperty());
                //new Thread(task).start();
                bar.progressProperty().bind(task.progressProperty());
                new Thread(task).start();

            }
            
        });

        StackPane root = new StackPane();
        root.getChildren().add(bar);
        root.getChildren().add(btn);
        root.setAlignment(bar, Pos.TOP_CENTER);
        root.setMargin(bar, new Insets(50));
        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

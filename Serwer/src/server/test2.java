/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
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
                            Socket socket = new Socket("127.0.0.1", 1100);
                            socket.setTcpNoDelay(true);
                            
                            //wysyłanie pierwszego obiektu (w tym wypadku stringa) - docelowo z poleceniem do api
                            OutputStream outputStream = socket.getOutputStream();
                            ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);
                            objOutputStream.writeObject("test");
                            objOutputStream.flush();
                            updateProgress(1, 2);//progres (obecny, max)

                            Thread.sleep(500);//uśpienie, żeby było widać progres

                            //wysyłanie drugiego obiektu (w tym wypadku stringa) - do testów, potrzebne będzie przy dodawaniu zleceń
                            objOutputStream = new ObjectOutputStream(outputStream);
                            objOutputStream.writeObject("test2");
                            objOutputStream.flush();
                            updateProgress(2, 2);//progres (obecny, max)
                            socket.close();
                        } catch (Exception e) {
                            System.err.println(e);
                        }
                        return null;
                    }
                };
                Task task2 = new Task<Void>() {//nowy wątek
                    @Override
                    public Void call() {
                        try {
                            Socket socket = new Socket("127.0.0.1", 1100);
                            socket.setTcpNoDelay(true);
                            OutputStream outputStream = socket.getOutputStream();
                            InputStream inputStream = socket.getInputStream();
                            ObjectInputStream objInputStream = null;
                            
                            //wysyłanie pierwszego obiektu - polecenie login
                            ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);
                            objOutputStream.writeObject("login");
                            objOutputStream.flush();
                            updateProgress(1, 4);//progres (obecny, max)

                            Thread.sleep(500);//uśpienie, żeby było widać progres

                            //wysyłanie drugiego obiektu - numer
                            objOutputStream = new ObjectOutputStream(outputStream);
                            objOutputStream.writeObject("1111");
                            objOutputStream.flush();
                            updateProgress(2, 4);//progres (obecny, max)

                            Thread.sleep(500);//uśpienie, żeby było widać progres

                            //wysyłanie trzeciego obiektu - haslo
                            objOutputStream = new ObjectOutputStream(outputStream);
                            objOutputStream.writeObject("1111");
                            objOutputStream.flush();
                            updateProgress(3, 4);//progres (obecny, max)

                            Thread.sleep(500);//uśpienie, żeby było widać progres

                            //odbieranie obiektu - poziom usera
                            objInputStream = new ObjectInputStream(inputStream);
                            int poziom = (int) objInputStream.readObject();
                            System.out.println(poziom);
                            updateProgress(4, 4);//progres (obecny, max)
                            socket.close();
                        } catch (Exception e) {
                            System.err.println(e);
                        }
                        return null;
                    }
                };
                //bar.progressProperty().bind(task.progressProperty());
                //new Thread(task).start();
                bar.progressProperty().bind(task2.progressProperty());
                new Thread(task2).start();

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

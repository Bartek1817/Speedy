/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Marlena
 */
package serwer;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import javafx.concurrent.Task;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import server.Database;

public abstract class Logowanie {

    static void menu(BorderPane root, Stage primaryStage) {

        /*
        Database.polacz();
        Database.init();
        Database.init2();
        Database.zamknij();
         */
        //////// IMAGE VIEW
        ImageView logo = new ImageView("file:SpeedySerwer.png");
        logo.setLayoutX(300);
        logo.setLayoutY(-50);

        ImageView ramka = new ImageView("file:ramka.png");
        ramka.setLayoutX(445);
        ramka.setLayoutY(470);
        ramka.setFitHeight(100);
        ramka.setFitWidth(290);
        ramka.setVisible(false);

        //////// TEKSTY 
        Text Login = new Text("Login: ");
        Login.setStyle("-fx-font-size: 50pt;");
        Login.setFill(Color.WHITE);
        Login.setLayoutY(325);
        Login.setLayoutX(400);

        Text Pass = new Text("Pass: ");
        Pass.setStyle("-fx-font-size: 60pt;");
        Pass.setFill(Color.WHITE);
        Pass.setLayoutY(425);
        Pass.setLayoutX(400);

        Text Zaloguj = new Text("Zaloguj");
        Zaloguj.setStyle("-fx-font-size: 60pt;");
        Zaloguj.setFill(Color.WHITE);
        Zaloguj.setLayoutY(540);
        Zaloguj.setLayoutX(475);
        Zaloguj.setPickOnBounds(true);

        Text error = new Text("Błędny login lub hasło");
        error.setStyle("-fx-font-size: 30pt;");
        error.setFill(Color.RED);
        error.setLayoutY(250);
        error.setLayoutX(425);
        error.setVisible(false);

        Text cb = new Text("Aplication Speedy create by: AL && BŻ");
        cb.setStyle("-fx-font-size: 10pt;");
        cb.setFill(Color.WHITE);
        cb.setLayoutY(600);
        cb.setLayoutX(1000);

        //////// FIELDS
        TextField login = new TextField();
        login.setPromptText("login");
        login.setLayoutY(280);
        login.setLayoutX(595);
        login.resize(200, 55);

        PasswordField password = new PasswordField();
        password.setPromptText("hasło");
        password.setLayoutY(380);
        password.setLayoutX(595);
        password.resize(200, 55);

        /////////// Rooot
        root.getChildren().add(Login);
        root.getChildren().add(Pass);
        root.getChildren().add(login);
        root.getChildren().add(Zaloguj);
        root.getChildren().add(error);
        root.getChildren().add(password);
        root.getChildren().add(cb);
        root.getChildren().add(logo);
        root.getChildren().add(ramka);

        Zaloguj.setOnMouseClicked((MouseEvent e) -> { // Po kliknieciu wykonaj
            try {
                //tylko na serwerze
                Database.polacz();
                int poziom = Database.login(Integer.parseInt(login.getText()), Integer.parseInt(password.getText()));
                Database.zamknij();
                
                /*
                //inne
                Socket socket = new Socket("127.0.0.1", 1100);
                socket.setTcpNoDelay(true);
                OutputStream outputStream = socket.getOutputStream();
                InputStream inputStream = socket.getInputStream();
                ObjectInputStream objInputStream = null;
                
                ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);
                objOutputStream.writeObject("login");
                objOutputStream.flush();
                
                objOutputStream = new ObjectOutputStream(outputStream);
                objOutputStream.writeObject(login.getText());
                objOutputStream.flush();
                
                objOutputStream = new ObjectOutputStream(outputStream);
                objOutputStream.writeObject(password.getText());
                objOutputStream.flush();
                
                objInputStream = new ObjectInputStream(inputStream);
                int poziom = (int) objInputStream.readObject();
                System.out.println(poziom);
                socket.close();
                */
                if (poziom == 0 || poziom == 1 || poziom == 2 || poziom == 3 || poziom == 4 || poziom == 5) {
                    error.setVisible(false);
                    root.getChildren().clear();
                    Menu.menu(root, primaryStage);
                } else {
                    error.setVisible(true);
                }
            } catch (Exception z) {
                // TODO Auto-generated catch block
                z.printStackTrace();
            }
        });

        Zaloguj.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            ramka.setVisible(false);

        });
        Zaloguj.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            ramka.setVisible(true);

        });

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
    }

}

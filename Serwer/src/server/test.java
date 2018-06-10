/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import dane.*;
import java.util.Date;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Arekl
 */
public class test extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        Database.polacz();
        /*
        //Test read
        for(Zlecenie z : Database.readZlecenia())
        {
            System.out.println(z.getData().toString());
        }
        for(Lokacja z : Database.readLokacje())
        {
            System.out.println(z.getNazwa());
        }
        for(User z : Database.readUserzy())
        {
            System.out.println(z.getImie());
        }
        
        //Test create
        Database.createZlecenie(new Zlecenie(0, new Date()));
        Database.createLokacja(new Lokacja(0, "testowo", "typowo", "123.313.123.123"));
        Database.createUser(new User(0, 5555, 5555, "Mirosław", "Dyrektor", 3));
        
        //Test update
        Zlecenie z = Database.readZlecenie(0);
        z.setData(new Date());
        Database.updateZlecenie(z);
        Lokacja l = Database.readLokacja(0);
        l.setNazwa("edytowo");
        Database.updateLokacja(l);
        User u = Database.readUser(0);
        u.setNazwiosko("Edytowy");
        Database.updateUser(u);
        
        //Test delete
        Database.deleteZlecenie(1);
        Database.deleteLokacja(1);
        Database.deleteUser(1);
        */
        Database.zamknij();
        
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

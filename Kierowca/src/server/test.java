/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import dane.*;
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
        
        //Test read
        for(Zamowienie z : Database.readZamowienia())
        {
            System.out.println(z.getLokalizacja());
        }
        for(Info z : Database.readInfo())
        {
            System.out.println(z.getWartosc());
        }
        
        //Test create
        Database.createInfo(new Info(0, "teśćik", "testowo"));
        Database.createZamowienie(new Zamowienie(0, 0, "Heheszkowo", 0));
        
        //Test update
        Info i = Database.readInfo(0);
        i.setNazwa("Trolololo");
        Database.updateInfo(i);
        Zamowienie z = Database.readZamowienie(0);
        z.setStatus(123);
        Database.updateZamownienie(z);
        
        //Test delete
        Database.deleteInfo(1);
        Database.deleteZamowienie(1);
        
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

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
public class Test extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Api test = new Api(1101);
                test.start();
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        Database.polacz();
        
        /*//Test read
        for(Info t : Database.readInfo())
        {
            System.out.println(t.getId());
        }
        */
        
        /*//Test create
        Database.createInfo(new Info(0, "teścik", "testowa"));
        Towar t = new Towar(0, "aaaa");
        Database.createTowar(t);
        Database.createMagazyn(new Magazyn(0, t, 20, 20));
        Database.createZamowienie(new Zamowienie(0, 20, t, 20, 0));
        */
        
        /*//Test update
        Towar t = Database.readTowar(0);
        t.setNazwa("xxx");
        Database.updateTowar(t);
        
        Zamowienie z = Database.readZamowienie(0);
        z.setIlosc(258);
        Database.updateZamownienie(z);
        
        Magazyn m = Database.readMagazyn(0);
        m.setRegal(80);
        Database.updateMagazyn(m);
        
        Info i = Database.readInfo(0);
        i.setNazwa("xxx");
        Database.updateInfo(i);
        */
        
        /*//Test delete
        Database.deleteTowar(5);
        Database.deleteMagazyn(0);
        Database.deleteInfo(0);
        Database.deleteZamowienie(0);
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

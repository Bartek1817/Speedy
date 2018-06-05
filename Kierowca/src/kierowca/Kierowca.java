/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kierowca;

import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.scene.Scene;

import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;
import server.Database;

/**
 *
 * @author Arekl
 */
public class Kierowca extends Application {
  
    @Override
    public void start(Stage primaryStage) {
 
        /*
        Database.polacz();
        Database.init();
        Database.init2();
        Database.zamknij();
         */
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1200, 600);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("Speedy_Kierowca");
        primaryStage.setResizable(false);

        root.getChildren().clear();
        kierowca.Logowanie.menu(root, primaryStage);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}


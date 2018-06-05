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

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public abstract class Menu {

    static void menu(BorderPane root, Stage primaryStage) {

        ///////// IMAGE VIEW
        ImageView logo = new ImageView("file:SpeedySerwer.png");
        logo.setLayoutX(300);
        logo.setLayoutY(-50);

        ImageView ramka1 = new ImageView("file:ramka.png");
        ramka1.setLayoutX(20);
        ramka1.setLayoutY(305);
        ramka1.setFitHeight(35);
        ramka1.setFitWidth(125);
        ramka1.setVisible(false);

        ImageView ramka2 = new ImageView("file:ramka.png");
        ramka2.setLayoutX(20);
        ramka2.setLayoutY(355);
        ramka2.setFitHeight(35);
        ramka2.setFitWidth(125);
        ramka2.setVisible(false);

        ImageView ramka3 = new ImageView("file:ramka.png");
        ramka3.setLayoutX(20);
        ramka3.setLayoutY(405);
        ramka3.setFitHeight(35);
        ramka3.setFitWidth(125);
        ramka3.setVisible(false);

        ImageView ramka4 = new ImageView("file:ramka.png");
        ramka4.setLayoutX(20);
        ramka4.setLayoutY(480);
        ramka4.setFitHeight(35);
        ramka4.setFitWidth(125);
        ramka4.setVisible(false);
        ///////// TEXT
        Text Lista = new Text("Lista Lokacji");
        Lista.setStyle("-fx-font-size: 40pt;");
        Lista.setFill(Color.WHITE);
        Lista.setLayoutY(250);
        Lista.setLayoutX(425);

        Text Zlecenia = new Text("Lista Zlecenia");
        Zlecenia.setStyle("-fx-font-size: 40pt;");
        Zlecenia.setFill(Color.WHITE);
        Zlecenia.setLayoutY(250);
        Zlecenia.setLayoutX(425);
        Zlecenia.setVisible(false);

        Text Użytkownicy = new Text("Użytkownicy");
        Użytkownicy.setStyle("-fx-font-size: 40pt;");
        Użytkownicy.setFill(Color.WHITE);
        Użytkownicy.setLayoutY(250);
        Użytkownicy.setLayoutX(425);
        Użytkownicy.setVisible(false);
        //----------------------------

        Text Listam = new Text("Lista Lokacji");
        Listam.setStyle("-fx-font-size: 12pt;");
        Listam.setFill(Color.WHITE);
        Listam.setLayoutY(325);
        Listam.setLayoutX(30);
        Listam.setPickOnBounds(true);

        Text Zleceniam = new Text("Lista Zleceń");
        Zleceniam.setStyle("-fx-font-size: 12pt;");
        Zleceniam.setFill(Color.WHITE);
        Zleceniam.setLayoutY(375);
        Zleceniam.setLayoutX(30);
        Zleceniam.setPickOnBounds(true);

        Text Użytkownicym = new Text("Użytkownicy");
        Użytkownicym.setStyle("-fx-font-size: 12pt;");
        Użytkownicym.setFill(Color.WHITE);
        Użytkownicym.setLayoutY(425);
        Użytkownicym.setLayoutX(30);
        Użytkownicym.setPickOnBounds(true);

        Text Wylogujm = new Text("Wyloguj");
        Wylogujm.setStyle("-fx-font-size: 12pt;");
        Wylogujm.setFill(Color.WHITE);
        Wylogujm.setLayoutY(500);
        Wylogujm.setLayoutX(30);
        Wylogujm.setPickOnBounds(true);

        Text cb = new Text("Aplication Speedy create by: AL && BŻ");
        cb.setStyle("-fx-font-size: 10pt;");
        cb.setFill(Color.WHITE);
        cb.setLayoutY(600);
        cb.setLayoutX(1000);
        ///////// ROOOT
        root.getChildren().add(Lista);
        root.getChildren().add(Zlecenia);
        root.getChildren().add(Użytkownicy);
        root.getChildren().add(Listam);
        root.getChildren().add(Zleceniam);
        root.getChildren().add(Użytkownicym);
        root.getChildren().add(Wylogujm);
        root.getChildren().add(cb);
        root.getChildren().add(logo);
        root.getChildren().add(ramka1);
        root.getChildren().add(ramka2);
        root.getChildren().add(ramka3);
        root.getChildren().add(ramka4);
        //////// WYKONANIE

        Listam.setOnMouseClicked((MouseEvent e) -> { // Po kliknieciu wykonaj
            Użytkownicy.setVisible(false);
            Zlecenia.setVisible(false);
            Lista.setVisible(true);

        });
        Listam.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            ramka1.setVisible(false);

        });
        Listam.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            ramka1.setVisible(true);

        });

        Zleceniam.setOnMouseClicked((MouseEvent e) -> { // Po kliknieciu wykonaj
            Użytkownicy.setVisible(false);
            Zlecenia.setVisible(true);
            Lista.setVisible(false);
        });
        Zleceniam.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            ramka2.setVisible(false);

        });
        Zleceniam.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            ramka2.setVisible(true);

        });

        Użytkownicym.setOnMouseClicked((MouseEvent e) -> { // Po kliknieciu wykonaj

            Użytkownicy.setVisible(true);
            Zlecenia.setVisible(false);
            Lista.setVisible(false);
        });
        Użytkownicym.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            ramka3.setVisible(false);

        });
        Użytkownicym.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            ramka3.setVisible(true);

        });

        Wylogujm.setOnMouseClicked((MouseEvent e) -> { // Po kliknieciu wykonaj
            root.getChildren().clear();
            Logowanie.menu(root, primaryStage);
        });
        Wylogujm.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            ramka4.setVisible(false);

        });
        Wylogujm.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            ramka4.setVisible(true);

        });
    }
    
}

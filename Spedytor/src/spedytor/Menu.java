/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Marlena
 */
package spedytor;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public abstract class Menu {

    static void menu(BorderPane root, Stage primaryStage) {

        ///////// IMAGE VIEW
        ImageView logo = new ImageView("file:SpeedySpedytor.png");
        logo.setLayoutX(0);
        logo.setLayoutY(10);
        logo.setFitHeight(100);
        logo.setFitWidth(200);

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

        ImageView ramka4 = new ImageView("file:ramka.png");
        ramka4.setLayoutX(20);
        ramka4.setLayoutY(480);
        ramka4.setFitHeight(35);
        ramka4.setFitWidth(125);
        ramka4.setVisible(false);
        ///////// TEXT
        Text Lista = new Text("Lista Zleceń");
        Lista.setStyle("-fx-font-size: 40pt;");
        Lista.setFill(Color.WHITE);
        Lista.setLayoutY(70);
        Lista.setLayoutX(525);

        Text Zlecenie = new Text("Dodaj Zlecenie");
        Zlecenie.setStyle("-fx-font-size: 40pt;");
        Zlecenie.setFill(Color.WHITE);
        Zlecenie.setLayoutY(70);
        Zlecenie.setLayoutX(525);
        Zlecenie.setVisible(false);

        //----------------------------
        Text Listam = new Text("Lista Zleceń");
        Listam.setStyle("-fx-font-size: 12pt;");
        Listam.setFill(Color.WHITE);
        Listam.setLayoutY(325);
        Listam.setLayoutX(30);
        Listam.setPickOnBounds(true);

        Text Zleceniem = new Text("Dodaj Zlecenie");
        Zleceniem.setStyle("-fx-font-size: 12pt;");
        Zleceniem.setFill(Color.WHITE);
        Zleceniem.setLayoutY(375);
        Zleceniem.setLayoutX(30);
        Zleceniem.setPickOnBounds(true);

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
        ///////// TABLE

        TableView zawartosc = new TableView();
        zawartosc.setEditable(true);

        TableColumn nazwa = new TableColumn("Lista Zleceń");
        nazwa.setPrefWidth(900);
        TableColumn ID = new TableColumn("Zlecenie ID");
        ID.setPrefWidth(900/7);
        TableColumn Magazyn = new TableColumn("Magazyn");
        Magazyn.setPrefWidth(900/7);
        TableColumn Status = new TableColumn("Status");
       Status.setPrefWidth(900/7);
        TableColumn Towar = new TableColumn("Towar");
        Towar.setPrefWidth(900/7);
         TableColumn Ilosc = new TableColumn("Ilość");
          Ilosc.setPrefWidth(900/7);
         TableColumn Kierowca = new TableColumn("Kierowca");
          Kierowca.setPrefWidth(900/7);
         TableColumn Data = new TableColumn("Data");
        Data.setPrefWidth(900/7);

        nazwa.getColumns().addAll(ID, Magazyn, Status, Towar,Ilosc,Kierowca,Data );
        zawartosc.getColumns().addAll(nazwa);
        
      

        ///////// ROOOT
        
        	final VBox vbox = new VBox();
        vbox.setLayoutY(100);
        vbox.setLayoutX(210);
        vbox.resize(900,550);
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().add(zawartosc);
        
        
       //////////////////////////////////////////// 
       
        root.getChildren().add(Lista);
        root.getChildren().add(Zlecenie);
        root.getChildren().add(Listam);
        root.getChildren().add(Zleceniem);
        root.getChildren().add(Wylogujm);
        root.getChildren().add(cb);
        root.getChildren().add(logo);
        root.getChildren().add(ramka1);
        root.getChildren().add(ramka2);
        root.getChildren().add(ramka4);
        root.getChildren().add(vbox);

        //////// WYKONANIE
        Listam.setOnMouseClicked((MouseEvent e) -> { // Po kliknieciu wykonaj
            Zlecenie.setVisible(false);
            Lista.setVisible(true);
            vbox.getChildren().clear();
            vbox.getChildren().add(zawartosc);

        });
        Listam.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            ramka1.setVisible(false);

        });
        Listam.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            ramka1.setVisible(true);

        });

        Zleceniem.setOnMouseClicked((MouseEvent e) -> { // Po kliknieciu wykonaj
            Zlecenie.setVisible(true);
            Lista.setVisible(false);
            vbox.getChildren().clear();
        });
        Zleceniem.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            ramka2.setVisible(false);

        });
        Zleceniem.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            ramka2.setVisible(true);

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

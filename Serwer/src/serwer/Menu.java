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
        ImageView logo = new ImageView("file:SpeedySerwer.png");
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
        Text Zlecenia = new Text("Lista Zleceń");
        Zlecenia.setStyle("-fx-font-size: 40pt;");
        Zlecenia.setFill(Color.WHITE);
        Zlecenia.setLayoutY(70);
        Zlecenia.setLayoutX(525);

        Text Lista = new Text("Lista Lokacji");
        Lista.setStyle("-fx-font-size: 40pt;");
        Lista.setFill(Color.WHITE);
        Lista.setLayoutY(70);
        Lista.setLayoutX(525);
        Lista.setVisible(false);

        Text Użytkownicy = new Text("Użytkownicy");
        Użytkownicy.setStyle("-fx-font-size: 40pt;");
        Użytkownicy.setFill(Color.WHITE);
        Użytkownicy.setLayoutY(70);
        Użytkownicy.setLayoutX(525);
        Użytkownicy.setVisible(false);
        //----------------------------

        Text Zleceniam = new Text("Lista Zleceń");
        Zleceniam.setStyle("-fx-font-size: 12pt;");
        Zleceniam.setFill(Color.WHITE);
        Zleceniam.setLayoutY(325);
        Zleceniam.setLayoutX(30);
        Zleceniam.setPickOnBounds(true);

        Text Listam = new Text("Lista Lokacji");
        Listam.setStyle("-fx-font-size: 12pt;");
        Listam.setFill(Color.WHITE);
        Listam.setLayoutY(375);
        Listam.setLayoutX(30);
        Listam.setPickOnBounds(true);

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
        ///////// TABLE

        TableView tabela1 = new TableView();
        tabela1.setEditable(true);

        TableColumn nazwa = new TableColumn("Lista Zleceń");
        nazwa.setPrefWidth(900);
        TableColumn ID = new TableColumn("Zlecenie ID");
        ID.setPrefWidth(900 / 7);
        TableColumn Magazyn = new TableColumn("Magazyn");
        Magazyn.setPrefWidth(900 / 7);
        TableColumn Status = new TableColumn("Status");
        Status.setPrefWidth(900 / 7);
        TableColumn Towar = new TableColumn("Towar");
        Towar.setPrefWidth(900 / 7);
        TableColumn Ilosc = new TableColumn("Ilość");
        Ilosc.setPrefWidth(900 / 7);
        TableColumn Kierowca = new TableColumn("Kierowca");
        Kierowca.setPrefWidth(900 / 7);
        TableColumn Data = new TableColumn("Data");
        Data.setPrefWidth(900 / 7);

        nazwa.getColumns().addAll(ID, Magazyn, Status, Towar, Ilosc, Kierowca, Data);
        tabela1.getColumns().addAll(nazwa);
        //  -------------------------------

        TableView tabela2 = new TableView();
        tabela2.setEditable(true);

        TableColumn tab2 = new TableColumn("Lokacje");
        tab2.setPrefWidth(900);
        TableColumn ID_tab2 = new TableColumn("ID");
        ID_tab2.setPrefWidth(900 / 3);
        TableColumn Lokacje_nazwa = new TableColumn("Nazwa");
        Lokacje_nazwa.setPrefWidth(900 / 3);
        TableColumn Typ = new TableColumn("Typ");
        Typ.setPrefWidth(900 / 3);

        tab2.getColumns().addAll(ID_tab2, Lokacje_nazwa, Typ);
        tabela2.getColumns().addAll(tab2);

        //  -------------------------------
        TableView tabela3 = new TableView();
        tabela3.setEditable(true);

        TableColumn tab3 = new TableColumn("Użytkownicy");
        tab3.setPrefWidth(900);
        TableColumn IDUserzy = new TableColumn("Id");
        IDUserzy.setPrefWidth(900 / 7);
        TableColumn NR = new TableColumn("NR");
        NR.setPrefWidth(900 / 7);
        TableColumn Imie = new TableColumn("Imie");
        Imie.setPrefWidth(900 / 7);
        TableColumn Nazwisko = new TableColumn("Nazwisko");
        Nazwisko.setPrefWidth(900 / 7);
        TableColumn Stanowisko = new TableColumn("Stanowisko");
        Stanowisko.setPrefWidth(900 / 7);
        TableColumn Poziom = new TableColumn("Poziom");
        Poziom.setPrefWidth(900 / 7);

        TableColumn Hasło = new TableColumn("Hasło");
        Hasło.setPrefWidth(900 / 7);

        tab3.getColumns().addAll(IDUserzy, NR, Imie, Nazwisko, Stanowisko, Poziom, Hasło);
        tabela3.getColumns().addAll(tab3);

        ///////// ROOOT
        final VBox vbox = new VBox();
        vbox.setLayoutY(100);
        vbox.setLayoutX(210);
        vbox.resize(900, 550);
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().add(tabela1);

        //////////////////////////////////////////// 
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
        root.getChildren().add(vbox);
        //////// WYKONANIE

        Zleceniam.setOnMouseClicked((MouseEvent e) -> { // Po kliknieciu wykonaj
            Użytkownicy.setVisible(false);
            Zlecenia.setVisible(true);
            Lista.setVisible(false);
            vbox.getChildren().clear();
            vbox.getChildren().add(tabela1);
        });
        Zleceniam.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            ramka1.setVisible(false);

        });
        Zleceniam.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            ramka1.setVisible(true);

        });

        Listam.setOnMouseClicked((MouseEvent e) -> { // Po kliknieciu wykonaj
            Użytkownicy.setVisible(false);
            Zlecenia.setVisible(false);
            Lista.setVisible(true);
            vbox.getChildren().clear();
            vbox.getChildren().add(tabela2);

        });
        Listam.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            ramka2.setVisible(false);

        });
        Listam.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            ramka2.setVisible(true);

        });

        Użytkownicym.setOnMouseClicked((MouseEvent e) -> { // Po kliknieciu wykonaj

            Użytkownicy.setVisible(true);
            Zlecenia.setVisible(false);
            Lista.setVisible(false);
            vbox.getChildren().clear();
            vbox.getChildren().add(tabela3);
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

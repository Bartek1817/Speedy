/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Marlena
 */
package kierowca;

import dane.Info;
import dane.Zamowienie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import server.Database;

public abstract class Menu {

    static void menu(BorderPane root, Stage primaryStage) {

        ///////// IMAGE VIEW
        ImageView logo = new ImageView("file:SpeedyKierowca.png");
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
        Text Lista = new Text("Lista Zamówień");
        Lista.setStyle("-fx-font-size: 40pt;");
        Lista.setFill(Color.WHITE);
        Lista.setLayoutY(70);
        Lista.setLayoutX(525);

        Text Info = new Text("Informacje");
        Info.setStyle("-fx-font-size: 40pt;");
        Info.setFill(Color.WHITE);
        Info.setLayoutY(70);
        Info.setLayoutX(525);

        Info.setVisible(false);

        //----------------------------
        Text Listam = new Text("Lista Zamówień");
        Listam.setStyle("-fx-font-size: 12pt;");
        Listam.setFill(Color.WHITE);
        Listam.setLayoutY(325);
        Listam.setLayoutX(30);
        Listam.setPickOnBounds(true);

        Text Infom = new Text("Informacje");
        Infom.setStyle("-fx-font-size: 12pt;");
        Infom.setFill(Color.WHITE);
        Infom.setLayoutY(375);
        Infom.setLayoutX(30);
        Infom.setPickOnBounds(true);

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

        Database.polacz();
        ObservableList<Zamowienie> zam = FXCollections.observableArrayList();
        zam.clear();
        zam.addAll(Database.readZamowienia());
        tabela1.setItems(zam);

        TableColumn tab1 = new TableColumn("Lista Zamówień");
        tab1.setPrefWidth(900);
        TableColumn ID = new TableColumn("Zamówienie ID");
        ID.setPrefWidth(900 / 4);
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn IDZ = new TableColumn("Zlecenie ID");
        IDZ.setPrefWidth(900 / 4);
        IDZ.setCellValueFactory(new PropertyValueFactory<>("idZlecenia"));
        TableColumn Towar = new TableColumn("Lokalizacja");
        Towar.setPrefWidth(900 / 4);
        Towar.setCellValueFactory(new PropertyValueFactory<>("lokalizacja"));
        TableColumn Kierowca = new TableColumn("Status");
        Kierowca.setPrefWidth(900 / 4);
        Kierowca.setCellValueFactory(new PropertyValueFactory<>("status"));

        tab1.getColumns().addAll(ID, IDZ, Towar, Kierowca);
        tabela1.getColumns().addAll(tab1);
        //  -------------------------------
          TableView tabela2 = new TableView();
        tabela2.setEditable(true);

        Database.polacz();
        ObservableList<Info> info = FXCollections.observableArrayList();
        info.clear();
        info.addAll(Database.readInfo());
        tabela2.setItems(info);

        TableColumn tab2 = new TableColumn("Informacje");
        tab2.setPrefWidth(900);
        TableColumn ID_tab2 = new TableColumn("ID");
        ID_tab2.setPrefWidth(900 / 3);
        ID_tab2.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn Magazyn_nazwa = new TableColumn("Nazwa");
        Magazyn_nazwa.setPrefWidth(900 / 3);
        Magazyn_nazwa.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        TableColumn Status_wartosc = new TableColumn("Wartość");
        Status_wartosc.setPrefWidth(900 / 3);
        Status_wartosc.setCellValueFactory(new PropertyValueFactory<>("wartosc"));

        tab2.getColumns().addAll(ID_tab2, Magazyn_nazwa, Status_wartosc);
        tabela2.getColumns().addAll(tab2);

        ///////// ROOOT
        final VBox vbox = new VBox();
        vbox.setLayoutY(100);
        vbox.setLayoutX(210);
        vbox.resize(915, 550);
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().add(tabela1);

        //////////////////////////////////////////// 
        root.getChildren().add(Lista);
        root.getChildren().add(Info);
        root.getChildren().add(Listam);
        root.getChildren().add(Infom);
        root.getChildren().add(Wylogujm);
        root.getChildren().add(cb);
        root.getChildren().add(logo);
        root.getChildren().add(ramka1);
        root.getChildren().add(ramka2);
        root.getChildren().add(ramka4);
        root.getChildren().add(vbox);
        //////// WYKONANIE

        Listam.setOnMouseClicked((MouseEvent e) -> { // Po kliknieciu wykonaj
            Info.setVisible(false);
            Lista.setVisible(true);
            vbox.getChildren().clear();
            vbox.getChildren().add(tabela1);

        });
        Listam.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            ramka1.setVisible(false);

        });
        Listam.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            ramka1.setVisible(true);

        });

        Infom.setOnMouseClicked((MouseEvent e) -> { // Po kliknieciu wykonaj

            Info.setVisible(true);
            Lista.setVisible(false);
            vbox.getChildren().clear();
            vbox.getChildren().add(tabela2);
        });
        Infom.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            ramka2.setVisible(false);

        });
        Infom.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
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

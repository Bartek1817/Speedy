/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Marlena
 */
package magazyn;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public abstract class Menu {

    static void menu(BorderPane root, Stage primaryStage) {

        ///////// IMAGE VIEW
        ImageView logo = new ImageView("file:SpeedyMagazyn.png");
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

        ImageView ramka5 = new ImageView("file:ramka.png");
        ramka5.setLayoutX(270);
        ramka5.setLayoutY(560);
        ramka5.setFitHeight(35);
        ramka5.setFitWidth(125);
        ramka5.setVisible(false);

        ImageView ramka6 = new ImageView("file:ramka.png");
        ramka6.setLayoutX(420);
        ramka6.setLayoutY(560);
        ramka6.setFitHeight(35);
        ramka6.setFitWidth(125);
        ramka6.setVisible(false);
        ///////// TEXT
        Text Lista = new Text("Lista Zamówień");
        Lista.setStyle("-fx-font-size: 40pt;");
        Lista.setFill(Color.WHITE);
        Lista.setLayoutY(70);
        Lista.setLayoutX(525);

        Text Towary = new Text("Lista Towarów");
        Towary.setStyle("-fx-font-size: 40pt;");
        Towary.setFill(Color.WHITE);
        Towary.setLayoutY(70);
        Towary.setLayoutX(525);
        Towary.setVisible(false);

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

        Text Towarym = new Text("Lista Towarów");
        Towarym.setStyle("-fx-font-size: 12pt;");
        Towarym.setFill(Color.WHITE);
        Towarym.setLayoutY(375);
        Towarym.setLayoutX(30);
        Towarym.setPickOnBounds(true);

        Text Infom = new Text("Informacje");
        Infom.setStyle("-fx-font-size: 12pt;");
        Infom.setFill(Color.WHITE);
        Infom.setLayoutY(425);
        Infom.setLayoutX(30);
        Infom.setPickOnBounds(true);

        Text Wylogujm = new Text("Wyloguj");
        Wylogujm.setStyle("-fx-font-size: 12pt;");
        Wylogujm.setFill(Color.WHITE);
        Wylogujm.setLayoutY(500);
        Wylogujm.setLayoutX(30);
        Wylogujm.setPickOnBounds(true);

        Text Dodaj = new Text("Dodaj Towar");
        Dodaj.setStyle("-fx-font-size: 12pt;");
        Dodaj.setFill(Color.WHITE);
        Dodaj.setLayoutY(580);
        Dodaj.setLayoutX(285);
        Dodaj.setPickOnBounds(true);
        Dodaj.setVisible(false);

        Text Usuń = new Text("Usuń Towar");
        Usuń.setStyle("-fx-font-size: 12pt;");
        Usuń.setFill(Color.WHITE);
        Usuń.setLayoutY(580);
        Usuń.setLayoutX(435);
        Usuń.setPickOnBounds(true);
        Usuń.setVisible(false);

        Text cb = new Text("Aplication Speedy create by: AL && BŻ");
        cb.setStyle("-fx-font-size: 10pt;");
        cb.setFill(Color.WHITE);
        cb.setLayoutY(600);
        cb.setLayoutX(1000);
        ///////// TABLE

        TableView tabela1 = new TableView();
        tabela1.setEditable(true);

        TableColumn tab1 = new TableColumn("Lista Zamówień");
        tab1.setPrefWidth(900);
        TableColumn ID = new TableColumn("Zamówienie ID");
        ID.setPrefWidth(900 / 4);
        TableColumn Towar = new TableColumn("Towar");
        Towar.setPrefWidth(900 / 4);
        TableColumn Ilosc = new TableColumn("Ilość");
        Ilosc.setPrefWidth(900 / 4);
        TableColumn Kierowca = new TableColumn("Kierowca");
        Kierowca.setPrefWidth(900 / 4);

        tab1.getColumns().addAll(ID, Towar, Ilosc, Kierowca);
        tabela1.getColumns().addAll(tab1);
        //  -------------------------------

        TableView tabela2 = new TableView();
        tabela2.setEditable(true);

        TableColumn tab2 = new TableColumn("Informacje");
        tab2.setPrefWidth(900);
        TableColumn ID_tab2 = new TableColumn("ID");
        ID_tab2.setPrefWidth(900 / 3);
        TableColumn Magazyn_nazwa = new TableColumn("Nazwa");
        Magazyn_nazwa.setPrefWidth(900 / 3);
        TableColumn Status_wartosc = new TableColumn("Wartość");
        Status_wartosc.setPrefWidth(900 / 3);

        tab2.getColumns().addAll(ID_tab2, Magazyn_nazwa, Status_wartosc);
        tabela2.getColumns().addAll(tab2);

        //  -------------------------------
        TableView tabela3 = new TableView();
        tabela3.setEditable(true);

        TableColumn tab3 = new TableColumn("Towary");
        tab3.setPrefWidth(900);
        TableColumn IdTowaru = new TableColumn("Id Towaru");
        IdTowaru.setPrefWidth(900 / 4);
        TableColumn Nazwa = new TableColumn("Nazwa");
        Nazwa.setPrefWidth(900 / 4);
        TableColumn Regał = new TableColumn("Regał");
        Regał.setPrefWidth(900 / 4);
        TableColumn Ilość = new TableColumn("Ilość");
        Ilość.setPrefWidth(900 / 4);

        tab3.getColumns().addAll(IdTowaru, Nazwa, Regał, Ilość);
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
        ///////////okno start

        Rectangle r = new Rectangle(); // Kwadrat na reszte ekranu żeby zablokować inne klikanie
        r.setX(0);
        r.setY(0);
        r.setWidth(1200);
        r.setHeight(1200);
        r.setArcWidth(1200);
        r.setArcHeight(1200);
        r.setFill(Color.TRANSPARENT);
        r.setVisible(false);

        Group oknoStart = new Group();
        oknoStart.setVisible(false);

        oknoStart.getChildren().add(new Rectangle(400, 300, new Color(1f, 1f, 1f, .85f)));
        oknoStart.setLayoutX(300);
        oknoStart.setLayoutY(190);

        Label Tytul = new Label("Dodawanie Towaru");
        Tytul.setLayoutX(150);
        Tytul.setLayoutY(10);

        Label NazwaTowarul = new Label("Nazwa Towaru");
        NazwaTowarul.setLayoutX(10);
        NazwaTowarul.setLayoutY(50);

        TextField NazwaTowarut = new TextField();
        NazwaTowarut.setText("Nazwa");
        NazwaTowarut.setLayoutX(10);
        NazwaTowarut.setLayoutY(80);

        Label IlośćTowarul = new Label("Ilość Towaru");
        IlośćTowarul.setLayoutX(10);
        IlośćTowarul.setLayoutY(120);

        TextField IlośćTowarut = new TextField();
        IlośćTowarut.setText("Ilość");
        IlośćTowarut.setLayoutX(10);
        IlośćTowarut.setLayoutY(150);

        Label RegałL = new Label("Regał");
        RegałL.setLayoutX(10);
        RegałL.setLayoutY(190);

        TextField RegałT = new TextField();
        RegałT.setText("Regał");
        RegałT.setLayoutX(10);
        RegałT.setLayoutY(220);

        Button btn000 = new Button();
        btn000.setText("X");
        btn000.setLayoutX(370);
        btn000.setLayoutY(10);
        btn000.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                oknoStart.setVisible(false);
                 r.setVisible(false);
            }
        });

        Button btn001 = new Button();
        btn001.setText("Dodaj Towar");
        btn001.setLayoutX(10);
        btn001.setLayoutY(265);
        btn001.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.print("dodano i chuj");
            }
        });

        oknoStart.getChildren().add(Tytul);
        oknoStart.getChildren().add(NazwaTowarul);
        oknoStart.getChildren().add(NazwaTowarut);
        oknoStart.getChildren().add(IlośćTowarul);
        oknoStart.getChildren().add(IlośćTowarut);
        oknoStart.getChildren().add(RegałL);
        oknoStart.getChildren().add(RegałT);
        oknoStart.getChildren().add(btn000);
        oknoStart.getChildren().add(btn001);

        ///////////koniec = okno start
        //////////////////////////////////////////// 
        root.getChildren().add(Lista);
        root.getChildren().add(Towary);
        root.getChildren().add(Info);
        root.getChildren().add(Listam);
        root.getChildren().add(Towarym);
        root.getChildren().add(Infom);
        root.getChildren().add(Wylogujm);

        root.getChildren().add(cb);
        root.getChildren().add(logo);
        root.getChildren().add(ramka1);
        root.getChildren().add(ramka2);
        root.getChildren().add(ramka3);
        root.getChildren().add(ramka4);

        root.getChildren().add(vbox);
        
        root.getChildren().add(Dodaj);
        root.getChildren().add(Usuń);
        root.getChildren().add(ramka5);
        root.getChildren().add(ramka6);
        root.getChildren().add(r);
        
       root.getChildren().add(oknoStart);
        //////// WYKONANIE

        Listam.setOnMouseClicked((MouseEvent e) -> { // Po kliknieciu wykonaj
            Info.setVisible(false);
            Towary.setVisible(false);
            Lista.setVisible(true);
            Usuń.setVisible(false);
            Dodaj.setVisible(false);
            vbox.getChildren().clear();
            vbox.getChildren().add(tabela1);

        });
        Listam.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            ramka1.setVisible(false);

        });
        Listam.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            ramka1.setVisible(true);

        });

        Towarym.setOnMouseClicked((MouseEvent e) -> { // Po kliknieciu wykonaj
            Info.setVisible(false);
            Towary.setVisible(true);
            Lista.setVisible(false);
            Usuń.setVisible(true);
            Dodaj.setVisible(true);
            vbox.getChildren().clear();
            vbox.getChildren().add(tabela3);
        });
        Towarym.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            ramka2.setVisible(false);

        });
        Towarym.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            ramka2.setVisible(true);

        });

        Infom.setOnMouseClicked((MouseEvent e) -> { // Po kliknieciu wykonaj

            Info.setVisible(true);
            Towary.setVisible(false);
            Lista.setVisible(false);
            Usuń.setVisible(false);
            Dodaj.setVisible(false);
            vbox.getChildren().clear();
            vbox.getChildren().add(tabela2);
        });
        Infom.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            ramka3.setVisible(false);

        });
        Infom.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            ramka3.setVisible(true);

        });
        Dodaj.setOnMouseClicked((MouseEvent e) -> { // Po kliknieciu wykonaj
            oknoStart.setVisible(true);
             r.setVisible(true);
        });
        Dodaj.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            ramka5.setVisible(false);

        });
        Dodaj.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            ramka5.setVisible(true);

        });
        Usuń.setOnMouseClicked((MouseEvent e) -> { // Po kliknieciu wykonaj
            oknoStart.setVisible(true);
        });
        Usuń.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            ramka6.setVisible(false);

        });
        Usuń.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            ramka6.setVisible(true);

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

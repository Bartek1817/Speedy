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

import dane.Lokacja;
import dane.User;
import dane.Zlecenie;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import server.Database;

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

        Text DodajL = new Text("Dodaj Lokacje");
        DodajL.setStyle("-fx-font-size: 12pt;");
        DodajL.setFill(Color.WHITE);
        DodajL.setLayoutY(580);
        DodajL.setLayoutX(285);
        DodajL.setPickOnBounds(true);
        DodajL.setVisible(false);

        Text UsuńL = new Text("Usuń Lokacje");
        UsuńL.setStyle("-fx-font-size: 12pt;");
        UsuńL.setFill(Color.WHITE);
        UsuńL.setLayoutY(580);
        UsuńL.setLayoutX(435);
        UsuńL.setPickOnBounds(true);
        UsuńL.setVisible(false);

        Text DodajU = new Text("Dodaj Użytkownika");
        DodajU.setStyle("-fx-font-size: 10pt;");
        DodajU.setFill(Color.WHITE);
        DodajU.setLayoutY(577);
        DodajU.setLayoutX(285);
        DodajU.setPickOnBounds(true);
        DodajU.setVisible(false);

        Text UsuńU = new Text("Usuń Użytkownika");
        UsuńU.setStyle("-fx-font-size: 10pt;");
        UsuńU.setFill(Color.WHITE);
        UsuńU.setLayoutY(577);
        UsuńU.setLayoutX(435);
        UsuńU.setPickOnBounds(true);
        UsuńU.setVisible(false);

        Text DodajZ = new Text("Dodaj Zlecenie");
        DodajZ.setStyle("-fx-font-size: 12pt;");
        DodajZ.setFill(Color.WHITE);
        DodajZ.setLayoutY(580);
        DodajZ.setLayoutX(285);
        DodajZ.setPickOnBounds(true);
        DodajZ.setVisible(true);

        Text UsuńZ = new Text("Usuń Zlecenie");
        UsuńZ.setStyle("-fx-font-size: 12pt;");
        UsuńZ.setFill(Color.WHITE);
        UsuńZ.setLayoutY(580);
        UsuńZ.setLayoutX(435);
        UsuńZ.setPickOnBounds(true);
        UsuńZ.setVisible(true);

        Text cb = new Text("Aplication Speedy create by: AL && BŻ");
        cb.setStyle("-fx-font-size: 10pt;");
        cb.setFill(Color.WHITE);
        cb.setLayoutY(600);
        cb.setLayoutX(1000);
        ///////// TABLE

        TableView tabela1 = new TableView();
        tabela1.setEditable(true);

        Database.polacz();
        ObservableList<Zlecenie> zlec = FXCollections.observableArrayList();
        zlec.clear();
        zlec.addAll(Database.readZlecenia());
        tabela1.setItems(zlec);

        TableColumn nazwa = new TableColumn("Lista Zleceń");
        nazwa.setPrefWidth(900);
        TableColumn ID = new TableColumn("Zlecenie ID");
        ID.setPrefWidth(900 / 7);
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
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
        Data.setCellValueFactory(new PropertyValueFactory<>("data"));

        nazwa.getColumns().addAll(ID, Magazyn, Status, Towar, Ilosc, Kierowca, Data);
        tabela1.getColumns().addAll(nazwa);
        //  -------------------------------

        TableView tabela2 = new TableView();
        tabela2.setEditable(true);

        Database.polacz();
        ObservableList<Lokacja> lok = FXCollections.observableArrayList();
        lok.clear();
        lok.addAll(Database.readLokacje());
        tabela2.setItems(lok);

        TableColumn tab2 = new TableColumn("Lokacje");
        tab2.setPrefWidth(900);
        TableColumn ID_tab2 = new TableColumn("ID");
        ID_tab2.setPrefWidth(900 / 4);
        ID_tab2.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn Lokacje_nazwa = new TableColumn("Nazwa");
        Lokacje_nazwa.setPrefWidth(900 / 4);
        Lokacje_nazwa.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        TableColumn Typ = new TableColumn("Typ");
        Typ.setPrefWidth(900 / 4);
        Typ.setCellValueFactory(new PropertyValueFactory<>("typ"));
        TableColumn IP = new TableColumn("IP");
        IP.setPrefWidth(900 / 4);
        IP.setCellValueFactory(new PropertyValueFactory<>("ip"));

        tab2.getColumns().addAll(ID_tab2, Lokacje_nazwa, Typ, IP);
        tabela2.getColumns().addAll(tab2);

        //  -------------------------------
        TableView tabela3 = new TableView();
        tabela3.setEditable(true);

        Database.polacz();
        ObservableList<User> us = FXCollections.observableArrayList();
        us.clear();
        us.addAll(Database.readUserzy());
        tabela3.setItems(us);

        TableColumn tab3 = new TableColumn("Użytkownicy");
        tab3.setPrefWidth(900);
        TableColumn IDUserzy = new TableColumn("Id");
        IDUserzy.setPrefWidth(900 / 6);
        IDUserzy.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn NR = new TableColumn("NR");
        NR.setPrefWidth(900 / 6);
        NR.setCellValueFactory(new PropertyValueFactory<>("numer"));
        TableColumn Imie = new TableColumn("Imie");
        Imie.setPrefWidth(900 / 6);
        Imie.setCellValueFactory(new PropertyValueFactory<>("imie"));
        TableColumn Nazwisko = new TableColumn("Nazwisko");
        Nazwisko.setPrefWidth(900 / 6);
        Nazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwiosko"));
        TableColumn Poziom = new TableColumn("Poziom");
        Poziom.setPrefWidth(900 / 6);
        Poziom.setCellValueFactory(new PropertyValueFactory<>("poziom"));
        TableColumn Hasło = new TableColumn("Hasło");
        Hasło.setPrefWidth(900 / 6);
        Hasło.setCellValueFactory(new PropertyValueFactory<>("haslo"));

        tab3.getColumns().addAll(IDUserzy, NR, Imie, Nazwisko, Poziom, Hasło);
        tabela3.getColumns().addAll(tab3);

        ///////// ROOOT
        final VBox vbox = new VBox();
        vbox.setLayoutY(100);
        vbox.setLayoutX(210);
        vbox.resize(913, 550);
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().add(tabela1);
        ////////////////////////////////////////////
        ///////////okno start

        Rectangle r = new Rectangle(); // Kwadrat na reszte ekranu żeby zablokować inne klikanie
        r.setX(-200);
        r.setY(-200);
        r.setWidth(1600);
        r.setHeight(1600);
        r.setArcWidth(1600);
        r.setArcHeight(1600);
        r.setFill(Color.TRANSPARENT);
        r.setVisible(false);

        Group oknoStart = new Group();
        oknoStart.setVisible(false);

        oknoStart.getChildren().add(new Rectangle(400, 300, new Color(1f, 1f, 1f, .85f)));
        oknoStart.setLayoutX(300);
        oknoStart.setLayoutY(190);

        Label Tytul = new Label("Dodawanie Użytkownika");
        Tytul.setLayoutX(150);
        Tytul.setLayoutY(10);

        Label Imięl = new Label("Imię użytkownika");
        Imięl.setLayoutX(10);
        Imięl.setLayoutY(25);

        TextField Imięt = new TextField();
        Imięt.setText("Imię");
        Imięt.setLayoutX(10);
        Imięt.setLayoutY(50);

        Label Nazwiskol = new Label("Nazwisko użytkownika");
        Nazwiskol.setLayoutX(10);
        Nazwiskol.setLayoutY(70);

        TextField Nazwiskou = new TextField();
        Nazwiskou.setText("Nazwisko");
        Nazwiskou.setLayoutX(10);
        Nazwiskou.setLayoutY(95);

        Label hasłol = new Label("Hasło (Liczbowy)");
        hasłol.setLayoutX(10);
        hasłol.setLayoutY(115);

        TextField hasłot = new TextField();
        hasłot.setText("123");
        hasłot.setLayoutX(10);
        hasłot.setLayoutY(135);

        Label Pozioml = new Label("Wybierz Poziom");
        Pozioml.setLayoutX(10);
        Pozioml.setLayoutY(160);

        TextField Poziomt = new TextField();
        Poziomt.setText("1");
        Poziomt.setLayoutX(10);
        Poziomt.setLayoutY(185);

        Label numerl = new Label("Wpisz Numer");
        numerl.setLayoutX(10);
        numerl.setLayoutY(210);

        TextField numert = new TextField();
        numert.setText("1");
        numert.setLayoutX(10);
        numert.setLayoutY(235);

        Label p1 = new Label();
        p1.setText("Numer użytkownika sie powtarza wybierz inny numer");
        p1.setLayoutX(200);
        p1.setLayoutY(80);
        p1.setVisible(false);
        p1.setWrapText(true);
        p1.setPrefWidth(100);

        Label p2 = new Label();
        p2.setText("Nie wszystkie pola są uzupełnione");
        p2.setLayoutX(200);
        p2.setLayoutY(80);
        p2.setVisible(false);
        p2.setWrapText(true);
        p2.setPrefWidth(100);

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
        btn001.setText("Dodaj Użytkownika");
        btn001.setLayoutX(10);
        btn001.setLayoutY(265);
        btn001.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                p1.setVisible(false);
                p2.setVisible(false);
                if (Imięt.getText().equals("") || Nazwiskou.getText().equals("")
                        || hasłot.getText().equals("") || Poziomt.getText().equals("")
                        || numert.getText().equals("")) {
                    p2.setVisible(true);
                } else {
                    Database.polacz();
                    ArrayList<User> usr = Database.readUserzy();
                    int pom = 0;
                    for (User a : usr) {
                        if (Integer.parseInt(numert.getText()) == a.getNumer()) {
                            pom++;
                            p1.setVisible(true);
                        }
                    }
                    if (pom == 0) {
                        User u = new User(0, Integer.parseInt(numert.getText()), Integer.parseInt(hasłot.getText()), Imięt.getText(), Nazwiskou.getText(), Integer.parseInt(Poziomt.getText()));
                        Database.createUser(u);
                        Database.zamknij();
                        root.getChildren().clear();
                        Menu.menu(root, primaryStage);
                    }
                    Database.zamknij();
                }
            }
        });

        oknoStart.getChildren().add(Tytul);
        oknoStart.getChildren().add(Imięt);
        oknoStart.getChildren().add(Imięl);
        oknoStart.getChildren().add(Nazwiskou);
        oknoStart.getChildren().add(Nazwiskol);
        oknoStart.getChildren().add(hasłol);
        oknoStart.getChildren().add(hasłot);
        oknoStart.getChildren().add(Poziomt);
        oknoStart.getChildren().add(Pozioml);
        oknoStart.getChildren().add(numert);
        oknoStart.getChildren().add(numerl);
        oknoStart.getChildren().add(p1);
        oknoStart.getChildren().add(p2);
        oknoStart.getChildren().add(btn000);
        oknoStart.getChildren().add(btn001);

        ///////////koniec = okno start
        ///////////Poczatek = okno start2
        Group oknoStart2 = new Group();
        oknoStart2.setVisible(false);

        oknoStart2.getChildren().add(new Rectangle(400, 300, new Color(1f, 1f, 1f, .85f)));
        oknoStart2.setLayoutX(300);
        oknoStart2.setLayoutY(190);

        Label Tytul2 = new Label("Usuwanie Użytkownika");
        Tytul2.setLayoutX(150);
        Tytul2.setLayoutY(10);

        Label wybr = new Label("Wybierz którego użytkownika chcesz usunąć");
        wybr.setLayoutX(100);
        wybr.setLayoutY(80);

        Database.polacz();
        ArrayList<User> usr2 = Database.readUserzy();
        ObservableList<String> data = FXCollections.observableArrayList();
        data.clear();
        for (User a : usr2) {
            data.add(a.getImie() + " " + a.getImie() + " NUMER: " + a.getNumer());
        }
        Database.zamknij();

        ChoiceBox cbox = new ChoiceBox(FXCollections.observableArrayList(data)
        );
        cbox.setLayoutX(50);
        cbox.setLayoutY(120);

        Button btn002 = new Button();
        btn002.setText("X");
        btn002.setLayoutX(370);
        btn002.setLayoutY(10);
        btn002.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                oknoStart2.setVisible(false);
                r.setVisible(false);
            }
        });

        Button btn003 = new Button();
        btn003.setText("Usuń Usera");
        btn003.setLayoutX(10);
        btn003.setLayoutY(265);
        btn003.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (User a : usr2) {
                    String s = a.getImie() + " " + a.getImie() + " NUMER: " + a.getNumer();
                    if (s.equals(cbox.getValue().toString())) {
                        System.out.println("Usunieto " + s);
                        Database.polacz();
                        Database.deleteUser(a.getId());
                        Database.zamknij();
                        root.getChildren().clear();
                        Menu.menu(root, primaryStage);
                    }
                }
            }
        });

        oknoStart2.getChildren().add(Tytul2);
        oknoStart2.getChildren().add(wybr);
        oknoStart2.getChildren().add(cbox);
        oknoStart2.getChildren().add(btn003);
        oknoStart2.getChildren().add(btn002);

        ///////////koniec = okno start2
        ///////////poczatek = okno start3
        Group oknoStart3 = new Group();
        oknoStart3.setVisible(false);

        oknoStart3.getChildren().add(new Rectangle(400, 300, new Color(1f, 1f, 1f, .85f)));
        oknoStart3.setLayoutX(300);
        oknoStart3.setLayoutY(190);

        Label Tytul3 = new Label("Dodawanie Lokacji");
        Tytul3.setLayoutX(150);
        Tytul3.setLayoutY(10);

        Label Lokal = new Label("Nazwa Lokacji");
        Lokal.setLayoutX(10);
        Lokal.setLayoutY(30);

        TextField Lokalt = new TextField();
        Lokalt.setText("Nazwa");
        Lokalt.setLayoutX(10);
        Lokalt.setLayoutY(50);

        Label Typ2 = new Label("Typ Lokacji");
        Typ2.setLayoutX(10);
        Typ2.setLayoutY(80);

        ChoiceBox cbox6 = new ChoiceBox(FXCollections.observableArrayList(
                "Magazyn", "Samochód")
        );

        cbox6.setLayoutX(10);
        cbox6.setLayoutY(100);
        cbox6.setValue("Magazyn");

        Label IPLokalizacji = new Label("IP Lokacji");
        IPLokalizacji.setLayoutX(10);
        IPLokalizacji.setLayoutY(130);

        TextField IPLokalizacjit = new TextField();
        IPLokalizacjit.setText("IP");
        IPLokalizacjit.setLayoutX(10);
        IPLokalizacjit.setLayoutY(150);

        Button btn004 = new Button();
        btn004.setText("X");
        btn004.setLayoutX(370);
        btn004.setLayoutY(10);
        btn004.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                oknoStart3.setVisible(false);
                r.setVisible(false);
            }
        });

        Button btn005 = new Button();
        btn005.setText("Dodaj Lokację");
        btn005.setLayoutX(10);
        btn005.setLayoutY(265);
        btn005.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                p2.setVisible(false);
                if (Lokalt.getText().equals("") || cbox6.getValue().equals("")
                        || IPLokalizacjit.getText().equals("")) {
                    p2.setVisible(true);
                } else {
                    Database.polacz();
                    Lokacja l = new Lokacja(0, Lokalt.getText(), cbox6.getValue().toString(), IPLokalizacjit.getText());
                    Database.createLokacja(l);
                    Database.zamknij();
                    root.getChildren().clear();
                    Menu.menu(root, primaryStage);
                }
            }
        });

        oknoStart3.getChildren().add(Tytul3);
        oknoStart3.getChildren().add(Lokal);
        oknoStart3.getChildren().add(Lokalt);
        oknoStart3.getChildren().add(Typ2);
        oknoStart3.getChildren().add(cbox6);
        oknoStart3.getChildren().add(p2);
        oknoStart3.getChildren().add(IPLokalizacji);
        oknoStart3.getChildren().add(IPLokalizacjit);
        oknoStart3.getChildren().add(btn004);
        oknoStart3.getChildren().add(btn005);

        ///////////koniec = okno start
        ///////////Poczatek = okno start2
        Group oknoStart4 = new Group();
        oknoStart4.setVisible(false);

        oknoStart4.getChildren().add(new Rectangle(400, 300, new Color(1f, 1f, 1f, .85f)));
        oknoStart4.setLayoutX(300);
        oknoStart4.setLayoutY(190);

        Label Tytul4 = new Label("Usuwanie Lokacji");
        Tytul4.setLayoutX(150);
        Tytul4.setLayoutY(10);

        Label wybr4 = new Label("Wybierz którą Lokację chcesz usunąć");
        wybr4.setLayoutX(100);
        wybr4.setLayoutY(80);

        Database.polacz();
        ArrayList<Lokacja> l1 = Database.readLokacje();
        ObservableList<String> data3 = FXCollections.observableArrayList();
        data.clear();
        for (Lokacja a : l1) {
            data3.add(a.getId() + " " + a.getNazwa() + " " + a.getTyp() + " " + a.getIp());
        }
        Database.zamknij();

        ChoiceBox cbox3 = new ChoiceBox(FXCollections.observableArrayList(
                data3)
        );
        cbox3.setLayoutX(100);
        cbox3.setLayoutY(120);

        Button btn006 = new Button();
        btn006.setText("X");
        btn006.setLayoutX(370);
        btn006.setLayoutY(10);
        btn006.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                oknoStart4.setVisible(false);
                r.setVisible(false);
            }
        });

        Button btn007 = new Button();
        btn007.setText("Usuń Lokację");
        btn007.setLayoutX(10);
        btn007.setLayoutY(265);
        btn007.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (Lokacja a : l1) {
                    String s =a.getId() + " " +  a.getNazwa() + " " + a.getTyp() + " " + a.getIp();
                    if (s.equals(cbox3.getValue().toString())) {
                        System.out.println("Usunieto " + s);
                        Database.polacz();
                        Database.deleteLokacja(a.getId());
                        Database.zamknij();
                        root.getChildren().clear();
                        Menu.menu(root, primaryStage);
                    }
                }
            }
        });

        oknoStart4.getChildren().add(Tytul4);
        oknoStart4.getChildren().add(wybr4);
        oknoStart4.getChildren().add(cbox3);
        oknoStart4.getChildren().add(btn006);
        oknoStart4.getChildren().add(btn007);

        ///////////koniec = okno start2
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
        root.getChildren().add(ramka5);
        root.getChildren().add(ramka6);
        root.getChildren().add(vbox);

        root.getChildren().add(DodajZ);
        root.getChildren().add(UsuńZ);
        root.getChildren().add(DodajU);
        root.getChildren().add(UsuńU);
        root.getChildren().add(DodajL);
        root.getChildren().add(UsuńL);

        root.getChildren().add(r);

        root.getChildren().add(oknoStart);
        root.getChildren().add(oknoStart2);
        root.getChildren().add(oknoStart3);
        root.getChildren().add(oknoStart4);
        //////// WYKONANIE

        Zleceniam.setOnMouseClicked((MouseEvent e) -> { // Po kliknieciu wykonaj
            Użytkownicy.setVisible(false);
            Zlecenia.setVisible(true);
            Lista.setVisible(false);
            UsuńZ.setVisible(true);
            DodajZ.setVisible(true);
            UsuńU.setVisible(false);
            DodajU.setVisible(false);
            UsuńL.setVisible(false);
            DodajL.setVisible(false);
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
            UsuńZ.setVisible(false);
            DodajZ.setVisible(false);
            UsuńU.setVisible(false);
            DodajU.setVisible(false);
            UsuńL.setVisible(true);
            DodajL.setVisible(true);
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
            UsuńZ.setVisible(false);
            DodajZ.setVisible(false);
            UsuńU.setVisible(true);
            DodajU.setVisible(true);
            UsuńL.setVisible(false);
            DodajL.setVisible(false);
            vbox.getChildren().clear();
            vbox.getChildren().add(tabela3);
        });
        Użytkownicym.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            ramka3.setVisible(false);

        });
        Użytkownicym.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            ramka3.setVisible(true);

        });
        DodajZ.setOnMouseClicked((MouseEvent e) -> { // Po kliknieciu wykonaj

            r.setVisible(true);
        });
        DodajZ.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            ramka5.setVisible(false);

        });
        DodajZ.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            ramka5.setVisible(true);

        });
        UsuńZ.setOnMouseClicked((MouseEvent e) -> { // Po kliknieciu wykonaj

            r.setVisible(true);
        });
        UsuńZ.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            ramka6.setVisible(false);

        });
        UsuńZ.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            ramka6.setVisible(true);

        });

        DodajL.setOnMouseClicked((MouseEvent e) -> { // Po kliknieciu wykonaj
            oknoStart3.setVisible(true);
            r.setVisible(true);
        });
        DodajL.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            ramka5.setVisible(false);

        });
        DodajL.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            ramka5.setVisible(true);

        });
        UsuńL.setOnMouseClicked((MouseEvent e) -> { // Po kliknieciu wykonaj
            oknoStart4.setVisible(true);
            r.setVisible(true);
        });
        UsuńL.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            ramka6.setVisible(false);

        });
        UsuńL.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            ramka6.setVisible(true);

        });

        DodajU.setOnMouseClicked((MouseEvent e) -> { // Po kliknieciu wykonaj
            oknoStart.setVisible(true);
            r.setVisible(true);
        });
        DodajU.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            ramka5.setVisible(false);

        });
        DodajU.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            ramka5.setVisible(true);

        });
        UsuńU.setOnMouseClicked((MouseEvent e) -> { // Po kliknieciu wykonaj
            oknoStart2.setVisible(true);
            r.setVisible(true);
        });
        UsuńU.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            ramka6.setVisible(false);

        });
        UsuńU.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
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

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

import dane.Info;
import dane.Towar;
import dane.Magazyn;
import dane.Zamowienie;
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
        ImageView logo = new ImageView("file:SpeedyMagazyn.png");
        logo.setLayoutX(0);
        logo.setLayoutY(10);
        logo.setFitHeight(100);
        logo.setFitWidth(200);

        ImageView ramka0 = new ImageView("file:ramka.png");
        ramka0.setLayoutX(20);
        ramka0.setLayoutY(255);
        ramka0.setFitHeight(35);
        ramka0.setFitWidth(125);
        ramka0.setVisible(false);

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
        ramka2.setFitWidth(135);
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

        ImageView ramka7 = new ImageView("file:ramka.png");
        ramka7.setLayoutX(570);
        ramka7.setLayoutY(560);
        ramka7.setFitHeight(35);
        ramka7.setFitWidth(125);
        ramka7.setVisible(false);

        ///////// TEXT
        Text Towary = new Text("Lista Towarów");
        Towary.setStyle("-fx-font-size: 40pt;");
        Towary.setFill(Color.WHITE);
        Towary.setLayoutY(70);
        Towary.setLayoutX(525);
        Towary.setVisible(false);

        Text Lista = new Text("Lista Zamówień");
        Lista.setStyle("-fx-font-size: 40pt;");
        Lista.setFill(Color.WHITE);
        Lista.setLayoutY(70);
        Lista.setLayoutX(525);

        Text Magazyny = new Text("Lista Magazynowa");
        Magazyny.setStyle("-fx-font-size: 40pt;");
        Magazyny.setFill(Color.WHITE);
        Magazyny.setLayoutY(70);
        Magazyny.setLayoutX(525);
        Magazyny.setVisible(false);

        Text Info = new Text("Informacje");
        Info.setStyle("-fx-font-size: 40pt;");
        Info.setFill(Color.WHITE);
        Info.setLayoutY(70);
        Info.setLayoutX(525);
        Info.setVisible(false);
        //----------------------------
        Text Towarym = new Text("Lista Towarów");
        Towarym.setStyle("-fx-font-size: 12pt;");
        Towarym.setFill(Color.WHITE);
        Towarym.setLayoutY(275);
        Towarym.setLayoutX(30);
        Towarym.setPickOnBounds(true);

        Text Listam = new Text("Lista Zamówień");
        Listam.setStyle("-fx-font-size: 12pt;");
        Listam.setFill(Color.WHITE);
        Listam.setLayoutY(325);
        Listam.setLayoutX(30);
        Listam.setPickOnBounds(true);

        Text Magazynym = new Text("Lista Magazynowa");
        Magazynym.setStyle("-fx-font-size: 12pt;");
        Magazynym.setFill(Color.WHITE);
        Magazynym.setLayoutY(375);
        Magazynym.setLayoutX(30);
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

        Text Dodaj = new Text("Dodaj Wpis");
        Dodaj.setStyle("-fx-font-size: 12pt;");
        Dodaj.setFill(Color.WHITE);
        Dodaj.setLayoutY(580);
        Dodaj.setLayoutX(285);
        Dodaj.setPickOnBounds(true);
        Dodaj.setVisible(false);

        Text Usuń = new Text("Usuń Wpis");
        Usuń.setStyle("-fx-font-size: 12pt;");
        Usuń.setFill(Color.WHITE);
        Usuń.setLayoutY(580);
        Usuń.setLayoutX(435);
        Usuń.setPickOnBounds(true);
        Usuń.setVisible(false);

        Text EdytujWpis = new Text("Edytuj Wpis");
        EdytujWpis.setStyle("-fx-font-size: 12pt;");
        EdytujWpis.setFill(Color.WHITE);
        EdytujWpis.setLayoutY(580);
        EdytujWpis.setLayoutX(580);
        EdytujWpis.setPickOnBounds(true);
        EdytujWpis.setVisible(false);

        Text Dodajt = new Text("Dodaj Towar");
        Dodajt.setStyle("-fx-font-size: 12pt;");
        Dodajt.setFill(Color.WHITE);
        Dodajt.setLayoutY(580);
        Dodajt.setLayoutX(285);
        Dodajt.setPickOnBounds(true);
        Dodajt.setVisible(false);

        Text Usuńt = new Text("Usuń Towar");
        Usuńt.setStyle("-fx-font-size: 12pt;");
        Usuńt.setFill(Color.WHITE);
        Usuńt.setLayoutY(580);
        Usuńt.setLayoutX(435);
        Usuńt.setPickOnBounds(true);
        Usuńt.setVisible(false);

        Text Edytut = new Text("Edytuj Towar");
        Edytut.setStyle("-fx-font-size: 12pt;");
        Edytut.setFill(Color.WHITE);
        Edytut.setLayoutY(580);
        Edytut.setLayoutX(580);
        Edytut.setPickOnBounds(true);
        Edytut.setVisible(false);

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
        ID.setPrefWidth(900 / 5);
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn IDZ = new TableColumn("Zlecenie ID");
        IDZ.setPrefWidth(900 / 5);
        IDZ.setCellValueFactory(new PropertyValueFactory<>("idZlecenia"));
        TableColumn Towar = new TableColumn("Towar");
        Towar.setPrefWidth(900 / 5);
        Towar.setCellValueFactory(new PropertyValueFactory<>("towar"));
        TableColumn Ilosc = new TableColumn("Ilość");
        Ilosc.setPrefWidth(900 / 5);
        Ilosc.setCellValueFactory(new PropertyValueFactory<>("ilosc"));
        TableColumn Kierowca = new TableColumn("Status");
        Kierowca.setPrefWidth(900 / 5);
        Kierowca.setCellValueFactory(new PropertyValueFactory<>("status"));

        tab1.getColumns().addAll(ID, IDZ, Towar, Ilosc, Kierowca);
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

        //  -------------------------------
        TableView tabela3 = new TableView();
        tabela3.setEditable(true);

        Database.polacz();
        ObservableList<Magazyn> magazyn = FXCollections.observableArrayList();
        magazyn.clear();
        magazyn.addAll(Database.readMagazyny());
        tabela3.setItems(magazyn);

        Database.zamknij();
        TableColumn tab3 = new TableColumn("Wpisy Magazynowe");
        tab3.setPrefWidth(900);
        TableColumn IdTowaru = new TableColumn("Id Wpisu");
        IdTowaru.setPrefWidth(900 / 4);
        IdTowaru.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn Nazwa = new TableColumn("Nazwa");
        Nazwa.setPrefWidth(900 / 4);
        Nazwa.setCellValueFactory(new PropertyValueFactory<>("towar"));
        TableColumn Regał = new TableColumn("Regał");
        Regał.setPrefWidth(900 / 4);
        Regał.setCellValueFactory(new PropertyValueFactory<>("regal"));
        TableColumn Ilość = new TableColumn("Ilość");
        Ilość.setPrefWidth(900 / 4);
        Ilość.setCellValueFactory(new PropertyValueFactory<>("ilosc"));

        tab3.getColumns().addAll(IdTowaru, Nazwa, Regał, Ilość);
        tabela3.getColumns().add(tab3);

        //  -------------------------------
        TableView tabela4 = new TableView();
        tabela4.setEditable(true);

        Database.polacz();
        ObservableList<Towar> towar = FXCollections.observableArrayList();
        towar.clear();
        towar.addAll(Database.readTowary());
        tabela4.setItems(towar);

        Database.zamknij();
        TableColumn tab4 = new TableColumn("Towary");
        tab4.setPrefWidth(900);
        TableColumn IdTowarut = new TableColumn("Id Towaru");
        IdTowarut.setPrefWidth(900 / 2);
        IdTowarut.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn Nazwat = new TableColumn("Nazwa");
        Nazwat.setPrefWidth(900 / 2);
        Nazwat.setCellValueFactory(new PropertyValueFactory<>("nazwa"));

        tab4.getColumns().addAll(IdTowarut, Nazwat);
        tabela4.getColumns().add(tab4);

        ///////// ROOOT
        final VBox vbox = new VBox();
        vbox.setLayoutY(100);
        vbox.setLayoutX(210);
        vbox.resize(915, 550);
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

        Label Tytul = new Label("Dodawanie Wpisu");
        Tytul.setLayoutX(150);
        Tytul.setLayoutY(10);

        Label NazwaTowarul = new Label("Nazwa Towaru");
        NazwaTowarul.setLayoutX(10);
        NazwaTowarul.setLayoutY(50);

        Database.polacz();
        ArrayList<Towar> towary = Database.readTowary();
        ObservableList<String> data = FXCollections.observableArrayList();
        data.clear();
        for (Towar a : towary) {
            data.add(a.getNazwa());
        }
        Database.zamknij();
        ChoiceBox wbox = new ChoiceBox(data);

        wbox.setLayoutX(10);
        wbox.setLayoutY(80);

        Label IlośćTowarul = new Label("Ilość Towaru");
        IlośćTowarul.setLayoutX(10);
        IlośćTowarul.setLayoutY(120);

        TextField IlośćTowarut = new TextField();
        IlośćTowarut.setText("100");
        IlośćTowarut.setLayoutX(10);
        IlośćTowarut.setLayoutY(150);

        Label RegałL = new Label("Regał");
        RegałL.setLayoutX(10);
        RegałL.setLayoutY(190);

        TextField RegałT = new TextField();
        RegałT.setText("1");
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
        btn001.setText("Dodaj Wpis");
        btn001.setLayoutX(10);
        btn001.setLayoutY(265);
        btn001.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Database.polacz();
                ArrayList<Towar> towary = Database.readTowary();
                int pom = 0;
                for (Towar a : towary) {
                    if (a.getNazwa().equals(wbox.getValue().toString())) {

                        Magazyn magazynek = new Magazyn(0, a, Integer.parseInt(RegałT.getText()), Integer.parseInt(IlośćTowarut.getText()));
                        Database.createMagazyn(magazynek);
                        pom++;
                    }
                }
                if (pom == 0) {
                    System.out.println("Czemu tego nie ma w bazie " + wbox.getValue().toString());
                }
                Database.zamknij();
                root.getChildren().clear();
                Menu.menu(root, primaryStage);
            }

        });

        oknoStart.getChildren().add(Tytul);
        oknoStart.getChildren().add(NazwaTowarul);
        oknoStart.getChildren().add(wbox);
        oknoStart.getChildren().add(IlośćTowarul);
        oknoStart.getChildren().add(IlośćTowarut);
        oknoStart.getChildren().add(RegałL);
        oknoStart.getChildren().add(RegałT);
        oknoStart.getChildren().add(btn000);
        oknoStart.getChildren().add(btn001);

        ///////////koniec = okno start
        ///////////Poczatek = okno start2
        Group oknoStart2 = new Group();
        oknoStart2.setVisible(false);

        oknoStart2.getChildren().add(new Rectangle(400, 300, new Color(1f, 1f, 1f, .85f)));
        oknoStart2.setLayoutX(300);
        oknoStart2.setLayoutY(190);

        Label Tytul2 = new Label("Usuwanie Wpisu");
        Tytul2.setLayoutX(150);
        Tytul2.setLayoutY(10);

        Label wybr = new Label("Wybierz Wpis który chcesz usunąć");
        wybr.setLayoutX(100);
        wybr.setLayoutY(80);

        Label kom1 = new Label("Usunięto Wpis");
        kom1.setLayoutX(100);
        kom1.setLayoutY(30);
        kom1.setVisible(false);

        Label kom2 = new Label("Nie wybrano wpisu");
        kom2.setLayoutX(100);
        kom2.setLayoutY(30);
        kom2.setVisible(false);

        Database.polacz();
        ArrayList<Magazyn> magazynki = Database.readMagazyny();
        ObservableList<Integer> data2 = FXCollections.observableArrayList();
        data2.clear();
        for (Magazyn a : magazynki) {
            data2.add(a.getId());
        }
        Database.zamknij();
        ChoiceBox cbox = new ChoiceBox(data2);

        cbox.setLayoutX(100);
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
        btn003.setText("Usuń Wpis");
        btn003.setLayoutX(10);
        btn003.setLayoutY(265);
        btn003.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Database.polacz();
                Database.deleteMagazyn((int) cbox.getValue());
                Database.zamknij();
                root.getChildren().clear();
                Menu.menu(root, primaryStage);
            }
        });

        oknoStart2.getChildren().add(Tytul2);
        oknoStart2.getChildren().add(wybr);
        oknoStart2.getChildren().add(kom1);
        oknoStart2.getChildren().add(kom2);
        oknoStart2.getChildren().add(cbox);
        oknoStart2.getChildren().add(btn003);
        oknoStart2.getChildren().add(btn002);

        ///////////koniec = okno start2
        ///////////Poczatek = okno start3
        Group oknoStart3 = new Group();
        oknoStart3.setVisible(false);

        oknoStart3.getChildren().add(new Rectangle(400, 300, new Color(1f, 1f, 1f, .85f)));
        oknoStart3.setLayoutX(300);
        oknoStart3.setLayoutY(190);

        Label Tytul3 = new Label("Usuwanie Towaru");
        Tytul3.setLayoutX(150);
        Tytul3.setLayoutY(10);

        Label wybrt = new Label("Wybierz Towar który chcesz usunąć");
        wybrt.setLayoutX(100);
        wybrt.setLayoutY(80);

        Label kom3 = new Label("Nie wybrano Towaru");
        kom3.setLayoutX(100);
        kom3.setLayoutY(30);
        kom3.setVisible(false);

        Database.polacz();

        data.clear();
        for (Towar a : towary) {
            data.add(a.getNazwa());
        }
        Database.zamknij();
        ChoiceBox tbox = new ChoiceBox(data);

        tbox.setLayoutX(100);
        tbox.setLayoutY(120);

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
        btn005.setText("Usuń Towar");
        btn005.setLayoutX(10);
        btn005.setLayoutY(265);
        btn005.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Database.polacz();
                for (Towar a : towary) {
                    if (a.getNazwa().equals(tbox.getValue().toString())) {
                        Database.deleteTowar(a.getId());
                    }
                }
                Database.zamknij();
                root.getChildren().clear();
                Menu.menu(root, primaryStage);
            }
        });

        oknoStart3.getChildren().add(Tytul3);
        oknoStart3.getChildren().add(wybrt);
        oknoStart3.getChildren().add(kom3);
        oknoStart3.getChildren().add(tbox);
        oknoStart3.getChildren().add(btn004);
        oknoStart3.getChildren().add(btn005);

        ///////////koniec = okno start3
        ///////////Poczatek = okno start4
        Group oknoStart4 = new Group();
        oknoStart4.setVisible(false);

        oknoStart4.getChildren().add(new Rectangle(400, 300, new Color(1f, 1f, 1f, .85f)));
        oknoStart4.setLayoutX(300);
        oknoStart4.setLayoutY(190);

        Label Tytul4 = new Label("Dodawanie Towaru");
        Tytul4.setLayoutX(150);
        Tytul4.setLayoutY(10);

        Label nzwt = new Label("Nazwa nowego Towaru");
        nzwt.setLayoutX(100);
        nzwt.setLayoutY(80);

        Label kom4 = new Label("Towar o wybranej nazwie istnieje ");
        kom4.setLayoutX(100);
        kom4.setLayoutY(30);
        kom4.setVisible(false);

        TextField nazwatow = new TextField();
        nazwatow.setText("nazwa");
        nazwatow.setLayoutX(150);
        nazwatow.setLayoutY(100);

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
        btn007.setText("Dodaj Towar");
        btn007.setLayoutX(10);
        btn007.setLayoutY(265);
        btn007.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                int pom = 0;
                Database.polacz();
                for (Towar a : towary) {
                    if (a.getNazwa().equals(nazwatow.getText())) {
                        pom++;
                    }
                }
                if (pom == 0) // nie powtarza sie
                {
                    Towar t = new Towar(0, nazwatow.getText());
                    Database.createTowar(t);
                    Database.zamknij();
                    root.getChildren().clear();
                    Menu.menu(root, primaryStage);

                } else {
                    kom4.setVisible(true);
                    Database.zamknij();
                }

            }
        });

        oknoStart4.getChildren().add(Tytul4);
        oknoStart4.getChildren().add(nzwt);
        oknoStart4.getChildren().add(kom4);
        oknoStart4.getChildren().add(nazwatow);
        oknoStart4.getChildren().add(btn006);
        oknoStart4.getChildren().add(btn007);

        ///////////koniec = okno start5
        ///////////Poczatek = okno start3
        Group oknoStart5 = new Group();
        oknoStart5.setVisible(false);

        oknoStart5.getChildren().add(new Rectangle(400, 300, new Color(1f, 1f, 1f, .85f)));
        oknoStart5.setLayoutX(300);
        oknoStart5.setLayoutY(190);

        Label Tytul5 = new Label("Edytowanie Towaru");
        Tytul5.setLayoutX(150);
        Tytul5.setLayoutY(10);

        Label wybr5 = new Label("Wybierz Towar który chcesz edytować");
        wybr5.setLayoutX(100);
        wybr5.setLayoutY(80);

        Label kom5 = new Label("Wybrana nazwa jest już zajęta ");
        kom5.setLayoutX(100);
        kom5.setLayoutY(30);
        kom5.setVisible(false);

        Label wart1 = new Label("ID");
        wart1.setLayoutX(60);
        wart1.setLayoutY(145);
        wart1.setVisible(false);

        TextField wart2 = new TextField("Nazwa");
        wart2.setLayoutX(120);
        wart2.setLayoutY(140);
        wart2.setVisible(false);

        Label nwart1 = new Label("ID");
        nwart1.setLayoutX(60);
        nwart1.setLayoutY(125);
        nwart1.setVisible(false);

        Label nwart2 = new Label("Nazwa");
        nwart2.setLayoutX(120);
        nwart2.setLayoutY(125);
        nwart2.setVisible(false);

        Database.polacz();

        data.clear();
        for (Towar a : towary) {
            data.add(a.getNazwa());
        }
        Database.zamknij();
        ChoiceBox tbox5 = new ChoiceBox(data);

        tbox5.setLayoutX(100);
        tbox5.setLayoutY(100);

        Button btn055 = new Button();
        btn055.setText("X");
        btn055.setLayoutX(370);
        btn055.setLayoutY(10);
        btn055.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                oknoStart5.setVisible(false);
                r.setVisible(false);
            }
        });

        Button btn057 = new Button();
        btn057.setText("Powrót");
        btn057.setLayoutX(10);
        btn057.setLayoutY(265);
        btn057.setVisible(false);

        Button btn056 = new Button();
        btn056.setText("Edytuj Wybrany Towar");
        btn056.setLayoutX(10);
        btn056.setLayoutY(265);

        Button btn058 = new Button();
        btn058.setText("Edytuj");
        btn058.setLayoutX(10);
        btn058.setLayoutY(235);
        btn058.setVisible(false);

        btn058.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                int pom = 0;
                Database.polacz();
                for (Towar a : towary) {
                    if (a.getNazwa().equals(wart2.getText())) {
                        pom++;
                    }
                }
                if (pom == 0) // nie powtarza siewa
                {
                    Towar t = new Towar(Integer.parseInt(wart1.getText()), wart2.getText());
                    Database.updateTowar(t);
                    Database.zamknij();
                    root.getChildren().clear();
                    Menu.menu(root, primaryStage);

                } else {
                    kom5.setVisible(true);
                    Database.zamknij();
                }

            }
        });

        btn056.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Database.polacz();
                btn056.setVisible(false);
                btn057.setVisible(true);
                btn058.setVisible(true);
                tbox5.setVisible(false);
                wybr5.setVisible(false);
                wart1.setVisible(true);
                wart2.setVisible(true);
                nwart1.setVisible(true);
                nwart2.setVisible(true);
                for (Towar a : towary) {
                    if (a.getNazwa().equals(tbox5.getValue().toString())) {

                        wart1.setText(Integer.toString(a.getId()));
                        wart2.setText(a.getNazwa());
                    }
                }
                Database.zamknij();

            }
        });

        btn057.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btn056.setVisible(true);
                btn057.setVisible(false);
                btn058.setVisible(false);
                tbox5.setVisible(true);
                wybr5.setVisible(true);
                wart1.setVisible(false);
                wart2.setVisible(false);
                nwart1.setVisible(false);
                nwart2.setVisible(false);
            }
        });

        oknoStart5.getChildren().add(Tytul5);
        oknoStart5.getChildren().add(wybr5);
        oknoStart5.getChildren().add(kom5);
        oknoStart5.getChildren().add(tbox5);
        oknoStart5.getChildren().add(btn055);
        oknoStart5.getChildren().add(btn056);
        oknoStart5.getChildren().add(btn057);
        oknoStart5.getChildren().add(btn058);
        oknoStart5.getChildren().add(wart1);
        oknoStart5.getChildren().add(wart2);
        oknoStart5.getChildren().add(nwart1);
        oknoStart5.getChildren().add(nwart2);

        ///////////koniec = okno start5
        ///////////Poczatek = okno start6
        Group oknoStart6 = new Group();
        oknoStart6.setVisible(false);

        oknoStart6.getChildren().add(new Rectangle(400, 300, new Color(1f, 1f, 1f, .85f)));
        oknoStart6.setLayoutX(300);
        oknoStart6.setLayoutY(190);

        Label Tytul6 = new Label("Edytowanie Wpisu");
        Tytul6.setLayoutX(150);
        Tytul6.setLayoutY(10);

        Label wybr6 = new Label("Wybierz Wpis który chcesz edytować");
        wybr6.setLayoutX(100);
        wybr6.setLayoutY(80);

        Label kom6 = new Label("Wybrana nazwa jest już zajęta ");
        kom6.setLayoutX(100);
        kom6.setLayoutY(30);
        kom6.setVisible(false);

        Label wart11 = new Label("ID");
        wart11.setLayoutX(30);
        wart11.setLayoutY(145);
        wart11.setVisible(false);

        ChoiceBox wart22 = new ChoiceBox(data);
        wart22.setLayoutX(60);
        wart22.setLayoutY(140);
        wart22.setVisible(false);

        TextField wart33 = new TextField("Regał");
        wart33.setLayoutX(150);
        wart33.setLayoutY(140);
        wart33.setVisible(false);

        TextField wart44 = new TextField("Ilość");
        wart44.setLayoutX(210);
        wart44.setLayoutY(140);
        wart44.setVisible(false);

        Label nwart11 = new Label("ID");
        nwart11.setLayoutX(30);
        nwart11.setLayoutY(125);
        nwart11.setVisible(false);

        Label nwart22 = new Label("Towar");
        nwart22.setLayoutX(50);
        nwart22.setLayoutY(125);
        nwart22.setVisible(false);

        Label nwart33 = new Label("Regał");
        nwart33.setLayoutX(150);
        nwart33.setLayoutY(125);
        nwart33.setVisible(false);

        Label nwart44 = new Label("Ilość");
        nwart44.setLayoutX(210);
        nwart44.setLayoutY(125);
        nwart44.setVisible(false);

        Database.polacz();
        ArrayList<Magazyn> l1 = Database.readMagazyny();
        ObservableList<String> data3 = FXCollections.observableArrayList();
        for (Magazyn a : l1) {
            data3.add(a.getId() + " Towar " + a.getTowar().getNazwa() + " Regal " + a.getRegal() + " Ilosc " + a.getIlosc());
        }
        Database.zamknij();

        ChoiceBox tbox6 = new ChoiceBox(FXCollections.observableArrayList(
                data3)
        );

        tbox6.setLayoutX(100);
        tbox6.setLayoutY(100);

        Button btn061 = new Button();
        btn061.setText("X");
        btn061.setLayoutX(370);
        btn061.setLayoutY(10);
        btn061.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                oknoStart6.setVisible(false);
                r.setVisible(false);
            }
        });

        Button btn062 = new Button();
        btn062.setText("Powrót");
        btn062.setLayoutX(10);
        btn062.setLayoutY(265);
        btn062.setVisible(false);

        Button btn063 = new Button();
        btn063.setText("Edytuj Wybrany Wpis");
        btn063.setLayoutX(10);
        btn063.setLayoutY(265);

        Button btn064 = new Button();
        btn064.setText("Edytuj");
        btn064.setLayoutX(10);
        btn064.setLayoutY(235);
        btn064.setVisible(false);

        btn064.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                int pom = 0;
                Database.polacz();
                for (Towar a : towary) {
                    if (a.getNazwa().equals(wart22.getValue().toString())) {

                        Magazyn m = new Magazyn(Integer.parseInt(wart11.getText()), Database.readTowar(a.getId()), Integer.parseInt(wart33.getText()), Integer.parseInt(wart44.getText()));
                        Database.updateMagazyn(m);
                    }
                }

                Database.zamknij();
                root.getChildren().clear();
                Menu.menu(root, primaryStage);

                Database.zamknij();

            }
        });

        btn062.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                btn062.setVisible(false);
                btn063.setVisible(true);
                btn064.setVisible(false);
                tbox6.setVisible(true);
                wybr6.setVisible(true);
                wart11.setVisible(false);
                wart22.setVisible(false);
                nwart11.setVisible(false);
                nwart22.setVisible(false);
                wart33.setVisible(false);
                wart44.setVisible(false);
                nwart33.setVisible(false);
                nwart44.setVisible(false);
                Database.polacz();

            }
        });

        btn063.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btn062.setVisible(true);
                btn063.setVisible(false);
                btn064.setVisible(true);
                tbox6.setVisible(false);
                wybr6.setVisible(false);
                wart11.setVisible(true);
                wart22.setVisible(true);
                nwart11.setVisible(true);
                nwart22.setVisible(true);
                wart33.setVisible(true);
                wart44.setVisible(true);
                nwart33.setVisible(true);
                nwart44.setVisible(true);
                for (Magazyn a : l1) {
                    String s = a.getId() + " Towar " + a.getTowar().getNazwa() + " Regal " + a.getRegal() + " Ilosc " + a.getIlosc();;

                    if (s.equals(tbox6.getValue().toString())) {

                        wart11.setText(Integer.toString(a.getId()));
                        wart22.setValue(a.getTowar().getNazwa());
                        wart33.setText(Integer.toString(a.getRegal()));
                        wart44.setText(Integer.toString(a.getIlosc()));
                    }
                }
                Database.zamknij();
            }
        });

        oknoStart6.getChildren().add(Tytul6);
        oknoStart6.getChildren().add(wybr6);
        oknoStart6.getChildren().add(kom6);
        oknoStart6.getChildren().add(tbox6);
        oknoStart6.getChildren().add(btn061);
        oknoStart6.getChildren().add(btn062);
        oknoStart6.getChildren().add(btn063);
        oknoStart6.getChildren().add(btn064);
        oknoStart6.getChildren().add(wart11);
        oknoStart6.getChildren().add(wart22);
        oknoStart6.getChildren().add(nwart11);
        oknoStart6.getChildren().add(nwart22);
        oknoStart6.getChildren().add(wart33);
        oknoStart6.getChildren().add(wart44);
        oknoStart6.getChildren().add(nwart33);
        oknoStart6.getChildren().add(nwart44);
        ///////////koniec = okno start6
        //////////////////////////////////////////// 
        root.getChildren().add(Magazyny);
        root.getChildren().add(Lista);
        root.getChildren().add(Towary);
        root.getChildren().add(Info);
        root.getChildren().add(Magazynym);
        root.getChildren().add(Listam);
        root.getChildren().add(Towarym);
        root.getChildren().add(Infom);
        root.getChildren().add(Wylogujm);

        root.getChildren().add(cb);
        root.getChildren().add(logo);
        root.getChildren().add(ramka0);
        root.getChildren().add(ramka1);
        root.getChildren().add(ramka2);
        root.getChildren().add(ramka3);
        root.getChildren().add(ramka4);

        root.getChildren().add(vbox);

        root.getChildren().add(Dodaj);
        root.getChildren().add(Usuń);
        root.getChildren().add(EdytujWpis);
        root.getChildren().add(Dodajt);
        root.getChildren().add(Usuńt);
        root.getChildren().add(Edytut);
        root.getChildren().add(ramka5);
        root.getChildren().add(ramka6);
        root.getChildren().add(ramka7);
        root.getChildren().add(r);

        root.getChildren().add(oknoStart);
        root.getChildren().add(oknoStart2);
        root.getChildren().add(oknoStart3);
        root.getChildren().add(oknoStart4);
        root.getChildren().add(oknoStart5);
        root.getChildren().add(oknoStart6);

        //////// WYKONANIE
        Listam.setOnMouseClicked((MouseEvent e) -> { // Po kliknieciu wykonaj
            Info.setVisible(false);
            Towary.setVisible(false);
            Lista.setVisible(true);
            Usuń.setVisible(false);
            Dodaj.setVisible(false);
            Usuńt.setVisible(false);
            EdytujWpis.setVisible(false);
            Edytut.setVisible(false);
            Dodajt.setVisible(false);
            Magazyny.setVisible(false);
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
            Usuńt.setVisible(true);
            Dodajt.setVisible(true);
            EdytujWpis.setVisible(false);
            Edytut.setVisible(true);
            Usuń.setVisible(false);
            Dodaj.setVisible(false);
            Magazyny.setVisible(false);
            vbox.getChildren().clear();
            vbox.getChildren().add(tabela4);
        });
        Towarym.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            ramka0.setVisible(false);

        });
        Towarym.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            ramka0.setVisible(true);

        });

        Magazynym.setOnMouseClicked((MouseEvent e) -> { // Po kliknieciu wykonaj
            Info.setVisible(false);
            Towary.setVisible(false);
            Lista.setVisible(false);
            Usuń.setVisible(true);
            Dodaj.setVisible(true);
            Usuńt.setVisible(false);
            Dodajt.setVisible(false);
            EdytujWpis.setVisible(true);
            Edytut.setVisible(false);
            Magazyny.setVisible(true);
            vbox.getChildren().clear();
            vbox.getChildren().add(tabela3);
        });
        Magazynym.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            ramka2.setVisible(false);

        });
        Magazynym.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            ramka2.setVisible(true);

        });

        Infom.setOnMouseClicked((MouseEvent e) -> { // Po kliknieciu wykonaj

            Info.setVisible(true);
            Towary.setVisible(false);
            Lista.setVisible(false);
            Usuń.setVisible(false);
            Dodaj.setVisible(false);
            Usuńt.setVisible(false);
            Dodajt.setVisible(false);
            Magazyny.setVisible(false);
            EdytujWpis.setVisible(false);
            Edytut.setVisible(false);
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
            oknoStart2.setVisible(true);
            r.setVisible(true);
        });
        Usuń.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            ramka6.setVisible(false);

        });
        Usuń.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            ramka6.setVisible(true);

        });

        Dodajt.setOnMouseClicked((MouseEvent e) -> { // Po kliknieciu wykonaj
            oknoStart4.setVisible(true);
            r.setVisible(true);
        });
        Dodajt.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            ramka5.setVisible(false);

        });
        Dodajt.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            ramka5.setVisible(true);

        });
        Usuńt.setOnMouseClicked((MouseEvent e) -> { // Po kliknieciu wykonaj
            oknoStart3.setVisible(true);
            r.setVisible(true);
        });
        Usuńt.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            ramka6.setVisible(false);

        });
        Usuńt.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            ramka6.setVisible(true);

        });
        EdytujWpis.setOnMouseClicked((MouseEvent e) -> { // Po kliknieciu wykonaj
            oknoStart6.setVisible(true);
            r.setVisible(true);
        });
        EdytujWpis.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            ramka7.setVisible(false);

        });
        EdytujWpis.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            ramka7.setVisible(true);

        });
        Edytut.setOnMouseClicked((MouseEvent e) -> { // Po kliknieciu wykonaj
            oknoStart5.setVisible(true);
            r.setVisible(true);
        });
        Edytut.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            ramka7.setVisible(false);

        });
        Edytut.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            ramka7.setVisible(true);

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

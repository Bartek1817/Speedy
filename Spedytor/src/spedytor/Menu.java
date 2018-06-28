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

import dane.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public abstract class Menu {
    static ObservableList<Zlecenie> zlec = FXCollections.observableArrayList();

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
        ID.setPrefWidth(900 / 8);
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn Magazyn = new TableColumn("Magazyn");
        Magazyn.setPrefWidth(900 / 8);
        Magazyn.setCellValueFactory(new PropertyValueFactory<>("magazyn"));
        TableColumn Status = new TableColumn("Status");
        Status.setPrefWidth(900 / 8);
        Status.setCellValueFactory(new PropertyValueFactory<>("statusM"));
        TableColumn Towar = new TableColumn("Towar");
        Towar.setPrefWidth(900 / 8);
        Towar.setCellValueFactory(new PropertyValueFactory<>("towar"));
        TableColumn Ilosc = new TableColumn("Ilość");
        Ilosc.setPrefWidth(900 / 8);
        Ilosc.setCellValueFactory(new PropertyValueFactory<>("ilosc"));
        TableColumn Kierowca = new TableColumn("Kierowca");
        Kierowca.setPrefWidth(900 / 8);
        Kierowca.setCellValueFactory(new PropertyValueFactory<>("kierowca"));
        TableColumn Status2 = new TableColumn("Status");
        Status2.setPrefWidth(900 / 8);
        Status2.setCellValueFactory(new PropertyValueFactory<>("statusK"));
        TableColumn Data = new TableColumn("Data");
        Data.setPrefWidth(900 / 8);
        Data.setCellValueFactory(new PropertyValueFactory<>("data"));
        pobierzZlecenia(zlec);
        zawartosc.setItems(zlec);
        nazwa.getColumns().addAll(ID, Magazyn, Status, Towar, Ilosc, Kierowca, Status2, Data);
        zawartosc.getColumns().addAll(nazwa);
        
        
        
        ////////////
        Group g = new Group();
        ObservableList<Lokacja> magazyny = FXCollections.observableArrayList();
        ObservableList<Lista> towary = FXCollections.observableArrayList();
        ObservableList<Lokacja> kierowcy = FXCollections.observableArrayList();
        ChoiceBox wyborMagazynu = new ChoiceBox(magazyny);
        wyborMagazynu.setLayoutX(140);
        wyborMagazynu.setLayoutY(5);
        wyborMagazynu.setPrefWidth(100);
        g.getChildren().add(wyborMagazynu);
        Text wyborMagazynuText = new Text("Wybierz Magazyn");
        wyborMagazynuText.setStyle("-fx-font-size: 12pt;");
        wyborMagazynuText.setFill(Color.WHITE);
        wyborMagazynuText.setLayoutY(15);
        wyborMagazynuText.setLayoutX(10);
        g.getChildren().add(wyborMagazynuText);
        ChoiceBox wyborTowaru = new ChoiceBox(towary);
        wyborTowaru.setLayoutX(140);
        wyborTowaru.setLayoutY(55);
        wyborTowaru.setPrefWidth(100);
        g.getChildren().add(wyborTowaru);
        Text wyborTowaruText = new Text("Wybierz Towar");
        wyborTowaruText.setStyle("-fx-font-size: 12pt;");
        wyborTowaruText.setFill(Color.WHITE);
        wyborTowaruText.setLayoutY(65);
        wyborTowaruText.setLayoutX(10);
        g.getChildren().add(wyborTowaruText);
        TextField ilosc = new TextField ();
        ilosc.setLayoutX(140);
        ilosc.setLayoutY(105);
        ilosc.setPrefWidth(100);
        g.getChildren().add(ilosc);
        Text iloscText = new Text("Wybierz Ilość");
        iloscText.setStyle("-fx-font-size: 12pt;");
        iloscText.setFill(Color.WHITE);
        iloscText.setLayoutY(115);
        iloscText.setLayoutX(10);
        g.getChildren().add(iloscText);
        ChoiceBox wyborKierowcy = new ChoiceBox(kierowcy);
        wyborKierowcy.setLayoutX(140);
        wyborKierowcy.setLayoutY(155);
        wyborKierowcy.setPrefWidth(100);
        g.getChildren().add(wyborKierowcy);
        Text wyborKierowcyText = new Text("Wybierz Kierowce");
        wyborKierowcyText.setStyle("-fx-font-size: 12pt;");
        wyborKierowcyText.setFill(Color.WHITE);
        wyborKierowcyText.setLayoutY(165);
        wyborKierowcyText.setLayoutX(10);
        g.getChildren().add(wyborKierowcyText);
        TextField data = new TextField ();
        data.setLayoutX(140);
        data.setLayoutY(205);
        data.setPrefWidth(100);
        g.getChildren().add(data);
        Text dataText = new Text("Wybierz Date");
        dataText.setStyle("-fx-font-size: 12pt;");
        dataText.setFill(Color.WHITE);
        dataText.setLayoutY(215);
        dataText.setLayoutX(10);
        g.getChildren().add(dataText);
        Text data2Text = new Text("(yyyy-MM-dd HH:mm:ss)");
        data2Text.setStyle("-fx-font-size: 12pt;");
        data2Text.setFill(Color.WHITE);
        data2Text.setLayoutY(215);
        data2Text.setLayoutX(250);
        g.getChildren().add(data2Text);
        Text dodajText = new Text("Dodaj");
        dodajText.setStyle("-fx-font-size: 12pt;");
        dodajText.setFill(Color.WHITE);
        dodajText.setLayoutY(265);
        dodajText.setLayoutX(10);
        g.getChildren().add(dodajText);
        ///////// ROOOT
        final VBox vbox = new VBox();
        vbox.setLayoutY(100);
        vbox.setLayoutX(210);
        vbox.resize(900, 550);
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
            pobierzZlecenia(zlec);

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
            vbox.getChildren().add(g);
            pobierzMagazyny(magazyny);
            pobierzKierowcy(kierowcy);
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
        
        wyborMagazynu.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                pobierzTowary(magazyny.get(newValue.intValue()).getIp(), towary);
            }
        });
        dodajText.setOnMouseClicked((MouseEvent e) -> {
            String ipMag = ((Lokacja)(wyborMagazynu.getSelectionModel().getSelectedItem())).getIp();
            int idTowaru = ((Lista)(wyborTowaru.getSelectionModel().getSelectedItem())).getId();
            String ipKie = ((Lokacja)(wyborKierowcy.getSelectionModel().getSelectedItem())).getIp();
            String lok = ((Lokacja)(wyborMagazynu.getSelectionModel().getSelectedItem())).getNazwa();
            int il = Integer.parseInt(ilosc.getText());
            dodajZlecenie(data.getText(), ipMag, idTowaru, il, 0, ipKie, lok, 0);
            
            vbox.getChildren().clear();
            vbox.getChildren().add(zawartosc);
            Zlecenie.setVisible(false);
            Lista.setVisible(true);
        });
        dodajText.setOnMouseExited((MouseEvent e) -> {
            dodajText.setFill(Color.WHITE);
        });
        dodajText.setOnMouseEntered((MouseEvent e) -> {
            dodajText.setFill(Color.YELLOW);
        });
    }
    
    static void pobierzZlecenia(ObservableList<Zlecenie> zlec)
    {
        Task task = new Task<Void>() {//nowy wątek
            @Override
            public Void call() {
                ArrayList<Zlecenie> zlecenia = new ArrayList<>();
                ArrayList<Lokacja> lokacje = new ArrayList<>();
                ArrayList<Magazyn> zamowieniaMagazyn = new ArrayList<>();
                ArrayList<Kierowca> zamowieniaKierowca = new ArrayList<>();
                try {
                    Socket socket = new Socket("127.0.0.1", 1100);
                    socket.setTcpNoDelay(true);
                    OutputStream outputStream = socket.getOutputStream();
                    InputStream inputStream = socket.getInputStream();
                    ObjectInputStream objInputStream = null;
                    ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);
                    objOutputStream.writeObject("getLokacje");
                    objOutputStream.flush();
                    objInputStream = new ObjectInputStream(inputStream);
                    int ilosc = (int) objInputStream.readObject();
                    for(int i = 0;i<ilosc;i++)
                    {
                        objInputStream = new ObjectInputStream(inputStream);
                        int id = (int) objInputStream.readObject();
                        objInputStream = new ObjectInputStream(inputStream);
                        String nazwa = (String) objInputStream.readObject();
                        objInputStream = new ObjectInputStream(inputStream);
                        String typ = (String) objInputStream.readObject();
                        objInputStream = new ObjectInputStream(inputStream);
                        String ip = (String) objInputStream.readObject();
                        lokacje.add(new Lokacja(id, typ, nazwa, ip));
                    }
                    socket.close();
                    
                    for(int j = 0; j < lokacje.size(); j++)
                    {
                        if(lokacje.get(j).getTyp().equals("Magazyn"))
                        {
                            socket = new Socket(lokacje.get(j).getIp(), 1101);
                            socket.setTcpNoDelay(true);
                            inputStream = socket.getInputStream();
                            objInputStream = null;
                            
                            //wysyłanie pierwszego obiektu (w tym wypadku stringa) - docelowo z poleceniem do api
                            outputStream = socket.getOutputStream();
                            objOutputStream = new ObjectOutputStream(outputStream);
                            objOutputStream.writeObject("getZamowienia");
                            objOutputStream.flush();
                            objInputStream = new ObjectInputStream(inputStream);
                            ilosc = (int) objInputStream.readObject();
                            for(int i = 0;i<ilosc;i++)
                            {
                                ArrayList<ZamowienieMagazyn> z = new ArrayList<>();
                                objInputStream = new ObjectInputStream(inputStream);
                                int id = (int) objInputStream.readObject();
                                objInputStream = new ObjectInputStream(inputStream);
                                int idZlecenia = (int) objInputStream.readObject();
                                objInputStream = new ObjectInputStream(inputStream);
                                int idTowaru = (int) objInputStream.readObject();
                                objInputStream = new ObjectInputStream(inputStream);
                                String nazwa = (String) objInputStream.readObject();
                                objInputStream = new ObjectInputStream(inputStream);
                                int _ilosc = (int) objInputStream.readObject();
                                objInputStream = new ObjectInputStream(inputStream);
                                int status = (int) objInputStream.readObject();
                                z.add(new ZamowienieMagazyn(id, idZlecenia, idTowaru, nazwa, _ilosc, status));
                                zamowieniaMagazyn.add(new Magazyn(lokacje.get(j).getId(), lokacje.get(j).getNazwa(), lokacje.get(j).getIp(), z));
                            }
                            socket.close();
                        }
                        if(lokacje.get(j).getTyp().equals("Samochód"))
                        {
                            socket = new Socket(lokacje.get(j).getIp(), 1102);
                            socket.setTcpNoDelay(true);
                            inputStream = socket.getInputStream();
                            objInputStream = null;
                            outputStream = socket.getOutputStream();
                            objOutputStream = new ObjectOutputStream(outputStream);
                            objOutputStream.writeObject("getZamowienia");
                            objOutputStream.flush();
                            objInputStream = new ObjectInputStream(inputStream);
                            ilosc = (int) objInputStream.readObject();
                            for(int i = 0;i<ilosc;i++)
                            {
                                ArrayList<ZamowienieKierowca> z = new ArrayList<>();
                                objInputStream = new ObjectInputStream(inputStream);
                                int id = (int) objInputStream.readObject();
                                objInputStream = new ObjectInputStream(inputStream);
                                int idZlecenia = (int) objInputStream.readObject();
                                objInputStream = new ObjectInputStream(inputStream);
                                String lokalizacja = (String) objInputStream.readObject();
                                objInputStream = new ObjectInputStream(inputStream);
                                int status = (int) objInputStream.readObject();
                                z.add(new ZamowienieKierowca(id, idZlecenia, lokalizacja, status));
                                zamowieniaKierowca.add(new Kierowca(lokacje.get(j).getId(), lokacje.get(j).getNazwa(), lokacje.get(j).getIp(), z));
                            }
                            socket.close();
                        }
                    }
                    
                    socket = new Socket("127.0.0.1", 1100);
                    socket.setTcpNoDelay(true);
                    outputStream = socket.getOutputStream();
                    inputStream = socket.getInputStream();
                    objInputStream = null;
                    objOutputStream = new ObjectOutputStream(outputStream);
                    objOutputStream.writeObject("getZlecenia");
                    objOutputStream.flush();
                    objInputStream = new ObjectInputStream(inputStream);
                    ilosc = (int) objInputStream.readObject();
                    for(int i = 0;i<ilosc;i++)
                    {
                        objInputStream = new ObjectInputStream(inputStream);
                        int id = (int) objInputStream.readObject();
                        objInputStream = new ObjectInputStream(inputStream);
                        Date data = (Date) objInputStream.readObject();
                        ArrayList<Lokacja> magazyny = new ArrayList<>();
                        ArrayList<Integer> statusM = new ArrayList<>();
                        ArrayList<Towar> towary = new ArrayList<>();
                        ArrayList<Integer> _ilosc = new ArrayList<>();
                        for(Magazyn mag : zamowieniaMagazyn)
                        {
                            for(ZamowienieMagazyn z : mag.getZamowieniaMagazyn())
                            {
                                if(z.getIdZlecenia() == id)
                                {
                                    magazyny.add(new Lokacja(mag.getId(), "Magazyn", mag.getNazwa(), mag.getIp()));
                                    statusM.add(new Integer(z.getStatus()));
                                    towary.add(new Towar(z.getIdTowar(), z.getNazwaTowar()));
                                    _ilosc.add(new Integer(z.getIlosc()));
                                }
                            }
                        }
                        ArrayList<Lokacja> samochody = new ArrayList<>();
                        ArrayList<Integer> statusK = new ArrayList<>();
                        for(Kierowca kie : zamowieniaKierowca)
                        {
                            for(ZamowienieKierowca z : kie.getZamowieniaKierowca())
                            {
                                if(z.getIdZlecenia() == id)
                                {
                                    samochody.add(new Lokacja(kie.getId(), "Samochód", kie.getNazwa(), kie.getIp()));
                                    statusK.add(new Integer(z.getStatus()));
                                }
                            }
                        }
                        zlecenia.add(new Zlecenie(id, magazyny, statusM, towary, _ilosc, samochody, statusK, data));
                    }
                    
                    socket.close();
                    
                    zlec.clear();
                    zlec.addAll(zlecenia);
                    System.out.println(zlec.get(0).getId());
                } catch (IOException ex) { 
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
                return null;
            }
        };
        new Thread(task).start();
    }
    static void pobierzMagazyny(ObservableList<Lokacja> zlec)
    {
        Task task = new Task<Void>() {//nowy wątek
            @Override
            public Void call() {
                try {
                    ArrayList<Lokacja> lokacje = new ArrayList<>();
                    Socket socket = new Socket("127.0.0.1", 1100);
                    socket.setTcpNoDelay(true);
                    OutputStream outputStream = socket.getOutputStream();
                    InputStream inputStream = socket.getInputStream();
                    ObjectInputStream objInputStream = null;
                    ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);
                    objOutputStream.writeObject("getLokacje");
                    objOutputStream.flush();
                    objInputStream = new ObjectInputStream(inputStream);
                    int ilosc = (int) objInputStream.readObject();
                    for(int i = 0;i<ilosc;i++)
                    {
                        objInputStream = new ObjectInputStream(inputStream);
                        int id = (int) objInputStream.readObject();
                        objInputStream = new ObjectInputStream(inputStream);
                        String nazwa = (String) objInputStream.readObject();
                        objInputStream = new ObjectInputStream(inputStream);
                        String typ = (String) objInputStream.readObject();
                        objInputStream = new ObjectInputStream(inputStream);
                        String ip = (String) objInputStream.readObject();
                        if(typ.equals("Magazyn"))
                            lokacje.add(new Lokacja(id, typ, nazwa, ip));
                    }
                    zlec.addAll(lokacje);
                    socket.close();
                } catch (IOException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
                return null;
            }
        };
        new Thread(task).start();
    }
    static void pobierzKierowcy(ObservableList<Lokacja> zlec)
    {
        Task task = new Task<Void>() {//nowy wątek
            @Override
            public Void call() {
                try {
                    ArrayList<Lokacja> lokacje = new ArrayList<>();
                    Socket socket = new Socket("127.0.0.1", 1100);
                    socket.setTcpNoDelay(true);
                    OutputStream outputStream = socket.getOutputStream();
                    InputStream inputStream = socket.getInputStream();
                    ObjectInputStream objInputStream = null;
                    ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);
                    objOutputStream.writeObject("getLokacje");
                    objOutputStream.flush();
                    objInputStream = new ObjectInputStream(inputStream);
                    int ilosc = (int) objInputStream.readObject();
                    for(int i = 0;i<ilosc;i++)
                    {
                        objInputStream = new ObjectInputStream(inputStream);
                        int id = (int) objInputStream.readObject();
                        objInputStream = new ObjectInputStream(inputStream);
                        String nazwa = (String) objInputStream.readObject();
                        objInputStream = new ObjectInputStream(inputStream);
                        String typ = (String) objInputStream.readObject();
                        objInputStream = new ObjectInputStream(inputStream);
                        String ip = (String) objInputStream.readObject();
                        if(typ.equals("Samochód"))
                            lokacje.add(new Lokacja(id, typ, nazwa, ip));
                    }
                    zlec.addAll(lokacje);
                    socket.close();
                } catch (IOException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
                return null;
            }
        };
        new Thread(task).start();
    }
    static void pobierzTowary(String ip, ObservableList<Lista> zlec)
    {
        Task task = new Task<Void>() {//nowy wątek
            @Override
            public Void call() {
                try {
                    ArrayList<Lista> lista = new ArrayList<>();
                    Socket socket = new Socket(ip, 1101);
                    socket.setTcpNoDelay(true);
                    InputStream inputStream = socket.getInputStream();
                    ObjectInputStream objInputStream = null;
                    OutputStream outputStream = socket.getOutputStream();
                    ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);
                    objOutputStream.writeObject("getTowary");
                    objOutputStream.flush();objInputStream = new ObjectInputStream(inputStream);
                    int ilosc = (int) objInputStream.readObject();
                    for(int i = 0;i<ilosc;i++)
                    {
                        objInputStream = new ObjectInputStream(inputStream);
                        int id = (int) objInputStream.readObject();
                        objInputStream = new ObjectInputStream(inputStream);
                        String nazwa = (String) objInputStream.readObject();
                        lista.add(new Lista(id, nazwa));
                    }
                    zlec.addAll(lista);
                    socket.close();
                } catch (IOException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
                return null;
            }
        };
        new Thread(task).start();
    }
    static void dodajZlecenie(String data, String ipMag, int idTowaru, int ilosc, int statusM, String ipKie, String lokalizacja, int statusK)
    {
        Task task = new Task<Void>() {//nowy wątek
            @Override
            public Void call() {
                try {
                    Socket socket = new Socket("127.0.0.1", 1100);
                    socket.setTcpNoDelay(true);
                    OutputStream outputStream = socket.getOutputStream();
                    InputStream inputStream = socket.getInputStream();
                    ObjectInputStream objInputStream = null;
                    ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);
                    objOutputStream.writeObject("addZlecenie");
                    objOutputStream.flush();
                    objOutputStream = new ObjectOutputStream(outputStream);
                    String string = "January 2, 2010";
                    DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = format.parse(data);
                    objOutputStream.writeObject(date);
                    objOutputStream.flush();
                    objInputStream = new ObjectInputStream(inputStream);
                    int id = (int) objInputStream.readObject();
                    socket.close();
                    
                    socket = new Socket(ipMag, 1101);
                    socket.setTcpNoDelay(true);
                    inputStream = socket.getInputStream();
                    objInputStream = null;
                    outputStream = socket.getOutputStream();
                    objOutputStream = new ObjectOutputStream(outputStream);
                    objOutputStream.writeObject("addZamowienie");
                    objOutputStream.flush();
                    objOutputStream = new ObjectOutputStream(outputStream);
                    objOutputStream.writeObject(id);
                    objOutputStream.flush();
                    objOutputStream = new ObjectOutputStream(outputStream);
                    objOutputStream.writeObject(idTowaru);
                    objOutputStream.flush();
                    objOutputStream = new ObjectOutputStream(outputStream);
                    objOutputStream.writeObject(ilosc);
                    objOutputStream.flush();
                    objOutputStream = new ObjectOutputStream(outputStream);
                    objOutputStream.writeObject(statusM);
                    objOutputStream.flush();
                    objInputStream = new ObjectInputStream(inputStream);
                    boolean x = (boolean) objInputStream.readObject();
                    System.out.println(x);
                    socket.close();
                    socket = new Socket(ipKie, 1102);
                    socket.setTcpNoDelay(true);
                    inputStream = socket.getInputStream();
                    objInputStream = null;
                    outputStream = socket.getOutputStream();
                    objOutputStream = new ObjectOutputStream(outputStream);
                    objOutputStream.writeObject("addZamowienie");
                    objOutputStream.flush();
                    objOutputStream = new ObjectOutputStream(outputStream);
                    objOutputStream.writeObject(id);
                    objOutputStream.flush();
                    objOutputStream = new ObjectOutputStream(outputStream);
                    objOutputStream.writeObject(lokalizacja);
                    objOutputStream.flush();
                    objOutputStream = new ObjectOutputStream(outputStream);
                    objOutputStream.writeObject(statusK);
                    objOutputStream.flush();
                    objInputStream = new ObjectInputStream(inputStream);
                    x = (boolean) objInputStream.readObject();
                    System.out.println(x);
                    updateProgress(1, 1);//progres (obecny, max)
                    socket.close();
                } catch (IOException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
                return null;
            }
        };
        task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent t)
            {
                pobierzZlecenia(zlec);
            }
        });
        new Thread(task).start();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import dane.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arekl
 */
public class Database {

    private static Connection con;
    private static String address = "jdbc:mysql://127.0.0.1:3306";

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        Database.address = address;
    }

    public static Connection polacz() {
        Statement st = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        Properties p = new Properties();
        p.put("user", "root");
        p.put("password", "");
        p.put("characterEncoding", "utf8");
        p.put("serverTimezone", "Europe/Warsaw");
        try {
            con = DriverManager.getConnection(address, p);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            st = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            if (st.executeUpdate("USE Magazyn;") == 0) {
                System.out.println("Baza Magazyn wybrana");
            } else {
                System.out.println("Baza nie istnieje! Tworzymy bazę: ");
                if (st.executeUpdate("create Database Magazyn DEFAULT CHARSET=utf8;") == 1) {
                    System.out.println("Baza Magazyn utworzona");
                } else {
                    System.out.println("Baza Magazyn nieutworzona!");
                    System.exit(10);
                }
                if (st.executeUpdate("USE Magazyn;") == 0) {
                    System.out.println("Baza Magazyn wybrana");
                } else {
                    System.out.println("Baza Magazyn niewybrana!");
                    System.exit(11);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Baza nie istnieje! Tworzymy bazę: ");
            try {
                st.executeUpdate("CREATE DATABASE Magazyn DEFAULT CHARSET=utf8;");
                st.executeUpdate("USE Magazyn;");
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public static void zamknij() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void init() {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("CREATE TABLE Towary ( id INT NOT NULL, nazwa VARCHAR(255) NOT NULL, PRIMARY KEY (id));");
            st.executeUpdate("CREATE TABLE Zamowienia ( id INT NOT NULL, id_zlecenia INT NOT NULL, id_towaru INT NOT NULL, ilosc INT NOT NULL, status INT NOT NULL, PRIMARY KEY (id), FOREIGN KEY (id_towaru) REFERENCES Towary(id));");
            st.executeUpdate("CREATE TABLE Magazyn ( id INT NOT NULL, id_towaru INT NOT NULL, regal INT NOT NULL, ilosc INT NOT NULL, PRIMARY KEY (id), FOREIGN KEY (id_towaru) REFERENCES Towary(id));");
            st.executeUpdate("CREATE TABLE Informacje ( id INT NOT NULL, nazwa VARCHAR(255) NOT NULL, wartosc TEXT NOT NULL, PRIMARY KEY (id));");
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void init2() {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("INSERT INTO Towary VALUES ( 0, 'Ziemniaki'),( 1, 'Pomidory'),( 2, 'Cebula'),( 3, 'Marchew'),( 4, 'Ogórek');");
            st.executeUpdate("INSERT INTO Zamowienia VALUES ( 0, 0, 0, 100, 0),( 1, 0, 1, 50, 1),( 2, 1, 2, 100, 2);");
            st.executeUpdate("INSERT INTO Magazyn VALUES ( 0, 0, 0, 500),( 1, 1, 0, 500),( 2, 2, 1, 500),( 3, 3, 1, 500),( 4, 4, 3, 500);");
            st.executeUpdate("INSERT INTO Informacje VALUES ( 0, 'Nazwa', 'Magazyn A'),( 1, 'Adres', 'Przykładowa 1, 00-000 Przykład'),( 2, 'email', 'magazyna@speedy.example');");
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static ArrayList<Towar> readTowary() {
        ArrayList<Towar> a = new ArrayList<Towar>();
        try {
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery("SELECT * FROM Towary");
            while(r.next())
            {
                a.add(new Towar(r.getInt("id"), r.getString("nazwa")));
            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return a;
    }
    public static Towar readTowar(int id) {
        Towar a = null;
        try {
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery("SELECT * FROM Towary WHERE id = "+id);
            if(r.next())
            {
                a = new Towar(r.getInt("id"), r.getString("nazwa"));
            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return a;
    }
    public static ArrayList<Zamowienie> readZamowienia() {
        ArrayList<Zamowienie> a = new ArrayList<Zamowienie>();
        try {
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery("SELECT * FROM Zamowienia");
            while(r.next())
            {
                a.add(new Zamowienie(r.getInt("id"), r.getInt("id_zlecenia"), readTowar(r.getInt("id_towaru")), r.getInt("ilosc"), r.getInt("status")));
            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return a;
    }
    public static Zamowienie readZamowienie(int id) {
        Zamowienie a = null;
        try {
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery("SELECT * FROM Zamowienia WHERE id = "+id);
            if(r.next())
            {
                a = new Zamowienie(r.getInt("id"), r.getInt("id_zlecenia"), readTowar(r.getInt("id_towaru")), r.getInt("ilosc"), r.getInt("status"));
            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return a;
    }
    public static ArrayList<Magazyn> readMagazyny() {
        ArrayList<Magazyn> a = new ArrayList<Magazyn>();
        try {
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery("SELECT * FROM Magazyn");
            while(r.next())
            {
                a.add(new Magazyn(r.getInt("id"), readTowar(r.getInt("id_towaru")), r.getInt("regal"), r.getInt("ilosc")));
            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return a;
    }
    public static Magazyn readMagazyn(int id) {
        Magazyn a = null;
        try {
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery("SELECT * FROM Magazyn WHERE id = "+id);
            while(r.next())
            {
                a = new Magazyn(r.getInt("id"), readTowar(r.getInt("id_towaru")), r.getInt("regal"), r.getInt("ilosc"));
            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return a;
    }
    public static ArrayList<Info> readInfo() {
        ArrayList<Info> a = new ArrayList<Info>();
        try {
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery("SELECT * FROM Informacje");
            while(r.next())
            {
                a.add(new Info(r.getInt("id"), r.getString("nazwa"), r.getString("wartosc")));
            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return a;
    }
    public static Info readInfo(int id) {
        Info a = null;
        try {
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery("SELECT * FROM Informacje WHERE id = "+id);
            if(r.next())
            {
                a = new Info(r.getInt("id"), r.getString("nazwa"), r.getString("wartosc"));
            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return a;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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

            if (st.executeUpdate("USE Kierowca;") == 0) {
                System.out.println("Baza Kierowca wybrana");
            } else {
                System.out.println("Baza nie istnieje! Tworzymy bazę: ");
                if (st.executeUpdate("create Database Kierowca DEFAULT CHARSET=utf8;") == 1) {
                    System.out.println("Baza Kierowca utworzona");
                } else {
                    System.out.println("Baza Kierowca nieutworzona!");
                    System.exit(10);
                }
                if (st.executeUpdate("USE Kierowca;") == 0) {
                    System.out.println("Baza Kierowca wybrana");
                } else {
                    System.out.println("Baza Kierowca niewybrana!");
                    System.exit(11);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Baza nie istnieje! Tworzymy bazę: ");
            try {
                st.executeUpdate("CREATE DATABASE Kierowca DEFAULT CHARSET=utf8;");
                st.executeUpdate("USE Kierowca;");
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
            st.executeUpdate("CREATE TABLE Zamowienia ( id INT NOT NULL, id_zlecenia INT NOT NULL, lokalizacja TEXT NOT NULL, status INT NOT NULL, PRIMARY KEY (id));");
            st.executeUpdate("CREATE TABLE Informacje ( id INT NOT NULL, nazwa VARCHAR(255) NOT NULL, wartosc TEXT NOT NULL, PRIMARY KEY (id));");
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void init2() {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("INSERT INTO Zamowienia VALUES ( 0, 0, 'Przykładowa 1, 00-000 Przykład', 0),( 1, 1, 'Przykładowa 1, 00-000 Przykład', 2);");
            st.executeUpdate("INSERT INTO Informacje VALUES ( 0, 'Nazwa', 'Żuk A-11B'),( 1, 'Numer Rejestracyjny', 'KRA 00000'),( 2, 'Telefon', '123456789');");
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}

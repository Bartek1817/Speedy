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
    private static String address = "jdbc:postgresql://127.0.0.1:5432";

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        Database.address = address;
    }

    public static Connection polacz() {
        Properties p = new Properties();
        p.put("user", "postgres");
        p.put("password", "postgres");
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(address+"/serwer", p);
            
        } catch (Exception e) {
            try {
                System.out.println(e);
                con = DriverManager.getConnection(address+"/postgres", p);
                Statement statement = con.createStatement();
                statement.execute("CREATE DATABASE serwer");
                con.close();
                con = DriverManager.getConnection(address+"/serwer", p);
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            st.executeUpdate("CREATE TABLE Zlecenia ( id int PRIMARY KEY, data timestamp NOT NULL);");
            st.executeUpdate("CREATE TABLE Lokacje ( id int PRIMARY KEY, nazwa varchar(255) NOT NULL, typ varchar(255) NOT NULL, ip varchar(15) NOT NULL);");
            st.executeUpdate("CREATE TABLE Userzy ( id int PRIMARY KEY, numer int NOT NULL, haslo int NOT NULL, imie text NOT NULL, nazwisko text NOT NULL, poziom int NOT NULL );");
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void init2() {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("INSERT INTO Zlecenia VALUES ( 0, now()),( 1, now());");
            st.executeUpdate("INSERT INTO Lokacje VALUES ( 0, 'Magazyn A', 'Magazyn', '127.0.0.1'),( 1, 'Żuk A-11B', 'Samochód', '127.0.0.1');");
            st.executeUpdate("INSERT INTO Userzy VALUES ( 0, 1111, 1111, 'admin', 'admin', 5),( 1, 2222, 2222, 'Stanisław', 'Pracownik', 0),( 2, 3333, 3333, 'Wieczysław', 'Kierownik', 2);");
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}

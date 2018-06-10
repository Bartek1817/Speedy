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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    
    public static ArrayList<Zlecenie> readZlecenia()
    {
        ArrayList<Zlecenie> a = new ArrayList<Zlecenie>();
        try {
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery("SELECT * FROM Zlecenia");
            while(r.next())
            {
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                Date d = format.parse(r.getString("data"));
                a.add(new Zlecenie(r.getInt("id"), d));
            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ParseException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
    public static Zlecenie readZlecenie(int id)
    {
        Zlecenie a = null;
        try {
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery("SELECT * FROM Zlecenia WHERE id="+id);
            if(r.next())
            {
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                Date d = format.parse(r.getString("data"));
                a = new Zlecenie(r.getInt("id"), d);
            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ParseException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
    public static ArrayList<Lokacja> readLokacje()
    {
        ArrayList<Lokacja> a = new ArrayList<Lokacja>();
        try {
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery("SELECT * FROM Lokacje");
            while(r.next())
            {
                a.add(new Lokacja(r.getInt("id"), r.getString("nazwa"), r.getString("typ"), r.getString("ip")));
            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return a;
    }
    public static Lokacja readLokacja(int id)
    {
        Lokacja a = null;
        try {
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery("SELECT * FROM Lokacje WHERE id="+id);
            if(r.next())
            {
                a = new Lokacja(r.getInt("id"), r.getString("nazwa"), r.getString("typ"), r.getString("ip"));
            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return a;
    }
    public static ArrayList<User> readUserzy()
    {
        ArrayList<User> a = new ArrayList<User>();
        try {
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery("SELECT * FROM Userzy");
            while(r.next())
            {
                a.add(new User(r.getInt("id"), r.getInt("numer"), r.getInt("haslo"), r.getString("imie"), r.getString("nazwisko"), r.getInt("poziom")));
            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return a;
    }
    public static User readUser(int id)
    {
        User a = null;
        try {
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery("SELECT * FROM Userzy WHERE id="+id);
            if(r.next())
            {
                a = new User(r.getInt("id"), r.getInt("numer"), r.getInt("haslo"), r.getString("imie"), r.getString("nazwisko"), r.getInt("poziom"));
            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return a;
    }
    public static boolean createZlecenie(Zlecenie a) {
        try {
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery("SELECT max(id) as max FROM Zlecenia");
            int id;
            if(r.next())
            {
                id = r.getInt("max")+1;
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                st.executeUpdate("INSERT INTO Zlecenia VALUES ("+id+",'"+format.format(a.getData())+"')");
            }
            st.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    public static boolean createLokacja(Lokacja a) {
        try {
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery("SELECT max(id) as max FROM Lokacje");
            int id;
            if(r.next())
            {
                id = r.getInt("max")+1;
                st.executeUpdate("INSERT INTO Lokacje VALUES ("+id+",'"+a.getNazwa()+"','"+a.getTyp()+"','"+a.getIp()+"')");
            }
            st.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    public static boolean createUser(User a) {
        try {
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery("SELECT max(id) as max FROM Userzy");
            int id;
            if(r.next())
            {
                id = r.getInt("max")+1;
                st.executeUpdate("INSERT INTO Userzy VALUES ("+id+","+a.getNumer()+","+a.getHaslo()+",'"+a.getImie()+"','"+a.getNazwiosko()+"',"+a.getPoziom()+")");
            }
            st.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    public static boolean updateZlecenie(Zlecenie a) {
        try {
            Statement st = con.createStatement();
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            st.executeUpdate("UPDATE Zlecenia SET data = '"+format.format(a.getData())+"' WHERE id ="+a.getId()+";");
            st.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    public static boolean updateLokacja(Lokacja a) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("UPDATE Lokacje SET nazwa = '"+a.getNazwa()+"',typ = '"+a.getTyp()+"',ip = '"+a.getIp()+"' WHERE id ="+a.getId()+";");
            st.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    public static boolean updateUser(User a) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("UPDATE Userzy SET numer = "+a.getNumer()+",haslo = "+a.getHaslo()+",imie = '"+a.getImie()+"',nazwisko = '"+a.getNazwiosko()+"',poziom = "+a.getPoziom()+" WHERE id ="+a.getId()+";");
            st.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    public static boolean deleteZlecenie(int id) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("DELETE FROM Zlecenia WHERE id ="+id+";");
            st.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    public static boolean deleteLokacja(int id) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("DELETE FROM Lokacje WHERE id ="+id+";");
            st.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    public static boolean deleteUser(int id) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("DELETE FROM Userzy WHERE id ="+id+";");
            st.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
}

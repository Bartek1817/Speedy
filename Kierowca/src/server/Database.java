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
    public static ArrayList<Zamowienie> readZamowienia()
    {
        ArrayList<Zamowienie> a = new ArrayList<Zamowienie>();
        try {
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery("SELECT * FROM Zamowienia");
            while(r.next())
            {
                a.add(new Zamowienie(r.getInt("id"), r.getInt("id_zlecenia"), r.getString("lokalizacja"), r.getInt("status")));
            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return a;
    }
    public static Zamowienie readZamowienie(int id)
    {
        Zamowienie a = null;
        try {
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery("SELECT * FROM Zamowienia WHERE id="+id);
            while(r.next())
            {
                a = new Zamowienie(r.getInt("id"), r.getInt("id_zlecenia"), r.getString("lokalizacja"), r.getInt("status"));
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
    public static boolean createZamowienie(Zamowienie a) {
        try {
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery("SELECT max(id) as max FROM Zamowienia");
            int id;
            if(r.next())
            {
                id = r.getInt("max")+1;
                st.executeUpdate("INSERT INTO Zamowienia VALUES ("+id+","+a.getIdZlecenia()+",'"+a.getLokalizacja()+"',"+a.getStatus()+")");
            }
            st.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    public static boolean createInfo(Info a) {
        try {
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery("SELECT max(id) as max FROM Informacje");
            int id;
            if(r.next())
            {
                id = r.getInt("max")+1;
                st.executeUpdate("INSERT INTO Informacje VALUES ("+id+",'"+a.getNazwa()+"','"+a.getWartosc()+"')");
            }
            st.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    public static boolean updateZamownienie(Zamowienie a) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("UPDATE Zamowienia SET id_zlecenia = "+a.getIdZlecenia()+", lokalizacja='"+a.getLokalizacja()+"', status="+a.getStatus()+" WHERE id ="+a.getId()+";");
            st.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    public static boolean updateInfo(Info a) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("UPDATE Informacje SET nazwa = '"+a.getNazwa()+"', wartosc='"+a.getWartosc()+"' WHERE id ="+a.getId()+";");
            st.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    public static boolean deleteZamowienie(int id) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("DELETE FROM Zamowienia WHERE id ="+id+";");
            st.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    public static boolean deleteInfo(int id) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("DELETE FROM Informacje WHERE id ="+id+";");
            st.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
}

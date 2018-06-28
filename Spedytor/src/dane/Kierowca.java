/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dane;

import java.util.ArrayList;

/**
 *
 * @author Arekl
 */
public class Kierowca {
    int id;
    String nazwa;
    String ip; 
    ArrayList<ZamowienieKierowca> zamowieniaKierowca;

    public Kierowca(int id, String nazwa, String ip, ArrayList<ZamowienieKierowca> zamowieniaKierowca) {
        this.id = id;
        this.nazwa = nazwa;
        this.ip = ip;
        this.zamowieniaKierowca = zamowieniaKierowca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public ArrayList<ZamowienieKierowca> getZamowieniaKierowca() {
        return zamowieniaKierowca;
    }

    public void setZamowieniaKierowca(ArrayList<ZamowienieKierowca> zamowieniaKierowca) {
        this.zamowieniaKierowca = zamowieniaKierowca;
    }
    
}

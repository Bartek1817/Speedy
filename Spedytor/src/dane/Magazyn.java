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
public class Magazyn {
    int id;
    String nazwa;
    String ip; 
    ArrayList<ZamowienieMagazyn> zamowieniaMagazyn;

    public Magazyn(int id, String nazwa, String ip, ArrayList<ZamowienieMagazyn> zamowieniaMagazyn) {
        this.id = id;
        this.nazwa = nazwa;
        this.ip = ip;
        this.zamowieniaMagazyn = zamowieniaMagazyn;
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

    public ArrayList<ZamowienieMagazyn> getZamowieniaMagazyn() {
        return zamowieniaMagazyn;
    }

    public void setZamowieniaMagazyn(ArrayList<ZamowienieMagazyn> zamowieniaMagazyn) {
        this.zamowieniaMagazyn = zamowieniaMagazyn;
    }
    
}

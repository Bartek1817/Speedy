/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dane;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Arekl
 */
public class Zlecenie {
    int id;
    ArrayList<Lokacja> magazyn;
    ArrayList<Integer> statusM;
    ArrayList<Towar> towar;
    ArrayList<Integer> ilosc;
    ArrayList<Lokacja> kierowca;
    ArrayList<Integer> statusK;
    Date data;

    public Zlecenie(int id, ArrayList<Lokacja> magazyn, ArrayList<Integer> statusM, ArrayList<Towar> towar, ArrayList<Integer> ilosc, ArrayList<Lokacja> kierowca, ArrayList<Integer> statusK, Date data) {
        this.id = id;
        this.magazyn = magazyn;
        this.statusM = statusM;
        this.towar = towar;
        this.ilosc = ilosc;
        this.kierowca = kierowca;
        this.statusK = statusK;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Lokacja> getMagazyn() {
        return magazyn;
    }

    public void setMagazyn(ArrayList<Lokacja> magazyn) {
        this.magazyn = magazyn;
    }

    public ArrayList<Integer> getStatusM() {
        return statusM;
    }

    public void setStatusM(ArrayList<Integer> statusM) {
        this.statusM = statusM;
    }

    public ArrayList<Towar> getTowar() {
        return towar;
    }

    public void setTowar(ArrayList<Towar> towar) {
        this.towar = towar;
    }

    public ArrayList<Integer> getIlosc() {
        return ilosc;
    }

    public void setIlosc(ArrayList<Integer> ilosc) {
        this.ilosc = ilosc;
    }

    public ArrayList<Lokacja> getKierowca() {
        return kierowca;
    }

    public void setKierowca(ArrayList<Lokacja> kierowca) {
        this.kierowca = kierowca;
    }

    public ArrayList<Integer> getStatusK() {
        return statusK;
    }

    public void setStatusK(ArrayList<Integer> statusK) {
        this.statusK = statusK;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    
}

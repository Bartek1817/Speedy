/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dane;

/**
 *
 * @author Arekl
 */
public class Magazyn {
    int id;
    Towar towar;
    int regal;
    int ilosc;

    public Magazyn(int id, Towar towar, int regal, int ilosc) {
        this.id = id;
        this.towar = towar;
        this.regal = regal;
        this.ilosc = ilosc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Towar getTowar() {
        return towar;
    }

    public void setTowar(Towar towar) {
        this.towar = towar;
    }

    public int getRegal() {
        return regal;
    }

    public void setRegal(int regal) {
        this.regal = regal;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
    
}

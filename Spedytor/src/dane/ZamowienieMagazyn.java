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
public class ZamowienieMagazyn {
    int id;
    int idZlecenia;
    int idTowar;
    String nazwaTowar;
    int ilosc;
    int status;

    public ZamowienieMagazyn(int id, int idZlecenia, int idTowar, String nazwaTowar, int ilosc, int status) {
        this.id = id;
        this.idZlecenia = idZlecenia;
        this.idTowar = idTowar;
        this.nazwaTowar = nazwaTowar;
        this.ilosc = ilosc;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdZlecenia() {
        return idZlecenia;
    }

    public void setIdZlecenia(int idZlecenia) {
        this.idZlecenia = idZlecenia;
    }

    public int getIdTowar() {
        return idTowar;
    }

    public void setIdTowar(int idTowar) {
        this.idTowar = idTowar;
    }

    public String getNazwaTowar() {
        return nazwaTowar;
    }

    public void setNazwaTowar(String nazwaTowar) {
        this.nazwaTowar = nazwaTowar;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}

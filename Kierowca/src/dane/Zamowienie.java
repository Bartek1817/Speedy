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
public class Zamowienie {
    int id;
    int idZlecenia;
    String lokalizacja;
    int status;

    public Zamowienie(int id, int idZlecenia, String lokalizacja, int status) {
        this.id = id;
        this.idZlecenia = idZlecenia;
        this.lokalizacja = lokalizacja;
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

    public String getLokalizacja() {
        return lokalizacja;
    }

    public void setLokalizacja(String lokalizacja) {
        this.lokalizacja = lokalizacja;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}

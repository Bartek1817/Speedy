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
public class User {
    int id;
    int numer;
    int haslo;
    String imie;
    String nazwiosko;
    int poziom;

    public User(int id, int numer, int haslo, String imie, String nazwiosko, int poziom) {
        this.id = id;
        this.numer = numer;
        this.haslo = haslo;
        this.imie = imie;
        this.nazwiosko = nazwiosko;
        this.poziom = poziom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumer() {
        return numer;
    }

    public void setNumer(int numer) {
        this.numer = numer;
    }

    public int getHaslo() {
        return haslo;
    }

    public void setHaslo(int haslo) {
        this.haslo = haslo;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwiosko() {
        return nazwiosko;
    }

    public void setNazwiosko(String nazwiosko) {
        this.nazwiosko = nazwiosko;
    }

    public int getPoziom() {
        return poziom;
    }

    public void setPoziom(int poziom) {
        this.poziom = poziom;
    }
    
}

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
public class Towar {
    int id;
    String nazwa;

    public Towar(int id, String nazwa) {
        this.id = id;
        this.nazwa = nazwa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        assert(id<0);
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        assert(nazwa.length()>255);
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return nazwa;
    }
    
}

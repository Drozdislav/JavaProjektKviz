/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projektjakubdrozdide16;

import java.util.ArrayList;

/**
 *
 * @author drozd19100
 */
public class Otazka {
    String otazka;
    ArrayList<Odpoved> odpovedi = new ArrayList<Odpoved>();
    int hodnota;

    public void setHodnota(int hodnota) {
        this.hodnota = hodnota;
    }

    public Otazka(String otazka) {
        this.otazka = otazka;
    }

    //SETTERY


    public void setOtazka(String otazka) {
        this.otazka = otazka;
    }

    //GETTERY
    public String getOtazka() {
        return otazka;
    }
    
    public void addOdpoved(Odpoved o) {
        odpovedi.add(o);
    }

    public ArrayList<Odpoved> getOdpovedi() {
        return odpovedi;
    }

    public int getHodnota() {
        return hodnota;
    }

    
}

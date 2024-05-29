/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projektjakubdrozdide16;

import java.util.ArrayList;

/**
 * třída řešící otázku 
 * @author Jakub Drozd <drozd19100@zak.gvid.cz>
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
/**
 * metoda která vrací jestli je otázka typu otevřená nebo 1 z 3 možností
 * @return 
 */
    public int getTypOtazky() {
        long countSpatne = odpovedi.stream().filter(o -> !o.isSpravne()).count();
        if (countSpatne == 2) {
            return 1;
        } 
        else    {
            return 2;
        }
    }
}


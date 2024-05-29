/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projektjakubdrozdide16;

/**
 * třída používaná k ukládání tabulky výsledků
 * @author Jakub Drozd <drozd19100@zak.gvid.cz>
 */
public class VysledkyTabulka {
    String JmenoUzivatele;
    int skoreUzivatele;

    public VysledkyTabulka(String JmenoUzivatele, int skoreUzivatele) {
        this.JmenoUzivatele = JmenoUzivatele;
        this.skoreUzivatele = skoreUzivatele;
    }

    public int getSkoreUzivatele() {
        return skoreUzivatele;
    }    

    public VysledkyTabulka() {
    }
    
    
}

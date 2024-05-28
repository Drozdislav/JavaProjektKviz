/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projektjakubdrozdide16;

/**
 * 
 * @author Jakub Drozd <drozd19100@zak.gvid.cz>
 */
public class Odpoved { // v této třídě se rozebírá odpoved, využívá se při načtení a výpisu odpovedi
    boolean spravne;
    String textOdpovedi;

    public Odpoved(boolean spravne, String textOdpovedi) {
        this.spravne = spravne;
        this.textOdpovedi = textOdpovedi;
    }

    public boolean isSpravne() {
        return spravne;
    }

}

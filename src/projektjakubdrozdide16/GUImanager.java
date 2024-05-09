/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projektjakubdrozdide16;

import javax.swing.JFrame;

/**
 *
 * @author jakub
 */
public class GUImanager {
    int GUIManagerhodnota;
    
    public void dalsiFrame(JFrame aktualniFrame, String nazevFrame, Scanner s) {
        JFrame frame = null;
        frame = switch (nazevFrame) {
                
            default -> new Kviz(s);
        };
        
        aktualniFrame.dispose();
        frame.show();
        
    }
    
    public void vysledkyFrame(JFrame aktualniFrame, String nazevFrame, int skore) {
        JFrame frame = null;
        frame = switch (nazevFrame) {
                
            default -> new Vysledky(skore);
        };
        
        aktualniFrame.dispose();
        frame.show();
}
/* 
    POZOR! Vím že funkce vysledkyFrame a dalsiFrame 
    obsahují switch, který tam nemusí být ale když 
    jsem se to pokusil přepsat tak mi to přestalo 
    fungovat
    
    Skore se nevipisuje spravne, zatim nevim kde je chyba
*/

}

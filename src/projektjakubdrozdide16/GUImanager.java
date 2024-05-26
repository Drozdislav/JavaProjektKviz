/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projektjakubdrozdide16;

import javax.swing.JFrame;


/**
 * 
 * @author Jakub Drozd <drozd19100@zak.gvid.cz>
 */
public class GUImanager {
    public void dalsiFrame(JFrame aktualniFrame, String nazevFrame) {

        
        aktualniFrame.dispose();
        aktualniFrame.show();
        
    }
    
    public void vysledkyFrame(JFrame aktualniFrame, String nazevFrame, int skore) {
        JFrame frame = null;
        frame = switch (nazevFrame) {
                
            default -> new Vysledky(skore, aktualniFrame);
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projektjakubdrozdide16;

import javax.swing.JFrame;


/**
 * Tato třída přepíná mezi obrazovkami
 * @author Jakub Drozd <drozd19100@zak.gvid.cz>
 */
public class GUImanager {
    /**
     * Metoda která přepíná mezi obrazovkami
     * @param aktualniFrame
     * @param nazevFrame 
     */
    public void dalsiFrame(Kviz aktualniFrame, String nazevFrame) {

        
        aktualniFrame.dispose();
        aktualniFrame.setVisible(true);
        
    }
    /**
     * metoda která přepíná na obrazovku Výsledky
     * @param aktualniFrame
     * @param nazevFrame
     * @param skore
     * @throws EmptyFileException 
     */
    public void vysledkyFrame(Kviz aktualniFrame, String nazevFrame, int skore) throws EmptyFileException {
        JFrame frame = null;
        frame = switch (nazevFrame) {
                
            default -> new Vysledky(skore, aktualniFrame);
        };
        
        aktualniFrame.dispose();
        frame.setVisible(true);
}
/* 
    POZOR! Vím že funkce vysledkyFrame obsahují 
    switch, který tam nemusí být ale když 
    jsem se to pokusil přepsat tak mi to přestalo 
    fungovat
*/

}

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
    
    public void dalsiFrame(JFrame aktualniFrame, String nazevFrame) {
        JFrame frame = null;
        frame = switch (nazevFrame) {
                
            default -> new Kviz();
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

    public int getGUIManagerHodnota() {
        return GUIManagerhodnota;
    }

    public void setGUIManagerHodnota(int hodnota) {
        this.GUIManagerhodnota = hodnota;
    }
    
}

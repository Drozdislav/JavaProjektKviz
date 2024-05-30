/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projektjakubdrozdide16;

import java.awt.Font;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 * třída řešící obrazovku Kviz
 * @author Jakub Drozd <drozd19100@zak.gvid.cz>
 */
public class Kviz extends javax.swing.JFrame {
    GUImanager gui = new GUImanager();
    ArrayList<Otazka> list;
    int indexAktOtazky=0; //index otázky, aby kdyz dojdou otázky tak se zobrazila obrazovka s vysledky, viz. DalsiActionPerformed
    int skore=0;
    boolean otazkaspravneDalsi = false;
    String nazevKvizu;
    String jmenoUzivatele;
    FileReader fr = new FileReader();
      
      
      
    public void setJmenoUzivatele(String jmenoUzivatele) {
        this.jmenoUzivatele = jmenoUzivatele;
    }

    public String getJmenoUzivatele() {
        return jmenoUzivatele;
    }
  
    public void setSkore(int skore) {
        this.skore = skore;
        this.indexAktOtazky = 0;
    }
 
    /**
     * konstruktor zapínající obrazovku kviz
     * @param data 
     */
    public Kviz(ArrayList<Otazka> data) {
        initComponents();
        list = data;
        Collections.shuffle(list);
        ProgressBarKviz.setMaximum(list.size());
        
        NazevKvizu.setText(fr.getNazevKvizu());
        this.ZapisPomDoGUI(list.get(0));
        
            this.addComponentListener(new java.awt.event.ComponentAdapter() {
        public void componentResized(java.awt.event.ComponentEvent evt) {
            resizeText();
        }
    });
    }
    
    /**
     * metoda pomocí které meni velikost okna 
     */
    private void resizeText() {
    int frameWidth = this.getWidth();
    int frameHeight = this.getHeight();

    float baseWidth = 400f; // Původní šířka rámu při návrhu
    float baseHeight = 300f; // Původní výška rámu při návrhu

    float widthRatio = frameWidth / baseWidth;
    float heightRatio = frameHeight / baseHeight;

    float newFontSize = 14f * Math.min(widthRatio, heightRatio); // Základní velikost písma 14

    Font newFont = NazevKvizu.getFont().deriveFont(newFontSize);
    NazevKvizu.setFont(newFont);
    TextOtazky.setFont(newFont);
    Odpoved1.setFont(newFont);
    Odpoved2.setFont(newFont);
    Odpoved3.setFont(newFont);
    odpovedOtevrenaOtazka.setFont(newFont);
}

    /**
     * metoda která po zmáčknutí tlačítka opakovat resetne skore a vymaže selekce tlačítek
     * @param n 
     */
    public void resetProgressBar(int n) {
        ProgressBarKviz.setValue(n);
        buttonGroup1.clearSelection();
    }
    
    
    /**
     * tato funkce zapisuje otazky ze seznamu do GUI
     * @param o 
     */
     public void ZapisPomDoGUI(Otazka o) {
         Collections.shuffle(o.odpovedi);
    TextOtazky.setText(o.otazka);

    int typOtazky = o.getTypOtazky();
    
    if (typOtazky == 2) { // otevřená otázka
        Odpoved1.setVisible(false);
        Odpoved2.setVisible(false);
        Odpoved3.setVisible(false);
        dalsiButton.setVisible(true);
        odpovedOtevrenaOtazka.setVisible(true);
    } else { // jedna ze tří
        Odpoved1.setVisible(true);
        Odpoved2.setVisible(true);
        Odpoved3.setVisible(true);
        dalsiButton.setVisible(false);
        odpovedOtevrenaOtazka.setVisible(false);

        Odpoved1.setText(o.odpovedi.get(0).textOdpovedi);
        Odpoved2.setText(o.odpovedi.get(1).textOdpovedi);
        Odpoved3.setText(o.odpovedi.get(2).textOdpovedi);
    }
    }
    /**
     * metoda zobrazující výsledky
     * @param skore
     * @throws EmptyFileException 
     */
    private void ZobrazVysledky(int skore) throws EmptyFileException {
        gui.vysledkyFrame(this, "Vysledky", skore);
    }                                     
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        TextOtazky = new javax.swing.JLabel();
        Odpoved1 = new javax.swing.JRadioButton();
        Odpoved2 = new javax.swing.JRadioButton();
        Odpoved3 = new javax.swing.JRadioButton();
        NazevKvizu = new javax.swing.JLabel();
        odpovedOtevrenaOtazka = new javax.swing.JTextField();
        ProgressBarKviz = new javax.swing.JProgressBar();
        dalsiButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonGroup1.add(Odpoved1);
        Odpoved1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Odpoved1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(Odpoved2);
        Odpoved2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Odpoved2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(Odpoved3);
        Odpoved3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Odpoved3ActionPerformed(evt);
            }
        });

        odpovedOtevrenaOtazka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odpovedOtevrenaOtazkaActionPerformed(evt);
            }
        });

        dalsiButton.setText("Další");
        dalsiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dalsiButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(ProgressBarKviz, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(dalsiButton)
                                .addGap(39, 39, 39))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(NazevKvizu, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Odpoved3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Odpoved2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Odpoved1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(TextOtazky, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 76, Short.MAX_VALUE)))))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(odpovedOtevrenaOtazka, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NazevKvizu, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TextOtazky, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Odpoved1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Odpoved2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Odpoved3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(odpovedOtevrenaOtazka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(dalsiButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProgressBarKviz, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Funkce která reaguje na zmáčknutí tlačítka 1
     * @param evt 
     */
    private void Odpoved1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Odpoved1ActionPerformed
        otazkaspravneDalsi = list.get(indexAktOtazky).odpovedi.get(0).spravne;
        try {
            if(otazkaspravneDalsi) {
                skore += list.get(indexAktOtazky).getHodnota();
            }
            indexAktOtazky += 1;
            ProgressBarKviz.setValue(indexAktOtazky);
            ZapisPomDoGUI(list.get(indexAktOtazky));
            buttonGroup1.clearSelection();
        } catch (IndexOutOfBoundsException e) {
            try {
                ZobrazVysledky(skore); // Při vyčerpání otázek předejte celkové skóre
            } catch (EmptyFileException ex) {
                Logger.getLogger(Kviz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
        static {
    }//GEN-LAST:event_Odpoved1ActionPerformed

    /**
    * Funkce která reaguje na zmáčknutí tlačítka 2
    * @param evt 
    */
    private void Odpoved2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Odpoved2ActionPerformed
        otazkaspravneDalsi = list.get(indexAktOtazky).odpovedi.get(1).spravne;
       try {
            if(otazkaspravneDalsi) {
                skore += list.get(indexAktOtazky).getHodnota();
            }
            indexAktOtazky += 1;
            ProgressBarKviz.setValue(indexAktOtazky);
            ZapisPomDoGUI(list.get(indexAktOtazky));
            buttonGroup1.clearSelection();
        } catch (IndexOutOfBoundsException e) {
            try {
                ZobrazVysledky(skore); // Při vyčerpání otázek předejte celkové skóre
            } catch (EmptyFileException ex) {
                Logger.getLogger(Kviz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
        static { //toto mi ze záhadného důvodu nejde smazat
    }//GEN-LAST:event_Odpoved2ActionPerformed

    /**
    * Funkce která reaguje na zmáčknutí tlačítka 3
    * @param evt 
    */
    private void Odpoved3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Odpoved3ActionPerformed
        otazkaspravneDalsi = list.get(indexAktOtazky).odpovedi.get(2).spravne;
        try {
            if(otazkaspravneDalsi) {
                skore += list.get(indexAktOtazky).getHodnota();
            }
            indexAktOtazky += 1;
            ProgressBarKviz.setValue(indexAktOtazky);
            
            ZapisPomDoGUI(list.get(indexAktOtazky));
            buttonGroup1.clearSelection();
        } catch (IndexOutOfBoundsException e) {
            try {
                ZobrazVysledky(skore); // Při vyčerpání otázek předejte celkové skóre
            } catch (EmptyFileException ex) {
                Logger.getLogger(Kviz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
        static { //toto mi ze záhadného důvodu nejde smazat
    }//GEN-LAST:event_Odpoved3ActionPerformed
        
    private void odpovedOtevrenaOtazkaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odpovedOtevrenaOtazkaActionPerformed
 
    }//GEN-LAST:event_odpovedOtevrenaOtazkaActionPerformed
/**
 * při zmáčknutí tlačítka další při otevřené otázce
 * @param evt 
 */
    private void dalsiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dalsiButtonActionPerformed
    String userOdpoved = normalizujText(odpovedOtevrenaOtazka.getText());
    Otazka aktualniOtazka = list.get(indexAktOtazky);

    if (aktualniOtazka.getTypOtazky() == 2) { // otevřená otázka
        String spravnaOdpoved = normalizujText(aktualniOtazka.odpovedi.get(0).textOdpovedi);
        if (userOdpoved.equals(spravnaOdpoved)) {
            skore += aktualniOtazka.getHodnota();
        }
        indexAktOtazky += 1;
        ProgressBarKviz.setValue(indexAktOtazky);
        odpovedOtevrenaOtazka.setText("");
        try {
            ZapisPomDoGUI(list.get(indexAktOtazky));
        } catch (IndexOutOfBoundsException e) {
            try {
                ZobrazVysledky(skore);
            } catch (EmptyFileException ex) {
                Logger.getLogger(Kviz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    }//GEN-LAST:event_dalsiButtonActionPerformed

    private String normalizujText(String text) {
    // Odstranění diakritiky a převedení na malá písmena
    text = text.toLowerCase();
    text = Normalizer.normalize(text, Normalizer.Form.NFD);
    text = text.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    return text;
}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NazevKvizu;
    private javax.swing.JRadioButton Odpoved1;
    private javax.swing.JRadioButton Odpoved2;
    private javax.swing.JRadioButton Odpoved3;
    private javax.swing.JProgressBar ProgressBarKviz;
    private javax.swing.JLabel TextOtazky;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton dalsiButton;
    private javax.swing.JTextField odpovedOtevrenaOtazka;
    // End of variables declaration//GEN-END:variables
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projektjakubdrozdide16;

import java.awt.Font;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * třída tvořící úvodní obrazovku 
 * @author Jakub Drozd <drozd19100@zak.gvid.cz>
 */
public class UvodniObrazovka extends javax.swing.JFrame {
    GUImanager gui = new GUImanager();
    ArrayList<Otazka> list = new ArrayList<>();
    String NazevSouboru;
    String JmenoUzivatele;
    ArrayList<VysledkyTabulka> vysledkyList = new ArrayList<>();
    VysledkyTabulka vt = new VysledkyTabulka();
    

    public String getJmenoUzivatele() {
        return JmenoUzivatele;
    }

    public String getNazevSouboru() {
        return NazevSouboru;
    }
    
    /**
     * Creates new form UvodniObrazovka
     */
    public UvodniObrazovka() {
        initComponents();
        this.addComponentListener(new java.awt.event.ComponentAdapter() {
        @Override
        public void componentResized(java.awt.event.ComponentEvent evt) {
            resizeText();
        }
        
    });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        VyberSouboruText = new javax.swing.JTextField();
        VyberSouboruLabel = new javax.swing.JLabel();
        NacistSouborTlacitko = new javax.swing.JButton();
        JmenoUzivateleTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Drozdova Úžasná Kvízová Aplikace");

        VyberSouboruText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VyberSouboruTextActionPerformed(evt);
            }
        });

        VyberSouboruLabel.setText("Vyber si soubor:");

        NacistSouborTlacitko.setText("Načíst Soubor a Spustit Kvíz");
        NacistSouborTlacitko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NacistSouborTlacitkoActionPerformed(evt);
            }
        });

        JmenoUzivateleTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmenoUzivateleTextFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Jméno uživatele:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(VyberSouboruLabel)
                        .addGap(210, 210, 210))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(97, 97, 97))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(NacistSouborTlacitko)
                        .addGap(91, 91, 91))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(VyberSouboruText, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                .addComponent(JmenoUzivateleTextField)))
                        .addGap(56, 56, 56))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(VyberSouboruLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VyberSouboruText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JmenoUzivateleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NacistSouborTlacitko)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * tlačítko spouštějící kvíz a načítající jméno uživatele
 * @param evt 
 */
    private void NacistSouborTlacitkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NacistSouborTlacitkoActionPerformed
        FileReader fr = new FileReader();
        
        NazevSouboru = VyberSouboruText.getText();
        JmenoUzivatele = JmenoUzivateleTextField.getText();
        try {
            list = fr.nactiOtazky(NazevSouboru);
        } catch (EmptyFileException ex) {
            Logger.getLogger(UvodniObrazovka.class.getName()).log(Level.SEVERE, null, ex);
        }
        VyberSouboruText.setText("");
        VyberSouboruLabel.setText("Soubor nenačten");
        Kviz resetSkore = new Kviz(list);
        resetSkore.setSkore(0);
        resetSkore.setJmenoUzivatele(JmenoUzivatele);
        try {
            gui.dalsiFrame(resetSkore, "Kviz");
        } catch (Exception e) {
            // Handle all types of exceptions
            System.out.println("An error occurred: " + e.getMessage());
        }
        this.dispose();
    }//GEN-LAST:event_NacistSouborTlacitkoActionPerformed

    private void resizeText() {
    int frameWidth = this.getWidth();
    int frameHeight = this.getHeight();

    float baseWidth = 400f; // Původní šířka rámu při návrhu
    float baseHeight = 300f; // Původní výška rámu při návrhu

    float widthRatio = frameWidth / baseWidth;
    float heightRatio = frameHeight / baseHeight;

    float newFontSize = 14f * Math.min(widthRatio, heightRatio); // Základní velikost písma 14

    Font newFont = jLabel1.getFont().deriveFont(newFontSize);
    jLabel1.setFont(newFont);
    VyberSouboruLabel.setFont(newFont);
    NacistSouborTlacitko.setFont(newFont);
    jLabel2.setFont(newFont);
    VyberSouboruText.setFont(newFont);
    JmenoUzivateleTextField.setFont(newFont);
}
    
    private void VyberSouboruTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VyberSouboruTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VyberSouboruTextActionPerformed

    private void JmenoUzivateleTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmenoUzivateleTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JmenoUzivateleTextFieldActionPerformed
    /**
     * experiment s grafickou knihovnou, podle videa od Ing. Davida Martinka
     */
    public static void setFlatLaf() {
    try {
        UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatLightLaf());
    } catch (UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(UvodniObrazovka.class.getName()).log(java.util.logging.Level.SEVERE, null,ex);
        System.err.println("Pravděpodobně tu hcybí knihovna lib/flatlaf-3.3.jar.");
        System.exit(1);
        }           
    }
    
    public static void setDefaultLaf() {
        try {
            for(UIManager.LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()) {
                if("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UvodniObrazovka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            System.err.println("Nejde nastavit vzhled GTK+ ani Windows!");
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        setFlatLaf();
        

    /**
     *
     */
    

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UvodniObrazovka().setVisible(true);
            }
});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JmenoUzivateleTextField;
    private javax.swing.JButton NacistSouborTlacitko;
    private javax.swing.JLabel VyberSouboruLabel;
    private javax.swing.JTextField VyberSouboruText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}

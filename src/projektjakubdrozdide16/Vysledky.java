/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projektjakubdrozdide16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 * Tato třída je umožňuje zobrazení výsledků kvízu
 * @author
 */
public class Vysledky extends javax.swing.JFrame {
    GUImanager gui = new GUImanager();
    UvodniObrazovka uo = new UvodniObrazovka();
    String NazevSouboruVysledky = uo.getNazevSouboru();
    ArrayList<Otazka> list = new ArrayList<>();
    Kviz KvizZnovaFrame;

    /**
     * Vytvari novy form Vysledky
     */
    public Vysledky() {
        initComponents();       
    }
    /**
     * Pro zobrazení vysledné obrazovky a vypsání finálního skóre
     * @param hodnota 
         * @param KvizFrame 
     */
    public Vysledky(int hodnota, Kviz KvizFrame) {
        initComponents();
        KvizZnovaFrame = KvizFrame;
        
        PocetBoduCislo.setText(String.valueOf(hodnota));
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VysledkyNadpis = new javax.swing.JLabel();
        PocetBoduText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        PocetBoduCislo = new javax.swing.JLabel();
        zkusZnovaTlacitko = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        VysledkyNadpis.setText("Výsledky:");

        PocetBoduText.setText("Počet Bodů:");

        PocetBoduCislo.setText("jLabel2");

        zkusZnovaTlacitko.setText("Opakovat");
        zkusZnovaTlacitko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zkusZnovaTlacitkoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(218, 218, 218))
            .addGroup(layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(PocetBoduCislo)
                            .addGap(14, 14, 14))
                        .addComponent(PocetBoduText))
                    .addComponent(zkusZnovaTlacitko)
                    .addComponent(VysledkyNadpis))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(VysledkyNadpis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PocetBoduText)
                .addGap(18, 18, 18)
                .addComponent(PocetBoduCislo)
                .addGap(91, 91, 91)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(zkusZnovaTlacitko)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * 
     * @param evt 
     */
    private void zkusZnovaTlacitkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zkusZnovaTlacitkoActionPerformed

        // Set the initial score to 0
        KvizZnovaFrame.setSkore(0);
        Collections.shuffle(KvizZnovaFrame.list);
        KvizZnovaFrame.ZapisPomDoGUI(KvizZnovaFrame.list.get(0));
        
        //Display the quiz frame
        gui.dalsiFrame(KvizZnovaFrame, "Kviz");
        
        // Close the current results frame
        this.dispose();
    }//GEN-LAST:event_zkusZnovaTlacitkoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vysledky.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vysledky.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vysledky.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vysledky.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vysledky().setVisible(true);
            }
        });
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PocetBoduCislo;
    private javax.swing.JLabel PocetBoduText;
    private javax.swing.JLabel VysledkyNadpis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton zkusZnovaTlacitko;
    // End of variables declaration//GEN-END:variables

}

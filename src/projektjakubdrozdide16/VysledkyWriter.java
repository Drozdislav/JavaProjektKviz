/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projektjakubdrozdide16;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * třída pro zapsaní top 3 vysledků do souboru
 * @author Jakub Drozd <drozd19100@zak.gvid.cz>
 */
public class VysledkyWriter {
    
    /**
     * metoda pro vypsání top 3 výsledků do souboru
     * @param data 
     */
    public void zapisVysledkyTabulka(ArrayList<VysledkyTabulka> data) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Vysledky.txt")))) {
            for (int i = 0; i < Math.min(3, data.size()); i++) {
                VysledkyTabulka vysledek = data.get(i);
                writer.write(vysledek.JmenoUzivatele + ";" + vysledek.skoreUzivatele);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Chyba při zápisu do souboru: " + e.getMessage());
        }
    }
}
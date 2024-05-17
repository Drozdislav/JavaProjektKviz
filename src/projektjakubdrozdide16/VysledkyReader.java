/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projektjakubdrozdide16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jakub Drozd <drozd19100@zak.gvid.cz>
 */
public class VysledkyReader {

    
    
public ArrayList<VysledkyTabulka> nactiOtazky() throws EmptyFileException {
        ArrayList<VysledkyTabulka> data = new ArrayList<>();
        try {
            Scanner s = new Scanner(new FileInputStream("Vysledky.txt"));
            boolean isEmpty = true;

            while (s.hasNextLine()) {
                String radek = s.nextLine().trim();
                
                // Check for empty file
                if (isEmpty && !radek.isEmpty()) {
                    isEmpty = false;
                }

                // Skip comment lines
                if (radek.startsWith("#")) {
                    continue;
                }
                
                if(radek.startsWith("1.")) {
                    data.add(new VysledkyTabulka(radek.substring(2).trim()));
                }
                
                else if (radek.startsWith("skore:")) {
                    try {
                        data.add(new VysledkyTabulka(Integer.parseInt(radek.substring(6).trim())));
                    } catch (NumberFormatException e) {
                        System.err.println("Chyba při převodu hodnoty na číslo: " + radek.substring(8).trim());
                    }
                }
                else if(radek.startsWith("2.")) {
                    data.add(new VysledkyTabulka(radek.substring(2).trim()));
                }
                
                else if (radek.startsWith("skore:")) {
                    try {
                        data.add(new VysledkyTabulka(Integer.parseInt(radek.substring(6).trim())));
                    } catch (NumberFormatException e) {
                        System.err.println("Chyba při převodu hodnoty na číslo: " + radek.substring(8).trim());
                    }
                }
                else if(radek.startsWith("3.")) {
                    data.add(new VysledkyTabulka(radek.substring(2).trim()));
                }
                
                else if (radek.startsWith("skore:")) {
                    try {
                        data.add(new VysledkyTabulka(Integer.parseInt(radek.substring(6).trim())));
                    } catch (NumberFormatException e) {
                        System.err.println("Chyba při převodu hodnoty na číslo: " + radek.substring(8).trim());
                    }
                }
            }

            if (isEmpty) {
                throw new EmptyFileException();
            }

            s.close();
        } catch (FileNotFoundException e) {
            System.err.println("Soubor nenalezen: " + e.getMessage());
        }

        return data;
    }
    
    
}
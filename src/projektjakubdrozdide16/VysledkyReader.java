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

    
    
public ArrayList<VysledkyTabulka> nactiVysledkyTabulka() throws EmptyFileException {
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
                
                data.add(new VysledkyTabulka(radek.split(";")[0], Integer.parseInt(radek.split(";")[1])));
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
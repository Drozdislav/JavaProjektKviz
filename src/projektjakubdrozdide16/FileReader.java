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
 * @author drozd19100
 */
public class FileReader {
    String NazevKvizu;
    String radek;
    
    
    public ArrayList<Otazka> nactiOtazky(String soubor) throws EmptyFileException {
        ArrayList<Otazka> data = new ArrayList<>();
        try {
            Scanner s = new Scanner(new FileInputStream(soubor + ".txt"));
            boolean isEmpty = true;

            while (s.hasNextLine()) {
                String radek = s.nextLine().trim();
                
                // Check for empty file
                if (isEmpty && !radek.isEmpty()) {
                    isEmpty = false;
                }

                
                if (radek.startsWith("#")) {
                    continue;
                }

                
                if (radek.startsWith("Nazev:")) {
                    String nazevKvizu = radek.substring(6).trim();
                } else if (radek.startsWith("Otazka 1zN:")) {
                    data.add(new Otazka(radek.substring(11).trim()));
                } else if (radek.startsWith("Spravne:")) {
                    data.get(data.size() - 1).addOdpoved(new Odpoved(true, radek.substring(8).trim()));
                } else if (radek.startsWith("Spatne:")) {
                    data.get(data.size() - 1).addOdpoved(new Odpoved(false, radek.substring(7).trim()));
                } else if (radek.startsWith("Hodnota:")) {
                    try {
                        int hodnota = Integer.parseInt(radek.substring(8).trim());
                        data.get(data.size() - 1).setHodnota(hodnota);
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
    
    public void setNazevKvizu(String NazevKvizu) {
        this.NazevKvizu = NazevKvizu;
    }
    
    public String getNazevKvizu() {
        return NazevKvizu;
    }
}   
    

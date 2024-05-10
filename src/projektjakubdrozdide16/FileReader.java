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
 * @author jakub
 */
public class FileReader {
    String NazevKvizu;
    String radek;
    
    public ArrayList<Otazka> nactiOtazky(String soubor) {
        ArrayList<Otazka> data = new ArrayList<>();
        try {
            Scanner s = new Scanner(new FileInputStream(soubor + ".txt"));
            while(s.hasNextLine()) { // zde se načítá po řádcích, vždy podle klicoveho slova na zacatku 
            radek=s.nextLine();
            
            if(radek.startsWith("#")) {
                radek=s.nextLine();
            }
            if(radek.startsWith("Nazev:")) {
                NazevKvizu = (radek.substring(6));
            }
            
            if(radek.startsWith("Otazka 1zN:")) {
                data.add(new Otazka(radek.substring(11)));
            }
            
             if(radek.startsWith("Spravne:")) {
                data.get(data.size()-1).addOdpoved(new Odpoved(true, radek.substring(8)));
             }
                
             if(radek.startsWith("Spatne:")) {
               data.get(data.size()-1).addOdpoved(new Odpoved(false, radek.substring(7)));
                 
            }
             
             if(radek.startsWith("Hodnota:")) { // nacita hodnotu, pokud to neprojde vypise error
                 try {
                 int hodnota = Integer.parseInt(radek.substring(8));
                 data.get(data.size()-1).setHodnota(hodnota);
                     } catch (NumberFormatException e) {
                            System.err.println("Chyba při převodu hodnoty na číslo");
                }
             }
            
        }
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("Soubor nenalezen: " + e.getMessage());
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
    

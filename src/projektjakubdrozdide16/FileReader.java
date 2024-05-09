/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projektjakubdrozdide16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author jakub
 */
public class FileReader {
    
    Scanner s = null;
    
    public Scanner NactiSoubor(String Text) {
        try { //zde se otevírá soubor s otázkami
            s = new Scanner(new FileInputStream(Text + ".txt")); //NacitaniOtazek2
            
        } 
        catch(FileNotFoundException e) { //pokud je soubor nefunkční
            System.out.println("soubor nenalezen");
          }
        return s;
        }
}

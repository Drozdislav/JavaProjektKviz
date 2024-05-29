/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projektjakubdrozdide16;

/**
 * Výjimka kontrolující jestli je soubor prázdný
 * @author Jakub Drozd <drozd19100@zak.gvid.cz>
 */
public class EmptyFileException extends Exception{
    
    public EmptyFileException() {
        super("Soubor je prázdný!");
    }
    
    public EmptyFileException(String text) {
        super(text);
    }
}

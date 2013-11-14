/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokeri;

import kortit.kasi;
import kortit.korttipakka;
import voittovalinta.jakaja;

/**
 *
 * @author Janne
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        korttipakka pakka = new korttipakka();
        kasi käsi = new kasi();
        jakaja joni = new jakaja();        
        joni.jaaKasi(käsi, pakka);
        System.out.println(käsi.toString());
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import kortit.Kasi;
import kortit.Korttipakka;
import voittovalinta.Jakaja;
import voittovalinta.Voitot;

/**
 *
 * @author Janne
 */
public class Pokeripeli {
    
    private Jakaja jakaja;
    private Korttipakka pakka;
    private Kasi käsi;
    private Voitot voitot;
    
    public Pokeripeli(){
        this.jakaja = new Jakaja();
        this.pakka = new Korttipakka();
        this.käsi = new Kasi();
        this.voitot = new Voitot(1.0);
    }
    
    public void pelaa(){
        
    }
}

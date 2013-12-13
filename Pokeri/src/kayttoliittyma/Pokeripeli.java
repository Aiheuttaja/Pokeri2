/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import kortit.Kasi;
import kortit.Korttipakka;
import voittovalinta.Jakaja;
import voittovalinta.Voitot;

/**
 *
 * @author Janne
 */
public class Pokeripeli{
    
    public Jakaja jakaja;
    public Korttipakka pakka;
    public Kasi käsi;
    public Voitot voitot;
    
    public Pokeripeli(){
        this.jakaja = new Jakaja();
        this.pakka = new Korttipakka();
        this.käsi = new Kasi();
        this.voitot = new Voitot(1.0);
    }
    
    public void pelaa(){
    }  

    
}

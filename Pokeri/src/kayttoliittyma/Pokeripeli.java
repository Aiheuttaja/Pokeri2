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
public class Pokeripeli implements KeyListener{
    
    public Jakaja jakaja;
    public Korttipakka pakka;
    public Kasi käsi;
    public Voitot voitot;
    public Runnable Kayttoliittyma;
    
    public Pokeripeli(){
        this.jakaja = new Jakaja();
        this.pakka = new Korttipakka();
        this.käsi = new Kasi();
        this.voitot = new Voitot(1.0);
        this.Kayttoliittyma.run();
    }
    
    public void pelaa(){
        this.Kayttoliittyma.run();
    }  

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}

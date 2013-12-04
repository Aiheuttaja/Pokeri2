/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import kayttoliittyma.Pokeripeli;
import kortit.Kasi;
import kortit.Korttipakka;
import voittovalinta.Jakaja;
import voittovalinta.Voitot;

/**
 *
 * @author Janne
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;

    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new JFrame("Pokerikone");
        frame.setPreferredSize(new Dimension(700, 500));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    public void luoKomponentit(Container container) {
        GridBagLayout leiska = new GridBagLayout();
        container.setLayout(leiska);
        GridBagConstraints c = new GridBagConstraints();
        
        JTextField voittolista = new JTextField();
        voittolista.setEditable(false);
        //container.add(voittolista);
        
        JLabel viimVoit = new JLabel("Viimeisin voitto");
        JTextField viimeisinVoitto = new JTextField();
        viimeisinVoitto.setEditable(false);
        //container.add(viimVoit);
        //container.add(viimeisinVoitto);
        
        JLabel pan = new JLabel("Panos");
        JTextField panos = new JTextField();
        panos.setEditable(false);
        //container.add(pan);
        //container.add(panos);
        
        JLabel voit = new JLabel("Voitot");
        JTextField voitot = new JTextField();
        voitot.setEditable(false);
        //container.add(voit);
        //container.add(voitot);
        
        JLabel rahut = new JLabel("Pelit");
        JTextField rahat = new JTextField();
        rahat.setEditable(false);
        //container.add(rahut);
        //container.add(rahat);
        
        JTextField eka = new JTextField();
        eka.setEditable(false);
        
        JTextField toka = new JTextField();
        toka.setEditable(false);
        
        JTextField kolmas = new JTextField();
        kolmas.setEditable(false);
        
        JTextField neljas = new JTextField();
        neljas.setEditable(false);
        
        JTextField viides = new JTextField();
        viides.setEditable(false);
        
    }
    
    public static void main(String[] args){
        
    }
    
    public JFrame getFrame(){
        return frame;
    }
}

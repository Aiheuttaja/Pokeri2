/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import javax.swing.*;

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
        
        JLabel viimVoit = new JLabel("Viimeisin voitto");
        JTextField viimeisinVoitto = new JTextField();
        viimeisinVoitto.setEditable(false);
        
        JLabel pan = new JLabel("Panos");
        JTextField panos = new JTextField();
        panos.setEditable(false);
        
        JLabel voit = new JLabel("Voitot");
        JTextField voitot = new JTextField();
        voitot.setEditable(false);
        
        JLabel rahut = new JLabel("Pelit");
        JTextField rahat = new JTextField();
        rahat.setEditable(false);
    }
}

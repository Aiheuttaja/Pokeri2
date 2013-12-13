package kayttoliittyma;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import kortit.Kasi;
import kortit.Korttipakka;
import voittovalinta.Jakaja;
import voittovalinta.Voitot;

/**
 *
 * @author Janne
 */
public class Kayttoliittyma implements Runnable {

    private Kasi käsi;
    private Korttipakka pakka;
    private Jakaja jakaja;
    private Voitot voitot;
    private JFrame frame;
    private JTextArea voittolista;
    private JTextField viimeisinVoitto,panos,voittorahat,rahat;

    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        //Luodaan peliä varten tarvittavat oliot sekä JFrame, jossa kaikki tapahtuu.
        this.käsi = new Kasi();
        this.pakka = new Korttipakka();
        this.jakaja = new Jakaja();
        this.voitot = new Voitot(0.2);
        frame = new JFrame("Pokerikone");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        
        //Luodaan kuuntelija
        //Aloitetaan peli
        pelaa();
    }

    /**
     * Luodaan pelin käyttöliittymän komponentit.
     *
     * @param container frame, johon komponentit lisätään
     */
    public void luoKomponentit(Container container) {

        //Luodaan JPaneleilla paikat komponenteille.
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        //Yläpaneeli.
        JPanel upper = new JPanel();
        upper.setLayout(new BorderLayout());
        container.add(upper);

        //Alapaneeli.
        JPanel lower = new JPanel();
        lower.setLayout(new BoxLayout(lower, BoxLayout.Y_AXIS));
        container.add(lower);

        //Ylävasemmalle tulee viimeisin voitto, voittorahat, pelirahat sekä panos.
        JPanel upperleft = new JPanel();
        upperleft.setLayout(new BoxLayout(upperleft, BoxLayout.Y_AXIS));

        //Yläoikealle tulee lista mahdollisista voittokäsistä ja niistä saatavista voittorahoista.
        JPanel upperright = new JPanel();

        //Lisätään molemmat upper-paneeliin.
        upper.add(upperleft, BorderLayout.WEST);
        upper.add(upperright, BorderLayout.EAST);

        //Alapaneelin ylimpään kolmannekseen tulee pelinhallintaan liittyvät painikkeet:
        //rahanlisäys, panoksen kasvatus sekä uuden käden jakaminen.
        JPanel lower1 = new JPanel();
        lower1.setLayout(new BoxLayout(lower1, BoxLayout.X_AXIS));
        lower.add(lower1);

        //Alapaneelin keskikolmannekseen tulee kädessä olevat kortit.
        JPanel lower2 = new JPanel();
        lower2.setLayout(new BoxLayout(lower2, BoxLayout.X_AXIS));
        lower.add(lower2);

        //Alapaneelin alimpaan kolmannekseen tulee lukituspainikkeet korttien lukitsemista varten.
        JPanel lower3 = new JPanel();
        lower3.setLayout(new BoxLayout(lower3, BoxLayout.X_AXIS));
        lower.add(lower3);

        //Luodaan lista voitoista.
        this.voittolista = new JTextArea();
        this.voittolista.setText("Kuningasvärisuora           " + this.voitot.panos() * 50 + "€ \n"
                + "Värisuora                              " + this.voitot.panos() * 40 + "€" + "\n"
                + "Neloset                                 " + this.voitot.panos() * 20 + "€ \n"
                + "Täyskäsi                               " + this.voitot.panos() * 10 + "€ \n"
                + "Väri                                        " + this.voitot.panos() * 5 + "€ \n"
                + "Suora                                     " + this.voitot.panos() * 4 + "€ \n"
                + "Kolmoset                              " + this.voitot.panos() * 2 + "€ \n"
                + "Kaksi paria                           " + this.voitot.panos() * 2 + "€");
        this.voittolista.setEditable(false);
        upperright.add(this.voittolista);

        //Luodaan tekstikenttä, joka ilmaisee viimeisimmän voiton.
        JLabel viimVoit = new JLabel("Viimeisin voitto");
        viimVoit.setVisible(true);
        this.viimeisinVoitto = new JTextField();
        this.viimeisinVoitto.setEditable(false);
        this.viimeisinVoitto.setText(String.valueOf(this.voitot.viimeisinVoitto()));
        upperleft.add(viimVoit);
        upperleft.add(this.viimeisinVoitto);

        //Luodaan tekstikenttä, joka ilmaisee panoksen.
        JLabel pan = new JLabel("Panos");
        pan.setVisible(true);
        this.panos = new JTextField();
        this.panos.setEditable(false);
        this.panos.setText(String.valueOf(this.voitot.panos()));
        upperleft.add(pan);
        upperleft.add(this.panos);

        //Luodaan tekstikenttä, joka ilmaisee kertyneet voitot.
        JLabel voit = new JLabel("Voitot");
        voit.setVisible(true);
        this.voittorahat = new JTextField();
        this.voittorahat.setEditable(false);
        this.voittorahat.setText(String.valueOf(this.voitot.voitot()));
        upperleft.add(voit);
        upperleft.add(this.voittorahat);

        //Luodaan tekstikenttä, joka ilmaisee, paljonko pelaajan syöttämistä rahoista on jäljellä
        //ts. paljonko pelirahaa on jäljellä.
        JLabel rahut = new JLabel("Pelit");
        rahut.setVisible(true);
        this.rahat = new JTextField();
        this.rahat.setEditable(false);
        this.rahat.setText(String.valueOf(this.voitot.rahat()));
        upperleft.add(rahut);
        upperleft.add(this.rahat);

        //Luodaan rahansyöttöpainike
        JButton rahanappi = new JButton("Syötä rahaa");
        lower1.add(rahanappi);
        
        //Lisätään kuuntelija painikkeelle.
        rahanappi.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                syotaRahaa();                
            }
            
        });

        //Luodaan panoksenkasvatuspainike
        JButton panosnappi = new JButton("Panos");
        lower1.add(panosnappi);
        
        //Lisätään kuuntelija painikkeelle.
        panosnappi.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                panoksenKasvatus();
            }
        });

        //Luodaan uuden käden jakopainike
        JButton jakonappi = new JButton("Jaa");
        lower1.add(jakonappi);

        //Luodaan fonttiolio korttien tekstuaalista esitystä varten
        Font kortit = new Font("Times New Roman", Font.CENTER_BASELINE, 20);

        //Luodaan ensimmäisen kortin tekstikenttä
        JTextField eka = new JTextField();
        eka.setEditable(false);
        eka.setFont(kortit);
        eka.setText("P");
        eka.setHorizontalAlignment(JTextField.CENTER);
        eka.setForeground(Color.RED);
        eka.setBackground(Color.WHITE);
        lower2.add(eka);

        //Luodaan toisen kortin tekstikenttä
        JTextField toka = new JTextField();
        toka.setEditable(false);
        toka.setFont(kortit);
        toka.setText("O");
        toka.setHorizontalAlignment(JTextField.CENTER);
        toka.setForeground(Color.BLACK);
        toka.setBackground(Color.WHITE);
        lower2.add(toka);

        //Luodaan kolmannen kortin tekstikenttä
        JTextField kolmas = new JTextField();
        kolmas.setEditable(false);
        kolmas.setFont(kortit);
        kolmas.setText("K");
        kolmas.setHorizontalAlignment(JTextField.CENTER);
        kolmas.setForeground(Color.RED);
        kolmas.setBackground(Color.WHITE);
        lower2.add(kolmas);

        //Luodaan neljännen kortin tekstikenttä
        JTextField neljas = new JTextField();
        neljas.setEditable(false);
        neljas.setFont(kortit);
        neljas.setText("E");
        neljas.setHorizontalAlignment(JTextField.CENTER);
        neljas.setForeground(Color.BLACK);
        neljas.setBackground(Color.WHITE);
        lower2.add(neljas);

        //Luodaan viidennen kortin tekstikenttä
        JTextField viides = new JTextField();
        viides.setEditable(false);
        viides.setFont(kortit);
        viides.setText("R");
        viides.setHorizontalAlignment(JTextField.CENTER);
        viides.setBackground(Color.WHITE);
        viides.setForeground(Color.RED);
        lower2.add(viides);

        //Luodaan viisi lukituspainiketta
        JButton lukitse1 = new JButton("Lukitse");
        lower3.add(lukitse1);

        JButton lukitse2 = new JButton("Lukitse");
        lower3.add(lukitse2);

        JButton lukitse3 = new JButton("Lukitse");
        lower3.add(lukitse3);

        JButton lukitse4 = new JButton("Lukitse");
        lower3.add(lukitse4);

        JButton lukitse5 = new JButton("Lukitse");
        lower3.add(lukitse5);

    }

    public JFrame getFrame() {
        return frame;
    }

    private void pelaa() {
        
    }
    
    public void syotaRahaa(){
        this.voitot.lisaaRahaa();
        this.rahat.setText(String.valueOf(this.voitot.rahat()));
    }
    
    public void panoksenKasvatus(){
        this.voitot.kasvataPanosta();
        
    }
}

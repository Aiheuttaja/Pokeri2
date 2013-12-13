/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package voittovalinta;

import kortit.Kasi;
import kortit.Kortti;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Janne
 */
public class VoitotTest {

    Kasi käsi;
    Kortti herttaässä;
    Kortti herttakuningas;
    Kortti herttakuningatar;
    Kortti herttajätkä;
    Kortti herttakymppi;
    Kortti ruutukymppi;
    Kortti ristikymppi;
    Kortti patakymppi;
    Kortti ruutujätkä;
    Kortti herttaysi;
    Voitot tarkastaja;

    public VoitotTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        käsi=new Kasi();
        herttaässä=new Kortti(0,12);
        herttakuningas=new Kortti(0,11);
        herttakuningatar=new Kortti(0,10);
        herttajätkä=new Kortti(0,9);
        herttakymppi=new Kortti(0,8);
        ruutukymppi=new Kortti(1,8);
        ristikymppi=new Kortti(3,8);
        patakymppi=new Kortti(2,8);
        ruutujätkä=new Kortti(1,9);
        herttaysi=new Kortti(0,7);
        tarkastaja=new Voitot(1.0);
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void panosAlussaOikein(){
        assertEquals(0.2,tarkastaja.panos(),0.1);
    }
    
    @Test
    public void voitotAlussaOikein(){
        assertEquals(0.0,tarkastaja.voitot(),0.1);
    }
    
    @Test
    public void viimeisinVoittoAlussaOikein(){
        assertEquals(0.0,tarkastaja.viimeisinVoitto(),0.1);
    }
    
    @Test
    public void onkoKuningasVariSuora(){
        käsi.otaKateen(herttaässä);
        käsi.otaKateen(herttakuningas);
        käsi.otaKateen(herttakuningatar);
        käsi.otaKateen(herttajätkä);
        käsi.otaKateen(herttakymppi);
        assertEquals(10.0,tarkastaja.tulikoVoittoa(käsi),0.1);
    }
    
    @Test
    public void onkoVariSuora(){
        käsi.otaKateen(herttakymppi);
        käsi.otaKateen(herttakuningas);
        käsi.otaKateen(herttakuningatar);
        käsi.otaKateen(herttajätkä);
        käsi.otaKateen(herttaysi);
        assertEquals(8.0,tarkastaja.tulikoVoittoa(käsi),0.1);
    }
    
    @Test
    public void onkoNeloset(){
        käsi.otaKateen(herttakymppi);
        käsi.otaKateen(ruutukymppi);
        käsi.otaKateen(ristikymppi);
        käsi.otaKateen(patakymppi);
        käsi.otaKateen(ruutujätkä);
        assertEquals(4.0,tarkastaja.tulikoVoittoa(käsi),0.1);
    }
    
    @Test
    public void onkoTayskasi(){
        käsi.otaKateen(herttakymppi);
        käsi.otaKateen(ruutukymppi);
        käsi.otaKateen(ristikymppi);
        käsi.otaKateen(herttajätkä);
        käsi.otaKateen(ruutujätkä);
        assertEquals(2.0,tarkastaja.tulikoVoittoa(käsi),0.1);
    }
    
    @Test
    public void onkoVari(){
        käsi.otaKateen(herttaässä);
        käsi.otaKateen(herttakuningas);
        käsi.otaKateen(herttakuningatar);
        käsi.otaKateen(herttajätkä);
        käsi.otaKateen(herttaysi);
        assertEquals(1.0,tarkastaja.tulikoVoittoa(käsi),0.1);
    }
    
    @Test
    public void onkoSuora(){
        käsi.otaKateen(ruutukymppi);
        käsi.otaKateen(herttaässä);
        käsi.otaKateen(herttakuningas);
        käsi.otaKateen(herttakuningatar);
        käsi.otaKateen(herttajätkä);
        assertEquals(0.8,tarkastaja.tulikoVoittoa(käsi),0.1);
    }
    
    @Test
    public void onkoKolmoset(){
        käsi.otaKateen(herttakymppi);
        käsi.otaKateen(ruutukymppi);
        käsi.otaKateen(patakymppi);
        käsi.otaKateen(herttaässä);
        käsi.otaKateen(ruutujätkä);
        assertEquals(0.4,tarkastaja.tulikoVoittoa(käsi),0.1);
    }
    
    @Test
    public void onkoKaksiParia(){
        käsi.otaKateen(herttakymppi);
        käsi.otaKateen(ruutukymppi);
        käsi.otaKateen(herttajätkä);
        käsi.otaKateen(ruutujätkä);
        käsi.otaKateen(herttaässä);
        assertEquals(0.4,tarkastaja.tulikoVoittoa(käsi),0.1);
    }
    
    @Test
    public void onkoMitaan(){
        käsi.otaKateen(herttakymppi);
        käsi.otaKateen(ruutukymppi);
        käsi.otaKateen(herttajätkä);
        käsi.otaKateen(herttaässä);
        käsi.otaKateen(herttaysi);
        assertEquals(0.0,tarkastaja.tulikoVoittoa(käsi),0.1);
    }
    
    @Test
    public void panosOikein(){
        tarkastaja.kasvataPanosta();
        tarkastaja.kasvataPanosta();
        tarkastaja.kasvataPanosta();
        tarkastaja.kasvataPanosta();
        //Palataan takaisin 0.20€ panokseen seuraavalla kasvatuksella.
        tarkastaja.kasvataPanosta();
        tarkastaja.kasvataPanosta();
        assertEquals(0.4,tarkastaja.panos(),0.1);
    }
    
    @Test
    public void viimeisinVoittoOikein(){
        käsi.otaKateen(herttaässä);
        käsi.otaKateen(herttakuningas);
        käsi.otaKateen(herttakuningatar);
        käsi.otaKateen(herttajätkä);
        käsi.otaKateen(herttakymppi);
        tarkastaja.tulikoVoittoa(käsi);
        assertEquals(10.0,tarkastaja.viimeisinVoitto(),0.1);
    }
    
    @Test
    public void voitotOikein(){
        käsi.otaKateen(herttaässä);
        käsi.otaKateen(herttakuningas);
        käsi.otaKateen(herttakuningatar);
        käsi.otaKateen(herttajätkä);
        käsi.otaKateen(herttakymppi);
        tarkastaja.tulikoVoittoa(käsi);
        assertEquals(10.0,tarkastaja.voitot(),0.1);
    }
    
    @Test
    public void rahatOikein(){
        assertEquals(1.0,tarkastaja.rahat(),0.1);
    }
    
    @Test
    public void eiIsompaaPanostaKuinOnRahaa(){
        this.tarkastaja.otaRahaa();
        this.tarkastaja.kasvataPanosta();
        this.tarkastaja.kasvataPanosta();
        this.tarkastaja.kasvataPanosta();
        //Rahaa oli jäljellä koneessa vain 80 senttiä, joten seuraavalla kasvatuksella palataan takaisin 20 senttiin
        this.tarkastaja.kasvataPanosta();
        
        assertEquals(0.2,tarkastaja.panos(),0.1);
    }
    
}

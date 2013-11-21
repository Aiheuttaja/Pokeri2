/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kortit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import voittovalinta.Jakaja;

/**
 *
 * @author jilli
 */
public class KasiTest {
    
    Kasi käsi;
    Jakaja jakaja;
    Korttipakka pakka;
    
    public KasiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        käsi = new Kasi();
        jakaja = new Jakaja();
        pakka = new Korttipakka();
        jakaja.uusiKasi(käsi, pakka);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void jaonJalkeenKadessaViisiKorttia(){
        
        assertEquals(5,käsi.listaaKortit().size());
    }
    
    @Test
    public void tulostuuOikein(){
        
        assertEquals("♥2 ♥3 ♥4 ♥5 ♥6 ",käsi.toString());
    }
    
    @Test
    public void kunOtetaanKorttiPoisNiinKateenJaaNelja(){
        käsi.poistaKadesta(0);
        assertEquals(4,käsi.listaaKortit().size());
    }
    
    @Test
    public void lukittujaKorttejaEiPoisteta(){
        for(Kortti g:käsi.listaaKortit()){
            g.lukitse();
        }
        
        jakaja.uusiKasi(käsi, pakka);
        
        assertEquals("♥2 ♥3 ♥4 ♥5 ♥6 ", käsi.toString());
    }
}
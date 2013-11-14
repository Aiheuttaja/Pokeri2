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
import voittovalinta.jakaja;

/**
 *
 * @author jilli
 */
public class kasiTest {
    
    kasi käsi;
    jakaja jakaja;
    korttipakka pakka;
    
    public kasiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kasi käsi = new kasi();
        jakaja jakaja = new jakaja();
        korttipakka pakka = new korttipakka();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void jaonJalkeenKadessaViisiKorttia(){
        jakaja.jaaKasi(käsi, pakka);
        assertEquals(5,käsi.montakoKorttia());
    }
}
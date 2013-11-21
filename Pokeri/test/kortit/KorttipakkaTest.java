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

/**
 *
 * @author Janne
 */
public class KorttipakkaTest {
    
    Korttipakka pakka;
    
    public KorttipakkaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pakka=new Korttipakka();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void oikeaMaaraKortteja(){
        assertEquals(52,pakka.paljonkoKortteja());
        
    }
    
    @Test
    public void poistoToimii(){        
        //Poistetaan pakan päällimmäinen Kortti, ♥A eli Kortti, jonka maa on 0 ja arvo on 0.
        pakka.PaallimmaisinKortti();
        boolean olikoSiella=false;
        
        //Tarkistetaan, onko pakassa sellaista korttia, jolla on maa 0 ja arvo 0, eli ♥A.
        for(Kortti k:pakka.mitkaKortit()){
            if(k.haeMaa() == 0){
                if(k.haeArvo() == 0){
                    olikoSiella=true;
                }
            }
        }
        
        assertEquals(false,olikoSiella);
        
    }
    
    
}

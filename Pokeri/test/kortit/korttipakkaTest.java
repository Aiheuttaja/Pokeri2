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
public class korttipakkaTest {
    
    korttipakka pakka;
    
    public korttipakkaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pakka=new korttipakka();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void oikeaMaaraKortteja(){
        assertEquals(52,pakka.paljonkoKortteja());
        
    }
    
    
}

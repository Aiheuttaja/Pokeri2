package kortit;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class korttiTest {
    
    kortti herttaAssa;
    
    public korttiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        herttaAssa = new kortti(0,0);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void arvoOikein(){
        assertEquals(0,herttaAssa.haeArvo());        
    }
    
    @Test
    public void maaOikein(){
        assertEquals(0,herttaAssa.haeMaa());
    }
    
    @Test
    public void tulostuuOikein(){
        assertEquals("herttaässä",herttaAssa.toString());
    }
    
}

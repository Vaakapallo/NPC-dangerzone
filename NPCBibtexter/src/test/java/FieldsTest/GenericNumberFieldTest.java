/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FieldsTest;

import Fields.Year;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laursuom
 */
public class GenericNumberFieldTest {
    
    Year year;
    
    public GenericNumberFieldTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        year = new Year(1989);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testaaNumeronTunnistustaKunNumero() {
        year.setField("2013");
        assertEquals(("2013"), year.getField());
        year.setField(1989);
        assertEquals(("1989"), year.getField());
    }


    @Test
    public void testaaNumeronTunnistusKunEiNumero() {
        year.setField("Blakablakablaa");
        assertEquals(("1989"), year.getField());
    }
}

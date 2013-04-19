/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FieldsTest;

import Fields.Month;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lauri
 */
public class MonthTest {
    Month month;
    
    public MonthTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        month = new Month(Month.MonthConstant.mar);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetField() {
        assertEquals("mar", month.getField());
    }
    @Test
    public void testToString() {
        assertEquals("month = {mar},\n", month.toString());
    }
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FieldsTest;

import Fields.Pages;
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
public class PagesTest {
    Pages pages;
    
    public PagesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void normaaliLisaysToimii() {
        pages = new Pages(10,12,20,20);
        assertEquals("[10, 12] [20] ", pages.getField());
    }
    
    @Test
    public void vaarinPainLisaysToimii() {
        pages = new Pages(12,10,20,20);
        assertEquals("[10, 12] [20] ", pages.getField());
    }
    
    @Test
    public void yksittaistaEiHuomioida() {
        pages = new Pages(10,12,20,20,666);
        assertEquals("[10, 12] [20] ", pages.getField());
    }
    @Test
    public void negatiivistaEiHuomioida() {
        pages = new Pages(10,12,20,20, -13, -6);
        assertEquals("[10, 12] [20] ", pages.getField());
    }

@Test
public void toStringToimii() {
    pages = new Pages(10,12,20,20);
        assertEquals("pages = { 10--12, 20},\n", pages.toString());
}
}
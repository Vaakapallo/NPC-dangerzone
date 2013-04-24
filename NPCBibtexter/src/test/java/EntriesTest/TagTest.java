/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EntriesTest;

import Entries.Inproceedings;
import applicationLogic.Build;
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
public class TagTest {

    Inproceedings inp;

    public TagTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        inp = Build.Inproceedings("Fleuri", "TagTest", "TagToStars", 2013);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void AddingTagWorks() {
        inp.addTag("Tagi");
        assertTrue(inp.tagExists("Tagi"));
    }
    @Test
    public void removingTagWorks() {
        inp.addTag("Tagi");
        inp.addTag("ToinenTagi");
        inp.removeTag("Tagi");
        assertFalse(inp.tagExists("Tagi"));
        assertTrue(inp.tagExists("ToinenTagi"));
    }
    @Test
    public void tagGetterReturnsAProperSet() {
        inp.addTag("Tagi");
        inp.addTag("ToinenTagi");
        assertEquals(2, inp.getTags().size());
    }
}
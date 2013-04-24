/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ambassadorTest;

import Entries.Entry;
import ambassador.Bibwriter;
import applicationLogic.Build;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.Assert.assertFalse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jjoonia
 */
public class BibreaderTest {
    
    public BibreaderTest() {
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
    public void readReferencesWorks() throws FileNotFoundException{
        ArrayList<Entry> entries = new ArrayList<Entry>();
        entries.add(Build.Inproceedings("Read", "Reference", "Works", 1992));
        Bibwriter.writeReferencesFromList(entries);
        List list = Bibwriter.readAndListReferences();
        assertFalse(list.isEmpty());
        Bibwriter.nukeFile();
    }
    
}
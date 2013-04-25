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
    public void readReferencesWorks() throws FileNotFoundException {
        ArrayList<Entry> entries = new ArrayList<Entry>();
        entries.add(Build.Inproceedings("Read", "Reference", "Works", 1992));
        Bibwriter.writeReferencesFromList(entries);
        List<Entry> list = Bibwriter.readAndListReferences();
        assertTrue(list.get(0).toString().contains("Read"));
        assertFalse(list.isEmpty());
        Bibwriter.nukeFile();
    }

    @Test
    public void readReferenceReturnsManyWhenManyAreWritten() throws FileNotFoundException {
        ArrayList<Entry> entries = new ArrayList<Entry>();
        entries.add(Build.Inproceedings("Read1", "Reference1", "Works", 1992));
        entries.add(Build.Inproceedings("Read5", "Reference2", "Works", 1992));
        entries.add(Build.Inproceedings("Read3", "Reference3", "Works", 1992));
        entries.add(Build.Inproceedings("Read2", "Reference4", "Works", 1992));
        entries.add(Build.Inproceedings("Read4", "Reference5", "Works", 1992));
        entries.add(Build.Inproceedings("Read1", "Reference6", "Works", 1992));
        Bibwriter.writeReferencesFromList(entries);
        List<Entry> list = Bibwriter.readAndListReferences();
        assertTrue(list.size() == 6);
    }
}
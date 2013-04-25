/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ambassadorTest;

import Entries.Entry;
import Fields.Edition;
import Fields.Series;
import ambassador.Bibmakeupartist;
import applicationLogic.Build;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author jjoonia
 */
public class BibmakeupartistTest extends TestCase {

    private final ByteArrayOutputStream outContent;

    public BibmakeupartistTest(String testName) {
        super(testName);
        outContent = new ByteArrayOutputStream();
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        System.setOut(new PrintStream(outContent));
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testInproceedingsPrintsWhatAsked() {
        Bibmakeupartist mu = new Bibmakeupartist();
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(Build.Inproceedings("lol", "karhu", "uli", 1556, "sinep"));
        entries.get(0).list.put(Edition.class, new Edition("edition"));
        entries.get(0).list.put(Series.class, new Series("serie"));
        mu.printSexyStringsToUser(entries);
        assertTrue(outContent.toString().contains("karhu"));
        assertTrue(outContent.toString().contains("serie"));
        assertTrue(outContent.toString().contains("edition"));
    }

    public void testArticlePrintsWhatAsked() {
        Bibmakeupartist mu = new Bibmakeupartist();
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(Build.Article("lol", "karhu", "uli", 1556, "sinep"));
        mu.printSexyStringsToUser(entries);
        assertTrue(outContent.toString().contains("sinep"));
    }

    public void testBookPrintsWhatAsked() {
        Bibmakeupartist mu = new Bibmakeupartist();
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(Build.Book("lol", "karhu", "uli", 1556, "sinep"));
        mu.printSexyStringsToUser(entries);
        assertTrue(outContent.toString().contains("uli"));
    }
    // TODO add test methods here. The name must begin with 'test'. For example:
    // public void testHello() {}
}

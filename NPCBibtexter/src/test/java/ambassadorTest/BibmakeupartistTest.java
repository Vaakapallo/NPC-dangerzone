/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ambassadorTest;

import Entries.Entry;
import Entries.Inproceedings;
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
        mu.printSexyStringsToUser(entries);
        assertTrue(outContent.toString().contains("karhu"));
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

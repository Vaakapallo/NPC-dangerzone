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
import textUI.IOStub;

/**
 *
 * @author jjoonia
 */
public class BibmakeupartistTest extends TestCase {

//    private final ByteArrayOutputStream outContent;
    public BibmakeupartistTest(String testName) {
        super(testName);
//        outContent = new ByteArrayOutputStream();
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
//        System.setOut(new PrintStream(outContent));
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testInproceedingsPrintsWhatAsked() {
        IOStub alexander = new IOStub();
        Bibmakeupartist mu = new Bibmakeupartist(alexander);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(Build.Inproceedings("lol", "karhu", "uli", 1556, "sinep"));
        entries.get(0).list.put(Edition.class, new Edition("edition"));
        entries.get(0).list.put(Series.class, new Series("serie"));
        mu.printSexyStringsToUser(entries);
        String output = "";
        for (String string : alexander.getOutput()) {
            output += string;
        }
        assertTrue(output.contains("karhu"));
        assertTrue(output.contains("serie"));
        assertTrue(output.contains("edition"));
    }

    public void testArticlePrintsWhatAsked() {
        IOStub alexander = new IOStub();
        Bibmakeupartist mu = new Bibmakeupartist(alexander);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(Build.Article("lol", "karhu", "uli", 1556, "sinep"));
        mu.printSexyStringsToUser(entries);
        String output = "";
        for (String string : alexander.getOutput()) {
            output += string;
        }
        System.out.println(output);
        assertTrue(output.contains("sinep"));
    }

    public void testBookPrintsWhatAsked() {
        IOStub alexander = new IOStub();
        Bibmakeupartist mu = new Bibmakeupartist(alexander);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(Build.Book("lol", "karhu", "uli", 1556, "sinep"));
        mu.printSexyStringsToUser(entries);
        String output = "";
        for (String string : alexander.getOutput()) {
            output += string;
        }
        assertTrue(output.contains("uli"));
    }
    // TODO add test methods here. The name must begin with 'test'. For example:
    // public void testHello() {}
}

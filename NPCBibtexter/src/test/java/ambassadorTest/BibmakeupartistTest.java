/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ambassadorTest;

import Entries.Entry;
import Entries.Inproceedings;
import ambassador.Bibmakeupartist;
import applicationLogic.Build;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author jjoonia
 */
public class BibmakeupartistTest extends TestCase {

    public BibmakeupartistTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testVisual() {
        Bibmakeupartist mu = new Bibmakeupartist();
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(Build.Inproceedings("lol", "karhu", "uli", 1556, "sinep"));
        mu.printSexyStringsToUser(entries);
    }
    // TODO add test methods here. The name must begin with 'test'. For example:
    // public void testHello() {}
}

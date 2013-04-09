package ambassadorTrialist;

import Entries.Entry;
import Entries.Inproceedings;
import ambassador.Bibwriter;
import applicationLogic.EntryBuilder;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import junit.framework.Test;
import junit.framework.TestCase;

public class BibwriterTest extends TestCase {
    
    public BibwriterTest(String testName) {
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
    
    public void testWritingFileExistsAfterWritingInIt() {
        Bibwriter bw = new Bibwriter();
        Entry e = EntryBuilder.buildInproceedings("Luukkainen, Matti", "Extreme Apprenticeship Method in Teaching Programming for Beginners.", "SIGCSE '11: Proceedings of the 42nd SIGCSE technical symposium on Computer science education", 2011, "VPL11");
        ArrayList<Entry> things = new ArrayList<Entry>();
        bw.writeReferencesFromList(things);
        File f = new File("references.bib");
        f.exists();
    }
}

package ambassadorTrialist;

import Entries.Article;
import Entries.Book;
import Entries.Entry;
import Entries.Inproceedings;
import ambassador.Bibwriter;
import applicationLogic.Build;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
//        Inproceedings inproceedings = Build.Inproceedings("Luukkainen, Matti", "Extreme Apprenticeship Method in Teaching Programming for Beginners.", "SIGCSE '11: Proceedings of the 42nd SIGCSE technical symposium on Computer science education", 2011, "VPL11");
//        Inproceedings inproceedings1 = Build.Inproceedings("Luukkainen, Matti", "Extreme Apprenticeship Method in Teaching Programming for Beginners.", "SIGCSE '11: Proceedings of the 42nd SIGCSE technical symposium on Computer science education", 2011, "VPL11");
//        Book book = Build.Book("TestiAuthor", "TestiTitle", "TestiPublisher", 2000);
//        Book book1 = Build.Book("TestiAuthor", "TestiTitle", "TestiPublisher", 2000);
//        Article article = Build.Article("Luukkainen, Matti", "Extreme Apprenticeship Method in Teaching Programming for Beginners.", "SIGCSE '11: Proceedings of the 42nd SIGCSE technical symposium on Computer science education", 2011, "VPL11");
//        Article article1 = Build.Article("Luukkainen, Matti", "Extreme Apprenticeship Method in Teaching Programming for Beginners.", "SIGCSE '11: Proceedings of the 42nd SIGCSE technical symposium on Computer science education", 2011, "VPL11");
//        List<Entry> entries = new ArrayList<Entry>();
//        entries.add(inproceedings);
//        entries.add(inproceedings1);
//        entries.add(book);
//        entries.add(book1);
//        entries.add(article);
//        entries.add(article1);
//        Bibwriter.writeReferencesFromList(entries);
        Bibwriter bw = new Bibwriter();
        try {
            bw.entryParserAlpha();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BibwriterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

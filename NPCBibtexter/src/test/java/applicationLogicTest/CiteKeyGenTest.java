/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogicTest;

import Fields.Author;
import Fields.CiteKeyGen;
import Fields.Title;
import Fields.Year;
import java.util.ArrayList;
import junit.framework.TestCase;

/**
 *
 * @author jjoonia
 */
public class CiteKeyGenTest extends TestCase {

    public CiteKeyGenTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testIfSubstringsWork() {
        String shouldBe = "jjooni1995-robots";
        String whatWeGet = CiteKeyGen.generateCitationKey(new Author("jjoonia"), new Year(1995), new Title("robots on mars"));
        assertEquals(shouldBe, whatWeGet);
    }

    public void testIfItWorksWithShortOnes() {
        String shouldBe = "dax2001-lol";
        String whatWeGet = CiteKeyGen.generateCitationKey(new Author("dax"), new Year(2001), new Title("lol"));
        assertEquals(shouldBe, whatWeGet);
    }

    public void testIfUniqueWhenCiteDoesntExist() {
        ArrayList<String> cites = new ArrayList<String>();
        cites.add("lol");
        cites.add("auto");
        assertTrue(CiteKeyGen.isUnique(cites, "jackpot"));
    }

    public void testIfUniqueWhenNot() {
        ArrayList<String> cites = new ArrayList<String>();
        cites.add("lol");
        cites.add("auto");
        assertFalse(CiteKeyGen.isUnique(cites, "auto"));
    }
    // TODO add test methods here. The name must begin with 'test'. For example:
    // public void testHello() {}
}

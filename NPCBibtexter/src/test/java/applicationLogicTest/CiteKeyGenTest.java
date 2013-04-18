/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogicTest;

import Entries.Inproceedings;
import Fields.Author;
import applicationLogic.Generate;
import Fields.Title;
import Fields.Year;
import applicationLogic.Build;
import java.util.ArrayList;
import junit.framework.TestCase;
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
        String whatWeGet = Generate.identifier("jjoonia", 1995, "robots on mars");
        assertEquals(shouldBe, whatWeGet);
    }

    public void testIfItWorksWithShortOnes() {
        String shouldBe = "dax2001-lol";
        String whatWeGet = Generate.identifier("dax", 2001, "lol");
        assertEquals(shouldBe, whatWeGet);
    }

    public void testIfUniqueWhenCiteDoesntExist() {
        ArrayList<String> cites = new ArrayList<String>();
        cites.add("lol");
        cites.add("auto");
        assertTrue(Generate.isUnique(cites, "jackpot"));
    }

    public void testIfUniqueWhenNot() {
        ArrayList<String> cites = new ArrayList<String>();
        cites.add("lol");
        cites.add("auto");
        assertFalse(Generate.isUnique(cites, "auto"));
    }

    @Test
    public void addTwoWithTheSameSpecs() {
        Inproceedings eka = Build.Inproceedings("yks", "kaks", "kol", 1);
        Inproceedings toka = Build.Inproceedings("yks", "kaks", "kol", 1);
        System.out.println("TOIMIIXMITÄVITTUA");
        System.out.println(eka.getCitationKey());
        System.out.println(toka.getCitationKey());
    }
    // TODO add test methods here. The name must begin with 'test'. For example:
    // public void testHello() {}
}

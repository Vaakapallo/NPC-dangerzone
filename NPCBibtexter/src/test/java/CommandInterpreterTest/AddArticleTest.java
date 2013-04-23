/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreterTest;

import CommandInterpreter.AddArticle;
import applicationLogic.EntryStorage;
import junit.framework.TestCase;
import textUI.IOStub;

/**
 *
 * @author lvapaaka
 */
public class AddArticleTest extends TestCase {

    public AddArticleTest() {
    }

    public AddArticleTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        EntryStorage.empty();
        super.tearDown();
    }

    public void testAddingWorksWithValidInfo() {
        String[] input = {"MTEBMB2012", "Mayra, Tero", "EasyB made Easy", "Journal of Awesome", "2012", "en halua vaihtoehtoja"};
        IOStub io = new IOStub(input);
        new AddArticle(io).run();

        String output = "";
        for (String string : io.getOutput()) {
            output += string;
            System.out.println(string);
        }

        assertTrue(output.contains("title = {EasyB made Easy}"));
        assertTrue(output.contains("journal = {Journal of Awesome}"));
        assertTrue(output.contains("@Article"));
        assertTrue(output.contains("MTEBMB2012"));
    }

    public void testAddingWorksWithGeneratedKey() {
        String[] input = {" ", "Mayra, Tero", "EasyB made Easy", "Journal of Awesome", "2012", "en halua vaihtoehtoja"};
        IOStub io = new IOStub(input);
        new AddArticle(io).run();

        String output = "";
        for (String string : io.getOutput()) {
            output += string;
        }

        assertTrue(output.contains("title = {EasyB made Easy}"));
        assertTrue(output.contains("journal = {Journal of Awesome}"));
        assertTrue(output.contains("@Article"));
        assertFalse(output.contains("MTEBMB2012"));
    }

    public void testAddingWithOptionalFields() {
        String[] input = {" ", "Mayra, Tero", "EasyB made Easy", "Journal of Awesome", "2012", "k", "Supervoluumi", "January", null, "5"};
        IOStub io = new IOStub(input);
        new AddArticle(io).run();

        String output = "";
        for (String string : io.getOutput()) {
            output += string;
//            System.out.println(string);
        }

        assertTrue(output.contains("title = {EasyB made Easy}"));
        assertTrue(output.contains("Vaihtoehtoisia tietoja"));
        assertTrue(output.contains("month = {January}"));
        assertTrue(output.contains("volume = {Supervoluumi}"));
        assertTrue(output.contains("number = {5}"));
    }
}

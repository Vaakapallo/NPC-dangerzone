/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreterTest;

import CommandInterpreter.AddBook;
import applicationLogic.EntryStorage;
import junit.framework.TestCase;
import textUI.IOStub;

/**
 *
 * @author lvapaaka
 */
public class AddBookTest extends TestCase {

    public AddBookTest() {
    }

    public AddBookTest(String testName) {
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    public void testAddingWorksWithValidInfo() {
        String[] input = {"MTEBMB2012", "Mayra, Tero", "EasyB made Easy", "Publisher of Awesome", "2012", "en halua vaihtoehtoja"};
        IOStub io = new IOStub(input);
        new AddBook(io).run();

        String output = "";
        for (String string : io.getOutput()) {
            output += string;
            System.out.println(string);
        }

        assertTrue(output.contains("title = {EasyB made Easy}"));
        assertTrue(output.contains("publisher = {Publisher of Awesome}"));
        assertTrue(output.contains("@Book"));
        assertTrue(output.contains("MTEBMB2012"));
        EntryStorage.empty();
    }

    public void testAddingWorksWithGeneratedKey() {
        String[] input = {" ", "Mayra, Tero", "EasyB made Easy", "Publisher of Awesome", "2012", "en halua vaihtoehtoja"};
        IOStub io = new IOStub(input);
        new AddBook(io).run();

        String output = "";
        for (String string : io.getOutput()) {
            output += string;
        }

        assertTrue(output.contains("title = {EasyB made Easy}"));
        assertTrue(output.contains("publisher = {Publisher of Awesome}"));
        assertTrue(output.contains("@Book"));
        assertFalse(output.contains("MTEBMB2012"));
        EntryStorage.empty();
    }

    public void testAddingWithOptionalFields() {
        String[] input = {" ", "Mayra, Tero", "EasyB made Easy", "Publisher of Awesome", "2012", "k", "Supervoluumi", "January", null, null, null, null};
        IOStub io = new IOStub(input);
        new AddBook(io).run();

        String output = "";
        for (String string : io.getOutput()) {
            output += string;
//            System.out.println(string);
        }

        assertTrue(output.contains("title = {EasyB made Easy}"));
        assertTrue(output.contains("Vaihtoehtoisia tietoja"));
        assertTrue(output.contains("month = {January}"));
        assertTrue(output.contains("volume = {Supervoluumi}"));
        EntryStorage.empty();
    }
}

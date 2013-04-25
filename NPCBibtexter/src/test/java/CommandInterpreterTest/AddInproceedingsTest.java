/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreterTest;

import CommandInterpreter.EntryMenu.AddInproceedings;
import applicationLogic.EntryStorage;
import junit.framework.TestCase;
import stub.IOStub;

/**
 *
 * @author lvapaaka
 */
public class AddInproceedingsTest extends TestCase {

    public AddInproceedingsTest(String testName) {
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

    public void testAddingWorksWithValidInfo() {
        String[] input = {"ma231", "Mayra, Tero", "EasyB made Easy", "Frustrations of a CS Student", "2012", "en halua vaihtoehtoja"};
        IOStub io = new IOStub(input);
        new AddInproceedings(io).run();

        String output = "";
        for (String string : io.getOutput()) {
            output += string;
        }

        assertTrue(output.contains("title = {EasyB made Easy}"));
        assertTrue(output.contains("@Inproceedings"));
        EntryStorage.empty();
    }

    public void testAddingWorksWithGeneratedKey() {
        String[] input = {" ", "Mayra, Tero", "EasyB made Easy", "Frustrations of a CS Student", "2012", "en halua vaihtoehtoja"};
        IOStub io = new IOStub(input);
        new AddInproceedings(io).run();

        String output = "";
        for (String string : io.getOutput()) {
            output += string;
        }

        assertTrue(output.contains("title = {EasyB made Easy}"));
        assertTrue(output.contains("2012"));
        EntryStorage.empty();
    }

    public void testAddingWithOptionalFields() {
        String[] input = {" ", "Mayra, Tero", "EasyB made Easy", "Frustrations of a CS Student", "2012", "k", "Malin, Jukka", null, null, null, null, "January"};
        IOStub io = new IOStub(input);
        new AddInproceedings(io).run();

        String output = "";
        for (String string : io.getOutput()) {
            output += string;
            System.out.println(string);
        }

        assertTrue(output.contains("title = {EasyB made Easy}"));
        assertTrue(output.contains("Vaihtoehtoisia tietoja"));
        assertTrue(output.contains("Malin, Jukka"));
        assertTrue(output.contains("month = {January}"));
        EntryStorage.empty();
    }
}

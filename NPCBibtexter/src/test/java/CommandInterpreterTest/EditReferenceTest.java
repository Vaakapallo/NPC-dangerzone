/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreterTest;

import CommandInterpreter.AddInproceedings;
import CommandInterpreter.EditReference;
import applicationLogic.EntryStorage;
import junit.framework.TestCase;
import textUI.IOStub;

/**
 *
 * @author Cobrelli
 */
public class EditReferenceTest extends TestCase {

    public EditReferenceTest(String testName) {
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

    public void testEmptyStorageGivesRightMessage() {
        String[] input = {""};
        IOStub io = new IOStub(input);
        new EditReference(io).run();

        String output = "";
        for (String string : io.getOutput()) {
            output += string;
        }

        assertTrue(output.contains("Muokattavia viitteitä ei ole."));
        EntryStorage.empty();
    }

//    public void testEditingAddsNewReferenceWhenRightKey() {
//        String[] input = {"jj1", "Nawb, Jerry", "Starcraft ownage", "Starcraft II Ownage 101",
//            "2013", "e ", "jj1", "jj1", "Nawb, Jerry", "Starcraft pwnage", "Starre II", "1337", "e"};
//        IOStub io = new IOStub(input);
//        new AddInproceedings(io).run();
//        new EditReference(io).run();
//
//        String output = "";
//        for (String string : io.getOutput()) {
//            output += string;
//        }
//
//        assertTrue(output.contains("Starre II"));
//        EntryStorage.empty();
//    }
    public void testEditingDoesntAddNewReferenceWhenWrongKey() {
        String[] input = {"jj1", "Nawb, Jerry", "Starcraft ownage", "Starcraft II Ownage 101",
            "2013", "e", "jj23", "jj1", "Nawb, Jerry", "Starcraft pwnage", "Starre II", "1337"};
        IOStub io = new IOStub(input);
        new AddInproceedings(io).run();
        new EditReference(io).run();

        String output = "";
        for (String string : io.getOutput()) {
            output += string;
        }

        assertTrue(!output.contains("Starre II"));
        EntryStorage.empty();
    }

    public void testEditingGivesCorrectSizeList() {
        String[] input = {"jj1", "Nawb, Jerry", "Starcraft ownage", "Starcraft II Ownage 101",
            "2013", "en halua vaihtoehtoisia ", "jj1", "jj1", "Nawb, Jerry", "Starcraft pwnage", "Starre II", "1337"};
        IOStub io = new IOStub(input);
        new AddInproceedings(io).run();
        new EditReference(io).run();

        assertTrue(EntryStorage.getEntries().size() == 1);
        EntryStorage.empty();
    }
}

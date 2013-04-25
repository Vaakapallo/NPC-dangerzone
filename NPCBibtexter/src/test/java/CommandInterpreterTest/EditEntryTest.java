/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreterTest;

import CommandInterpreter.EntryMenu.AddInproceedings;
import CommandInterpreter.EditEntry;
import applicationLogic.EntryStorage;
import junit.framework.TestCase;
import stub.IOStub;

/**
 *
 * @author Cobrelli
 */
public class EditEntryTest extends TestCase {

    public EditEntryTest(String testName) {
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
        new EditEntry(io).run();

        String output = "";
        for (String string : io.getOutput()) {
            output += string;
        }

        assertTrue(output.contains("Muokattavia viitteitä ei ole."));
        EntryStorage.empty();
    }

    public void testEditingAddsNewReferenceWhenRightKey() {
        String[] input = {"jj1", "Nawb, Jerry", "Starcraft ownage", "Starcraft II Ownage 101",
            "2013", "e", "jj1", "jj1", "Nawb, Jerry", "Starcraft pwnage", "Starre II", "1337", "e"};
        IOStub io = new IOStub(input);
        new AddInproceedings(io).run();
        new EditEntry(io).run();

        String output = "";
        for (String string : io.getOutput()) {
            output += string;
        }

        assertTrue(output.contains("Starre II"));
        EntryStorage.empty();
    }

    public void testEditingWorksWithBook() {
        String[] input = {"jj1", "", "Starcraft ownage", "Starcraft II Ownage 101",
            "2013", "e", "jj1", "jj1", "Nawb, Jerry", "Starcraft pwnage", "Starre II", "1337", "e"};
        IOStub io = new IOStub(input);
        new AddInproceedings(io).run();
        new EditEntry(io).run();

        String output = "";
        for (String string : io.getOutput()) {
            output += string;
        }

        assertTrue(output.contains("Starre II"));
        EntryStorage.empty();
    }

    public void testEditingWorksWithArticle() {
        String[] input = {"jj1", "esa", "Starcraft ownage", "Starcraft II Ownage 101",
            "2013", "e", "jj1", "jj1", "Nawb, Jerry", "Starcraft pwnage", "Starre II", "1337", "e"};
        IOStub io = new IOStub(input);
        new AddInproceedings(io).run();
        new EditEntry(io).run();

        String output = "";
        for (String string : io.getOutput()) {
            output += string;
        }

        assertTrue(output.contains("Starre II"));
        EntryStorage.empty();
    }

    public void testEditingOptionalFieldsWorksWithoutPreviousOptionals() {
        String[] input = {"opti", "Nawb, Jerry", "Starcraft ownage", "Starcraft II Ownage 101",
            "2013", "e", "opti", "opti2", "Nawb, Jerry", "Starcraft pwnage", "Starre II", "1337",
            "k", "edi", "org", "pub", "add", "", "key", "oiskonyt"};
        IOStub io = new IOStub(input);
        new AddInproceedings(io).run();
        new EditEntry(io).run();

        String output = "";
        for (String string : io.getOutput()) {
            output += string;
        }

        assertTrue(output.contains("{key}"));
        assertTrue(!output.contains("month"));
        EntryStorage.empty();
    }

    public void testEditingOptionalFieldsWorksWithPreviousOptionals() {
        String[] input = {" ", "esa", "kirjot", "Starcraft II Ownage 101",
            "123", "k", "edi", "org", "pub", "add", "kuukausi", "avain", "esa123-kirjot", "optit2", "Nawb, Jerry", "Starcraft pwnage", "Starre II", "1337",
            "k", "edi", "org", "pub", "add", "", "key", "COOLMANBROTHERSISTHEBLACKSOULBROTHERWHOISYODADDYANDYODASDADDYCUZHELIKEMALCOLMXNMLKINDASAMEYO"};
        IOStub io = new IOStub(input);
        new AddInproceedings(io).run();
        new EditEntry(io).run();

        String output = "";
        for (String string : io.getOutput()) {
            output += string;
        }

        assertTrue(output.contains("{key}"));
        assertTrue(output.contains("{kuukausi}"));
        EntryStorage.empty();
    }

    public void testEditingCitationKeyAllowed() {
        String[] input = {"nawbi", "Nawb, Jerry", "Starcraft ownage", "Starcraft II Ownage 101",
            "2013", "e", "nawbi", "newba", "Nawb, Jerry", "Starcraft pwnage", "Starre II", "1337", "e"};
        IOStub io = new IOStub(input);
        new AddInproceedings(io).run();
        new EditEntry(io).run();

        String output = "";
        for (String string : io.getOutput()) {
            output += string;
        }

        assertTrue(output.contains("newba"));
        EntryStorage.empty();
    }

    public void testEditingAllowsToKeepOldReferenceWithEmpty() {
        String[] input = {"empt", "Nawb, Jerry", "Starcraft ownage", "Starcraft II Ownage 101",
            "2013", "e", "empt", "", "Nawb, Jerry", "", "a",
            "", "e"};

        IOStub io = new IOStub(input);
        new AddInproceedings(io).run();
        new EditEntry(io).run();

        String output = "";
        for (String string : io.getOutput()) {
            output += string;
        }

        assertTrue(output.contains("{2013}"));
        assertTrue(output.contains("Starcraft ownage"));
        EntryStorage.empty();
    }

    public void testEditingNotAllowedWhenCiteKeyNotUnique() {
        String[] input = {"jj2", "Nawb, Jerry", "Starcraft ownage", "Starcraft II Ownage 101",
            "2013", "e", "jj1", "Nawb, Jerry", "Starcraft ownage", "Starcraft II Ownage 101",
            "2013", "e", "jj1", "jj2", "esa", "Nawb, Jerry", "Starcraft pwnage", "Starre II", "1337", "e"};
        IOStub io = new IOStub(input);
        new AddInproceedings(io).run();
        new AddInproceedings(io).run();
        new EditEntry(io).run();

        String output = "";
        for (String string : io.getOutput()) {
            output += string;
        }

        assertTrue(output.contains("Anna uusi viiteavain, vanha ei ole uniikki"));
        EntryStorage.empty();
    }

    public void testEditingWorksWhenCiteKeyNotUniqueButGivenNewAfterCheck() {
        String[] input = {"esa", "Nawb, Jerry", "Starcraft ownage", "Starcraft II Ownage 101",
            "2013", "e", "esa1", "Nawb, Jerry", "Starcraft ownage", "Starcraft II Ownage 101",
            "2013", "e", "esa1", "esa", "vesa", "Nawb, Jerry", "Starcraft pwnage", "Starre II", "1337", "e"};
        IOStub io = new IOStub(input);
        new AddInproceedings(io).run();
        new AddInproceedings(io).run();
        new EditEntry(io).run();

        String output = "";
        for (String string : io.getOutput()) {
            output += string;
        }

        assertTrue(output.contains("Anna uusi viiteavain, vanha ei ole uniikki"));
        assertTrue(output.contains("vesa"));
        EntryStorage.empty();
    }

    public void testEditingDoesntAddNewReferenceWhenWrongKey() {
        String[] input = {"wrong", "Nawb, Jerry", "Starcraft ownage", "Starcraft II Ownage 101",
            "2013", "e", "right", "wrong", "Nawb, Jerry", "Starcraft pwnage", "Starre II", "1337"};
        IOStub io = new IOStub(input);
        new AddInproceedings(io).run();
        new EditEntry(io).run();

        String output = "";
        for (String string : io.getOutput()) {
            output += string;
        }

        assertTrue(output.contains("Viiteavainta ei valitettavasti löytynyt"));
        EntryStorage.empty();
    }

    public void testEditingGivesCorrectSizeList() {
        String[] input = {"jj1", "Nawb, Jerry", "Starcraft ownage", "Starcraft II Ownage 101",
            "2013", "en halua vaihtoehtoisia ", "jj1", "jj1", "Nawb, Jerry", "Starcraft pwnage", "Starre II", "1337", "e"};
        IOStub io = new IOStub(input);
        new AddInproceedings(io).run();
        new EditEntry(io).run();

        assertTrue(EntryStorage.getEntries().size() == 1);
        EntryStorage.empty();
    }
}

package textUITest;

import applicationLogic.EntryStorage;
import junit.framework.TestCase;
import stub.IOStub;
import textUI.TextUI;

public class TextUITest extends TestCase {

    public TextUITest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        EntryStorage.empty();
    }

    public void testLoopEndsWhenExiting() {
        String[] input = {"9"};
        IOStub io = new IOStub(input);

        new TextUI(io).run();
    }

    public void testProperErrorMessageGivenWhenCommandNotFound() {
        String[] input = {"112", "9"};
        IOStub io = new IOStub(input);

        new TextUI(io).run();

        String output = "";
        for (String string : io.getOutput()) {
            output += string;
        }

        assertTrue(output.contains("Komentoa ei löytynyt, yritä uudelleen"));
    }

    public void testAddReferenceCommandWorks() {
        String[] input = {"1", "1", "esa", "a", "b", "c", "123", "e", "9"};
        IOStub io = new IOStub(input);

        new TextUI(io).run();

        String output = "";
        for (String string : io.getOutput()) {
            output += string;
        }
        assertTrue(output.contains("{b}"));
        assertTrue(output.contains("@Inproceedings{ esa,"));
    }
}

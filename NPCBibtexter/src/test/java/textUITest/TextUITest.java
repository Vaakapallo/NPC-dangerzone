package textUITest;

import junit.framework.TestCase;
import textUI.IO;
import textUI.TextUI;

public class TextUITest extends TestCase {

    public int testCommandInt;
    public int command;
//    public String testCommandString;
    TextUI ui;

    public IO getIOStub() {
        IO io = new IO() {
            public int read() {
                return command;
            }

            public void printSomething(String text) {
            }

            public void printLineChange() {
            }

            public void addReference() {
                testCommandInt = 1;
            }

            public void saveReferences() {
                testCommandInt = 2;
            }

            public void printReferences() {
                testCommandInt = 3;
            }
        };
        return io;
    }

    public TextUITest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        ui = new TextUI(getIOStub());
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testLoopEndsWhenExiting() {
        command = 9;
        ui.launchUberUI();
    }

    public void testAddingReferenceReturnsTrue() {
        assertTrue(ui.checkCommand(1));
    }

    public void testprintingReferenceReturnsTrue() {
        assertTrue(ui.checkCommand(2));
    }
    
    public void testPrintingReferenceReturnsTrue() {
        assertTrue(ui.checkCommand(3));
    }
}

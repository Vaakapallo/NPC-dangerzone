/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreterTest;

import CommandInterpreter.EntryType;
import applicationLogic.EntryStorage;
import junit.framework.TestCase;
import textUI.IOStub;

/**
 *
 * @author lvapaaka
 */
public class EntryTypeTest extends TestCase {

    public EntryTypeTest(String testName) {
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

    public void testInvalidNumber() {
        String[] input = {"4", "1", " ", "a", "b", "c", "3", "e"};
        IOStub io = new IOStub(input);
        new EntryType(io).run();

        String output = "";
        for (String string : io.getOutput()) {
            output += string;
        }

        assertTrue(output.contains("Viitteen tyyppi oli väärin, yritetäänpä uudelleen"));
        
    }
}

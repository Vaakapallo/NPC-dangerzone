/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreterTest;

import CommandInterpreter.LoadReferences;
import CommandInterpreter.PrintReferences;
import applicationLogic.EntryStorage;
import junit.framework.TestCase;
import textUI.IOStub;

/**
 *
 * @author lvapaaka
 */
public class PrintReferenceTest extends TestCase {

    public PrintReferenceTest(String testName) {
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

    public void testEmptyPrint() {
        String[] input = {""};
        IOStub io = new IOStub(input);
        new PrintReferences(io).run();
        assertTrue(io.getOutput().isEmpty());
    }

    public void testPrintAfterLoad() {
        String[] input = {""};
        IOStub io = new IOStub(input);
        new LoadReferences(io).run();
        new PrintReferences(io).run();

        String output = "";
        for (String string : io.getOutput()) {
            output += string;
        }

        assertTrue(output.contains("@Inproceedings"));
        EntryStorage.empty();
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreterTest;

import CommandInterpreter.AddReference;
import java.util.List;
import junit.framework.TestCase;
import textUI.IOStub;

/**
 *
 * @author lvapaaka
 */
public class AddReferenceTest extends TestCase {

    public AddReferenceTest(String testName) {
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
        String[] input = {"ma231", "Mayra, Tero", "EasyB made Easy", "Frustrations of a CS Student", "2012"};
        IOStub io = new IOStub(input);
        AddReference add = new AddReference(io);
        add.run();

        String output = "";
        for (String string : io.getOutput()) {
            output += string;
        }

        assertTrue(output.contains("title = {EasyB made Easy}"));
        assertTrue(output.contains("@Inproceedings"));
    }
}

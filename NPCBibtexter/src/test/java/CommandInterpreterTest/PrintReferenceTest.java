/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreterTest;

import CommandInterpreter.PrintReferences;
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
   
    public void testEmptyPrint(){
        String[] input = {""};
        IOStub io = new IOStub(input);
        PrintReferences add = new PrintReferences(io);
        add.run();
        assertTrue(io.getOutput().isEmpty());
    }
}

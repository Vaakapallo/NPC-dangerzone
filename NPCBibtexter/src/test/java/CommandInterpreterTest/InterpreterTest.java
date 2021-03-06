/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreterTest;

import CommandInterpreter.EntryMenu.EntryType;
import CommandInterpreter.*;
import junit.framework.TestCase;

/**
 *
 * @author lvapaaka
 */
public class InterpreterTest extends TestCase {
    
    private CommandInterpreter interpreter = new CommandInterpreter(null);
    
    public InterpreterTest(String testName) {
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
    // TODO add test methods here. The name must begin with 'test'. For example:
    // public void testHello() {}
    
    public void testOneEqualsAdd(){
        assertTrue(EntryType.class == interpreter.getCommand(1).getClass());
    }
    
    public void testTwoEqualsSave(){
        assertTrue(SaveEntries.class == interpreter.getCommand(2).getClass());
    }
    
    public void testThreeEqualsPrint(){
        assertTrue(PrintEntries.class == interpreter.getCommand(3).getClass());
    }
    
    public void testFourEqualsLoad(){
        assertTrue(LoadEntries.class == interpreter.getCommand(4).getClass());
    }
    public void testNineEqualsQuit(){
        assertTrue(Quit.class == interpreter.getCommand(9).getClass());
    }
}

package textUITest;

import junit.framework.TestCase;
import textUI.IO;

public class TextUITest extends TestCase {
    
    public int testCommandInt;
    public String testCommandString;
    
    public IO getIOStub(){
        IO io = new IO() {

            public int read() {
                return testCommandInt;
            }

            public void printSomething(String text) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void printLineChange() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void addReference() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void saveReferences() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void printReferences() {
                throw new UnsupportedOperationException("Not supported yet.");
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
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    // TODO add test methods here. The name must begin with 'test'. For example:
    // public void testHello() {}
    
    public void testaaEtteiKirjaimetRiko(){
        
    }
}

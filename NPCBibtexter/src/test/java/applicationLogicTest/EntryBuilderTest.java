/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogicTest;

import applicationLogic.Build;
import junit.framework.TestCase;

/**
 *
 * @author lvapaaka
 */
public class EntryBuilderTest extends TestCase {

    public EntryBuilderTest(String testName) {
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

    public void testBuildInproceedingsNotNullWithContent() {
        assertNotNull(Build.Inproceedings("Vaakapallo", "Palloja n-ulottuvuudessa", "Palloja yleensä", 0, "VPK90"));
    }
    
    public void testBuilderBuildsAValidInproceedings(){
        assertTrue(Build.Inproceedings("Vaakapallo", "Palloja n-ulottuvuudessa", "Palloja yleensä", 0, "VPK90").isValid());
    }
    
    public void testBuildInproceedingsNotNullWithNulls() {
        assertNotNull(Build.Inproceedings(null, null, null, 0, null));
    }
}

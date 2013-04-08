/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic;

import java.util.HashMap;
import junit.framework.TestCase;

/**
 *
 * @author laursuom
 */
public class InproceedingsTest extends TestCase {
    Inproceedings inproceedings;
    
    private class TestField extends Field {

        @Override
        public String getField() {
            return ("I AM ERROR! MY NAME IS TestField!");
        }

        @Override
        public String toString() {
            return ("I AM ERROR! MY NAME IS TestField!");
        }
        
    }
    
    public InproceedingsTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        inproceedings = EntryBuilder.buildInproceedings("Luukkainen, Matti", "Extreme Apprenticeship Method in Teaching Programming for Beginners.", "SIGCSE '11: Proceedings of the 42nd SIGCSE technical symposium on Computer science education", 2011, "VPL11");
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of isValid method, of class Inproceedings.
     */
    public void testIsValid() {
        assertTrue(inproceedings.isValid());
        inproceedings.list.put(TestField.class, new TestField());
        assertFalse(inproceedings.isValid());
        inproceedings.list.remove(TestField.class);
        assertTrue(inproceedings.isValid());
        inproceedings.list.remove(Author.class);
        assertFalse(inproceedings.isValid());
        
    }

    /**
     * Test of toString method, of class Inproceedings.
     */
    public void testToString() {
        String expString = "@Inproceedings{ VPL11,\nauthor = {Luukkainen, Matti},\ntitle = {Extreme Apprenticeship Method in Teaching Programming for Beginners.},\n"
                + "booktitle = {SIGCSE '11: Proceedings of the 42nd SIGCSE technical symposium on Computer science education},\nyear = {2011},\n}";
        assertEquals(expString, inproceedings.toString());
        String expString2 = "@Inproceedings{ VPL11,\nauthor = {M},\ntitle = {Extreme Apprenticeship Method in Teaching Programming for Beginners.},\n"
                + "booktitle = {SIGCSE '11: Proceedings of the 42nd SIGCSE technical symposium on Computer science education},\nyear = {2011},\n}";
        
    }

    /**
     * Test of getRequiredFields method, of class Inproceedings.
     */
//    public void testGetRequiredFields() {
//        System.out.println("getRequiredFields");
//        Class[] expResult = null;
//        Class[] result = Inproceedings.getRequiredFields();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getOptionalFields method, of class Inproceedings.
//     */
//    public void testGetOptionalFields() {
//        System.out.println("getOptionalFields");
//        Class[] expResult = null;
//        Class[] result = Inproceedings.getOptionalFields();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EntriesTest;


import Entries.Inproceedings;
import Fields.Author;
import Fields.Field;
import applicationLogic.Build;
import junit.framework.TestCase;

/**
 *
 * @author laursuom
 */
public class InproceedingsTest extends TestCase {
    Inproceedings inproceedings;
    
    private class TestField implements Field {

        @Override
        public String getField() {
            return ("I AM ERROR! MY NAME IS TestField!");
        }

        @Override
        public String toString() {
            return ("I AM ERROR! MY NAME IS TestField!");
        }

        @Override
        public void setField(String value) {
        }
        
    }
    
    public InproceedingsTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        
        inproceedings = Build.Inproceedings("Luukkainen, Matti", "Extreme Apprenticeship Method in Teaching Programming for Beginners.", "SIGCSE '11: Proceedings of the 42nd SIGCSE technical symposium on Computer science education", 2011, "VPL11");
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
    }
}

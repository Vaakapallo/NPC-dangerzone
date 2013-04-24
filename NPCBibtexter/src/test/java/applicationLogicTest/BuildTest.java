/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogicTest;

import Entries.Entry;
import applicationLogic.Build;
import junit.framework.TestCase;

/**
 *
 * @author lvapaaka
 */
public class BuildTest extends TestCase {

    public BuildTest(String testName) {
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
        assertNotNull(Build.Inproceedings("Vaakapallo", "Palloja n-ulottuvuudessa", "Palloja yleensä", 0));
    }
    
    public void testBuilderBuildsAValidInproceedings(){
        assertTrue(Build.Inproceedings("Vaakapallo", "Palloja n-ulottuvuudessa", "Palloja yleensä", 1990).isValid());
    }
    
    public void testBuildInproceedingsNotNullWithNulls() {
        assertNotNull(Build.Inproceedings(null, null, null, 0, null));
    }
    
    public void testInproceedingsValidWithNullOptionalFields(){
        assertTrue(Build.optionalFieldsInproceedings("Vaakapallo", "Palloja n-ulottuvuudessa", "Palloja yleensä", 1990, null, null, null, null, null, null, null).isValid());
    }
    
    public void testInproceedingsValidWithSomeOptionalFields(){
        Entry entry = Build.optionalFieldsInproceedings("Vaakapallo", "Palloja n-ulottuvuudessa", "Palloja yleensä", 0, null, null, null, null, "Yliopisto", "Huono kirjoitus", "Tammikuu");
        assertTrue(entry.isValid());
    }
    
    public void testInproceedingsValidWithAllOptionalFields(){
        Entry entry = Build.optionalFieldsInproceedings("Vaakapallo", "Palloja n-ulottuvuudessa", "Palloja yleensä", 0, "aab", null, "baab", "caab", "Yliopisto", "Huono kirjoitus", "Tammikuu");
        assertTrue(entry.isValid());
    }
    
    public void testBookValidWithNullOptionalFields(){
        assertTrue(Build.optionalFieldsBook("Vaakapallo", "Palloja n-ulottuvuudessa", "Palloja yleensä", 1990, null, null, null, null, null, null).isValid());
    }
    
    public void testBookNotNullWithOptionalFields(){
        assertNotNull(Build.optionalFieldsBook("Vaakapallo", "Palloja n-ulottuvuudessa", "Palloja yleensä", 1990, "supervolyymi", null, null, null, "February", null));
    }
    
    public void testBookValidWithSomeOptionalFields(){
        assertTrue(Build.optionalFieldsBook("Vaakapallo", "Palloja n-ulottuvuudessa", "Palloja yleensä", 0, "supervolyymi", null, null, null, "February", null).isValid());
    }
    
   public void testArticleValidWithNullOptionalFields(){
        assertTrue(Build.optionalFieldsArticle("Vaakapallo", "Palloja n-ulottuvuudessa", "Palloja yleensä", 1990, null, 5, null, null, null).isValid());
    }
    
    public void testArticleNotNullWithOptionalFields(){
        assertNotNull(Build.optionalFieldsArticle("Vaakapallo", "Palloja n-ulottuvuudessa", "Palloja yleensä", 1990, "supervolyymi", 5, null, "February" , null));
    } 
}

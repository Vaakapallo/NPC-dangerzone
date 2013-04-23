/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EntriesTest;

import Entries.Article;
import Entries.Inproceedings;
import Fields.Author;
import Fields.Field;
import applicationLogic.Build;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import junit.framework.TestCase;

/**
 *
 * @author Lauri
 */
    public class ArticleTest extends TestCase {
    Article article;
    
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
    
    public ArticleTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        
        article = Build.Article("Luukkainen, Matti", "Extreme Apprenticeship Method in Teaching Programming for Beginners.", "SIGCSE '11: Proceedings of the 42nd SIGCSE technical symposium on Computer science education", 2011, "VPL11");
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

  
    public void testIsValid() {
        assertTrue(article.isValid());
        article.list.put(EntriesTest.ArticleTest.TestField.class, new EntriesTest.ArticleTest.TestField());
        assertFalse(article.isValid());
        article.list.remove(EntriesTest.ArticleTest.TestField.class);
        assertTrue(article.isValid());
        article.list.remove(Author.class);
        assertFalse(article.isValid());
        
    }

   
    public void testToString() {
        
        String expString = "@Article{ VPL11,\nauthor = {Luukkainen, Matti},\ntitle = {Extreme Apprenticeship Method in Teaching Programming for Beginners.},\n"
                + "journal = {SIGCSE '11: Proceedings of the 42nd SIGCSE technical symposium on Computer science education},\nyear = {2011},\n}";
        assertEquals(expString, article.toString());    
    }
}



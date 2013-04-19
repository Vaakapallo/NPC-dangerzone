/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EntriesTest;

import Fields.*;
import Entries.Book;
import applicationLogic.Build;
import java.util.HashMap;
import java.util.HashSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lauri
 */
public class BookTest {
    private Book book;
    Author auth;
    Title title;
    Publisher pub;
    Year year;
    Editor edit;
    
    public BookTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        auth = new Author("TestAuthor"); 
     title = new Title("TestTitle");
     pub = new Publisher("TestPublisher");
     year = new Year(2000);
     edit = new Editor("TestEditor");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isValid method, of class Book.
     */
    @Test
    public void IsValidPalauttaaTrueKunKaikkiOikein() {
         
         book = Build.Book("TestiAuthor", "TestiTitle", "TestiPublisher", 2000);
         assertEquals(true, book.isValid());
    }
    @Test
    public void IsValidPalauttaaFalseKunJokinPuuttuu() {
     HashMap<Class<? extends Field>, Field> map = new HashMap();
     map.put(Author.class, auth);
     map.put(pub.getClass(), pub);
     map.put(year.getClass(), year);
     book = new Book(map, "Test");
     assertEquals(false, book.isValid());
     
}
    @Test
    public void IsValidPalauttaaFalseKunSekaAuthorJaEditor() {
         HashMap<Class<? extends Field>, Field> map = new HashMap();
     map.put(Author.class, auth);
     map.put(pub.getClass(), pub);
     map.put(year.getClass(), year);
     map.put(title.getClass(), title);
     map.put(edit.getClass(), edit);
     book = new Book(map, "Test");
     assertEquals(false, book.isValid());
    }
    
    @Test
    public void IsValidPalauttaaaFalseKunLiikaaLuokkia() {
        
         HashMap<Class<? extends Field>, Field> map = new HashMap();
     map.put(Author.class, auth);
     map.put(Booktitle.class, new Booktitle("TestBookTitle"));
     map.put(pub.getClass(), pub);
     map.put(year.getClass(), year);
     map.put(title.getClass(), title);
     map.put(edit.getClass(), edit);
     book = new Book(map, "Test");
     assertEquals(false, book.isValid());
    }
   
}
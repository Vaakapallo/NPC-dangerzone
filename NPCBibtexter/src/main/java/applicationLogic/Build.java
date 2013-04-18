/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic;

import Entries.Article;
import Entries.Book;
import Entries.Inproceedings;
import Fields.Author;
import Fields.Booktitle;
import Fields.Field;
import Fields.Journal;
import Fields.Publisher;
import Fields.Title;
import Fields.Year;
import java.util.HashMap;

/**
 *
 * @author lvapaaka
 */
public class Build {

    public static Inproceedings Inproceedings(String author, String title, String booktitle, int year, String citationKey) {
        HashMap<Class<? extends Field>, Field> constructor = new HashMap();
        constructor.put(Author.class, new Author(author));
        constructor.put(Title.class, new Title(title));
        constructor.put(Year.class, new Year(year));
        constructor.put(Booktitle.class, new Booktitle(booktitle));

        return new Inproceedings(constructor, citationKey);
    }

    public static Book Book(String author, String title, String publisher, int year, String citationKey) {
        HashMap<Class<? extends Field>, Field> constructor = new HashMap();
        constructor.put(Author.class, new Author(author));
        constructor.put(Title.class, new Title(title));
        constructor.put(Publisher.class, new Publisher(publisher));
        constructor.put(Year.class, new Year(year));

        return new Book(constructor, citationKey);
    }
    
    public static Article Article(String author, String title, String journal, int year, String citationKey) {
        HashMap<Class<? extends Field>, Field> constructor = new HashMap();
        constructor.put(Author.class, new Author(author));
        constructor.put(Title.class, new Title(title));
        constructor.put(Journal.class, new Journal(journal));
        constructor.put(Year.class, new Year(year));

        return new Article(constructor, citationKey);
    }
    /**
     * Makes an Inproceedings
     *
     * @param author
     * @param title
     * @param booktitle
     * @param year
     * @return
     */
    public static Inproceedings Inproceedings(String author, String title, String booktitle, int year) {
        return Inproceedings(author, title, booktitle, year, Generate.identifier(author, year, title));
    }

    public static Book Book(String author, String title, String publisher, int year) {
        return Book(author, title, publisher, year, Generate.identifier(author, year, title));
    }
    
    public static Article Article(String author, String title, String journal, int year) {
        return Article(author, title, journal, year, Generate.identifier(author, year, title));
    }
}

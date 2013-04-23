/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic;

import Entries.Article;
import Entries.Book;
import Entries.Inproceedings;
import Fields.*;
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

    public static Article optionalFieldsArticle(String author, String title, String journal, int year, String volume, int number, int[] pages, String month, String note) {
        HashMap<Class<? extends Field>, Field> constructor = new HashMap();
        constructor.put(Author.class, new Author(author));
        constructor.put(Title.class, new Title(title));
        constructor.put(Journal.class, new Journal(journal));
        constructor.put(Year.class, new Year(year));

        if (volume != null) {
            constructor.put(Volume.class, new Volume(volume));
        }
        if (number != 0) {
            constructor.put(BibNumber.class, new BibNumber(number));
        }
//        if (pages.length != 0) {
//            constructor.put(Pages.class, new Pages(pages));
//        }
        if (month != null) {
            constructor.put(Month.class, new Month(month));
        }
        if (note != null) {
            constructor.put(Note.class, new Note(note));
        }

        return new Article(constructor, Generate.identifier(author, year, title));
    }
//       Volume.class, Series.class, Address.class, Edition.class, Month.class, Note.class, Key.class

    public static Book optionalFieldsBook(String author, String title, String publisher, int year, String volume, String series, String address, String edition, String month, String note) {
        HashMap<Class<? extends Field>, Field> constructor = new HashMap();
        constructor.put(Author.class, new Author(author));
        constructor.put(Title.class, new Title(title));
        constructor.put(Publisher.class, new Publisher(publisher));
        constructor.put(Year.class, new Year(year));

        if (volume != null) {
            constructor.put(Volume.class, new Volume(volume));
        }
        if (series != null) {
            constructor.put(Series.class, new Series(series));
        }
        if (address != null) {
            constructor.put(Address.class, new Address(address));
        }
        if (month != null) {
            constructor.put(Month.class, new Month(month));
        }
        if (note != null) {
            constructor.put(Note.class, new Note(note));
        }

        return new Book(constructor, Generate.identifier(author, year, title));
    }
    //                                                      Editor.class, Pages.class, Organization.class, Publisher.class, Address.class, Month.class, Key.class 

    public static Inproceedings optionalFieldsInproceedings(String author, String title, String booktitle, int year, String editor, int[] pages, String organization, String address, String publisher, String month, String note) {
        HashMap<Class<? extends Field>, Field> constructor = new HashMap();
        constructor.put(Author.class, new Author(author));
        constructor.put(Title.class, new Title(title));
        constructor.put(Year.class, new Year(year));
        constructor.put(Booktitle.class, new Booktitle(booktitle));

        if (editor != null) {
            constructor.put(Editor.class, new Editor(editor));
        }
        if (publisher != null) {
            constructor.put(Publisher.class, new Publisher(publisher));
        }
        if (organization != null) {
            constructor.put(Organization.class, new Organization(organization));
        }
        if (address != null) {
            constructor.put(Address.class, new Address(address));
        }
        if (month != null) {
            constructor.put(Month.class, new Month(month));
        }
        if (note != null) {
            constructor.put(Note.class, new Note(note));
        }

        return new Inproceedings(constructor, Generate.identifier(author, year, title));
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

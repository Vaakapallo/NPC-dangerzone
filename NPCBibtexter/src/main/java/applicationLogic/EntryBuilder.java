/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic;


import Entries.Inproceedings;
import Fields.Author;
import Fields.Booktitle;
import Fields.Field;
import Fields.Title;
import Fields.Year;
import java.util.HashMap;

/**
 *
 * @author lvapaaka
 */
public class EntryBuilder {

    public static Inproceedings buildInproceedings(String author, String title, String booktitle, int year, String tag) {
        HashMap<Class<? extends Field>, Field> constructor = new HashMap();
        constructor.put(Author.class, new Author(author));
        constructor.put(Title.class, new Title(title));
        constructor.put(Year.class, new Year(year));
        constructor.put(Booktitle.class, new Booktitle(booktitle));

        return new Inproceedings(constructor, tag);
    }
}

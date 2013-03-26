/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic;

import java.util.HashMap;

/**
 *
 * @author lvapaaka
 */
public class EntryBuilder {

    public static Inproceedings buildInproceedings(String author, String title, String booktitle, int year) {
        HashMap<Class<? extends Field>, Field> constructor = new HashMap();
        constructor.put(Author.class, new Author(author));
        constructor.put(Title.class, new Title(title));
//        constructor.put(Year.class, new Year(year));
//        constructor.put(BookTitle.class, new BookTitle(booktitle));

        return new Inproceedings(constructor);
    }
}

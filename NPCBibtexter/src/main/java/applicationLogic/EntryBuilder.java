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


        return new Inproceedings(new HashMap());
    }
}

package applicationLogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Inproceedings extends Entry {

    final public Class[] requiredFields = {Author.class, Title.class, Booktitle.class, Year.class};
    private Class[] optionalarray = {};
    final public HashSet optionalFields = new HashSet(Arrays.asList(optionalarray));
    private String author;
    private String title;
    private String booktitle;
    private String year;
//
//    public Inproceedings(Author author, String title, String booktitle, String year) {
//        
//        this.title = title;
//        this.booktitle = booktitle;
//        this.year = year;
//        list = new HashMap();
//        list.put(author.getClass(), author);
//    }
    /*
     * Constructor takes a hashMap of fields and checks if all fields are valid.
     * If they are, the fields are stored in the hashMap provided by the superclass.
     */

    public Inproceedings(HashMap<Class<? extends Field>, Field> map) {
        list = new HashMap();
        try {
            for (Class field : requiredFields) {
                if (!map.containsKey(field)) {
                    throw new Exception();
                } else {
                    list.put(field, map.get(field));
                    map.remove(field);
                }
            }
            for (Class field2 : map.keySet()) {
                if (!optionalFields.contains(field2)) {
                    throw new Exception();
                } else {
                    list.put(field2, map.get(field2));
                    map.remove(field2);
                }
            }

        } catch (Exception e) {
            System.out.println("Fields are not valid!");
        }
    }

    public void testimetodi() {
        System.out.println(list.containsKey((Author.class)));
        System.out.println(list.containsKey((Title.class)));
        System.out.println(list.get(Author.class).getField());
        ;

    }

    @Override
    public String toString() {
        String palautettava = "@INPROCEEDINGS{inproceedings-minimal,\n"
                + "\tauthor = " + "\"" + author + "\"," + "\n"
                + "\ttitle = " + "\"" + title + "\"," + "\n"
                + "\tbooktitle = " + "\"" + booktitle + "\"," + "\n"
                + "\tyear = " + "\"" + year + "\"" + "\n"
                + "}";
        return palautettava;
    }
}

package applicationLogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;



public class Inproceedings extends Entry {
   public Class[] requiredFields = {Author.class, Title.class, Booktitle.class, Year.class};
   public Class[] optionalFields = {}; 
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
    
    public boolean Inproceedings(HashMap<Class<? extends Field>, Field> map) {
        
        for (Class field : requiredFields) {
            if (!map.containsKey(field)) {
                return false;
        } else {
            list.put(field, map.get(field));
            map.remove(field);
        }
    } for (Class class) {
            
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
                + "\tauthor = "+"\""+author+"\","+"\n"
                + "\ttitle = "+"\""+title+"\","+"\n"
                + "\tbooktitle = "+"\""+booktitle+"\","+"\n"
                + "\tyear = "+"\""+year+"\""+"\n"
                + "}";
        return palautettava;
    }
    
}

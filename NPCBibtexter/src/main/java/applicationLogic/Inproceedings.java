package applicationLogic;

import java.util.HashMap;



public class Inproceedings {
    HashMap<Class<? extends Field>, Field> list;
    private String author;
    private String title;
    private String booktitle;
    private String year;

    public Inproceedings(Author author, String title, String booktitle, String year) {
        
        this.title = title;
        this.booktitle = booktitle;
        this.year = year;
        list = new HashMap();
        list.put(author.getClass(), author);
    }
    
    public void testimetodi() {
        System.out.println(list.containsKey((Author.class)));
        System.out.println(list.containsKey((Title.class)));
        System.out.println(list.get(Author.class).getField());
        ;
        
    }
    
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

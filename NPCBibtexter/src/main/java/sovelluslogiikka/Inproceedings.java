package sovelluslogiikka;

public class Inproceedings {
    
    private String author;
    private String title;
    private String booktitle;
    private String year;

    public Inproceedings(String author, String title, String booktitle, String year) {
        this.author = author;
        this.title = title;
        this.booktitle = booktitle;
        this.year = year;
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

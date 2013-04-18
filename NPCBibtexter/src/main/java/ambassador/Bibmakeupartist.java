package ambassador;

import Entries.Article;
import Entries.Book;
import Entries.Entry;
import Entries.Inproceedings;
import Fields.Field;
import applicationLogic.Build;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bibmakeupartist {

    public Bibmakeupartist() {
    }

    /**
     * FAAABULOOOOOOUS
     *
     * @param entries
     */
    public void printSexyStringsToUser(List<Entry> entries) {
        for (Entry entry : entries) {
            if (entry.getClass() == Inproceedings.class) {
                Inproceedings i = (Inproceedings) entry;
                printSexyInproceedings(i);
                System.out.println("\n");
            } else if (entry.getClass() == Article.class) {
                Article a = (Article) entry;
                printSexyArticle(a);
                System.out.println("\n");
            } else if (entry.getClass() == Book.class) {
                Book b = (Book) entry;
                printSexyBook(b);
                System.out.println("\n");
            } else {
                System.out.println("Entry type: " + entry.getClass().getName() + " not supported yet. Sexy printing did not succeed.");
            }
        }
    }

    public void printSexyInproceedings(Inproceedings i) {
        System.out.println("Entry: Inproceedings");
        System.out.println("Citation key: " + i.getCitationKey());
        for (Field f : i.getList().values()) {
            String toSplit = f.toString();
            toSplit = toSplit.split("=")[0].trim();
            System.out.println(toSplit + ": " + f.getField());
        }
    }

    public void printSexyArticle(Article a) {
        System.out.println("Entry: Article");
        System.out.println("Citation key: " + a.getCitationKey());
        for (Field f : a.getList().values()) {
            String toSplit = f.toString();
            toSplit = toSplit.split("=")[0].trim();
            System.out.println(toSplit + ": " + f.getField());
        }
    }

    public void printSexyBook(Book b) {
        System.out.println("Entry: Book");
        System.out.println("Citation key: " + b.getCitationKey());
        for (Field f : b.getList().values()) {
            String toSplit = f.toString();
            toSplit = toSplit.split("=")[0].trim();
            System.out.println(toSplit + ": " + f.getField());
        }
    }
}

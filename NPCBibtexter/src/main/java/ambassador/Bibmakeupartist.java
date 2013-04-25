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
     * @param entries
     */
    public void printSexyStringsToUser(List<Entry> entries) {
        for (Entry entry : entries) {
            System.out.println("Entry: " + entry.getClass().getCanonicalName().split("\\.")[1]);
            System.out.println("Citation key: " + entry.getCitationKey());
            for (Field f : entry.list.values()) {
                String toSplit = f.toString();
                toSplit = toSplit.split("=")[0].trim();
                System.out.println(toSplit + ": " + f.getField());
            }
        }
    }
}
package ambassador;

import Entries.Entry;
import Fields.Field;
import java.util.List;
import textUI.IO;

public class Bibmakeupartist {

    private IO io;
    
    public Bibmakeupartist() {
        
    }
    
    public Bibmakeupartist(IO io) {
        this.io = io;
    }

    /**
     * FAAABULOOOOOOUS
     * @param entries
     */
    public void printSexyStringsToUser(List<Entry> entries) {
        for (Entry entry : entries) {
            io.printLine("Entry: " + entry.getClass().getCanonicalName().split("\\.")[1]);
            io.printLine("Citation key: " + entry.getCitationKey());
            for (Field f : entry.list.values()) {
                String toSplit = f.toString();
                toSplit = toSplit.split("=")[0].trim();
                io.printLine(toSplit + ": " + f.getField());
            }
        }
    }
}
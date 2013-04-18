package CommandInterpreter;

import Entries.Entry;
import applicationLogic.Build;
import applicationLogic.EntryStorage;
import applicationLogic.Generate;
import textUI.IO;

public class AddArticle extends Command {

    public AddArticle(IO io) {
        super(io);
    }

    @Override
    public void run() {
        io.printLine("Anna viiteavain (pelkkä väliyönti generoi)");
        String citationKey = io.readString();
        io.printLine("Anna kirjoittaja(t):");
        String author = io.readString();
        io.printLine("Anna kirjoituksen nimi:");
        String title = io.readString();
        io.printLine("Anna julkaisun nimi:");
        String journal = io.readString();
        io.printLine("Anna vuosi:");
        int year = io.readInt();
        Entry entry;
        if (citationKey.equals(" ")) {
            entry = Build.Article(author, title, journal, year);
        } else {
            while (!Generate.isUnique(EntryStorage.getCiteKeys(), citationKey)) {
                io.printLine("Anna uusi viiteavain, vanha ei ole uniikki");
                citationKey = io.readString();
            }
            entry = Build.Article(author, title, journal, year, citationKey);
        }
        if (entry.isValid()) {
            EntryStorage.addEntry(entry);
            EntryStorage.addCiteKey(entry.getCitationKey());
            io.printLine(entry.toString());
        } else {
            io.printLine("Väärää infoa, takaisin valikkoon");
        }
    }
}

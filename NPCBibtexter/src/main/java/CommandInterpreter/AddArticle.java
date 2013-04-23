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
        io.printLine("Haluatko lisätä vaihtoehtoisia kenttiä? (k/e)");
        if(io.readString().equalsIgnoreCase("k")){
            askAndAddOptionalFields(author,title,journal,year);
            return;
        } 
        
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
// Volume.class, Fields.BibNumber.class, Pages.class, Month.class, Note.class, Key.class
    private void askAndAddOptionalFields(String author, String title, String journal, int year) {
        io.printLine("Vaihtoehtoisia tietoja");
        io.printLine("Anna volyymin nimi:");
        String volume = io.readString();
        io.printLine("Anna kuukausi:");
        String month = io.readString();
        io.printLine("Anna muistiinpano:");
        String note = io.readString();
        io.printLine("Anna julkaisun numero:");
        int number = io.readInt();
        Entry entry = Build.optionalFieldsArticle(author, title, journal, year, volume, number, null, month, note);
        EntryStorage.addEntry(entry);
        io.printLine(entry.toString());
    }
}

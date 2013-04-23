package CommandInterpreter;

import Entries.Entry;
import applicationLogic.Build;
import applicationLogic.EntryStorage;
import applicationLogic.Generate;
import textUI.IO;

public class AddBook extends Command {

    public AddBook(IO io) {
        super(io);
    }

    @Override
    public void run() {
        io.printLine("Anna viiteavain (pelkkä väliyönti generoi)");
        String citationKey = io.readString();
        io.printLine("Anna kirjoittaja(t) tai toimittaja:");
        String author = io.readString();
        io.printLine("Anna kirjoituksen nimi:");
        String title = io.readString();
        io.printLine("Anna julkaisijan nimi:");
        String publisher = io.readString();
        io.printLine("Anna vuosi:");
        int year = io.readInt();
        Entry entry;
        io.printLine("Haluatko lisätä vaihtoehtoisia kenttiä? (k/e)");
        if (io.readString().equalsIgnoreCase("k")) {
            askAndAddOptionalFields(author, title, publisher, year);
            return;
        }
        if (citationKey.equals(" ")) {
            entry = Build.Book(author, title, publisher, year);
        } else {
            while (!Generate.isUnique(EntryStorage.getCiteKeys(), citationKey)) {
                io.printLine("Anna uusi viiteavain, vanha ei ole uniikki");
                citationKey = io.readString();
            }
            entry = Build.Book(author, title, publisher, year, citationKey);
        }
        if (entry.isValid()) {
            EntryStorage.addEntry(entry);
            EntryStorage.addCiteKey(entry.getCitationKey());
            io.printLine(entry.toString());
        } else {
            io.printLine("Väärää infoa, takaisin valikkoon");
        }
    }

    // Volume.class, Series.class, Address.class, Edition.class, Month.class, Note.class, Key.class
    private void askAndAddOptionalFields(String author, String title, String publisher, int year) {
        io.printLine("Vaihtoehtoisia tietoja");
        io.printLine("Anna volyymin nimi:");
        String volume = io.readString();
        io.printLine("Anna kuukausi:");
        String month = io.readString();
        io.printLine("Anna muistiinpano:");
        String note = io.readString();
        io.printLine("Anna sarjan nimi:");
        String series = io.readString();
        io.printLine("Anna julkaisijan osoite:");
        String address = io.readString();
        io.printLine("Anna versio:");
        String edition = io.readString();
        Entry entry = Build.optionalFieldsBook(author, title, publisher, year, volume, series, address, edition, month, note);
        EntryStorage.addEntry(entry);
        io.printLine(entry.toString());
    }
}

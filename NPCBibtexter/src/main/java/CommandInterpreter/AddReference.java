/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreter;

import Entries.Entry;
import Entries.Inproceedings;
import applicationLogic.Build;
import applicationLogic.EntryStorage;
import applicationLogic.Generate;
import textUI.IO;

/**
 * Asks the user for the necessary information and adds an Inproceedings-Entry
 * to EntryStorage
 *
 * @see EntryStorage
 * @see Inproceedings
 *
 * @author lvapaaka
 */
public class AddReference extends Command {

    public AddReference(IO io) {
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
        io.printLine("Anna kirjan nimi:");
        String booktitle = io.readString();
        io.printLine("Anna vuosi:");
        int year = io.readInt();
        Entry entry;
        if (citationKey.equals(" ")) {
            entry = Build.Inproceedings(author, title, booktitle, year);
        } else {
            while (!Generate.isUnique(EntryStorage.getCiteKeys(), citationKey)) {
                io.printLine("Anna uusi viiteavain, vanha ei ole uniikki");
                citationKey = io.readString();
            }
            entry = Build.Inproceedings(author, title, booktitle, year, citationKey);
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

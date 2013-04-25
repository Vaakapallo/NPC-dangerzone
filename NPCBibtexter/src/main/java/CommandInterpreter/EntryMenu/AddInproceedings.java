/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreter.EntryMenu;

import CommandInterpreter.Command;
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
public class AddInproceedings extends Command {

    public AddInproceedings(IO io) {
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
        io.printLine("Haluatko lisätä vaihtoehtoisia kenttiä? (k/e)");
        if (io.readString().equalsIgnoreCase("k")) {
            askAndAddOptionalFields(author, title, booktitle, year);
            return;
        }
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

    //  Editor.class, Pages.class, Organization.class, Publisher.class, Address.class, Month.class, Key.class
    private void askAndAddOptionalFields(String author, String title, String booktitile, int year) {
        io.printLine("Vaihtoehtoisia tietoja");
        io.printLine("Anna editoijan nimi:");
        String editor = io.readString();
        io.printLine("Anna organisaation nimi:");
        String organization = io.readString();
        io.printLine("Anna muistiinpano:");
        String note = io.readString();
        io.printLine("Anna julkaisijan nimi:");
        String publisher = io.readString();
        io.printLine("Anna julkaisijan osoite:");
        String address = io.readString();
        io.printLine("Anna kuukausi:");
        String month = io.readString();
        Entry entry = Build.optionalFieldsInproceedings(author, title, booktitile, year, editor, null, organization, address, publisher, month, note);
        EntryStorage.addEntry(entry);
        EntryStorage.addCiteKey(entry.getCitationKey());
        io.printLine(entry.toString());
    }
}

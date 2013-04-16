/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreter;

import Entries.Entry;
import Entries.Inproceedings;
import applicationLogic.Build;
import applicationLogic.EntryStorage;
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
        io.printLine("Give the citation key:");
        String tag = io.readString();
        io.printLine("Give the author(s):");
        String author = io.readString();
        io.printLine("Give the title:");
        String title = io.readString();
        io.printLine("Give the booktitle:");
        String booktitle = io.readString();
        io.printLine("Give the year:");
        int year = io.readInt();
        Entry entry = Build.Inproceedings(author, title, booktitle, year, tag);
        if (entry.isValid()) {
            EntryStorage.addEntry(entry);
            io.printLine(entry.toString());
        } else {
            io.printLine("Invalid information. Back to menu.");
        }

    }
}

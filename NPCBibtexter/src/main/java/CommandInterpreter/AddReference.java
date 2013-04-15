/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreter;

import CommandInterpreter.Command;
import Entries.Entry;
import applicationLogic.EntryBuilder;
import applicationLogic.EntryStorage;
import textUI.IO;

/**
 *
 * @author lvapaaka
 */
class AddReference extends Command {

    public AddReference(IO io) {
        super(io);
    }

    @Override
    public void run() {
        io.printLine("Give the tag:");
        String tag = io.readString();
        io.printLine("Give the author(s):");
        String author = io.readString();
        io.printLine("Give the title:");
        String title = io.readString();
        io.printLine("Give the booktitle:");
        String booktitle = io.readString();
        io.printLine("Give the year:");
        int year = io.readInt();
        Entry entry = EntryBuilder.buildInproceedings(author, title, booktitle, year, tag);
        if (entry.isValid()) {
            EntryStorage.addEntry(entry);
            io.printLine(entry.toString());
        } else {
            io.printLine("Invalid information. Back to menu.");
        }

    }
}

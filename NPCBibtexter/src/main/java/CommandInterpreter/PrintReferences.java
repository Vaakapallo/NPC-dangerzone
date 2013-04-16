/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreter;

import Entries.Entry;
import applicationLogic.EntryStorage;
import textUI.IO;

/**
 * Prints all the references in EntryStorage
 * 
 * @author lvapaaka
 */
public class PrintReferences extends Command {

    public PrintReferences(IO io) {
        super(io);
    }

    @Override
    public void run() {
        for (Entry entry : EntryStorage.getEntries()) {
            io.printLine(entry.toString());
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreter;

import CommandInterpreter.Command;
import Entries.Entry;
import applicationLogic.EntryStorage;
import textUI.IO;

/**
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

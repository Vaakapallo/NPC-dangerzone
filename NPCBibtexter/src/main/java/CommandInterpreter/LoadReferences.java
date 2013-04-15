/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreter;

import Entries.Entry;
import ambassador.Bibwriter;
import applicationLogic.EntryStorage;
import textUI.IO;

/**
 *
 * @author lvapaaka
 */
public class LoadReferences extends Command {

    public LoadReferences(IO io) {
        super(io);
    }

    @Override
    public void run() {
        for (Entry entry: Bibwriter.readAndListReferences()) {
            EntryStorage.addEntry(entry);
        }
    }
    
}

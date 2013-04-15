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
class ReadReferencesFromMemory extends Command {

    public ReadReferencesFromMemory(IO io) {
        super(io);
    }

    @Override
    public void run() {
        for (Entry entry: Bibwriter.readAndListReferences()) {
            EntryStorage.addEntry(entry);
        }
    }
    
}

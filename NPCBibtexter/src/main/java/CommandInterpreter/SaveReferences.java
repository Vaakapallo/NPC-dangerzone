/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreter;

import ambassador.Bibwriter;
import applicationLogic.EntryStorage;
import textUI.IO;

/**
 *
 * @author lvapaaka
 */
class SaveReferences extends Command {

    public SaveReferences(IO io) {
        super(io);
    }

    @Override
    public void run() {
        Bibwriter.writeReferencesFromList(EntryStorage.getEntries());
    }
    
}

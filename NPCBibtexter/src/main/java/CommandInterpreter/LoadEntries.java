/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreter;

import Entries.Entry;
import ambassador.Bibwriter;
import applicationLogic.EntryStorage;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import textUI.IO;

/**
 * Loads all the references in a .bib-file to EntryStorage.
 * 
 * @author lvapaaka
 */
public class LoadEntries extends Command {

    public LoadEntries(IO io) {
        super(io);
    }

    @Override
    public void run() {
        try {
            for (Entry entry: Bibwriter.readAndListReferences()) {
                EntryStorage.addEntry(entry);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoadEntries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

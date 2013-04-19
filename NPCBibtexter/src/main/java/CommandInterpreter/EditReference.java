/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreter;

import Entries.Entry;
import applicationLogic.EntryStorage;
import textUI.IO;

/**
 *
 * @author Cobrelli
 */
public class EditReference extends Command {

    public EditReference(IO io){
        super(io);
    }
    
    @Override
    public void run() {
        if(EntryStorage.getEntries().isEmpty()){
            io.printLine("Muokattavia viitteitä ei ole. ");
            return;
        }
        
        io.printLine("Anna muokattavan viitteen viiteavain ");
        String citationKey = io.readString();
        
        int index = 0;
        for (Entry entry : EntryStorage.getEntries()) {
            if(citationKey.equals(entry.getCitationKey())){
                io.printLine("Alkuperäinen viite: ");
                io.printLine(entry.toString());
                EntryStorage.getEntries().remove(index);
                EntryStorage.getCiteKeys().remove(entry.getCitationKey());
                new AddReference(io).run();
                break;
            }
            index++;
        }
    }
}

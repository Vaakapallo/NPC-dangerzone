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
        System.out.println("Anna muokattavan viitteen viiteavain ");
        String citationKey = io.readString();
        
        int index = 0;
        for (Entry entry : EntryStorage.getEntries()) {
            if(citationKey.equals(entry.getCitationKey())){
                EntryStorage.getEntries().remove(index);
                new AddReference(io).run();
                break;
            }
            index++;
        }
    }
}

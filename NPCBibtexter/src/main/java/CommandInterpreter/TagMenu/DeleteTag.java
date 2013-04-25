/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreter.TagMenu;

import CommandInterpreter.Command;
import Entries.Entry;
import textUI.IO;

/**
 *
 * @author lassi
 */
public class DeleteTag extends Command {

    private Entry entry;

    public DeleteTag(IO io, Entry entry) {
        super(io);
        this.entry = entry;
    }

    @Override
    public void run() {
        new PrintTags(io, entry).run();
        io.printLine("Anna poistettava tagi");
        String string = io.readPossiblyEmptyString();
        if (entry.removeTag(string)) {
            io.printLine("Tagi poistettu!");
        } else {
            io.printLine("Tagin poistaminen epäonnistui!");
        }
    }
}
    


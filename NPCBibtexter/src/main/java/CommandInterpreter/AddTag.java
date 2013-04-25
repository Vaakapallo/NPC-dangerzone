/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreter;

import Entries.Entry;
import textUI.IO;

/**
 *
 * @author lassi
 */
public class AddTag extends Command {

    private Entry entry;

    public AddTag(IO io, Entry entry) {
        super(io);
        this.entry = entry;
    }

    @Override
    public void run() {
        io.printLine(entry.toString());
        io.printLine("Anna lisättävä tagi");
        String string = io.readPossiblyEmptyString();
        if (!(string.isEmpty())) {
            entry.addTag(string);
        }
    }
}

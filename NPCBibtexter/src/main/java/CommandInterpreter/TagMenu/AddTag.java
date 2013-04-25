/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreter.TagMenu;

import CommandInterpreter.Command;
import Entries.Entry;
import textUI.IO;

/**
 * Asks for a tag and adds it to the given entry.
 * 
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
        entry.addTag(io.readString());
    }
}

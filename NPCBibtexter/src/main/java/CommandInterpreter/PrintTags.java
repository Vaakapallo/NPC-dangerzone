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
public class PrintTags extends Command {

    private Entry entry;

    public PrintTags(IO io, Entry entry) {
        super(io);
        this.entry = entry;
    }

    @Override
    public void run() {
        for (String tag : entry.getTags()) {
            io.printLine(tag);
        }
    }
}
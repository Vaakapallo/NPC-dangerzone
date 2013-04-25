/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreter.TagMenu;

import CommandInterpreter.Command;
import Entries.Entry;
import java.util.Set;
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
        Set<String> tags = entry.getTags();
        if (tags.isEmpty()) {
            io.printLine("Viitteellä ei ole tageja");
            return;
        }
        io.printLine("Viitteen tagit:");
        for (String tag : tags) {
            io.printLine(tag);
        }
    }
}
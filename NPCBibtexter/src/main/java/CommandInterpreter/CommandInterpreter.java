/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreter;

import java.util.HashMap;
import java.util.Map;
import textUI.IO;

/**
 * Holds and dispenses the Command-objects.
 *
 * @see Command
 *
 * @author lvapaaka
 */
public class CommandInterpreter {

    private Map<Integer, Command> commands = new HashMap();

    public CommandInterpreter(IO io) {
        commands.put(1, new EntryType(io));
        commands.put(2, new SaveEntries(io));
        commands.put(3, new PrintEntries(io));
        commands.put(4, new LoadEntries(io));
        commands.put(5, new EditEntry(io));
        commands.put(6, new PrintSexyEntries(io));
        commands.put(7, new EditTags(io));
        commands.put(8, new PrintIDs(io));
        commands.put(9, new Quit(io));
    }

    public Command getCommand(int command) {
        return commands.get(command);
    }
}

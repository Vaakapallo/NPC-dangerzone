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
        commands.put(1, new ReferenceType(io));
        commands.put(2, new SaveReferences(io));
        commands.put(3, new PrintReferences(io));
        commands.put(4, new LoadReferences(io));
        commands.put(5, new EditReference(io));
        commands.put(6, new PrintSexyReferences(io));
        commands.put(9, new Quit(io));
    }

    public Command getCommand(int command) {
        try {
            return commands.get(command);
        } catch (NullPointerException e) {
            return null;
        }

    }
}

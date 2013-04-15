/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreter;

import java.util.HashMap;
import java.util.Map;
import textUI.IO;

/**
 *
 * @author lvapaaka
 */
public class CommandInterpreter {

    private Map<Integer, Command> commands = new HashMap();

    public CommandInterpreter(IO io) {
        commands.put(1, new AddReference(io));
        commands.put(2, new SaveReferences(io));
        commands.put(3, new PrintReferences(io));
        commands.put(4, new ReadReferencesFromMemory(io));
        commands.put(9, new ShutDown(io));
    }

    public Command getCommand(int command) {
        return commands.get(command);
    }
}

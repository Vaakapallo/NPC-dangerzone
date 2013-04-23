package CommandInterpreter;

import java.util.HashMap;
import java.util.Map;
import textUI.IO;

public class EntryType extends Command {

    private Map<Integer, Command> referenceTypes = new HashMap();

    public EntryType(IO io) {
        super(io);
        referenceTypes.put(1, new AddInproceedings(io));
        referenceTypes.put(2, new AddBook(io));
        referenceTypes.put(3, new AddArticle(io));
    }

    @Override
    public void run() {
        io.printLine("Anna uuden viitteen tyypi:");
        io.printLine("1 - Inproceedings");
        io.printLine("2 - Book");
        io.printLine("3 - Article");
        Command command = getCommand(io.readInt());
        if (command != null) {
            command.run();
        } else {
            io.printLine("Viitteen tyyppi oli väärin, yritetäänpä uudelleen");
            run();
        }
    }
    
    public Command getCommand(int number){
        return referenceTypes.get(number);
    }
}

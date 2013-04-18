package CommandInterpreter;

import textUI.IO;

public class ReferenceType extends Command {

    public ReferenceType(IO io) {
        super(io);
    }

    @Override
    public void run() {
        io.printLine("Anna uuden viitteen tyypi:");
        io.printLine("1 - Inproceedings");
        io.printLine("2 - Book");
        io.printLine("3 - Article");
        String entryType = io.readString();
        if (entryType.equals("1")) {
            new AddReference(io).run();
        } else if (entryType.equals("2")) {
            new AddBook(io).run();
        } else if (entryType.equals("3")) {
            new AddArticle(io).run();
        } else {
            io.printLine("Viitteen tyyppi oli väärin, yritetäänpä uudelleen");
            run();
        }
    }
}

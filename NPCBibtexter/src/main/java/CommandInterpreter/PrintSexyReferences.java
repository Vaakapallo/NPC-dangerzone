package CommandInterpreter;

import ambassador.Bibmakeupartist;
import applicationLogic.EntryStorage;
import textUI.IO;

class PrintSexyReferences extends Command {

    public PrintSexyReferences(IO io) {
        super(io);
    }

    @Override
    public void run() {
        Bibmakeupartist bma = new Bibmakeupartist();
        bma.printSexyStringsToUser(EntryStorage.getEntries());
    }
}

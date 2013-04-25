package CommandInterpreter;

import ambassador.Bibmakeupartist;
import applicationLogic.EntryStorage;
import textUI.IO;

class PrintSexyEntries extends Command {

    public PrintSexyEntries(IO io) {
        super(io);
    }

    @Override
    public void run() {
        Bibmakeupartist bma = new Bibmakeupartist(io);
        bma.printSexyStringsToUser(EntryStorage.getEntries());
    }
}

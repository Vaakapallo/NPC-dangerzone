/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreter;

import Entries.Entry;
import Fields.Field;
import applicationLogic.EntryStorage;
import textUI.IO;

/**
 *
 * @author Cobrelli
 */
public class EditReference extends Command {

    public EditReference(IO io) {
        super(io);
    }

    @Override
    public void run() {
        if (EntryStorage.getEntries().isEmpty()) {
            io.printLine("Muokattavia viitteitä ei ole. ");
            return;
        }

        io.printLine("Anna muokattavan viitteen viiteavain ");
        String citationKey = io.readString();

        for (Entry entry : EntryStorage.getEntries()) {
            if (entry.getCitationKey().equals(citationKey)) {
                editCitation(entry);
                return;
            }
        }
        io.printLine("Viiteavainta ei valitettavasti löytynyt");
    }

    private void editCitation(Entry originalEntry) {

        io.printLine("Aloitetaan muokkaus, tyhjä rivi säilyttää alkuperäisen viitteen");

        for (Field f : originalEntry.list.values()) {
            io.printLine("Alkuperäinen viite: ");
            io.printLine(f.toString());
            io.printLine("Anna uusi viite: ");
            String uusi = io.readPossiblyEmptyString();
            if (!uusi.isEmpty()) {
                f.setField(uusi);
            }
        }
    }
}

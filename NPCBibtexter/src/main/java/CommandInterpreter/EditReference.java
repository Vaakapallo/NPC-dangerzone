/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreter;

import Entries.Entry;
import Fields.Field;
import applicationLogic.EntryStorage;
import applicationLogic.Generate;
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

        io.printLine("alkuperäinen viiteavain: " + originalEntry.getCitationKey());
        io.printLine("Anna uusi viiteavain (tyhjä säilyttää edellisen): ");
        String newCitation = io.readPossiblyEmptyString();
        if (!newCitation.isEmpty()) {
            EntryStorage.getCiteKeys().remove(originalEntry.getCitationKey());
            while (!Generate.isUnique(EntryStorage.getCiteKeys(), newCitation)) {
                io.printLine("Anna uusi viiteavain, vanha ei ole uniikki");
                newCitation = io.readString();
            }

            EntryStorage.addCiteKey(newCitation);
            originalEntry.setCitationKey(newCitation);
        }

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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreter;

import Entries.Entry;
import applicationLogic.EntryStorage;
import textUI.IO;

/**
 *
 * @author Lauri
 */
public class EditTags extends Command {

    public EditTags(IO io) {
        super(io);
    }

    @Override
    public void run() {
        while (true) {
            if (EntryStorage.getEntries().isEmpty()) {
                io.printLine("Muokattavia viitteitä ei ole. ");
                return;
            }
            io.printLine("Anna muokattavan viitteen viiteavain, tyhjä lopettaa");
            String citationKey = io.readPossiblyEmptyString();
            if (citationKey.equals("")) {
                return;
            }

            for (Entry entry : EntryStorage.getEntries()) {
                if (entry.getCitationKey().equals(citationKey)) {
                    io.printLine("Valitse toiminto");
                    io.printLine("1. Lisää tagi");
                    io.printLine("2. Poista tagi");
                    io.printLine("3. Tulosta viitteen tagit");
                    String string = io.readString();
                    if (string.equals("1")) {
                        lisaaTagi(entry);
                        break;
                    } else if (string.equals("2")) {
                        poistaTagi(entry);
                        break;
                    } else if (string.equals("3")) {
                        TulostaTagit(entry);
                        break;
                    }
                }
            }
            io.printLine("Viiteavainta ei valitettavasti löytynyt");
        }
    }

    public void lisaaTagi(Entry entry) {
        io.printLine(entry.toString());
        io.printLine("Anna lisättävä tagi");
        String string = io.readPossiblyEmptyString();
        if (!(string.isEmpty())) {
            entry.addTag(string);
        }
    }

    public void poistaTagi(Entry entry) {
        io.printLine("Viitteen tagit:");
        TulostaTagit(entry);
        io.printLine("Anna poistettava tagi");
        String string = io.readPossiblyEmptyString();
        if (entry.removeTag(string)) {
            io.printLine("Tagi poistettu!");
        } else {
            io.printLine("Tagin poistaminen epäonnistui!");
        }
    }
    
    private void TulostaTagit(Entry entry) {
        for (String tag : entry.getTags()) {
            io.printLine(tag);
        }
    }
}
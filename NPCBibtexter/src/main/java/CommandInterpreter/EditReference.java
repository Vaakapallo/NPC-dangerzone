/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreter;

import Entries.Entry;
import Fields.Author;
import Fields.Booktitle;
import Fields.Field;
import Fields.Title;
import Fields.Year;
import applicationLogic.Build;
import applicationLogic.EntryStorage;
import applicationLogic.Generate;
import com.sun.imageio.plugins.common.I18N;
import com.sun.xml.internal.bind.v2.runtime.output.InPlaceDOMOutput;
import org.omg.CORBA.INTERNAL;
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

//        int index = 0;
//        for (Entry entry : EntryStorage.getEntries()) {
//            if (citationKey.equals(entry.getCitationKey())) {
//                io.printLine("Alkuperäinen viite: ");
//                io.printLine(entry.toString());
//                EntryStorage.getEntries().remove(index);
//                EntryStorage.getCiteKeys().remove(entry.getCitationKey());
//                new AddReference(io).run();
//                break;
//            }
//            index++;
//        }
    }

    private void editCitation(Entry originalEntry) {

        String citationKey = originalEntry.getCitationKey();

        io.printLine("Anna viiteavain (Välilyönti generoi, tyhjällä säilyttää edellisen)");
        String newCitationKey = io.readPossiblyEmptyString();

        if (!newCitationKey.isEmpty()) {
            citationKey = newCitationKey;
        }

        io.printLine("Anna kirjoittaja(t): (tyhjä säilyttää edellisen)");
        String author = io.readPossiblyEmptyString();
        Field originalAuthor = originalEntry.list.get(Author.class);

        if (author.isEmpty()) {
            author = originalAuthor.getField();
        }

        io.printLine("Anna kirjoituksen nimi: (tyhjä säilyttää edellisen)");
        String title = io.readPossiblyEmptyString();
        Field originalTitle = originalEntry.list.get(Title.class);

        if (title.isEmpty()) {
            title = originalTitle.getField();
        }

        io.printLine("Anna kirjan nimi: (tyhjä säilyttää edellisen)");
        String booktitle = io.readPossiblyEmptyString();
        Field originalBookTitle = originalEntry.list.get(Booktitle.class);

        if (booktitle.isEmpty()) {
            booktitle = originalBookTitle.getField();
        }


        io.printLine("Anna vuosi: (tyhjä säilyttää edellisen)");
        int year = io.readPossiblyEmptyInt();
        Field originalYear = originalEntry.list.get(Year.class);

        if (year == 0) {
            year = Integer.parseInt(originalYear.getField());
        }

        Entry entry;
        if (citationKey.equals(" ")) {
            entry = Build.Inproceedings(author, title, booktitle, year);
        } else {
            while (!Generate.isUnique(EntryStorage.getCiteKeys(), citationKey)) {
                if (newCitationKey.isEmpty()) {
                    break;
                } else {
                    io.printLine("Anna uusi viiteavain, vanha ei ole uniikki");
                    citationKey = io.readString();
                }
            }
            entry = Build.Inproceedings(author, title, booktitle, year, citationKey);
        }
        if (entry.isValid()) {
            EntryStorage.removeCiteKey(originalEntry.getCitationKey());
            EntryStorage.removeEntry(originalEntry);
            EntryStorage.addEntry(entry);
            EntryStorage.addCiteKey(entry.getCitationKey());
            io.printLine(entry.toString());
        } else {
            io.printLine("Väärää infoa, takaisin valikkoon");
        }
    }
}

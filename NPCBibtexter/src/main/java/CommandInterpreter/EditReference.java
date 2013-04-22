/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreter;

import Entries.Entry;
import Fields.Field;
import applicationLogic.EntryStorage;
import applicationLogic.Generate;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        for (Class c : originalEntry.getRequiredFields()) {
            io.printLine("Alkuperäinen viite: ");
            io.printLine(originalEntry.list.get(c).toString());
            io.printLine("Anna uusi viite: ");
            String uusi = io.readPossiblyEmptyString();
            if (!uusi.isEmpty()) {
                originalEntry.list.get(c).setField(uusi);
            }
        }

        io.printLine("Haluatko muokata vaihtoehtoisia kenttiä? (k/e)");
        io.printLine(newCitation);

        if (io.readString().equalsIgnoreCase("e")) {
            return;
        }

        for (Class c : originalEntry.getOptionalFields()) {
            if (originalEntry.list.containsKey(c)) {
                io.printLine("Alkuperäinen viite: ");
                io.printLine(originalEntry.list.get(c).toString());
                io.printLine("Anna uusi viite: ");
                String uusi = io.readPossiblyEmptyString();
                if (!uusi.isEmpty()) {
                    originalEntry.list.get(c).setField(uusi);
                }
            } else {

                Field f = createNewField(c);
                if (f != null) {
                    io.printLine("Anna uusi " + f.getClass().getSimpleName() + " viite: (tyhjä ohittaa)");
                    String uusi = io.readPossiblyEmptyString();
                    if (!uusi.isEmpty()) {
                        f.setField(uusi);
                        originalEntry.list.put(c, f);
                    }
                }
            }
        }
    }

    private Field createNewField(Class c) {
        try {
            Field f = (Field) c.getDeclaredConstructor(String.class).newInstance("testi");
            return f;
        } catch (NoSuchMethodException ex) {
        } catch (SecurityException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (IllegalArgumentException ex) {
        } catch (InvocationTargetException ex) {
        }

        return null;

    }
}

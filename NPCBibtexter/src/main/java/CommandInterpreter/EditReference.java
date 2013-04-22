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
                    System.out.println(f.getClass());
                }
            }
        }

//        for (Field f : originalEntry.list.values()) {
//            io.printLine("Alkuperäinen viite: ");
//            io.printLine(f.toString());
//            io.printLine("Anna uusi viite: ");
//            String uusi = io.readPossiblyEmptyString();
//            if (!uusi.isEmpty()) {
//                f.setField(uusi);
//            }
//        }
    }

    private Field createNewField(Class c) {
        Constructor[] ctors = c.getConstructors();
        Constructor ctor = null;
        Field f;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0) {
                break;
            }
        }
        try {
            f = (Field) ctor.newInstance(ctors);
            return f;
        } catch (InstantiationException ex) {
            Logger.getLogger(EditReference.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(EditReference.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(EditReference.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(EditReference.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreter;

import Entries.Entry;
import applicationLogic.EntryStorage;
import java.util.ArrayList;
import java.util.HashSet;
import textUI.IO;

/**
 * Prints all the references in EntryStorage
 *
 * @author lvapaaka
 */
public class PrintEntries extends Command {

    private HashSet<Entry> entries;

    public PrintEntries(IO io) {
        super(io);
        
    }

    @Override
    public void run() {
        entries = new HashSet();
                
        io.printLine("Anna hakusana. Tyhjä printtaa kaikki.");
        String string = io.readPossiblyEmptyString();
        if (!(string.isEmpty())) {
            search(string);
            printSpecificEntries();
        } else {
            printAllEntries();
        }
    }

    private void search(String string) {
        for (Entry entry : EntryStorage.getEntries()) {
                if (entry.tagExists(string)) {
                    entries.add(entry);
                    continue;
                }
            for (Class field : entry.list.keySet()) {
                if (entry.list.get(field).getField().contains(string)) {
                    entries.add(entry);
                }
            }
        }
    }

    private void printSpecificEntries() {
        for (Entry entry : entries) {
            io.printLine(entry.toString());
    }
}

    private void printAllEntries() {
        for (Entry entry : EntryStorage.getEntries()) {
            io.printLine(entry.toString());
        }
    }
}
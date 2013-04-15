/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic;

import Entries.Entry;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lvapaaka
 */
public class EntryStorage {

    private static List<Entry> entries = new ArrayList();

    public static void addEntry(Entry entry) {
        entries.add(entry);
    }

    public static List<Entry> getEntries() {
        return entries;
    }
}

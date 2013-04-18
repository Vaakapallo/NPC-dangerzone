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
    private static List<String> citationKeys = new ArrayList();

    public static void addEntry(Entry entry) {
        entries.add(entry);
    }
    
    public static void addCiteKey(String key) {
        citationKeys.add(key);
    }

    public static List<Entry> getEntries() {
        return entries;
    }
    
    public static List<String> getCiteKeys() {
        return citationKeys;
    }
    
    public static void empty(){
        entries.clear();
    }
}

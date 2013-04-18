package ambassador;

import Entries.Entry;
import Entries.Inproceedings;
import Fields.Field;
import applicationLogic.Build;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bibmakeupartist {

    public Bibmakeupartist() {
    }
    
    /**
     * FAAABULOOOOOOUS
     * @param entries 
     */
    public void printSexyStringsToUser(List<Entry> entries) {
        for (Entry entry : entries) {
            if (entry.getClass() == Inproceedings.class) {
                Inproceedings i = (Inproceedings) entry;
                        
            }
            System.out.println(entry.toString());
        }
    }
    
    
    public List<String> sexifyThatEntry(Entry entry) {
        ArrayList<String> entryAsString = new ArrayList<String>();
        if (entry.getClass().isInstance(Inproceedings.class)) {
            System.out.println("Oh wait no am I here?");
            entryAsString = sexifyInproceedings(entry);
        }
        return entryAsString;
    }
    
    public ArrayList<String> sexifyInproceedings(Entry entry) {
        Inproceedings inproceeding = (Inproceedings) entry;
        HashMap<Class<? extends Field>, Field> list = inproceeding.getList();
        ArrayList<String> inproceedingAsString = new ArrayList<String>();
        for (Field f : list.values()) {
            inproceedingAsString.add(f.toString());
        }
        return inproceedingAsString;
    }
}

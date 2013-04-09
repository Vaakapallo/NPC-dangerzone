package ambassador;

import Entries.Entry;
import java.io.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bibwriter {
    
    public Bibwriter() {

    }
    
    public void writeReferencesFromList(List<Entry> referenceList) {
        FileWriter scribe = null;
        try {
            scribe = new FileWriter(new File("references.bib"), true);
            for (Entry e : referenceList) {
                scribe.append(e.toString());
            }
            scribe.close();
        } catch (IOException ex) {
            Logger.getLogger(Bibwriter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                scribe.close();
            } catch (IOException ex) {
                Logger.getLogger(Bibwriter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void readAndListReferences() {
        
    }
}

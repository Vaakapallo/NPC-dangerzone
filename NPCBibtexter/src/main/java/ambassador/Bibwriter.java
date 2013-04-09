package ambassador;

import Entries.Entry;
import java.io.*;
import java.util.List;

public class Bibwriter {
    
    public Bibwriter() throws IOException {

    }
    
    public void writeReferencesFromList(List<Entry> referenceList) throws IOException {
        FileWriter scribe = new FileWriter(new File("references.bib"), true);
        for (Entry e : referenceList) {
            scribe.append(e.toString());
        }
        scribe.close();
    }
    
    public void readAndListReferences() {
        
    }
}

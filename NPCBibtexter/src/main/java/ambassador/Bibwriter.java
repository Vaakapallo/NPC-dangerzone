package ambassador;

import applicationLogic.Entry;
import java.io.*;
import java.util.List;

public class Bibwriter {
    
    private File references = new File("references.bib");
    private FileWriter out = new FileWriter("references.bib", true);
    
    public Bibwriter() throws IOException {
        if (references.exists()) {
        } else {
            references.createNewFile();
        }
    }
    
    public void writeReference(String viite) throws IOException {
        out.append(viite);
        out.append("\n");
        out.close();
    }
    
    public void writeReferencesFromList(List<Entry> referenceList) throws IOException {
        for (Entry entry : referenceList) {
            writeReference(entry.toString());
        }
    }
    
    public void readAndListReferences() {
        
    }
}

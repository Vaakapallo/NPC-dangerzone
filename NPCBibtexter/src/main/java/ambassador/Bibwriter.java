package ambassador;

import java.io.*;

public class Bibwriter {
    
    private File references = new File("references.bib");
    private FileWriter out = new FileWriter("references.bib", true);
    
    public Bibwriter() throws IOException {
        if (references.exists()) {
        } else {
            references.createNewFile();
        }
    }
    
    public void writeSomething(String viite) throws IOException {
        out.append(viite);
        out.append("\n");
        out.close();
    }
}

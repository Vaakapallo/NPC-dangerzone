package ambassador;

import Entries.Entry;
import applicationLogic.EntryBuilder;
import java.io.*;
import java.util.List;
import java.util.Scanner;
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
            System.out.println("Can't access the file: references.bib.");
        } finally {
            try {
                scribe.close();
            } catch (IOException ex) {
                System.out.println("Can't close the FileWriter, written data might be missing.");
            }
        }
    }

    public void readAndListReferences() {
        System.out.println("reading and listing");
        try {
            Scanner s = new Scanner(new File("references.bib"));
            System.out.println("Scanner open");
            String tag = s.nextLine();
            tag = tag.substring(16, tag.length()-1);
            System.out.println(tag);
            EntryBuilder.buildInproceedings(null, null, null, 1999, null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Bibwriter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

package ambassador;

import Entries.Entry;
import applicationLogic.Build;
import applicationLogic.ScandicConverter;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Bibwriter is used to communicate with BibTeX -formatted files. It offers
 * basic file writing functionality and also enables you to fetch all the
 * references from the file to the program as Entry-objects.
 */
public class Bibwriter {

    private static String referenceFileName = "references.bib";

    /**
     * Creates a standard Bibwriter.
     */
    public Bibwriter() {
    }

    public Bibwriter(String filename) {

        this.referenceFileName = filename;

    }

    /**
     * Writes all the references given in the list to a file 'references.bib' in
     * the program's root folder.
     *
     * @param referenceList
     */
    public static void writeReferencesFromList(List<Entry> referenceList) {
        List<Entry> allEntries = new ArrayList<Entry>();
        try {
            File referenceFile = new File(referenceFileName);
            allEntries.addAll(readAndListReferences());
            allEntries.addAll(referenceList);
            referenceFile.delete();
            referenceFile.createNewFile();
            allEntries = killDuplicates(allEntries);
        } catch (NullPointerException nph) {
            System.out.println("Something went south. ABORT PLS");
        } catch (IOException ex) {
            System.out.println("Managed to delete your previous references but somehow magically everything else disappeared. Tough luck mate.");
        }

        FileWriter scribe = null;

        try {
            scribe = new FileWriter(referenceFileName);
            for (Entry e : allEntries) {
                scribe.append(e.toString());
                scribe.append("\n\n");
            }
            scribe.close();
        } catch (IOException ex) {
            System.out.println("Can't access the file: "+referenceFileName);
        } finally {
            try {
                scribe.close();
            } catch (IOException ex) {
                System.out.println("Can't close the FileWriter, written data might be missing.");
            }
        }
    }


    public static List<Entry> readAndListReferences() throws FileNotFoundException {
        return new Bibreader().readAndListReferences(referenceFileName);
    }
    
    private static List<Entry> killDuplicates(List<Entry> entries) {
        HashMap<String, Entry> entriesByCitationKey = new HashMap<String, Entry>();
        for (Entry entry : entries) {
            entriesByCitationKey.put(entry.getCitationKey(), entry);
        }
        entries.clear();
        for (Entry entry : entriesByCitationKey.values()) {
            entries.add(entry);
        }
        return entries;
    }
}

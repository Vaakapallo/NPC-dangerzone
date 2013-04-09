package ambassador;

import Entries.Entry;
import applicationLogic.EntryBuilder;
import applicationLogic.ScandicConverter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bibwriter {

    public Bibwriter() {
    }

    public void writeReferencesFromList(List<Entry> referenceList) {
        FileWriter scribe = null;
        try {
            scribe = new FileWriter(new File("references.bib"), true);
            for (Entry e : referenceList) {
                scribe.append(e.toString());
                scribe.append("\n\n");
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

    public List<Entry> readAndListReferences() {
        try {
            Scanner s = new Scanner(new File("references.bib"));
            ArrayList<Entry> entries = new ArrayList<Entry>();
            while (s.hasNextLine()) {
                Entry e = parseInproceedings(s);
                entries.add(e);
            }
            return entries;
        } catch (FileNotFoundException ex) {
            System.out.println("File not found, it should be there.");
        }
        return null;

    }

    public Entry parseInproceedings(Scanner s) {
        String tag = s.nextLine();
        ScandicConverter.convertScandicsToBibText(tag = tag.substring(16, tag.length() - 1));
        
        String author = s.nextLine();
        ScandicConverter.convertScandicsToBibText(author = author.substring(10, author.length() - 2));
        
        String title = s.nextLine();
        ScandicConverter.convertScandicsToBibText(title = title.substring(9, title.length() - 2));
        
        String booktitle = s.nextLine();
        ScandicConverter.convertScandicsToBibText(booktitle = booktitle.substring(13, booktitle.length() - 2));
        
        String yearString = s.nextLine();
        yearString = yearString.substring(8, yearString.length() - 2);
        int year = Integer.parseInt(yearString);
        
        s.nextLine();
        s.nextLine();
        
        return EntryBuilder.buildInproceedings(author, title, booktitle, year, tag);
    }
}

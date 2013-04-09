package ambassador;

import Entries.Entry;
import applicationLogic.EntryBuilder;
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
        System.out.println("reading and listing");
        try {
            Scanner s = new Scanner(new File("references.bib"));
            System.out.println("Scanner open");
            String tag = s.nextLine();
            tag = tag.substring(16, tag.length()-1);
            System.out.println(tag);
            String author = s.nextLine();
            author = author.substring(10, author.length()-2);
            System.out.println(author);
            String title = s.nextLine();
            title = title.substring(9, title.length()-2);
            System.out.println(title);
            String booktitle = s.nextLine();
            booktitle = booktitle.substring(13, booktitle.length()-2);
            System.out.println(booktitle);
            String yearString = s.nextLine();
            yearString = yearString.substring(8, yearString.length()-2);
            int year = Integer.parseInt(yearString);
            System.out.println(year);
            Entry e = EntryBuilder.buildInproceedings(author, title, booktitle, year, tag);
            ArrayList<Entry> entries = new ArrayList<Entry>();
            entries.add(e);
            return entries;
        } catch (FileNotFoundException ex) {
            System.out.println("File not found, it should be there.");
        }
        return null;

    }
}

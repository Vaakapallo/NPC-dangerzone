package ambassador;

import Entries.Entry;
import applicationLogic.Build;
import applicationLogic.ScandicConverter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 * Bibwriter is used to communicate with BibTeX -formatted files. It offers
 * basic file writing functionality and also enables you to fetch all the
 * references from the file to the program as Entry-objects.
 */
public class Bibwriter {

    private static String referenceFileName = "references.bib";
    private static String[] possibleEntries = {"@Inproceedings",
        "@Book",
        "@Article"};

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
            new File(referenceFileName).delete();
            new File(referenceFileName).createNewFile();
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
            System.out.println("Can't access the file: references.bib.");
        } finally {
            try {
                scribe.close();
            } catch (IOException ex) {
                System.out.println("Can't close the FileWriter, written data might be missing.");
            }
        }
    }

    /**
     * Reads the references from a file and converts them into Entry-objects. So
     * far it has the capability to understand
     *
     * @Inproceedings.
     * @return A list of Entries (references).
     */
    public static List<Entry> readAndListReferences() throws NullPointerException {
        try {
            Scanner s = new Scanner(new File(referenceFileName));
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

    /**
     *
     * @param s Contains the information in the file where
     * @Inproceedings has been written.
     * @return Entry-object of the
     * @Inproceedings.
     */
    private static Entry parseInproceedings(Scanner s) {
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

        return Build.Inproceedings(author, title, booktitle, year, tag);
    }

    public void entryParserAlpha() throws FileNotFoundException {
        Scanner s = new Scanner(new File(referenceFileName));
        String kokoRoska = "";
        while (s.hasNextLine()) {
            kokoRoska += s.nextLine();
        }

        String[] entryt = kokoRoska.split("@");
        for (int i = 0; i < entryt.length; i++) {
            entryt[i] = "@" + entryt[i];
        }

        entryt[0] = null;

        for (String string : entryt) {
            if (string == null) {
                continue;
            }
            System.out.println(string);
            String entryType = "";
            for (int i = 0; i < possibleEntries.length; i++) {
                if (string.contains(possibleEntries[i])) {
                    if (possibleEntries[i].equals("@Inproceedings")) {
                        entryType = possibleEntries[i];
                    } else if (possibleEntries[i].equals("@Book")) {
                        entryType = possibleEntries[i];
                    } else {
                        entryType = "@Article";
                    }
                }
            }

            String citeKey = string.split("[{]")[1].split(",")[0].trim();
            System.out.println(citeKey);

            String address = null;
            String author = null;
            String booktitle = null;
            String edition = null;
            String editor = null;
            String field = null;
            String journal = null;
            String key = null;
            String month = null;
            String note = null;
            String number = null;
            String organization = null;
            String pages = null;
            String publisher = null;
            String series = null;
            String title = null;
            String volume = null;
            String year = null;
            if (string.contains("address")) {
            }
            if (string.contains("author")) {
                author = author.split("author = [{].*[}]")[0];
                

                System.out.println(author);
                        //Pattern p = Pattern.compile("author = [{].*[}]");
            }
            if (string.contains("booktitle")) {
            }
            if (string.contains("edition")) {
            }
            if (string.contains("editor")) {
            }
            if (string.contains("field")) {
            }
            if (string.contains("journal")) {
            }
            if (string.contains("key")) {
            }
            if (string.contains("month")) {
            }
            if (string.contains("note")) {
            }
            if (string.contains("number")) {
            }
            if (string.contains("organization")) {
            }
            if (string.contains("pages")) {
            }
            if (string.contains("publisher")) {
            }
            if (string.contains("series")) {
            }
            if (string.contains("title")) {
            }
            if (string.contains("volume")) {
            }
            if (string.contains("year")) {
            }
        }
    }
}

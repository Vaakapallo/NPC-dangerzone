package ambassador;

import Entries.Entry;
import Fields.Address;
import Fields.Author;
import Fields.Booktitle;
import Fields.Edition;
import Fields.Editor;
import Fields.Field;
import Fields.Journal;
import Fields.Key;
import Fields.Month;
import Fields.Note;
import Fields.Organization;
import Fields.Pages;
import Fields.Publisher;
import Fields.Series;
import Fields.Title;
import Fields.Volume;
import Fields.Year;
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
    public static List<Entry> readAndListReferences1() throws NullPointerException {
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

    public static List<Entry> readAndListReferences() throws FileNotFoundException {
        ArrayList<Entry> entries = new ArrayList<Entry>();
        Scanner reader = new Scanner(new File(referenceFileName));
        while (reader.hasNextLine()) {
            String definingLine = reader.nextLine();
            String entryType = definingLine.split("[{]")[0].substring(1);
            String citationKey = definingLine.split("[{]")[1].trim();

//            Method requs = Class.forName("Entries."+entryType).getMethod("getRequiredFields", null);
//            Method opts = Class.forName("Entries."+entryType).getMethod("getOptionalFields", null);
//            Class[] requireds = (Class[]) requs.invoke(null, null);
//            Class[] optionals = (Class[]) opts.invoke(null, null);
//            
//            HashMap<Class<? extends Field>, Field> constructor = new HashMap();
//            constructor.put(Author.class, new Author("amigamies"));
//            Class<?> c = Class.forName("Entries."+entryType);
//            Constructor<?> cons = c.getConstructor(entryTypes.get(entryType));
//            Entry e = (Entry) cons.newInstance(constructor);
//            
//            String methodName = "optionalFields"+entryType;
//            
//            Method m = entryTypes.get(entryType).getMethod(methodName, null);
//            Entry newEntry = (Entry) m.invoke(null, possibleEntries);
//            Class[] paramTypes = m.getParameterTypes();
            String address = null;
            String author = null;
            String booktitle = null;
            String edition = null;
            String editor = null;
            String journal = null;
            String month = null;
            String key = null;
            String note = null;
            String organization = null;
            int[] pages = new int[1];
            pages[0] = 0;
            String publisher = null;
            String series = null;
            String title = null;
            String volume = null;
            int year = 0;
            int number = 0;

            while (true) {
                String inUse = reader.nextLine();
                if (inUse.equals("}")) {
                    break;
                }
                String field[] = inUse.split("=");
                String type = field[0].trim();
                String content = field[1].trim().substring(1, field[1].length() - 3);

                if (type.equals("address")) {
                    address = content;
                }
                if (type.equals("author")) {
                    author = content;
                }
                if (type.equals("booktitle")) {
                    booktitle = content;
                }
                if (type.equals("edition")) {
                    edition = content;
                }
                if (type.equals("editor")) {
                    editor = content;
                }
                if (type.equals("journal")) {
                    journal = content;
                }
                if (type.equals("key")) {
                    key = content;
                }
                if (type.equals("month")) {
                    month = content;
                }
                if (type.equals("note")) {
                    note = content;
                }
                if (type.equals("organization")) {
                    organization = content;
                }
                if (type.equals("pages")) {
                    pages[0] = Integer.parseInt(content);
                }
                if (type.equals("publisher")) {
                    publisher = content;
                }
                if (type.equals("series")) {
                    series = content;
                }
                if (type.equals("title")) {
                    title = content;
                }
                if (type.equals("volume")) {
                    volume = content;
                }
                if (type.equals("year")) {
                    year = Integer.parseInt(content);
                }
                if (type.equals("number")) {
                    number = Integer.parseInt(content);
                }


            }

            if (entryType.equals("Inproceedings")) {
                Entry e = Build.optionalFieldsInproceedings(author, title, booktitle, year, editor, new int[0], organization, address, publisher, month, note);
                entries.add(e);
            }
            if (entryType.equals("Book")) {
                Entry e = Build.optionalFieldsBook(author, title, publisher, year, volume, series, address, edition, month, note);
                entries.add(e);
            }
            if (entryType.equals("Article")) {
                Entry e = Build.optionalFieldsArticle(author, title, journal, year, volume, number, new int[0], month, note);
                entries.add(e);
            }

            reader.nextLine();

        }

        return entries;

    }
}

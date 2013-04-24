package ambassador;

import Entries.Entry;
import applicationLogic.Build;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bibreader {
    
    public Bibreader() {
        
    }

    public List<Entry> readAndListReferences(String filename) throws FileNotFoundException {
        ArrayList<Entry> entries = new ArrayList<Entry>();
        Scanner reader = new Scanner(new File(filename));
        while (reader.hasNextLine()) {
            String definingLine = reader.nextLine();
            String entryType = definingLine.split("[{]")[0].substring(1);
            String citationKey = definingLine.split("[{]")[1].trim();

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

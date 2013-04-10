package textUI;

import ambassador.Bibwriter;
import Entries.Entry;
import applicationLogic.EntryBuilder;
import java.util.ArrayList;

/**
 * Väliaikainen luokka joka hoitaa käyttöliittymälle annettuja käskyjä
 *
 * @author vito
 */
public class Bibtextifier {

    private ArrayList<Entry> entries;
    private IO io;
    private Bibwriter bw;

    /**
     * Alustaa uuden Bibtextifier olion
     */
    public Bibtextifier(IO io) {
        this.io = io;
        entries = new ArrayList();
        this.bw = new Bibwriter();
    }

    /**
     * Hoitaa viitteiden lisäyksen
     */
    public void addReference() {
        io.printSomething("Give the tag:");
        String tag = io.readString();
        io.printSomething("Give the author(s):");
        String author = io.readString();
        io.printSomething("Give the title:");
        String title = io.readString();
        io.printSomething("Give the booktitle:");
        String booktitle = io.readString();
        io.printSomething("Give the year:");
        int year = io.readInt();
        Entry entry = EntryBuilder.buildInproceedings(author, title, booktitle, year, tag);
        if (entry.isValid()) {
            entries.add(entry);
            io.printSomething(entry.toString());
        } else {
            io.printSomething("Invalid information. Back to menu.");
        }

    }

    /**
     * Hoitaa viitteiden tallentamisen
     */
    public void saveReferences() {
        this.bw.writeReferencesFromList(entries);
    }

    /**
     * Hoitaa viitteiden tulostamisen / näyttämisen
     */
    public void printReferences() {
        for (Entry entry : entries) {
            io.printSomething(entry.toString());
        }
    }

    public void readReferencesToMemory() {
        this.entries.addAll(this.bw.readAndListReferences());
    }
}

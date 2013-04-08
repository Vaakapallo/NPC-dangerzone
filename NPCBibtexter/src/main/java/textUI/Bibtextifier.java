package textUI;

import ambassador.Bibwriter;
import applicationLogic.Entry;
import applicationLogic.EntryBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
        try {
            this.bw = new Bibwriter();
        } catch (IOException ex) {
            System.out.println("Can't create a new Bibwriter for some strange reason.");
        }
        
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
        int year = io.read();
        entries.add(EntryBuilder.buildInproceedings(author, title, booktitle, year, tag));
    }

    /**
     * Hoitaa viitteiden tallentamisen
     */
    public void saveReferences() {
        try {
            this.bw.writeReferencesFromList(entries);
        } catch (IOException ex) {
            System.out.println("Something funny happened while saving the reference");
        }
    }

    /**
     * Hoitaa viitteiden tulostamisen / näyttämisen
     */
    public void printReferences() {
        for (Entry entry : entries) {
            io.printSomething(entry.toString());
        }
    }
}

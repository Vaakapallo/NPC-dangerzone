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

    }

    /**
     * Hoitaa viitteiden tallentamisen
     */
    public void saveReferences() {
    }

    /**
     * Hoitaa viitteiden tulostamisen / näyttämisen
     */
    public void printReferences() {
        
    }

    public void readReferencesToMemory() {
    }
}

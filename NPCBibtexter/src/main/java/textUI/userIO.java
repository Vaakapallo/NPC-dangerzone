package textUI;

import java.util.Scanner;

/**
 * Luokka jolla poistetaan riippuvuuksia käyttöliittymältä
 *
 * @author vito
 */
public class userIO implements IO {

    Scanner scanner;
    Bibtextifier bib;

    /**
     * Konstruktori alustaa userIO:n ja alustaa scannerin sekä bibtextifierin
     */
    public userIO() {
        scanner = new Scanner(System.in);
        bib = new Bibtextifier();
    }

    /**
     * Lukee käyttäjältä uuden komennon
     *
     * @return Palauttaa komennon numeroarvon
     */
    public int read() {
        return Integer.parseInt(scanner.nextLine());
    }

    /**
     * Tulostaa käyttäjän antaman tekstin
     *
     * @param text Parametrina annetaan haluttu teksti
     */
    public void printSomething(String text) {
        System.out.println(text);
    }

    /**
     * Tulostaa rivinvaihdon
     */
    public void printLineChange() {
        System.out.println();
    }

    /**
     * Käskee Bibtextifieria siirtymään viitteiden lisäykseen
     */
    public void addReference() {
        bib.addReference();
    }

    /**
     * Käskee Bibtextifieria siirtymään viitteiden tallentamiseen
     */
    public void saveReferences() {
        bib.saveReferences();
    }

    /**
     * Käskee Bibtextifieria siirtymään viitteiden tulostamiseen
     */
    public void printReferences() {
        bib.printReferences();
    }
}

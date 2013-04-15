package textUI;

import java.util.Scanner;

/**
 * Luokka jolla poistetaan riippuvuuksia käyttöliittymältä
 *
 * @author vito
 */
public class userIO implements IO {

    private Scanner scanner;

    /**
     * Konstruktori alustaa userIO:n ja alustaa scannerin sekä bibtextifierin
     */
    public userIO() {
        scanner = new Scanner(System.in);
    }

    /**
     * Lukee käyttäjältä uuden komennon
     *
     * @return Palauttaa komennon numeroarvon
     */
    public int readInt() {
        int palautettava = 0;
        try {
            palautettava = Integer.parseInt(scanner.nextLine());

        } catch (NumberFormatException e) {
            printLine("Anna komento numerona");
        }

        if (palautettava == 0) {
            return readInt();
        }

        return palautettava;
    }

    /**
     * Tulostaa käyttäjän antaman tekstin
     *
     * @param text Parametrina annetaan haluttu teksti
     */
    public void printLine(String text) {
        System.out.println(text);
    }

    /**
     * Tulostaa rivinvaihdon
     */
    public void printLineChange() {
        System.out.println();
    }

    public String readString() {
        String luettava = scanner.nextLine();
        if (luettava.isEmpty()) {
            System.out.println("Syöte ei saa olla tyhjä: ");
            return readString();
        }
        return luettava;
    }
}

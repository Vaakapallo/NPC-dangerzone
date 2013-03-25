package textUI;

/**
 * Tekstikäyttöliittymä Bibtext viitteiden hallintaan
 *
 * @author vito
 */
public class TextUI {

    IO io;

    /**
     * Konstruktori tekstikäyttöliittymää varten
     *
     * @param io Saa parametrina IO olion, jonka tarkoituksena on poistaa
     * riippuvuuksia itse käyttöliittymältä
     */
    public TextUI(IO io) {
        this.io = io;
    }

    /**
     * Metodi jolla käynnistetään itse käyttöliittymä, pyörittää käskyn kyselyjä
     * kunnes suljetaan.
     */
    public void launchUberUI() {

        printCommands();

        while (true) {
            io.printSomething("Anna komento: ");

            try {

                int command = io.read();

                io.printLineChange();

                if (command == 9) {
                    io.printSomething("suljetaan");
                    break;
                }
                checkCommand(command);

            } catch (NumberFormatException e) {
                io.printSomething("Anna komento numerona");
            }
        }
    }

    /*
     * Tarkistaa komennon ja toimii sen mukaan
     * @param command Saa parametrina komennon numeroarvon
     */
    private void checkCommand(int command) {
        switch (command) {
            case 1:
                io.addReference();
                io.printLineChange();
                break;
            case 2:
                io.saveReferences();
                io.printLineChange();
                break;
            case 3:
                io.printReferences();
                io.printLineChange();
                break;
            default:
                io.printSomething("Väärä komento");
                io.printLineChange();
                printCommands();
        }
    }

    /*
     * Metodin ainoa tarkoitus on tulostaa lista sallituista komennoista
     */
    private void printCommands() {
        io.printSomething("1. Lisää uusi viite");
        io.printSomething("2. Tallenna viitteet");
        io.printSomething("3. Tulosta viitteet");
        io.printSomething("9. Lopeta");
        io.printLineChange();
    }
}

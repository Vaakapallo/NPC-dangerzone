package textUI;

import CommandInterpreter.Command;
import CommandInterpreter.CommandInterpreter;

/**
 * Tekstikäyttöliittymä Bibtext viitteiden hallintaan
 *
 * @author vito
 */
public class TextUI {
    
    private IO io;

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
    public void run() {
        CommandInterpreter commands = new CommandInterpreter(io);
        while (true) {
            printCommands();
            io.printLine("Anna komento: ");
            int input = io.readInt();
            Command com = commands.getCommand(input);
            if (com != null) {
                com.run();
            } else {
                io.printLine("Komentoa ei löytynyt, yritä uudelleen");
            }
            if (input == 9) {
                break;
            }
        }
    }

    /*
     * Metodin ainoa tarkoitus on tulostaa lista sallituista komennoista
     */
    private void printCommands() {
        io.printLine("1. Lisää uusi viite");
        io.printLine("2. Tallenna viitteet");
        io.printLine("3. Tulosta viitteet");
        io.printLine("4. Lue viitteet tiedostosta ja siirrä ohjelmaan");
        io.printLine("5. Muokkaa viitettä");
        io.printLine("6. Tulosta viitteet ihmisystävällisesti");
        io.printLine("7. Muokkaa tageja");
        io.printLine("9. Lopeta");
        io.printLineChange();
    }
}

package textUI;

public class TextUI {

    IO io;
    Bibtextifier bib;

    public TextUI(IO io) {
        this.io = io;
        bib = new Bibtextifier();
    }

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

    private void checkCommand(int command) {
        switch (command) {
            case 1:
                bib.addReference();
                io.printLineChange();
                break;
            case 2:
                bib.saveReferences();
                io.printLineChange();
                break;
            case 3:
                bib.printReferences();
                io.printLineChange();
                break;
            default:
                io.printSomething("Väärä komento");
                io.printLineChange();
                printCommands();
        }
    }

    private void printCommands() {
        io.printSomething("1. Lisää uusi viite");
        io.printSomething("2. Tallenna viitteet");
        io.printSomething("3. Tulostaviitteet");
        io.printSomething("9. Lopeta");
        io.printLineChange();
    }
}

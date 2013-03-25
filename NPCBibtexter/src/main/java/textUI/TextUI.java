package textUI;

import java.util.Scanner;

public class TextUI {

    Scanner scanner;

    public TextUI() {
        scanner = new Scanner(System.in);
    }

    public void launchUberUI() {

        System.out.println("1. Lisää uusi viite");
        System.out.println("2. Lopeta ohjelma");
        System.out.println();

        while (true) {
            System.out.print("Anna komento: ");
            String command = scanner.nextLine();
            System.out.println();
        }

    }
}

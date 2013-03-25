package textUI;

import java.util.Scanner;

public class userIO implements IO{

    Scanner scanner;
    Bibtextifier bib;
    
    public userIO(){
        scanner = new Scanner(System.in);
        bib = new Bibtextifier();
    }
    
    public int read() {
        return Integer.parseInt(scanner.nextLine());
    }

    public void printSomething(String text) {
        System.out.println(text);
    }

    public void printLineChange() {
        System.out.println();
    }

    public void addReference() {
        bib.addReference();
    }

    public void saveReferences() {
        bib.saveReferences();
    }

    public void printReferences() {
        bib.printReferences();
    }
    
}

package textUI;

import java.util.Scanner;

public class userIO implements IO{

    Scanner scanner;
    
    public userIO(){
        scanner = new Scanner(System.in);
    }
    
    public int read() {
        return Integer.parseInt(scanner.nextLine());
    }

    public void printSomething(String text) {
        System.out.println(text);
    }
    
}

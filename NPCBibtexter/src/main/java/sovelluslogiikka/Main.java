/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

/**
 *
 * @author jjoonia
 */
public class Main {

    public static void main(String[] args) {
        Inproceedings esko = new Inproceedings(new Author("Fleuri", true), "On notions", "Proc. jotain", "1983");
        esko.metodi();
        System.out.println(esko);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic;

import textUI.IO;
import textUI.TextUI;
import textUI.userIO;

/**
 *
 * @author jjoonia<3
 */
public class Main {

    public static void main(String[] args) {
        Inproceedings esko = new Inproceedings(new Author("Fleuri", true), "On notions", "Proc. jotain", "1983");
        esko.metodi();
        System.out.println(esko);
        
        TextUI UI = new TextUI(new userIO());
        UI.launchUberUI();
    }
}

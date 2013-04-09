/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic;


import Entries.Inproceedings;
import textUI.TextUI;
import textUI.userIO;

/**
 *
 * @author jjoonia<3
 */
public class Main {

    public static void main(String[] args) {
//        Inproceedings inproceedings = EntryBuilder.buildInproceedings("Luukkainen, Matti", "Extreme Apprenticeship Method in Teaching Programming for Beginners.", "SIGCSE '11: Proceedings of the 42nd SIGCSE technical symposium on Computer science education", 2011, "VPL11");
//        System.out.println(inproceedings.isValid());
//
//        System.out.println(inproceedings);

        TextUI ui = new TextUI(new userIO());
        ui.launchUberUI();
    }
}

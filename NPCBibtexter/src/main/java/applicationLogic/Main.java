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
        Class[] luokat = Inproceedings.getRequiredFields();
        for (Class classy : luokat) {
            System.out.println(classy);
        }
    }
}

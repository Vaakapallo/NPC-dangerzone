/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic;

import textUI.TextUI;

/**
 *
 * @author jjoonia<3
 */
public class Main {

    public static void main(String[] args) {
        Inproceedings esko = new Inproceedings("Alfred V. Oaho", "On notions", "Proc. jotain", "1983");
        System.out.println(esko);
        
        TextUI UI = new TextUI();
        UI.launchUberUI();
    }
}

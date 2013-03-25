/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic;

/**
 *
 * @author lvapaaka
 */
public class ScandicConverter {

    public static String convertScandicsToBibText(String convertee) {
        convertee = convertee.replace("ä", "\"{a}");
        convertee = convertee.replace("ö", "\"{o}");
        return convertee;
    }
}

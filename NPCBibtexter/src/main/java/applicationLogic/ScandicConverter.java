/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic;

/**
 * Static class that converts Scandic letters to a format BibText understands
 * 
 * @author lvapaaka
 */
public class ScandicConverter {

    /**
     * Converts all scandic characters in the given string into BibText-friendly ones.
     * 
     * @param convertee String with potential scandic letters
     * @return string that BibText accepts
     */
    public static String convertScandicsToBibText(String convertee) {
        convertee = convertee.replace("ä", "\"{a}");
        convertee = convertee.replace("å", "\"{aa}");
        convertee = convertee.replace("ö", "\"{o}");
        convertee = convertee.replace("Ä", "\"{A}");
        convertee = convertee.replace("Å", "\"{AA}");
        convertee = convertee.replace("Ö", "\"{O}");
        return convertee;
    }
}
